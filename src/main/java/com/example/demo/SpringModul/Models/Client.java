package com.example.demo.SpringModul.Models;

import javax.persistence.*;

@Entity
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String lastname;
    private String pesel;
    private String dateofBirth;
    private String Telephone;
    private String Email;


    public Client(int id, String name, String lastname, String pesel, String dateofBirth, String telephone, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.pesel = pesel;
        this.dateofBirth = dateofBirth;
        Telephone = telephone;
        Email = email;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Client{"+ " name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", pesel='" + pesel + '\'' +
                ", DateofBirth='" + dateofBirth + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }


    public Client(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
}
