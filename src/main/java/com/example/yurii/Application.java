package com.example.yurii;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Application extends javafx.application.Application {

    public ObservableList<Customer> customers = FXCollections.observableArrayList();
    public ObservableList<Employee> employees = FXCollections.observableArrayList();
    public ObservableList<Country> countrys = FXCollections.observableArrayList();
    public ObservableList<Head> heads = FXCollections.observableArrayList();
    public ObservableList<Office> offices = FXCollections.observableArrayList();
    public ObservableList<Agency> agencys = FXCollections.observableArrayList();

    public ObservableList<String> customerChoice = FXCollections.observableArrayList();
    public ObservableList<String> employeeChoice = FXCollections.observableArrayList();
    public ObservableList<String> officeChoice = FXCollections.observableArrayList();
    public ObservableList<String> headChoice = FXCollections.observableArrayList();
    public ObservableList<String> countryChoice = FXCollections.observableArrayList();


    public Map<Integer, String> headMap = new HashMap<>();
    public Map<Integer, String> customerMap = new HashMap<>();
    public Map<Integer, String> employeeMap = new HashMap<>();
    public Map<Integer, String> countryMap = new HashMap<>();
    public Map<Integer, String> officeMap = new HashMap<>();

    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Securty Agency (Yurii Merker)");
        stage.setScene(scene);
        stage.show();
        Class.forName("com.mysql.cj.jdbc.Driver");
        updateData();
    }

    public static void main(String[] args) {
        launch();
    }

    public boolean login(String l, String p) throws SQLException {
        boolean loginBool = false;
        String sql = "select login, password from users";
        String login ="";
        String password = "";
        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/securityagency",
                "root",
                "root");

            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                login = resultSet.getString("login");
                password = resultSet.getString("password");
                if(login.equals(l) && password.equals(p)) {
                    loginBool = true;
                } else {
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return loginBool;
    }

    public boolean register(String login, String password, String name, String surname, String email, String phone) {
        boolean bool = false;
        String sql = "insert into users(login, password, name, surname, email, phone)\n" +
                "VALUES('" +
                login + "','" +
                password + "', '" +
                name + "', '" +
                surname + "', '" +
                email + "', ' " +
                phone + "' )";

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/securityagency",
                "root",
                "root");
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            bool = true;
        } catch (SQLException throwables) {
            bool = false;
            throwables.printStackTrace();
        }
        return bool;
    }

    public boolean addNewData(String sql) {
        boolean bool = false;
        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/securityagency",
                "root",
                "root");
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Done!");
            bool = true;
        } catch (SQLException throwables) {
            bool = false;
            throwables.printStackTrace();
        }
        return bool;
    }

    public void updateData() {
        //
        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/securityagency",
                "root",
                "root");
            Statement statement = connection.createStatement()) {
            customers.clear();
            customerChoice.clear();
            employees.clear();
            employeeChoice.clear();
            agencys.clear();
            offices.clear();
            countryChoice.clear();
            countrys.clear();
            officeChoice.clear();
            heads.clear();
            headChoice.clear();
            var temp1 = "select * from customer";
            var temp2 = "select * from employee";
            var temp3 = "select * from office";
            var temp4 = "select * from head";
            var temp5 = "select * from country";
            var temp6 = "select * from agency";

            ResultSet resultSet1 = statement.executeQuery(temp1);
            while (resultSet1.next()) {
                customers.add(new Customer(
                        resultSet1.getInt("id_customer"),
                        resultSet1.getString("customer")
                ));
                customerMap.put(
                        resultSet1.getInt("id_customer"),
                        resultSet1.getString("customer")
                );
                customerChoice.add(resultSet1.getString("customer"));
            }

            ResultSet resultSet2 = statement.executeQuery(temp2);
            while (resultSet2.next()) {
                employees.add(new Employee(
                        resultSet2.getInt("id_employee"),
                        resultSet2.getString("employee")
                ));
                employeeMap.put(
                        resultSet2.getInt("id_employee"),
                        resultSet2.getString("employee")
                );
                employeeChoice.add(resultSet2.getString("employee"));
            }

            ResultSet resultSet3 = statement.executeQuery(temp3);
            while (resultSet3.next()) {
                offices.add(new Office(
                        resultSet3.getInt("id_office"),
                        resultSet3.getString("city"),
                        resultSet3.getString("address")
                ));
                officeMap.put(
                        resultSet3.getInt("id_office"),
                        resultSet3.getString("city")
                );
                officeChoice.add(resultSet3.getString("city"));
            }

            ResultSet resultSet4 = statement.executeQuery(temp4);
            while (resultSet4.next()) {
                heads.add(new Head(
                        resultSet4.getInt("id_head"),
                        resultSet4.getString("head"),
                        resultSet4.getString("email")
                ));
                headMap.put(
                        resultSet4.getInt("id_head"),
                        resultSet4.getString("head")
                );
                headChoice.add(resultSet4.getString("head"));
            }

            ResultSet resultSet5 = statement.executeQuery(temp5);
            while (resultSet5.next()) {
                countrys.add(new Country(
                        resultSet5.getInt("id_country"),
                        resultSet5.getString("country")
                ));
                countryMap.put(
                        resultSet5.getInt("id_country"),
                        resultSet5.getString("country")
                );
                countryChoice.add(resultSet5.getString("country"));
            }

            ResultSet resultSet6 = statement.executeQuery(temp6);
            while (resultSet6.next()) {
                agencys.add(new Agency(
                        resultSet6.getInt("id_agency"),
                        resultSet6.getInt("id_head"),
                        resultSet6.getInt("id_customer"),
                        resultSet6.getInt("id_employee"),
                        resultSet6.getInt("id_country"),
                        resultSet6.getString("name"),
                        resultSet6.getString("website"),
                        resultSet6.getInt("id_office")
                ));
            }

            for(Map.Entry<Integer, String> item : headMap.entrySet()) {
                for (Agency agency : agencys) {
                    if(agency.getId_head() == item.getKey()) {
                        agency.setHead(item.getValue());
                    }
                }
            }
            for(Map.Entry<Integer, String> item : countryMap.entrySet()) {
                for (Agency agency : agencys) {
                    if(agency.getId_country() == item.getKey()) {
                        agency.setCountry(item.getValue());
                    }
                }
            }
            for(Map.Entry<Integer, String> item : officeMap.entrySet()) {
                for (Agency agency : agencys) {
                    if(agency.getId_office() == item.getKey()) {
                        agency.setOffice(item.getValue());
                    }
                }
            }
            for(Map.Entry<Integer, String> item : employeeMap.entrySet()) {
                for (Agency agency : agencys) {
                    if(agency.getId_employee() == item.getKey()) {
                        agency.setEmployee(item.getValue());
                    }
                }
            }
            for(Map.Entry<Integer, String> item : customerMap.entrySet()) {
                for (Agency agency : agencys) {
                    if(agency.getId_customer() == item.getKey()) {
                        agency.setCustomer(item.getValue());
                    }
                }
            }


            System.out.println("Done!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}