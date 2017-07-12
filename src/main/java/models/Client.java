package models;

/**
 * Created by Zufar on 12-Jul-17.
 */
public class Client {
    private String name;
    //Фамилия
    private String surname;
    //Отчество
    private String patronymic;
    //Номер телефона
    private int telephoneNumber;

    public Client(String name, String surname, String patronymic, int telephoneNumber) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.telephoneNumber = telephoneNumber;
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

    public double getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
