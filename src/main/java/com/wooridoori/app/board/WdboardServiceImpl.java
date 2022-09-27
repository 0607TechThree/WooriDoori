package com.wooridoori.app.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("WdboardService")
public class WdboardServiceImpl implements WdboardService{
	@Autowired
	private WdboardDAO wdboardDAO;

	@Override
	public void insertWdboard(WdboardVO vo) {
		wdboardDAO.insertWdboard(vo);
	}

	@Override
	public void deleteWdboard(WdboardVO vo) {
		wdboardDAO.deleteWdboard(vo);
	}

	@Override
	public WdboardVO selectOneWdboard(WdboardVO vo) {
		return wdboardDAO.selectOne(vo);
	}

	@Override
	public void updateWdboard(WdboardVO vo) {
		wdboardDAO.updateWdboard(vo);
	}

	@Override
	public List<WdboardVO> selectAllWdboard(WdboardVO vo) {
		return wdboardDAO.selectAllBoard(vo);
	}

	@Override
	public void updateWdboardU(WdboardVO vo) {
		wdboardDAO.updateWdblikeU(vo);
	}

	@Override
	public void updateWdboardD(WdboardVO vo) {
		wdboardDAO.updateWdblikeD(vo);
	}
}
