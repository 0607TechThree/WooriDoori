package com.wooridoori.app.like;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("wdblikeDAO")
public class WdblikeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String sql_insert="INSERT INTO WDBLIKE VALUES((SELECT NVL(MAX(WDLPK),0) +1 FROM WDBLIKE),?,?,1)";
	final String sql_update="UPDATE WDBLIKE SET WDCHECK=? WHERE WDBPK=? AND WDMPK=?";
	
	void insertWdlike(WdblikeVO vo) {
		jdbcTemplate.update(sql_insert, vo.getWdbpk(),vo.getWdmpk());
	}
	void updateWdlike(WdblikeVO vo) {
		if(vo.getWdcheck() == 1) {
			vo.setWdcheck(0);
		}else {
			vo.setWdcheck(1);
		}
		jdbcTemplate.update(sql_update, vo.getWdcheck(),vo.getWdbpk(),vo.getWdmpk());
	}
}
class WdblikeRowMapper implements RowMapper<WdblikeVO> {

	@Override
	public WdblikeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		WdblikeVO data=new WdblikeVO();
		data.setWdlpk(rs.getInt("WDLPK"));
		data.setWdbpk(rs.getInt("WDBPK"));
		data.setWdmpk(rs.getInt("WDMPK"));
		data.setWdcheck(rs.getInt("WDCHECK"));
		return data;
	}
}