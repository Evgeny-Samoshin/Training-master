package com.company.Dao;

import com.company.Entities.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CustomerQuery implements Queries<Customer> {
    private Connection connection;

    public CustomerQuery(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Customer customer) {
        try {
            PreparedStatement st = connection.prepareStatement("insert into Customers (name,address,telephone) values (?,?,?)");
            st.setString(1, customer.getName());
            st.setString(2, customer.getAddress());
            st.setString(3, customer.getTelephone());
            st.execute();
            System.out.println("Customer inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Customer customer) throws SQLException {
        PreparedStatement st = connection.prepareStatement("UPDATE Customers SET Name=?, Address=?, Telephone=? WHERE ID=?");
        st.setString(1, customer.getName());
        st.setString(2, customer.getAddress());
        st.setString(3, customer.getTelephone());
        st.setInt(4, customer.getID());
        st.execute();
        System.out.println("Customer updated");
    }

    @Override
    public void delete(Customer customer) throws SQLException {
        PreparedStatement st = connection.prepareStatement("DELETE FROM Customers WHERE ID=?");
        st.setInt(1, customer.getID());
        st.execute();
        System.out.println("Customer deleted");
    }

    @Override
    public Customer getByID(int id) throws SQLException {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM Customers WHERE ID=?");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        Customer customer = new Customer();
        if ( rs.next()){
            customer.setID(rs.getInt("ID"));
            customer.setName(rs.getString("Name"));
            customer.setAddress(rs.getString("Address"));
            customer.setTelephone(rs.getString("Telephone"));
            System.out.println(customer);
        }
        return customer;
    }

    public List<Customer> getAll() throws SQLException {
        List<Customer> list = new LinkedList<>();
        PreparedStatement st = connection.prepareStatement("SELECT * FROM Customers");
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            Customer customer = new Customer();
            customer.setID(rs.getInt("ID"));
            customer.setName(rs.getString("Name"));
            customer.setAddress(rs.getString("Address"));
            customer.setTelephone(rs.getString("Telephone"));
            list.add(customer);
        }
        System.out.println(list);
        return list;
    }

}
