package com.wooridoori.app.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("wdboardDAO")
public class WdboardDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String sql_selectOne="SELECT * FROM WDBOARD WHERE WDBPK = ?";
	final String sql_insert="INSERT INTO WDBOARD VALUES((SELECT NVL(MAX(WDBPK),0) +1 FROM WDBOARD),?,?,?,?)";
	final String sql_delete="DELETE FROM WDBOARD WHERE WDBPK=?";
	final String sql_update="UPDATE WDBOARD SET WDBTITLE=? AND WDBCONTENT=? WHERE WDBPK=?";
	final String sql_update_LU="UPDATE WDBOARD SET WDBLIKE=WDBLIKE+1 WHERE WDBPK=?";
	final String sql_update_LD="UPDATE WDBOARD SET WDBLIKE=WDBLIKE-1 WHERE WDBPK=?";
	final String sql_selectAll="SELECT * FROM WDBOARD ORDER BY WDBPK DESC";
	final String sql_searchTitle="SELECT * FROM WDBOARD WHERE WDBTITLE LIKE '%'||?||'%' ORDER BY WDBPK DESC";
	final String sql_searchWriter="SELECT * FROM WDBOARD WHERE WDBCONTENT LIKE '%'||?||'%' ORDER BY WDBPK DESC";
	
	void insertWdboard(WdboardVO vo) {
		jdbcTemplate.update(sql_insert, vo.getWdbwriter(),vo.getWdbtitle(),vo.getWdbcontent(),vo.getWdblike(),vo.getWdbopen());	
	}
	void deleteWdboard(WdboardVO vo) {
		jdbcTemplate.update(sql_delete, vo.getWdbpk());
	}
	void updateWdboard(WdboardVO vo) {
		jdbcTemplate.update(sql_update,vo.getWdbtitle(),vo.getWdbcontent(),vo.getWdbpk());
	}
	void updateWdblikeU(WdboardVO vo) {
		jdbcTemplate.update(sql_update_LU,vo.getWdbpk());
	}
	void updateWdblikeD(WdboardVO vo) {
		jdbcTemplate.update(sql_update_LD,vo.getWdbpk());
	}
	WdboardVO selectOne(WdboardVO vo) {
		Object[] args= {vo.getWdbpk()};
		return jdbcTemplate.queryForObject(sql_selectOne, args,new WdboardRowMapper());
	}
	List<WdboardVO> selectAllBoard(WdboardVO vo) {
		if(vo.getWdbtitle() != null) {
			Object[] args= {vo.getWdbtitle()};			
			return jdbcTemplate.query(sql_searchTitle,args,new WdboardRowMapper());
		}else if(vo.getWdbtitle() != null) {
			Object[] args= {vo.getWdbtitle()};			
			return jdbcTemplate.query(sql_searchWriter,args,new WdboardRowMapper());
		}else {
			return jdbcTemplate.query(sql_selectAll,new WdboardRowMapper());
		}
	}
}
class WdboardRowMapper implements RowMapper<WdboardVO> {

	@Override
	public WdboardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		WdboardVO data=new WdboardVO();
		data.setWdbpk(rs.getInt("WDBPK"));
		data.setWdbwriter(rs.getInt("WDBWRITER"));
		data.setWdbtitle(rs.getString("WDBTITLE"));
		data.setWdbcontent(rs.getString("WDBCONTENT"));
		data.setWdblike(rs.getInt("WDBLIKE"));
		data.setWdbopen(rs.getInt("WDBOPEN"));
		return data;
	}
}