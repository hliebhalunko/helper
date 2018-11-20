package com.hlieb.dto.request;

import lombok.Data;

@Data
public class CashContributionRequestDTO {

    private long userId;
    private Integer cashAmount;
    private String description;

}
