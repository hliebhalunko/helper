package com.hlieb.entity;

import com.hlieb.enums.BloodType;
import com.hlieb.enums.Rank;
import com.hlieb.enums.UserStatus;
import lombok.Data;
import lombok.NonNull;

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
    @NotNull
    private Rank rank;
    @Column
    private BloodType bloodType;
    @Column
    @NotNull
    private UserStatus userStatus;

    public void addCashContribution(CashContribution cashContribution) {
        contributions.add(cashContribution);
    }


    //TODO Add contacts: email, phones, other
}
