package com.wooridoori.app.model.oneday;

import java.util.List;

public interface WdonedayService {
	void insertWdoneday(WdonedayVO vo);
	WdonedayVO selectOneWdoneday(WdonedayVO vo);
	List<WdonedayVO> selectAllWdoneday(WdonedayVO vo);
}
