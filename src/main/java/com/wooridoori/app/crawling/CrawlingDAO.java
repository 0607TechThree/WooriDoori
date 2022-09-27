package com.wooridoori.app.crawling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wooridoori.app.model.image.WdimageVO;
import com.wooridoori.app.model.oneday.WdonedayVO;

public class CrawlingDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	final String sql_insert_I="INSERT INTO WDIMAGE VALUES(?,?,?)";
	final String sql_insert_O="INSERT INTO WDONEDAY VALUES(?,?,?,?,?)";
	
	public void insertWdoneday(WdonedayVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert_O);
			pstmt.setInt(1, vo.getWdopk());
			pstmt.setString(2, vo.getWdoname());
			pstmt.setString(3, vo.getWdoregion());
			pstmt.setString(4, vo.getWdoaddress());
			pstmt.setString(5, vo.getWdosubject());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	public void insertWdimage(WdimageVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert_I);
			pstmt.setInt(1, vo.getWdipk());
			pstmt.setInt(2, vo.getWdopk());
			pstmt.setString(3, vo.getWdipickname());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
}
