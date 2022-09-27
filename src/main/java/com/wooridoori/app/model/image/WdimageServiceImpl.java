package com.wooridoori.app.model.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class WdimageServiceImpl implements WdimageService{
	@Autowired
	private WdimageDAO wdimageDAO;
	@Override
	public void insertWdimage(WdimageVO vo) {
		//wdimageDAO.insertWdimage(vo);	
	}

	@Override
	public List<WdimageVO> selectAllWdimage(WdimageVO vo) {
		return wdimageDAO.selectAllWdimage(vo);
	}

}
