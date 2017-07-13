package models;


import java.util.Date;

/**
 * Created by Zufar on 12-Jul-17.
 */
public class Order {
    enum Status {
        START, PROCESS, FINISH
    }
    private int id;
    private Client client;
    private Pizza pizzas;
    private PizzaMaker pizzaMaker;
    private Date startDate;
    private Date endDate;
    private Status status;

    public Order(Client client, Pizza pizzas, PizzaMaker pizzaMaker, Date startDate, Date endDate, Status status) {
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

    public Pizza getPizzas() {
        return pizzas;
    }

    public void setPizzas(Pizza pizzas) {
        this.pizzas = pizzas;
    }

    public PizzaMaker getPizzaMaker() {
        return pizzaMaker;
    }

    public void setPizzaMaker(PizzaMaker pizzaMaker) {
        this.pizzaMaker = pizzaMaker;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Status isStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }
}
