package com.company.Dao;

import com.company.Entities.Customer;
import com.company.Entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface Queries<T> {

    void add (T p) throws SQLException;
    void update (T p) throws SQLException;
    void delete (T p) throws SQLException;
    T getByID (int i) throws SQLException;
}
