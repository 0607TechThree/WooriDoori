package com.wooridoori.app.model.oneday;

public class WdonedayVO {
	private int wdopk; // pk
	private String wdoname; // 원데이클래스이름
	private String wdoregion; // 원데이클래스지역
	private String wdoaddress; // 원데이클래스주소
	private String wdosubject; // 클래스 종류 (카테고리)
	public int getWdopk() {
		return wdopk;
	}
	public void setWdopk(int wdopk) {
		this.wdopk = wdopk;
	}
	public String getWdoname() {
		return wdoname;
	}
	public void setWdoname(String wdoname) {
		this.wdoname = wdoname;
	}
	public String getWdoregion() {
		return wdoregion;
	}
	public void setWdoregion(String wdoregion) {
		this.wdoregion = wdoregion;
	}
	public String getWdoaddress() {
		return wdoaddress;
	}
	public void setWdoaddress(String wdoaddress) {
		this.wdoaddress = wdoaddress;
	}
	public String getWdosubject() {
		return wdosubject;
	}
	public void setWdosubject(String wdosubject) {
		this.wdosubject = wdosubject;
	}
	@Override
	public String toString() {
		return "WdonedayVO [wdopk=" + wdopk + ", wdoname=" + wdoname + ", wdoregion=" + wdoregion + ", wdoaddress="
				+ wdoaddress + ", wdosubject=" + wdosubject + "]";
	}
	
}
