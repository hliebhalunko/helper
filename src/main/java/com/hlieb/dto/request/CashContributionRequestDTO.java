package com.hlieb.dto.request;

import com.hlieb.enums.FinancialSourceType;
import lombok.Data;

@Data
public class CashContributionRequestDTO {

    private long userId;
    private long responsiveUserId;
    private Integer cashAmount;
    private String description;
    private FinancialSourceType type;

}
