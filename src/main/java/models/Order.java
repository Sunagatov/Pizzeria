package models;


import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Zufar on 12-Jul-17.
 */
public class Order {
    public static enum Status {
        START, PROCESS, FINISH
    }
    private int id;
    private Client client;
    private Pizza pizzas;
    private PizzaMaker pizzaMaker;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Status status;

    public Order(int id, Client client, Pizza pizzas, PizzaMaker pizzaMaker, LocalDateTime startDate, LocalDateTime endDate, Status status) {
        this.id = id;
        this.client = client;
        this.pizzas = pizzas;
        this.pizzaMaker = pizzaMaker;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Pizza getPizza() {
        return pizzas;
    }

    public void setPizza(Pizza pizzas) {
        this.pizzas = pizzas;
    }

    public PizzaMaker getPizzaMaker() {
        return pizzaMaker;
    }

    public void setPizzaMaker(PizzaMaker pizzaMaker) {
        this.pizzaMaker = pizzaMaker;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getID() {
        return id;
    }
}
