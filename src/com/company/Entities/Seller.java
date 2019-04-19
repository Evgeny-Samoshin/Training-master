package com.company.Entities;

public class Seller {
    private int ID;
    private String Name;
    private String Address;
    private String Telephone;

    public Seller() {
    }

    public Seller(int ID, String name, String address, String telephone) {
        this.ID = ID;
        Name = name;
        Address = address;
        Telephone = telephone;
    }

    public Seller(String name, String address, String telephone) {
        Name = name;
        Address = address;
        Telephone = telephone;
    }

    public int getID() {
        return ID;
    }

    public Seller setID(int ID) {
        this.ID = ID;
        return this;
    }

    public String getName() {
        return Name;
    }

    public Seller setName(String name) {
        Name = name;
        return this;
    }

    public String getAddress() {
        return Address;
    }

    public Seller setAddress(String address) {
        Address = address;
        return this;
    }

    public String getTelephone() {
        return Telephone;
    }

    public Seller setTelephone(String telephone) {
        Telephone = telephone;
        return this;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerID='" + ID + '\'' +
                ", sellerName='" + Name + '\'' +
                ", sellerAddress='" + Address + '\'' +
                ", sellerTelephone='" + Telephone + '\'' +
                '}';
    }
}
