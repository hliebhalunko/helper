package com.hlieb.entity;

import com.hlieb.enums.FinancialSourceType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table
@Data
public class BalanceTransaction {

    @Id
    @GeneratedValue
    private long id;
    @Column
    @NotNull
    private Integer amount;
    @Column
    @NotNull
    private String description;
    @ManyToOne
    @NotNull
    private User responsiveUser;
    @Column
    private LocalDate date;
    @Column
    @NotNull
    private Integer currentBalance;
    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private FinancialSourceType financialSourceType;


}
