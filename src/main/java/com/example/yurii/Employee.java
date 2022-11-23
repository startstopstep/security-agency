package com.example.yurii;

public class Employee {
    private int id_employee;
    private String employee;

    public Employee(int id_employee, String employee) {
        this.id_employee = id_employee;
        this.employee = employee;
    }

    public Employee() {
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
}
