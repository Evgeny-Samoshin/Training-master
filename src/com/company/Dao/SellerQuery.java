package com.company.Dao;

import com.company.Entities.Customer;
import com.company.Entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SellerQuery implements Queries<Seller> {
    private Connection connection;

    public SellerQuery(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Seller seller) {
        try {
            PreparedStatement st = connection.prepareStatement("insert into Sellers (name,address,telephone) values (?,?,?)");
            st.setString(1, seller.getName());
            st.setString(2, seller.getAddress());
            st.setString(3, seller.getTelephone());
            st.execute();
            System.out.println("Seller inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Seller seller) throws SQLException {
        PreparedStatement st = connection.prepareStatement("UPDATE Sellers SET Name=?, Address=?, Telephone=? WHERE ID=?");
        st.setString(1, seller.getName());
        st.setString(2, seller.getAddress());
        st.setString(3, seller.getTelephone());
        st.setInt(4, seller.getID());
        st.execute();
        System.out.println("Seller updated");
    }

    @Override
    public void delete(Seller seller) throws SQLException {
        PreparedStatement st = connection.prepareStatement("DELETE FROM Sellers WHERE ID=?");
        st.setInt(1, seller.getID());
        st.execute();
        System.out.println("Seller deleted");
    }

    @Override
    public Seller getByID(int id) throws SQLException {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM Sellers WHERE ID=?");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        Seller seller = new Seller();
        if ( rs.next()){
            seller.setID(rs.getInt("ID"));
            seller.setName(rs.getString("Name"));
            seller.setAddress(rs.getString("Address"));
            seller.setTelephone(rs.getString("Telephone"));
            System.out.println(seller);
        }
        return seller;
    }



    public List<Seller> getAll() throws SQLException {
        List<Seller> list = new LinkedList<>();
        PreparedStatement st = connection.prepareStatement("SELECT * FROM Sellers");
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            Seller seller = new Seller();
            seller.setID(rs.getInt("ID"));
            seller.setName(rs.getString("Name"));
            seller.setAddress(rs.getString("Address"));
            seller.setTelephone(rs.getString("Telephone"));
            list.add(seller);
        }
        System.out.println(list);
        return list;
    }
}
