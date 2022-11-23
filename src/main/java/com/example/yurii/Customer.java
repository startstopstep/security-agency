package com.example.yurii;

public class Customer {
    private int id_customer;
    private String customer;

    public Customer(int id_customer, String customer) {
        this.id_customer = id_customer;
        this.customer = customer;
    }

    public Customer() {
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
