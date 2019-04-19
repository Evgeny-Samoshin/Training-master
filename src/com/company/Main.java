package com.company;
//https://github.com/Evgeny-Samoshin/Training.git - link on my project;
import com.company.Dao.CustomerQuery;
import com.company.Dao.OrderQuery;
import com.company.Dao.ProductQuery;
import com.company.Dao.SellerQuery;
import com.company.Entities.Customer;
import com.company.Entities.Order;
import com.company.Entities.Product;
import com.company.Entities.Seller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static java.sql.DriverManager.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Product product = new Product(1,"Meat", 350, 2);
    Customer customer = new Customer("Ivan", "Saratov","+7111");
    Seller seller = new Seller("Petr","Saratov", "+987");
    Order order = new Order(product, customer,seller, 1);
        System.out.println(order);


        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:myDb.db");//создание соединения с бд
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connected");
//        ProductQuery productQuery = new ProductQuery(conn);
//        productQuery.add(product);
//        CustomerQuery customerQuery = new CustomerQuery(conn);
//        customerQuery.add(customer);
//        SellerQuery sellerQuery = new SellerQuery(conn);
//        sellerQuery.add(seller);
//        OrderQuery orderQuery = new OrderQuery(conn);
//        orderQuery.getByID(1);
//        System.out.println(order);
        System.out.println(
                "Via this app you can to interact with SQLite DataBase \n" +
                        "If you want to add/update/delete/select:\n" +
                        "Product, please, enter - 1 \n" +
                        "Seller, please, enter - 2 \n" +
                        "Customer, please, enter - 3 \n" +
                        "Order, please, enter - 4 \n"
        );
        Scanner scanner = new Scanner(System.in);
        int chosenTable = scanner.nextInt();
        switch (chosenTable){
            case 1:
                ProductQuery productQuery = new ProductQuery(conn);
                System.out.println("You chose Product. If you want to:\n" +
                        "Add product, enter - 1\n" +
                        "Update product, enter - 2\n" +
                        "Delete product, enter - 3\n" +
                        "Select product, enter - 4\n");
                int chosenActionProduct = scanner.nextInt();
                switch (chosenActionProduct){
                    case 1:
                        productQuery.add(product); break;
                    case 2:
                        productQuery.update(product); break;
                    case 3:
                        productQuery.delete(product); break;
                    case 4:
                        System.out.println("Choose ID product to be deleted\n");
                        int chosenID = scanner.nextInt();
                        productQuery.getByID(chosenID); break;
                        default:
                            System.out.println("You get nothing, sir! You loose! Good bye, sir!");
                } break;
            case 2:
                SellerQuery sellerQuery = new SellerQuery(conn);
                System.out.println("You chose Seller. If you want to:\n" +
                        "Add seller, enter - 1\n" +
                        "Update seller, enter - 2\n" +
                        "Delete seller, enter - 3\n" +
                        "Select seller, enter - 4\n");
                int chosenActionSeller = scanner.nextInt();
                switch (chosenActionSeller){
                    case 1:
                        sellerQuery.add(seller); break;
                    case 2:
                        sellerQuery.update(seller); break;
                    case 3:
                        sellerQuery.delete(seller); break;
                    case 4:
                        System.out.println("Choose ID seller to be deleted\n");
                        int chosenID = scanner.nextInt();
                        sellerQuery.getByID(chosenID); break;
                    default:
                        System.out.println("You get nothing, sir! You loose! Good bye, sir!");
                } break;
            case 3:
                CustomerQuery customerQuery = new CustomerQuery(conn);
                System.out.println("You chose Customer. If you want:\n" +
                        "Add customer, enter - 1\n" +
                        "Update customer, enter - 2\n" +
                        "Delete customer, enter - 3\n" +
                        "Select customer, enter - 4\n");
                int chosenActionCustomer = scanner.nextInt();
                switch (chosenActionCustomer){
                    case 1:
                        customerQuery.add(customer); break;
                    case 2:
                        customerQuery.update(customer); break;
                    case 3:
                        customerQuery.delete(customer); break;
                    case 4:
                        System.out.println("Choose ID customer to be deleted\n");
                        int chosenID = scanner.nextInt();
                        customerQuery.getByID(chosenID); break;
                    default:
                        System.out.println("You get nothing, sir! You loose! Good bye, sir!");
                } break;
            case 4:
                OrderQuery orderQuery = new OrderQuery(conn);
                System.out.println("You chose Order. If you want:\n" +
                        "Add order, enter - 1\n" +
                        "Update order, enter - 2\n" +
                        "Delete order, enter - 3\n" +
                        "Select order, enter - 4\n");
                int chosenActionOrder = scanner.nextInt();
                switch (chosenActionOrder){
                    case 1:
                        orderQuery.add(order); break;
                    case 2:
                        orderQuery.update(order); break;
                    case 3:
                        orderQuery.delete(order); break;
                    case 4:
                        System.out.println("Choose ID order to be deleted\n");
                        int chosenID = scanner.nextInt();
                        orderQuery.getByID(chosenID); break;
                    default:
                        System.out.println("You get nothing, sir! You loose! Good bye, sir!");
                } break;
            default: System.out.println("You chose wrong value. Good bye!\n");
        }


    }
}
