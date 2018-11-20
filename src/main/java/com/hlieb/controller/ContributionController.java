package com.hlieb.controller;

import com.hlieb.dto.request.CashContributionRequestDTO;
import com.hlieb.exceptions.UserNotFoundException;
import com.hlieb.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cash-contribution")
public class ContributionController {

    @Autowired
    private FinanceService financeService;

    @PostMapping
    @RequestMapping("/user")
    public ResponseEntity<?> addContribution(CashContributionRequestDTO cashContributionRequestDTO) throws UserNotFoundException {
        financeService.addContributionFromUser(cashContributionRequestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @RequestMapping("/user/{userId}")
    public ResponseEntity<?> getUserContributions(@PathVariable long userId) throws UserNotFoundException {
        return new ResponseEntity<>(financeService.getUserContributions(userId), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{date}")
    public ResponseEntity<?> getAllContributionsFromDate(@PathVariable String date) {
        return new ResponseEntity<>(financeService.getAllContributionsFromDate(date), HttpStatus.OK);
    }



}
