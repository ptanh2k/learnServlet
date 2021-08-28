package com.learn.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learn.DBconnect.DBconnect;
import com.learn.entity.Category;

public class CategoryDao implements CategoryDaoInterface {
    @Override
    public List<Category> getCategoryList() {
        List<Category> categoryList = new ArrayList<Category>();
        Connection connection = null;

        try {
            connection = DBconnect.openConnection();
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM category");
            while (result.next()) {
                categoryList.add(new Category(result.getInt("category_id"), result.getString("category_name")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categoryList;
    }

}
