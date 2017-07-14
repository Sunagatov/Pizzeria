package models;

/**
 * Created by Zufar on 12-Jul-17.
 */
public class Client {
    private int id;

    private String name;
    //Фамилия
    private String surname;
    //Отчество
    private String patronymic;
    //Номер телефона
    private int telephoneNumber;

    public Client(int id, String name, String surname, String patronymic, int telephoneNumber) {
        this.id = id;
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

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getID() {
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
