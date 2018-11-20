package com.hlieb.dto;

import com.hlieb.dto.request.CashContributionRequestDTO;
import com.hlieb.enums.BloodType;
import com.hlieb.enums.Rank;
import com.hlieb.enums.UserStatus;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String nickname;
    private String dateOfBirth;
    private String dateOfEnlistment;
    private List<CashContributionRequestDTO> contributions;
    private Rank rank;
    private BloodType bloodType;
    private UserStatus userStatus;

}
