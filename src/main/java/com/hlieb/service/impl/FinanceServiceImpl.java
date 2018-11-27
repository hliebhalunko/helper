package com.hlieb.service.impl;

import com.hlieb.dto.request.BalanceTransactionRequestDTO;
import com.hlieb.dto.request.CashContributionRequestDTO;
import com.hlieb.dto.response.BalanceTransactionResponseDTO;
import com.hlieb.dto.response.CashContributionResponseDTO;
import com.hlieb.entity.BalanceTransaction;
import com.hlieb.entity.CashContribution;
import com.hlieb.entity.User;
import com.hlieb.exceptions.UserNotFoundException;
import com.hlieb.repository.BalanceTransactionRepository;
import com.hlieb.repository.CashContributionRepository;
import com.hlieb.repository.UserRepository;
import com.hlieb.service.FinanceService;
import com.hlieb.util.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@PropertySource("classpath:application.properties")
public class FinanceServiceImpl implements FinanceService {

    @Value("contribution.transaction.prefix")
    private static String CONTRIBUTION_TRANSACTION_PREFIX;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CashContributionRepository cashContributionRepository;
    @Autowired
    private BalanceTransactionRepository balanceTransactionRepository;

    @Override
    public void addContributionFromUser(CashContributionRequestDTO cashContributionRequestDTO) throws UserNotFoundException {
        Optional<User> userOpt = userRepository.findById(cashContributionRequestDTO.getUserId());
        User user = userOpt.orElseThrow(() -> new UserNotFoundException(cashContributionRequestDTO.getUserId()));

        Optional<User> responsiveUserOpt = userRepository.findById(cashContributionRequestDTO.getResponsiveUserId());
        User responsiveUser = responsiveUserOpt.orElseThrow(() -> new UserNotFoundException(cashContributionRequestDTO.getResponsiveUserId()));

        CashContribution cashContribution = new CashContribution();
        cashContribution.setCashAmount(cashContributionRequestDTO.getCashAmount());
        cashContribution.setDateOfContribution(LocalDate.now());
        cashContribution.setDescription(cashContributionRequestDTO.getDescription());
        cashContribution.setFinancialSourceType(cashContributionRequestDTO.getType());
        user.addCashContribution(cashContribution);

        BalanceTransaction balanceTransaction = new BalanceTransaction();
        balanceTransaction.setFinancialSourceType(cashContributionRequestDTO.getType());
        balanceTransaction.setAmount(cashContributionRequestDTO.getCashAmount());
        balanceTransaction.setDate(LocalDate.now());
        balanceTransaction.setDescription(CONTRIBUTION_TRANSACTION_PREFIX + " User: " + user.getShortToString() + " " + cashContributionRequestDTO.getDescription());
        balanceTransaction.setCurrentBalance(calculateCurrentBalance(cashContributionRequestDTO.getCashAmount()));
        balanceTransaction.setResponsiveUser(responsiveUser);

        balanceTransactionRepository.save(balanceTransaction);
        cashContributionRepository.save(cashContribution);
        userRepository.save(user);
    }

    @Override
    public List<CashContributionResponseDTO> getUserContributions(long userId) throws UserNotFoundException {
        Optional<User> userOpt = userRepository.findById(userId);
        User user = userOpt.orElseThrow(() -> new UserNotFoundException(userId));
        return user.getContributions().stream().map(DTOMapper::cashContributionToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public List<CashContributionResponseDTO> getAllContributionsFromDate(String date) {
        return StreamSupport.stream(cashContributionRepository.getAllContributionsBeforeDate(LocalDate.parse(date)).spliterator(), false)
                .map(DTOMapper::cashContributionToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public List<BalanceTransactionResponseDTO> getMonthlyBalance() {
        return balanceTransactionRepository.findTop30ByOrderByIdDesc().stream()
                .map(DTOMapper::balanceTransactionToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public void conductTransaction(BalanceTransactionRequestDTO dto) throws UserNotFoundException {

        BalanceTransaction balanceTransaction = new BalanceTransaction();
        balanceTransaction.setCurrentBalance(calculateCurrentBalance(dto.getAmount()));
        balanceTransaction.setAmount(dto.getAmount());
        balanceTransaction.setDate(LocalDate.now());
        balanceTransaction.setDescription(dto.getDescription());
        balanceTransaction.setResponsiveUser(userRepository.findById(dto.getResponsiveUserId())
                .orElseThrow(() -> new UserNotFoundException(dto.getResponsiveUserId())));
        balanceTransaction.setFinancialSourceType(dto.getType());

        balanceTransactionRepository.save(balanceTransaction);

    }

    private Integer calculateCurrentBalance(Integer lastTransactionAmount) {
        if (balanceTransactionRepository.count() == 0) {
            return lastTransactionAmount;
        } else {
            return balanceTransactionRepository.findTopByOrderByIdDesc().getCurrentBalance() + lastTransactionAmount;
        }
    }

}
