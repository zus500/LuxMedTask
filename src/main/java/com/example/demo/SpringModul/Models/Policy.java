package com.example.demo.SpringModul.Models;

import javax.persistence.*;


@Entity
public class Policy {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String NrPolice;
    private String Mark;
    private String Model;
    private String Vin;
    private String Reg;
    private String Tread;



    public Policy() {
    }
    @ManyToOne(targetEntity = Client.class)
    Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNrPolice() {
        return NrPolice;
    }

    public void setNrPolice(String nrPolice) {
        NrPolice = nrPolice;
    }

    public String getMark() {
        return Mark;
    }

    public void setMark(String mark) {
        Mark = mark;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getVin() {
        return Vin;
    }

    public void setVin(String vin) {
        Vin = vin;
    }

    public String getReg() {
        return Reg;
    }

    public void setReg(String reg) {
        Reg = reg;
    }

    public String getTread() {
        return Tread;
    }

    public void setTread(String tread) {
        Tread = tread;
    }

    @Override
    public String toString() {
        return "Police{ NrPolice='" + NrPolice + '\'' +
                ", Mark='" + Mark + '\'' +
                ", Model='" + Model + '\'' +
                ", Vin='" + Vin + '\'' +
                ", Reg='" + Reg + '\'' +
                ", Tread='" + Tread + '\'' +
                ", client=" + client +
                '}';
    }
}
