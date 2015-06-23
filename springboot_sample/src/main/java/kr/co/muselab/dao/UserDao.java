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

    public User selectUserById(String id) {
        String query = "select id, name, age from user where id=? ";
        return (User)jdbcTemplate.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper(User.class));
    }

    public void insertUser(User user) {
        String query = "insert into user(id,name,age) values (?,?,?) ";
        jdbcTemplate.update(query, new Object[]{user.getId(), user.getName(), user.getAge()});
    }

    public void updateUser(String id, User user) {
        String query = "update user set name=?, age=? where id=? ";
        jdbcTemplate.update(query, new Object[]{ user.getName(), user.getAge(), id});
    }

    public void deleteUser(String id) {
        String query = "delete from user where id=?";
        jdbcTemplate.update(query,new Object[]{id});
    }
}
