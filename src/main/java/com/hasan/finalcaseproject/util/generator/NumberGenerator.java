package com.hasan.finalcaseproject.util.generator;

public class NumberGenerator {

    public static Double randomNumber() {
        Double randomNumber = (double) Math.floor(Math.random() * 1500) ;
        return randomNumber;
    }
}
