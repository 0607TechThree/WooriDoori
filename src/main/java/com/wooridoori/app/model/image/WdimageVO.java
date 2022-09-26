package com.wooridoori.app.model.image;

public class WdimageVO {
	private int wdipk; // pk
	private int wdopk; // 원데이클래스 테이블의 pk
	private String wdipickname; // 사진의 이름
	public int getWdipk() {
		return wdipk;
	}
	public void setWdipk(int wdipk) {
		this.wdipk = wdipk;
	}
	public int getWdopk() {
		return wdopk;
	}
	public void setWdopk(int wdopk) {
		this.wdopk = wdopk;
	}
	public String getWdipickname() {
		return wdipickname;
	}
	public void setWdipickname(String wdipickname) {
		this.wdipickname = wdipickname;
	}
	@Override
	public String toString() {
		return "WdimageVO [wdipk=" + wdipk + ", wdopk=" + wdopk + ", wdipickname=" + wdipickname + "]";
	}
	
}
