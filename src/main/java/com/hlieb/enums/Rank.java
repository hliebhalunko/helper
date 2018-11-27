package com.hlieb.enums;

import lombok.Getter;

@Getter
public enum Rank {


    LEVEL_0("Recrut"),
    LEVEL_1("Strilets"),
    LEVEL_2("Royoviy"),
    LEVEL_3("Chotoviy"),
    LEVEL_4("Bunchuzhniy"),
    LEVEL_5("UberBunchuzhniy"),
    LEVEL_6("UnterHorunzhiy"),
    LEVEL_7("Horunzhiy"),
    LEVEL_8("Poruchnyk"),
    LEVEL_9("Sotnyk"),
    LEVEL_10("Mayor"),
    LEVEL_11("Kurinniy"),
    LEVEL_12("Polkovnyk");

    private String rank;

    Rank(String rank) {
        this.rank = rank;
    }
}
