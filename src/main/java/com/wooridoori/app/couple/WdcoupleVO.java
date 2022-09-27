package com.wooridoori.app.couple;

public class WdcoupleVO {
	private int wdcpk;
	private int wdcwoori;
	private int wdcdoori;
	private String wdcdate;
	public int getWdcpk() {
		return wdcpk;
	}
	public void setWdcpk(int wdcpk) {
		this.wdcpk = wdcpk;
	}
	public int getWdcwoori() {
		return wdcwoori;
	}
	public void setWdcwoori(int wdcwoori) {
		this.wdcwoori = wdcwoori;
	}
	public int getWdcdoori() {
		return wdcdoori;
	}
	public void setWdcdoori(int wdcdoori) {
		this.wdcdoori = wdcdoori;
	}
	public String getWdcdate() {
		return wdcdate;
	}
	public void setWdcdate(String wdcdate) {
		this.wdcdate = wdcdate;
	}
	@Override
	public String toString() {
		return "WdcoupleVO [wdcpk=" + wdcpk + ", wdcwoori=" + wdcwoori + ", wdcdoori=" + wdcdoori + ", wdcdate="
				+ wdcdate + "]";
	}
	
}
