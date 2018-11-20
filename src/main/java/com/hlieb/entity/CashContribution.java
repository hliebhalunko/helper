package com.hlieb.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

}
