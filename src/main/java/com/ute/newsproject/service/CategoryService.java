package com.ute.newsproject.service;

import com.ute.newsproject.beans.Category;
import com.ute.newsproject.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class CategoryService {
    public static List<Category> getAll() {
        String sql = "select * from categories";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(sql).executeAndFetch(Category.class);
        }
    }

    public static Category get(int id) {
        String sql = "select * from categories where cat_id = :cat_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Category> list = con.createQuery(sql)
                    .addParameter("cat_id", id)
                    .executeAndFetch(Category.class);

            if (list.size() == 0)
                return null;

            return list.get(0);
        }
    }
}
