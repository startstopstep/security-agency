package com.example.yurii;

public class Country {
    private int id_country;
    private String country;

    public Country(int id_country, String country) {
        this.id_country = id_country;
        this.country = country;
    }

    public Country() {
    }

    public int getId_country() {
        return id_country;
    }

    public void setId_country(int id_country) {
        this.id_country = id_country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
