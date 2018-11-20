package com.hlieb.dto.response;

import com.hlieb.enums.BloodType;
import com.hlieb.enums.Rank;
import com.hlieb.enums.UserStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String nickname;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEnlistment;
    private Rank rank;
    private List<CashContributionResponseDTO> contributions;
    private BloodType bloodType;
    private UserStatus userStatus;

}
