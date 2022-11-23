package com.example.yurii;

public class Office {
    private int id_office;
    private String city;
    private String address;

    public Office(int id_office, String city, String address) {
        this.id_office = id_office;
        this.city = city;
        this.address = address;
    }

    public Office() {
    }

    public int getId_office() {
        return id_office;
    }

    public void setId_office(int id_office) {
        this.id_office = id_office;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
