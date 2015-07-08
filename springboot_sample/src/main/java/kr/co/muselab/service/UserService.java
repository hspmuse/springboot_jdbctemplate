package kr.co.muselab.service;

import kr.co.muselab.domain.User;

import java.util.List;

/**
 * Created by 1002428 on 15. 6. 19..
 */
public interface UserService {

    public List<User> selectUserList();

    public User selectUserById(String id);

    public void insertUser(User user);

    public void updateUser(String id, User user);

    public void deleteUser(String id);

}
