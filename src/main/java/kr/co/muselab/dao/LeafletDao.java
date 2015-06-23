package kr.co.muselab.dao;

import kr.co.muselab.Leaflet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 1002428 on 15. 6. 19..
 */
@Repository
public class LeafletDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Leaflet> selectLeafletList() {

        String query = "select leafletseq, leaflet_title from nlf_leaflet";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper(Leaflet.class));
    }
}
