package com.hlieb.controller;

import com.hlieb.dto.request.BalanceTransactionRequestDTO;
import com.hlieb.dto.response.BalanceTransactionResponseDTO;
import com.hlieb.exceptions.UserNotFoundException;
import com.hlieb.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    private FinanceService financeService;

    @GetMapping
    public ResponseEntity<?> getBalance(@RequestParam(required = false) Integer daysDepth,
                                        @RequestParam(required = false) String fromDate,
                                        @RequestParam(required = false) String tillDate) {
        List<BalanceTransactionResponseDTO> fullBalance = financeService.getBalance(daysDepth, fromDate, tillDate);
        return new ResponseEntity<>(fullBalance, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> conductTransaction(BalanceTransactionRequestDTO dto) throws UserNotFoundException {
        financeService.conductTransaction(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
