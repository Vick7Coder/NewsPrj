package com.ute.newsproject.service;

import com.ute.newsproject.beans.Tag;
import com.ute.newsproject.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class TagService {
    public static List<Tag> getAll() {
        String sql = "select * from tags";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(sql).executeAndFetch(Tag.class);
        }
    }

    public static Tag findById(int id) {
        String sql = "select * from tags where tag_id = :tag_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Tag> list = con.createQuery(sql)
                    .addParameter("tag_id", id)
                    .executeAndFetch(Tag.class);

            if (list.size() == 0)
                return null;

            return list.get(0);
        }
    }
}
