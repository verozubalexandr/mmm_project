package com.example.test.controller;

/**
 * Класс для десериализации объекта, содержащего индекс
 */
public class StringIndex {
    private int id;

    public StringIndex() {
    }

    public StringIndex(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
