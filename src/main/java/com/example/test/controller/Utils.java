package com.example.test.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    /**
     * Валидация строки с именем, фамилией, или отчеством
     *
     * @param name {String} — строка для валидации
     * @Returns {boolean}
     */
    public static boolean isCorrectName(String name) {
        String regex = "^(([a-zA-Z' -]{1,80})|([а-яА-ЯЁёІіЇїҐґЄє' -]{1,80}))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    /**
     * Валидация строки с городом или улицей
     *
     * @param city {String} — строка для валидации
     * @Returns {boolean}
     */
    public static boolean isCorrectCity(String city) {
        String regex = "^(([a-zA-Z0-9' -]{1,80})|([а-яА-ЯЁёІіЇїҐґЄє0-9' -]{1,80}))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(city);
        return matcher.matches();
    }

    /**
     * Валидация строки с номером договора
     *
     * @param contractNumber {String} — строка для валидации
     * @Returns {boolean}
     */
    public static boolean isCorrectContractNumber(String contractNumber) {
        String regex = "^([0-9]){3,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contractNumber);
        return matcher.matches();
    }

}
