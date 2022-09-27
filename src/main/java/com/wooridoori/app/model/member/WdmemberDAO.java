package com.wooridoori.app.model.member;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("WdmemberDAO")
public class WdmemberDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String sql_selectOne="SELECT * FROM WDMEMBER WHERE WDMPK = ?";
	final String sql_insert="INSERT INTO WDMEMBER VALUES((SELECT NVL(MAX(WDMPK),0) +1 FROM WDMEMBER),?,?,?,?,?,?,?,?,?)";
	final String sql_update="UPDATE WDMEMBER SET WDMPW=? AND WDMNICK=? WHERE WDMID=?";
	final String sql_delete="DELETE FROM WDMEMBER WHERE WDMID=?";
	
	void insertWdmember(WdmemberVO vo) {
		if(vo.getNemail() == null && vo.getKemail() == null) {
			vo.setNemail("-");
			vo.setKemail("-");
		}else if(vo.getKemail() == null) {
			vo.setKemail("-");
		}else {
			vo.setNemail("-");
		}
		jdbcTemplate.update(sql_insert,vo.getWdmid(),vo.getWdmpw(),vo.getWdmnick(),vo.getWdmemail(),vo.getWdmgender(),vo.getWdmmbti(),vo.getNemail(),vo.getKemail(),vo.getWdmvip());
	}
	void updateWdmember(WdmemberVO vo) {
		jdbcTemplate.update(sql_update,vo.getWdmpw(),vo.getWdmnick(),vo.getWdmid());
	}
	void deleteWdmember(WdmemberVO vo) {
		jdbcTemplate.update(sql_delete,vo.getWdmid());
	}
	WdmemberVO selectOne(WdmemberVO vo) {
		Object[] args= {vo.getWdmpk()};
		return jdbcTemplate.queryForObject(sql_selectOne,args,new WdmemberRowMapper());
	}
}
class WdmemberRowMapper implements RowMapper<WdmemberVO> {

	@Override
	public WdmemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		WdmemberVO data=new WdmemberVO();
		data.setWdmpk(rs.getInt("WDMPK"));
		data.setWdmid(rs.getString("WDMID"));
		data.setWdmpw(rs.getString("WDMPW"));
		data.setWdmnick(rs.getString("WDMNICK"));
		data.setWdmemail(rs.getString("WDMEMAIL"));
		data.setWdmgender(rs.getString("WDMGENDER"));
		data.setWdmmbti(rs.getString("WDMMBTI"));
		data.setNemail(rs.getString("NEMAIL"));
		data.setKemail(rs.getString("KEMAIL"));
		data.setWdmvip(rs.getInt("WDMVIP"));
		return data;
	}
}