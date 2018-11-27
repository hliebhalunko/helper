package com.hlieb.entity;

import com.hlieb.enums.BloodType;
import com.hlieb.enums.Rank;
import com.hlieb.enums.UserStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"firstName", "lastName", "nickname", "dateOfBirth", "bloodType"}))
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    @NotNull
    private String nickname;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private LocalDate dateOfEnlistment;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<CashContribution> contributions;
    @Column
    @Enumerated(EnumType.STRING)
    private Rank rank;
    @Column
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;
    @Column
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @Column
    private Integer balance;

    public void addCashContribution(CashContribution cashContribution) {
        contributions.add(cashContribution);
        this.balance = balance + cashContribution.getCashAmount();
    }

    public String getShortToString() {
        return rank.getRank() + " " + firstName + " " + nickname + " " + lastName;
    }

    //TODO Add contacts: email, phones, other
    //TODO Add unique constraint
}
