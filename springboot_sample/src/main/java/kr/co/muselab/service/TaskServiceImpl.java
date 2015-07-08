package kr.co.muselab.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by 1002428 on 15. 7. 8..
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {

    final static Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Async("workExecutor")
    @Override
    public void doWork() {
        try {
            Thread.sleep(10*1000);
            logger.debug("complete doWork!!");
        } catch(InterruptedException e) {
            logger.debug(e.getMessage());
        }
    }

    @Async
    @Override
    public void doWork1() {
        try {
            Thread.sleep(10*1000);
            logger.debug("complete doWork1!!");
        } catch(InterruptedException e) {
            logger.debug(e.getMessage());
        }
    }
}
