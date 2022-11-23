package com.example.yurii;

public class Agency {
    private int id_agency;
    private int id_head;
    private String head;
    private int id_customer;
    private String customer;
    private int id_employee;
    private String employee;
    private int id_country;
    private String country;
    private String active;
    private String private_security;
    private int id_office;
    private String office;

    public Agency(int id_agency, int id_head, int id_customer, int id_employee, int id_country, String active, String private_security, int id_office) {
        this.id_agency = id_agency;
        this.id_head = id_head;
        this.id_customer = id_customer;
        this.id_employee = id_employee;
        this.id_country = id_country;
        this.active = active;
        this.private_security = private_security;
        this.id_office = id_office;
    }

    public int getId_agency() {
        return id_agency;
    }

    public void setId_agency(int id_agency) {
        this.id_agency = id_agency;
    }

    public int getId_head() {
        return id_head;
    }

    public void setId_head(int id_head) {
        this.id_head = id_head;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getId_country() {
        return id_country;
    }

    public void setId_country(int id_country) {
        this.id_country = id_country;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getPrivate_security() {
        return private_security;
    }

    public void setPrivate_security(String private_security) {
        this.private_security = private_security;
    }

    public int getId_office() {
        return id_office;
    }

    public void setId_office(int id_office) {
        this.id_office = id_office;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
