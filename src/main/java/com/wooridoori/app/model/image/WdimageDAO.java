package com.wooridoori.app.model.image;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("wdimageDAO")
public class WdimageDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	final String sql_selectAll="SELECT * FROM WDIMAGE";
//	final String sql_insert="INSERT INTO WDIMAGE VALUES((SELECT NVL(MAX(WDIPK),0) +1 FROM WDIMAGE),?,?)";

//	public void insertWdimage(WdimageVO vo) {
//		jdbcTemplate.update(sql_insert,vo.getWdopk(),vo.getWdipickname());
//	}
	List<WdimageVO> selectAllWdimage(WdimageVO vo){
		return jdbcTemplate.query(sql_selectAll,new WdimageRowMapper());
	}
}
class WdimageRowMapper implements RowMapper<WdimageVO> {

	@Override
	public WdimageVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		WdimageVO data=new WdimageVO();
		data.setWdipk(rs.getInt("WDIPK"));
		data.setWdopk(rs.getInt("WDOPK"));
		data.setWdipickname(rs.getString("WDIPICKNAME"));
		return data;
	}
}
