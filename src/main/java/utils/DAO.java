package utils;

import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zufar on 12-Jul-17.
 */
public class DAO {

    private static DAO instance;

    private DAO() {
    }

    public static DAO getInstance() {
        if (instance == null) {
            instance = new DAO();
        }
        return instance;
    }

    public Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:hsqldb:file:testdb", "SA", "");
            return dbConnection;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return dbConnection;
    }

    public List<Client> LoadAllClients() throws SQLException {
        List<Client> data = new ArrayList<Client>();
        String selectSQL = "SELECT * FROM CLIENTS";
        Connection dbConnection = getDBConnection();
        PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
        ResultSet rsClients = preparedStatement.executeQuery();
        Client currentClient = null;
        while (rsClients.next()) {
            int clientID = rsClients.getInt("id");
            String name = rsClients.getString("NAME");
            String surname = rsClients.getString("SURNAME");
            String patronymic = rsClients.getString("PATRONYMIC");
            int telephoneNumber = rsClients.getInt("TELEPHONENUMBER");
            currentClient = new Client(clientID, name, surname, patronymic, telephoneNumber);
            data.add(currentClient);
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (dbConnection != null) {
            dbConnection.close();
        }
        return data;
    }

    public Client loadClient(int clientID) throws SQLException {
        String selectSQL = "SELECT * FROM CLIENTS WHERE ID = ?";
        Connection dbConnection = getDBConnection();
        PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
        preparedStatement.setInt(1, clientID);
        ResultSet rsClients = preparedStatement.executeQuery();
        Client currentClient = null;
        if (rsClients.next()) {
            String name = rsClients.getString("NAME");
            String surname = rsClients.getString("SURNAME");
            String patronymic = rsClients.getString("PATRONYMIC");
            int telephoneNumber = rsClients.getInt("TELEPHONENUMBER");
            currentClient = new Client(clientID, name, surname, patronymic, telephoneNumber);
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return currentClient;
    }


    public void storeClient(Client client) throws SQLException {
        String insertTableSQL = "INSERT INTO CLIENTS"
                + "(NAME, SURNAME, PATRONYMIC, TELEPHONENUMBER) VALUES"
                + "(?,?,?,?)";
        Connection dbConnection = getDBConnection();
        PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);
        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getSurname());
        preparedStatement.setString(3, client.getPatronymic());
        preparedStatement.setInt(4, client.getTelephoneNumber());
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (dbConnection != null) {
            dbConnection.close();
        }
    }

    public List<PizzaMaker> LoadAllPizzaMakers() throws SQLException {
        List<PizzaMaker> data = new ArrayList<PizzaMaker>();
        String selectSQL = "SELECT * FROM PIZZAMAKERS";
        Connection dbConnection = getDBConnection();
        PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
        ResultSet rsPizzaMakers = preparedStatement.executeQuery();
        PizzaMaker currentPizzaMaker = null;
        while (rsPizzaMakers.next()) {
            int pizzaMakerID = rsPizzaMakers.getInt("id");
            String name = rsPizzaMakers.getString("NAME");
            String surname = rsPizzaMakers.getString("SURNAME");
            String patronymic = rsPizzaMakers.getString("PATRONYMIC");
            double hourlypay = rsPizzaMakers.getDouble("HOURLYPAY");
            currentPizzaMaker = new PizzaMaker(pizzaMakerID, name, surname, patronymic, hourlypay);
            data.add(currentPizzaMaker);
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (dbConnection != null) {
            dbConnection.close();
        }
        return data;
    }

    public PizzaMaker loadPizzaMaker(int pizzaMakerID) throws SQLException {
        String selectSQL = "SELECT * FROM PIZZAMAKERS WHERE ID = ?";
        Connection dbConnection = getDBConnection();
        PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
        preparedStatement.setInt(1, pizzaMakerID);
        ResultSet rsPizzaMakers = preparedStatement.executeQuery();
        PizzaMaker currentPizzaMaker = null;
        if (rsPizzaMakers.next()) {
            String name = rsPizzaMakers.getString("NAME");
            String surname = rsPizzaMakers.getString("SURNAME");
            String patronymic = rsPizzaMakers.getString("PATRONYMIC");
            double hourlypay = rsPizzaMakers.getDouble("HOURLYPAY");
            currentPizzaMaker = new PizzaMaker(pizzaMakerID, name, surname, patronymic, hourlypay);
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return currentPizzaMaker;
    }

    public void storePizzaMaker(PizzaMaker pizzaMaker) throws SQLException {
        String insertTableSQL = "INSERT INTO PizzaMaker"
                + "(NAME, SURNAME, PATRONYMIC, HOURLYPAY) VALUES"
                + "(?,?,?,?)";
        Connection dbConnection = getDBConnection();
        PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);
        preparedStatement.setString(1, pizzaMaker.getName());
        preparedStatement.setString(2, pizzaMaker.getSurname());
        preparedStatement.setString(3, pizzaMaker.getPatronymic());
        preparedStatement.setDouble(4, pizzaMaker.getHourlyPay());
        preparedStatement.executeUpdate();
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (dbConnection != null) {
            dbConnection.close();
        }
    }

}