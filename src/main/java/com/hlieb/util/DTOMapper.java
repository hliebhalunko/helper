package com.hlieb.util;

import com.hlieb.dto.request.UserRequestDTO;
import com.hlieb.dto.response.BalanceTransactionResponseDTO;
import com.hlieb.dto.response.CashContributionResponseDTO;
import com.hlieb.dto.response.UserResponseDTO;
import com.hlieb.entity.BalanceTransaction;
import com.hlieb.entity.CashContribution;
import com.hlieb.entity.User;

import java.time.LocalDate;
import java.util.stream.Collectors;

import static com.google.common.base.Strings.isNullOrEmpty;

public class DTOMapper {

    public static UserResponseDTO userToResponseDTO(User user) {
        UserResponseDTO dto = userToChildlessResponseDTO(user);

        dto.setContributions(user.getContributions().stream()
                .map(DTOMapper::cashContributionToChildlessResponseDTO).collect(Collectors.toList()));

        return dto;
    }

    public static UserResponseDTO userToChildlessResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setNickname(user.getNickname());
        dto.setBloodType(user.getBloodType());
        dto.setDateOfBirth(user.getDateOfBirth());
        dto.setDateOfEnlistment(user.getDateOfEnlistment());
        dto.setRank(user.getRank());
        dto.setUserStatus(user.getUserStatus());
        dto.setBalance(user.getBalance());
        return dto;
    }

    public static UserResponseDTO userToBalanceResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setNickname(user.getNickname());
        dto.setBalance(user.getBalance());
        return dto;
    }

    public static User requestDTOtoUser(User user, UserRequestDTO userRequestDTO) {

        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setNickname(userRequestDTO.getNickname());
        user.setBloodType(userRequestDTO.getBloodType());
        user.setDateOfBirth(isNullOrEmpty(userRequestDTO.getDateOfBirth()) ? null : LocalDate.parse(userRequestDTO.getDateOfBirth()));
        user.setDateOfEnlistment(isNullOrEmpty(userRequestDTO.getDateOfEnlistment()) ? null : LocalDate.parse(userRequestDTO.getDateOfEnlistment()));
        user.setRank(userRequestDTO.getRank());
        user.setUserStatus(userRequestDTO.getUserStatus());

        return user;
    }

    public static CashContributionResponseDTO cashContributionToResponseDTO(CashContribution cashContribution) {
        CashContributionResponseDTO dto = cashContributionToChildlessResponseDTO(cashContribution);
        dto.setUser(userToChildlessResponseDTO(cashContribution.getUser()));
        return dto;
    }

    public static CashContributionResponseDTO cashContributionToChildlessResponseDTO(CashContribution cashContribution) {
        CashContributionResponseDTO dto = new CashContributionResponseDTO();
        dto.setId(cashContribution.getId());
        dto.setCashAmount(cashContribution.getCashAmount());
        dto.setDateOfContribution(cashContribution.getDateOfContribution());
        dto.setDescription(cashContribution.getDescription());
        return dto;
    }

    public static BalanceTransactionResponseDTO balanceTransactionToResponseDTO(BalanceTransaction balanceTransaction) {
        BalanceTransactionResponseDTO dto = new BalanceTransactionResponseDTO();
        dto.setId(balanceTransaction.getId());
        dto.setAmount(balanceTransaction.getAmount());
        dto.setCurrentBalance(balanceTransaction.getCurrentBalance());
        dto.setDate(balanceTransaction.getDate());
        dto.setDescription(balanceTransaction.getDescription());
        dto.setResponsiveUser(userToChildlessResponseDTO(balanceTransaction.getResponsiveUser()));

        return dto;
    }
}
