package com.wooridoori.app.model.member;

public interface WdmemberService {
	void insertWdmember(WdmemberVO vo);
	void updateWdmember(WdmemberVO vo);
	void deleteWdmember(WdmemberVO vo);	
	WdmemberVO selectOneWdmember(WdmemberVO vo);
}
