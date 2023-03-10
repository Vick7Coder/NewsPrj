package com.ute.newsproject.service;

import com.ute.newsproject.beans.User;
import com.ute.newsproject.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class UserService {
    public static List<User> getAll() {
        String sql = "select * from users";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(sql).executeAndFetch(User.class);
        }
    }

    public static User get(int id) {
        String sql = "select * from users where user_id = :user_id";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(sql)
                    .addParameter("user_id", id)
                    .executeAndFetch(User.class);

            if (list.size() == 0)
                return null;

            return list.get(0);
        }
    }

    public static User findByUsername(String uName) {
        final String query = "select * from users where uName = :uName";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("uName", uName)
                    .executeAndFetch(User.class);

            if (list.size() == 0) {
                return null;
            }

            return list.get(0);
        }
    }
}
