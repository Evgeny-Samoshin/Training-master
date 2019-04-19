package com.company.Dao;

import com.company.Entities.Order;
import com.company.Entities.Product;

import java.sql.*;
import java.util.List;

public class OrderQuery implements Queries<Order> {
    private Connection connection;

    public OrderQuery(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Order order) throws SQLException {
        PreparedStatement st =
                connection.prepareStatement("insert into Orders (Product_ID,Customer_ID,Seller_ID,Quantity) values (?,?,?,?)");
        st.setInt(1, order.getProduct().getID());
        st.setInt(2, order.getCustomer());
        st.setInt(3, order.getSeller());
        st.setInt(4, order.getQuantityOrderedProducts());
        st.execute();
        System.out.println("Order inserted");
    }

    @Override
    public void update(Order order) throws SQLException {
        PreparedStatement st =
                connection.prepareStatement("UPDATE Orders SET Product_ID=?, Customer_ID=?, Seller_ID, Quantity=? WHERE ID=?");
        st.setInt(1, order.getProduct().getID());
        st.setInt(2, order.getCustomer());
        st.setInt(3, order.getSeller());
        st.setInt(4, order.getQuantityOrderedProducts());
        st.execute();
        System.out.println("Order updated");
    }

    @Override
    public void delete(Order order) throws SQLException {
        PreparedStatement st =
                connection.prepareStatement("DELETE FROM Orders WHERE ID=?");
        st.setInt(1, order.getID());
        st.execute();
        System.out.println("Order deleted");
    }

    @Override
    public Order getByID(int id) throws SQLException {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM Orders WHERE ID=?");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        Order order = new Order();
        if ( rs.next()){
            order.setID(rs.getInt("ID"));
            order.setCustomer(rs.getInt("Customer_ID"));
            order.setSeller(rs.getInt("Seller_ID"));
            order.setQuantityOrderedProducts(rs.getInt("Quantity"));
            System.out.println(order);
        }
        return order;
    }



    public List<Order> getAll() {
        return null;
    }
}
