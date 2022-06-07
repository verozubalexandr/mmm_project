package com.example.test.controller;

/**
 * Класс сущности базы данных
 */
public class Contributor {
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
    private String contractNumber;

    public Contributor() {

    }

    public Contributor(String name, String lastName, String patronymic, String city,
                       String street, int houseNumber, int apartmentNumber,
                       float deposit, boolean autoProlongation, int term, String contractNumber) {
        setName(name);
        setLastName(lastName);
        setPatronymic(patronymic);
        setCity(city);
        setStreet(street);
        setHouseNumber(houseNumber);
        setApartmentNumber(apartmentNumber);
        setDeposit(deposit);
        setTerm(term);
        setAutoProlongation(autoProlongation);
        setContractNumber(contractNumber);
    }

    public void setName(String name) {
        this.name = Utils.isCorrectName(name) ? name.toLowerCase() : "---";
    }

    public void setLastName(String lastName) {
        this.lastName = Utils.isCorrectName(lastName) ? lastName.toLowerCase() : "---";
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = Utils.isCorrectName(patronymic) ? patronymic.toLowerCase() : "---";
    }

    public void setCity(String city) {
        this.city = Utils.isCorrectCity(city) ? city.toLowerCase() : "---";
    }

    public void setStreet(String street) {
        this.street = Utils.isCorrectCity(street) ? street.toLowerCase() : "---";
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = (houseNumber >= 0) ? houseNumber : -1;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = (apartmentNumber >= 0) ? apartmentNumber : -1;
    }

    public void setDeposit(float deposit) {
        this.deposit = (deposit > 0) ? deposit : -1;
    }

    public void setAutoProlongation(boolean autoProlongation) {
        this.autoProlongation = autoProlongation;
    }

    public void setTerm(int term) {
        this.term = (term > 0) ? term : -1;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = Utils.isCorrectContractNumber(contractNumber) ? contractNumber : "---";
    }

    public float getDeposit() {
        return deposit;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getTerm() {
        return term;
    }

    public String getCity() {
        return city;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getStreet() {
        return street;
    }

    public boolean getAutoProlongation() {
        return autoProlongation;
    }

    public String getContractNumber() {
        return contractNumber;
    }
}
