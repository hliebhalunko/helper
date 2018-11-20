package com.hlieb.util;

import com.hlieb.dto.request.UserRequestDTO;
import com.hlieb.dto.response.CashContributionResponseDTO;
import com.hlieb.dto.response.UserResponseDTO;
import com.hlieb.entity.CashContribution;
import com.hlieb.entity.User;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class DTOMapper {

    public static UserResponseDTO userToResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setNickname(user.getNickname());
        dto.setBloodType(user.getBloodType());
        dto.setContributions(user.getContributions().stream()
                .map(cc -> cashContributionToResponseDTO(cc, user)).collect(Collectors.toList()));
        dto.setDateOfBirth(user.getDateOfBirth());
        dto.setDateOfEnlistment(user.getDateOfEnlistment());
        dto.setRank(user.getRank());
        dto.setUserStatus(user.getUserStatus());
        return dto;
    }

    public static User requestDTOtoUser(User user, UserRequestDTO userRequestDTO) {

        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setNickname(userRequestDTO.getNickname());
        user.setBloodType(userRequestDTO.getBloodType());
        user.setDateOfBirth(LocalDate.parse(userRequestDTO.getDateOfBirth()));
        user.setDateOfEnlistment(LocalDate.parse(userRequestDTO.getDateOfEnlistment()));
        user.setRank(userRequestDTO.getRank());
        user.setUserStatus(userRequestDTO.getUserStatus());

        return user;
    }

    public static CashContributionResponseDTO cashContributionToResponseDTO(CashContribution cashContribution, User user) {
        CashContributionResponseDTO dto = new CashContributionResponseDTO();
        dto.setId(cashContribution.getId());
        dto.setCashAmount(cashContribution.getCashAmount());
        dto.setDateOfContribution(cashContribution.getDateOfContribution());
        dto.setDescription(cashContribution.getDescription());
        dto.setUserId(user.getId());
        return dto;
    }

}
