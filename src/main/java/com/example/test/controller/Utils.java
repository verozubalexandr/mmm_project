package com.example.test.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static boolean isCorrectName(String name) {
        String regex = "^(([a-zA-Z' -]{1,80})|([а-яА-ЯЁёІіЇїҐґЄє' -]{1,80}))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean isCorrectCity(String city) {
        String regex = "^(([a-zA-Z0-9' -]{1,80})|([а-яА-ЯЁёІіЇїҐґЄє0-9' -]{1,80}))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(city);
        return matcher.matches();
    }

    public static boolean isCorrectContractNumber(String contractNumber) {
        String regex = "^([0-9]){3,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contractNumber);
        return matcher.matches();
    }

}
