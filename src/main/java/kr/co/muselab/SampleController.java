package kr.co.muselab;

import kr.co.muselab.service.LeafletService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 1002428 on 15. 6. 18..
 */
@RestController
public class SampleController {

    final static Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private LeafletService leafletService;

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping(value="/leaflet", method= RequestMethod.POST)
    public List selectLeafletList() {
        logger.debug("Controller Post start!!");
        return leafletService.selectLeafletList();
    }

    @RequestMapping(value="/leaflet", method= RequestMethod.GET)
    public List selectLeafletListGET() {
        logger.debug("Controller GET start!!");
        return leafletService.selectLeafletList();
    }

    @RequestMapping("/doWork")
    public String doWork() {
        leafletService.doWork();
        return "Your request has been queued!!";
    }
}
