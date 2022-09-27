package com.wooridoori.app.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("WdblikeService")
public class WdblikeServiceImpl implements WdblikeService{
	@Autowired
	private WdblikeDAO wdblikeDAO;
	
	@Override
	public void insertWdlike(WdblikeVO vo) {
		wdblikeDAO.insertWdlike(vo);
	}

	@Override
	public void updateWdlike(WdblikeVO vo) {
		wdblikeDAO.updateWdlike(vo);
	}

}
