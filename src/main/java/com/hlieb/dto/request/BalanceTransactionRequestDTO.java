package com.hlieb.dto.request;

import com.hlieb.enums.FinancialSourceType;
import lombok.Data;

@Data
public class BalanceTransactionRequestDTO {

    private Integer amount;
    private String description;
    private long responsiveUserId;
    private FinancialSourceType type;

}
