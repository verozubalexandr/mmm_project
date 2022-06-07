
package com.example.test.controller;

public class StringIndexObject {
    private String name;
    private String lastName;
    private String patronymic;
    private String city;
    private String street;
    private int houseNumber;
    private int apartmentNumber;
    private float deposit;
    private boolean autoProlongation;
    private int term;
    private int id;
    private String contractNumber;

    public StringIndexObject() {

    }

    public StringIndexObject(String name, String lastName, String patronymic, String city, String street, int houseNumber, int apartmentNumber, float deposit, boolean autoProlongation, int term, int id, String contractNumber) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.deposit = deposit;
        this.autoProlongation = autoProlongation;
        this.term = term;
        this.id = id;
        this.contractNumber = contractNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public boolean isAutoProlongation() {
        return autoProlongation;
    }

    public void setAutoProlongation(boolean autoProlongation) {
        this.autoProlongation = autoProlongation;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
