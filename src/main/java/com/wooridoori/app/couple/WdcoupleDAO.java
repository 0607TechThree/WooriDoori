package com.wooridoori.app.couple;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("wdcoupleDAO")
public class WdcoupleDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String sql_selectOne="SELECT * FROM WDCOUPLE WHERE WDCPK = ?";
	final String sql_insert="INSERT INTO WDCOUPLE VALUES((SELECT NVL(MAX(WDCPK),0) +1 FROM WDBOARD),?,?,?)";
	final String sql_delete="DELETE FROM WDCOUPLE WHERE WDCPK=?";
	
	void insertWdcouple(WdcoupleVO vo) {
		jdbcTemplate.update(sql_insert,vo.getWdcwoori(),vo.getWdcdoori(),vo.getWdcdate());
	}
	void deleteWdcouple(WdcoupleVO vo) {
		jdbcTemplate.update(sql_delete,vo.getWdcpk());
	}
	WdcoupleVO selectOne(WdcoupleVO vo) {
		Object[] args= {vo.getWdcpk()};
		return jdbcTemplate.queryForObject(sql_selectOne, args,new WdcoupleRowMapper());
	}
}
class WdcoupleRowMapper implements RowMapper<WdcoupleVO> {

	@Override
	public WdcoupleVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		WdcoupleVO data=new WdcoupleVO();
		data.setWdcpk(rs.getInt("WDCPK"));
		data.setWdcwoori(rs.getInt("WDCWOORI"));
		data.setWdcdoori(rs.getInt("WDCDOORI"));
		data.setWdcdate(rs.getString("WDCDATE"));
		return data;
	}
}