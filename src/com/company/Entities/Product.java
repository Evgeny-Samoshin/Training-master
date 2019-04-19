package com.company.Entities;

public class Product{
    private  int ID;
    private String Name;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(int ID, String name, double price, int quantity) {
        this.ID = ID;
        Name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String Name, double price, int quantity) {
        this.Name = Name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getID() {
        return ID;
    }

    public Product setID(int ID) {
        this.ID = ID;
        return this;
    }

    public String getName() {
        return this.Name = Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
