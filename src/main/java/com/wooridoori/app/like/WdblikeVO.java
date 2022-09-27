package com.wooridoori.app.like;

public class WdblikeVO {
	private int wdlpk;
	private int wdbpk;
	private int wdmpk;
	private int wdcheck;
	public int getWdlpk() {
		return wdlpk;
	}
	public void setWdlpk(int wdlpk) {
		this.wdlpk = wdlpk;
	}
	public int getWdbpk() {
		return wdbpk;
	}
	public void setWdbpk(int wdbpk) {
		this.wdbpk = wdbpk;
	}
	public int getWdmpk() {
		return wdmpk;
	}
	public void setWdmpk(int wdmpk) {
		this.wdmpk = wdmpk;
	}
	public int getWdcheck() {
		return wdcheck;
	}
	public void setWdcheck(int wdcheck) {
		this.wdcheck = wdcheck;
	}
	@Override
	public String toString() {
		return "WdblikeVO [wdlpk=" + wdlpk + ", wdbpk=" + wdbpk + ", wdmpk=" + wdmpk + ", wdcheck=" + wdcheck + "]";
	}
}
