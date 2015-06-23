package kr.co.muselab.dao;

import kr.co.muselab.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 1002428 on 15. 6. 23..
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> selectUserList() {
        String query = "select id, name, age from user";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper(User.class));
    }
}
