package com.hlieb.helper.dto;

import com.hlieb.helper.enums.BloodType;
import com.hlieb.helper.enums.Rank;
import com.hlieb.helper.enums.UserStatus;
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
    private List<CashContributionDTO> contributions;
    private Rank rank;
    private BloodType bloodType;
    private UserStatus userStatus;

}
