package models;


import java.util.Date;

/**
 * Created by Zufar on 12-Jul-17.
 */
public class Order {
    private Client client;
    private Cashier cashier;
    private Pizza pizzas;
    private PizzaMaker pizzaMaker;
    private Date startDate;
    private Date endDate;
    private boolean status;

    public Order(Client client, Cashier cashier, Pizza pizzas, PizzaMaker pizzaMaker, Date startDate, Date endDate, boolean status) {
        this.client = client;
        this.cashier = cashier;
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

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
