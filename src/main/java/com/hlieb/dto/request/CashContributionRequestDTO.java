package com.hlieb.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CashContributionRequestDTO {

    private long userId;
    private Integer cashAmount;
    private String description;

}
