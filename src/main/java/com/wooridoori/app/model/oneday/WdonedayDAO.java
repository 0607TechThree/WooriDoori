package com.wooridoori.app.model.oneday;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository("wdonedayDAO")
public class WdonedayDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String sql_selectOne="SELECT * FROM WDONEDAY WHERE WDOPK = ?";
	final String sql_selectAll="SELECT * FROM WDONEDAY";
	final String sql_insert="INSERT INTO WDONEDAY VALUES((SELECT NVL(MAX(WDOPK),0) +1 FROM WDONEDAY),?,?,?,?)";
	
	void insertWdoneday(WdonedayVO vo) {
		jdbcTemplate.update(sql_insert,vo.getWdoname(),vo.getWdoregion(),vo.getWdoaddress(),vo.getWdosubject());
	}
	public WdonedayVO selectOneWdoneday(WdonedayVO vo) {
		Object[] args= {vo.getWdopk()};
		return jdbcTemplate.queryForObject(sql_selectOne,args,new WdonedayRowMapper());
	}
	List<WdonedayVO> selectAllWdoneday(WdonedayVO vo) {
		return jdbcTemplate.query(sql_selectAll,new WdonedayRowMapper());
	}
}
class WdonedayRowMapper implements RowMapper<WdonedayVO> {

	@Override
	public WdonedayVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		WdonedayVO data=new WdonedayVO();
		data.setWdopk(rs.getInt("WDOPK"));
		data.setWdoname(rs.getString("WDONAME"));
		data.setWdoregion(rs.getString("WDOREGION"));
		data.setWdoaddress(rs.getString("WDOADDRESS"));
		data.setWdosubject(rs.getString("WDOSUBJECT"));
		return data;
	}
}
