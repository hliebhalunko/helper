package com.hlieb.enums;

import lombok.Getter;

@Getter
public enum Rank {


    LEVEL_0("Recrut"),
    LEVEL_1("Royoviy"),
    LEVEL_2("Chotoviy"),
    LEVEL_3("Bunchuzhniy"),
    LEVEL_4("UberBunchuzhniy"),
    LEVEL_5("UnterHorunzhiy"),
    LEVEL_6("Horunzhiy"),
    LEVEL_7("Poruchnyk"),
    LEVEL_8("Sotnyk"),
    LEVEL_9("Mayor"),
    LEVEL_10("Kurinniy"),
    LEVEL_11("Polkovnyk");

    private String rank;

    Rank(String rank) {
        this.rank = rank;
    }
}
