package com.wooridoori.app.couple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("WdcoupleService")
public class WdcoupleServiceImpl implements WdcoupleService{
	@Autowired
	private WdcoupleDAO wdcoupleDAO;

	@Override
	public void insertWdcouple(WdcoupleVO vo) {
		wdcoupleDAO.insertWdcouple(vo);
	}

	@Override
	public void deleteWdcouple(WdcoupleVO vo) {
		wdcoupleDAO.deleteWdcouple(vo);
	}

	@Override
	public WdcoupleVO selectOneWdcouple(WdcoupleVO vo) {
		return wdcoupleDAO.selectOne(vo);
	}
}
