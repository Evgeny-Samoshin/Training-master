package com.company.Dao;

import com.company.Entities.Product;
import com.company.Entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductQuery implements Queries<Product>  {
    private Connection connection;

    public ProductQuery(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Product p) throws SQLException {
            PreparedStatement st = connection.prepareStatement("insert into Products (name,price,quantity) values (?,?,?)");
            st.setString(1, p.getName());
            st.setDouble(2, p.getPrice());
            st.setInt(3, p.getQuantity());
            st.execute();
            System.out.println("Product inserted");
    }

    @Override
    public void update(Product p) throws SQLException {
        PreparedStatement st = connection.prepareStatement("UPDATE Products SET Name=?, Price=?, Quantity=? WHERE ID=?");
        st.setString(1, p.getName());
        st.setDouble(2, p.getPrice());
        st.setInt(3, p.getQuantity());
        st.setInt(4, p.getID());
        st.execute();
        System.out.println("Product updated");
    }

    @Override
    public void delete(Product p) throws SQLException {
        PreparedStatement st = connection.prepareStatement("DELETE FROM Products WHERE ID=?");
        st.setInt(1, p.getID());
        st.execute();
        System.out.println("Product deleted");
    }

    @Override
    public Product getByID(int id) throws SQLException {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM Products WHERE ID=?");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        Product product = new Product();
        if ( rs.next()){
            product.setID(rs.getInt("ID"));
            product.setName(rs.getString("Name"));
            product.setPrice(rs.getDouble("Price"));
            product.setQuantity(rs.getInt("Quantity"));
            System.out.println(product);
        }
        return product;
    }


    public List<Product> getAll() throws SQLException {
        List<Product> list = new LinkedList<>();
        PreparedStatement st = connection.prepareStatement("SELECT * FROM Products");
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            Product product = new Product();
            product.setID(rs.getInt("ID"));
            product.setName(rs.getString("Name"));
            product.setPrice(rs.getDouble("Price"));
            product.setQuantity(rs.getInt("Quantity"));
            list.add(product);
        }
        System.out.println(list);
        return list;
    }
}
