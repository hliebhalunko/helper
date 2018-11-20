package com.hlieb.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BalanceTransactionResponseDTO {

    private long id;
    private Integer amount;
    private String description;
    private UserResponseDTO responsiveUser;
    private Integer currentBalance;
    private LocalDate date;

}
