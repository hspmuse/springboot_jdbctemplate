package kr.co.muselab.service;

import kr.co.muselab.dao.UserDao;
import kr.co.muselab.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 1002428 on 15. 6. 19..
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    public List<User> selectUserList() {
        return userDao.selectUserList();
    }

}
