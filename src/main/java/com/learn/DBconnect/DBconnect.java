package com.learn.DBconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
    public Connection connection = null;

    public DBconnect() {

    }

    public static Connection openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_sys", "root",
                "Anh988119@@@");
        return connection;
    }
}
