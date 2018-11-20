package com.hlieb.service;

import com.hlieb.dto.request.CashContributionRequestDTO;
import com.hlieb.dto.response.CashContributionResponseDTO;
import com.hlieb.exceptions.UserNotFoundException;

import java.util.List;

public interface FinanceService {
    void addContributionFromUser(CashContributionRequestDTO cashContributionRequestDTO) throws UserNotFoundException;

    List<CashContributionResponseDTO> getUserContributions(long userId) throws UserNotFoundException;

    List<CashContributionResponseDTO> getAllContributionsFromDate(String date);
}
