package kr.co.muselab.service;

import kr.co.muselab.Leaflet;
import kr.co.muselab.dao.LeafletDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 1002428 on 15. 6. 19..
 */
@Service("leafletService")
public class LeafletServiceImpl implements LeafletService {

    final static Logger logger = LoggerFactory.getLogger(LeafletServiceImpl.class);

    @Autowired
    private LeafletDao leafletdao;

    public List<Leaflet> selectLeafletList() {
        return leafletdao.selectLeafletList();
    }

    @Async("workExecutor")
    @Override
    public void doWork() {
        try {
            Thread.sleep(10*1000);
            logger.debug("complete work, send email!");
        } catch(InterruptedException ie) {
            logger.debug(ie.getMessage());
        }
    }
}
