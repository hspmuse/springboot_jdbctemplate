package kr.co.muselab.controller;

import kr.co.muselab.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 1002428 on 15. 7. 8..
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    final static Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @RequestMapping(value="/async/dowork")
    public void doWork() {
        taskService.doWork();
        logger.debug("Controller doWork End!!");
    }

    @RequestMapping(value="/async/dowork1")
    public void doWork1() {
        taskService.doWork1();
        logger.debug("Controller doWork1 End!!");
    }
}
