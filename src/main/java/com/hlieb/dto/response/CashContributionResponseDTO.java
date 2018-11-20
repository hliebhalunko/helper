package com.hlieb.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CashContributionResponseDTO {

    private long id;
    private Integer cashAmount;
    private String description;
    private LocalDate dateOfContribution;
    @JsonIgnore
    private UserResponseDTO user;

}
