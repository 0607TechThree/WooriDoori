package com.wooridoori.app.model.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("WdmemberService")
public class WdmemberServiceImpl implements WdmemberService{

	@Autowired
	private WdmemberDAO wdmemberDAO;
	
	@Override
	public void insertWdmember(WdmemberVO vo) {
		wdmemberDAO.insertWdmember(vo);
	}

	@Override
	public void updateWdmember(WdmemberVO vo) {
		wdmemberDAO.updateWdmember(vo);
	}

	@Override
	public void deleteWdmember(WdmemberVO vo) {
		wdmemberDAO.deleteWdmember(vo);
	}

	@Override
	public WdmemberVO selectOneWdmember(WdmemberVO vo) {
		return wdmemberDAO.selectOne(vo);
	}

}
