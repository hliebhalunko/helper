package com.hlieb.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CashContributionDTO {

    private long id;
    private Integer cashAmount;
    private LocalDate dateOfContribution;

}
