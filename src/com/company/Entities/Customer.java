package com.company.Entities;

public class Customer {
    private int ID;
    private String Name;
    private String Address;
    private String Telephone;

    public Customer() {
    }

    public Customer(int ID, String Name, String Address, String Telephone) {
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
        this.Telephone = Telephone;
    }

    public Customer(String Name, String Address, String Telephone) {
        this.Name = Name;
        this.Address = Address;
        this.Telephone = Telephone;
    }

    public int getID () { return ID;}

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String customerName) {
        this.Name = customerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String customerAddress) {
        this.Address = customerAddress;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String customerTelephone) {
        this.Telephone = customerTelephone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID ='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Telephone='" + Telephone + '\'' +
                '}';
    }

}
