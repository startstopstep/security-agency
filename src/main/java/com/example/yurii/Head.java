package com.example.yurii;

public class Head {
    private int id_head;
    private String head;
    private String email;

    public Head(int id_head, String head, String email) {
        this.id_head = id_head;
        this.head = head;
        this.email = email;
    }

    public Head() {
    }

    public int getId_head() {
        return id_head;
    }

    public void setId_head(int id_head) {
        this.id_head = id_head;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
