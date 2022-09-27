package com.wooridoori.app.board;

import java.util.List;

public interface WdboardService {
	void insertWdboard(WdboardVO vo);
	void deleteWdboard(WdboardVO vo);
	void updateWdboard(WdboardVO vo);
	void updateWdboardU(WdboardVO vo);
	void updateWdboardD(WdboardVO vo);
	WdboardVO selectOneWdboard(WdboardVO vo);
	List<WdboardVO> selectAllWdboard(WdboardVO vo);
}
