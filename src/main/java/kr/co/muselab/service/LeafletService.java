package kr.co.muselab.service;

import kr.co.muselab.Leaflet;

import java.util.List;

/**
 * Created by 1002428 on 15. 6. 19..
 */
public interface LeafletService {

    public List<Leaflet> selectLeafletList();

    public void doWork();
}
