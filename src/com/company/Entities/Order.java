package com.company.Entities;

import com.company.Dao.ProductQuery;

//import java.sql.Date;
public class Order {
    private int ID;
    private Product product;
    private ProductQuery productQuery;
    private Customer customer;
    private Seller seller;
    private int quantityOrderedProducts;

    public Order() {
    }

        public Order(int ID, Product product, Customer customer, Seller seller, int quantityOrderedProducts) {
        this.ID = ID;
        this.product = product;
        this.customer = customer;
        this.seller = seller;
        this.quantityOrderedProducts = quantityOrderedProducts;
    }

    public Order(Product product, Customer customer, Seller seller, int quantityOrderedProducts) {
        this.product = product;
        this.customer = customer;
        this.seller = seller;
        this.quantityOrderedProducts = quantityOrderedProducts;
    }

    public int getID() {
        return ID;
    }

    public Order setID(int ID) {
        this.ID = ID;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public Product setProduct(Product product) {
        return this.product = product;
    }

    public ProductQuery getProductQuery() {
        return productQuery;
    }

    public Order setProductQuery(ProductQuery productQuery) {
        this.productQuery = productQuery;
        return this;
    }

    public int getCustomer() {
        return customer.getID();
    }

    public int setCustomer(int customer) {
       return this.customer.getID();

    }

    public int getSeller() {
        return seller.getID();
    }

    public int setSeller(int seller) {
        return this.seller.getID();
    }

    public int getQuantityOrderedProducts() {
        return quantityOrderedProducts;
    }

    public Order setQuantityOrderedProducts(int quantityOrderedProducts) {
        this.quantityOrderedProducts = quantityOrderedProducts;
        return this;
    }

    @Override
    public String toString() {
        return "Order: " +
                ", \nCustomer: " + customer.getName() +", "+customer.getAddress()+", "+customer.getTelephone()+
                ", \nSeller: " + seller.getName() +", "+seller.getAddress()+", "+seller.getTelephone()+
                ", \nProduct: "+ product.getName() +":; Price: "+ product.getPrice() +
                "; Quantity: " + quantityOrderedProducts +
                "; Sum: " + (quantityOrderedProducts*product.getPrice());
    }

}
