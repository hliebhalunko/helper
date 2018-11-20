package com.hlieb.service.impl;

import com.hlieb.dto.request.CashContributionRequestDTO;
import com.hlieb.dto.response.CashContributionResponseDTO;
import com.hlieb.entity.CashContribution;
import com.hlieb.entity.User;
import com.hlieb.exceptions.UserNotFoundException;
import com.hlieb.repository.CashContributionRepository;
import com.hlieb.repository.UserRepository;
import com.hlieb.service.FinanceService;
import com.hlieb.util.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CashContributionRepository cashContributionRepository;

    @Override
    public void addContributionFromUser(CashContributionRequestDTO cashContributionRequestDTO) throws UserNotFoundException {
        Optional<User> userOpt = userRepository.findById(cashContributionRequestDTO.getUserId());
        User user = userOpt.orElseThrow(() -> new UserNotFoundException(cashContributionRequestDTO.getUserId()));
        CashContribution cashContribution = new CashContribution();
        cashContribution.setCashAmount(cashContributionRequestDTO.getCashAmount());
        cashContribution.setDateOfContribution(LocalDate.now());
        cashContribution.setDescription(cashContributionRequestDTO.getDescription());
        user.addCashContribution(cashContribution);

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
    public List<CashContributionResponseDTO> getAllContributionsFromDate(LocalDate date) {
        return StreamSupport.stream(cashContributionRepository.getAllContributionsBeforeDate(date).spliterator(), false)
                .map(DTOMapper::cashContributionToResponseDTO).collect(Collectors.toList());
    }

}
