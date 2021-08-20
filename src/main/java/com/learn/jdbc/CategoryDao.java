package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learn.entity.Category;

public class CategoryDao implements CategoryDaoInterface {
    private static final String url = "jdbc:mysql://localhost:3306/book_sys";
    private static final String name = "root";
    private static final String password = "Anh988119@@@";

    private static final String driver = "com.mysql.cj.jdbc.Driver";

    @Override
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<Category>();

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM category");
            while (result.next()) {
                categories.add(new Category(result.getInt("category_id"), result.getString("category_name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }

}
