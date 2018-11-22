package com.hlieb.entity;

import com.hlieb.enums.FinancialSourceType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class CashContribution {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private Integer cashAmount;
    @Column
    private LocalDate dateOfContribution;
    @Column
    private String description;
    @ManyToOne
    private User user;
    @Column
    @Enumerated(EnumType.STRING)
    private FinancialSourceType financialSourceType;

}
