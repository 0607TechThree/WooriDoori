package com.wooridoori.app.model.oneday;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("onedayService")
public class WdonedayServiceImpl implements WdonedayService{
	
	@Autowired
	private WdonedayDAO wdonedayDAO;

	@Override
	public void insertWdoneday(WdonedayVO vo) {
		//wdonedayDAO.insertWdoneday(vo);		
	}

	@Override
	public WdonedayVO selectOneWdoneday(WdonedayVO vo) {
		return wdonedayDAO.selectOneWdoneday(vo);
	}

	@Override
	public List<WdonedayVO> selectAllWdoneday(WdonedayVO vo) {
		return wdonedayDAO.selectAllWdoneday(vo);
	}
	
}
