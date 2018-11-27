package com.hlieb.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hlieb.enums.BloodType;
import com.hlieb.enums.Rank;
import com.hlieb.enums.UserStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
public class UserResponseDTO {

    @JsonInclude(NON_NULL)
    private Long id;
    @JsonInclude(NON_NULL)
    private String firstName;
    @JsonInclude(NON_NULL)
    private String lastName;
    private String nickname;
    @JsonInclude(NON_NULL)
    private LocalDate dateOfBirth;
    @JsonInclude(NON_NULL)
    private LocalDate dateOfEnlistment;
    @JsonInclude(NON_NULL)
    private Rank rank;
    @JsonInclude(NON_NULL)
    private List<CashContributionResponseDTO> contributions;
    @JsonInclude(NON_NULL)
    private BloodType bloodType;
    @JsonInclude(NON_NULL)
    private UserStatus userStatus;
    @JsonInclude(NON_NULL)
    private Integer balance;

}
