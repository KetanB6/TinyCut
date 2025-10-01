package com.ketan.urlshortner.repo;

import com.ketan.urlshortner.model.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UrlRepo {
    @Autowired
    private JdbcTemplate template;

    public boolean save(URL url) {
        String query="insert into urls values(?, ?);";
        int rows_affected = template.update(query, url.getShortURL(), url.getLongURL());
        if(rows_affected == 0){
            System.out.println("Database error!");
            return false;
        }
        return true;
    }

    public List<URL> getURL(String code) {
        String query = "SELECT *FROM urls";
        RowMapper<URL> rw = new RowMapper<>() {
            @Override
            public URL mapRow(ResultSet rs, int rowNum) throws SQLException {
                URL url = new URL();
                url.setShortURL(rs.getString(1));
                url.setLongURL(rs.getString(2));
                return url;
            }
        };
        return template.query(query, rw);
    }
}
