package kr.co.muselab.controller;

import kr.co.muselab.domain.User;
import kr.co.muselab.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 1002428 on 15. 6. 23..
 */
@RestController
public class UserController {

    final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> selectUserList() {
        return userService.selectUserList();
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.GET)
    public User selectUserById(@PathVariable("id") String id) {
        return userService.selectUserById(id);
    }

    @RequestMapping(value="/users", method = RequestMethod.POST)
    public void insertUser(@RequestBody User user){

        logger.debug("id=" + user.getId());
        logger.debug("Name=" + user.getName());
        logger.debug("age=" + user.getAge());

        userService.insertUser(user);
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user, @PathVariable("id") String id) {
        logger.debug("id=" + id);
        userService.updateUser(id, user);
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
    }

    @RequestMapping(value="/users/async")
    public void asyncTest() {
        userService.doWork();
        logger.debug("Controller doWork End!!");
    }
}
