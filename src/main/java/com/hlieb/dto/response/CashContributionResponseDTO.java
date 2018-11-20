package com.hlieb.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CashContributionResponseDTO {

    private long id;
    private long userId;
    private Integer cashAmount;
    private String description;
    private LocalDate dateOfContribution;

}
