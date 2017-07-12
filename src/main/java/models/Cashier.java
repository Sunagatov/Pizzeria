package models;

/**
 * Created by Zufar on 12-Jul-17.
 */
public class Cashier {
    private String name;
    //Фамилия
    private String surname;
    //Отчество
    private String patronymic;
    //Почасовая оплата
    private double hourlyPay;

    public Cashier(String name, String surname, String patronymic, double hourlyPay) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.hourlyPay = hourlyPay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }
}
