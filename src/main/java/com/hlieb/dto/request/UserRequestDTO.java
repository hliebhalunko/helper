package com.hlieb.dto.request;

import com.hlieb.enums.BloodType;
import com.hlieb.enums.Rank;
import com.hlieb.enums.UserStatus;
import lombok.Data;

@Data
public class UserRequestDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String nickname;
    private String dateOfBirth;
    private String dateOfEnlistment;
    private Rank rank;
    private BloodType bloodType;
    private UserStatus userStatus;

}
