package com.hlieb.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class BalanceResponseDTO {

    private Integer currentBalance;
    List<BalanceTransactionResponseDTO> transactionsForMonth;

}
