package models;

/**
 * Created by Zufar on 12-Jul-17.
 */
public class PizzaMaker {
    private int id;

    private String name;
    //Фамилия
    private String surname;
    //Отчество
    private String patronymic;
    //Почасовая оплата
    private double hourlyPay;

    public PizzaMaker(int id, String name, String surname, String patronymic, double hourlyPay) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( " Name: " );
        builder.append( getName() );
        builder.append( " Surname: ");
        builder.append( getSurname() );
        builder.append( " Patronymic: ");
        builder.append( getPatronymic() );
        return builder.toString();
    }
}
