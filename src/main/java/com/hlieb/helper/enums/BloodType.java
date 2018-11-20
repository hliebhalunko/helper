package com.hlieb.helper.enums;

import lombok.Getter;

@Getter
public enum BloodType {

    A_POS("A+"),
    A_NEG("A-"),
    B_POS("B+"),
    B_NEG("B-"),
    O_POS("O+"),
    O_NEG("O-"),
    AB_POS("AB+"),
    AB_NEG("AB-");

    private String bloodType;

    BloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
