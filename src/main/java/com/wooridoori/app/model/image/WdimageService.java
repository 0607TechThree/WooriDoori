package com.wooridoori.app.model.image;

import java.util.List;

public interface WdimageService {
	void insertWdimage(WdimageVO vo);
	List<WdimageVO> selectAllWdimage(WdimageVO vo);
}
