package com.wooridoori.app.model.member;

public class WdmemberVO {
	private int wdmpk;
	private String wdmid;
	private String wdmpw;
	private String wdmnick;
	private String wdmemail;
	private String wdmgender;
	private String wdmmbti;
	private String nemail;
	private String kemail;
	private int wdmvip;
	public int getWdmpk() {
		return wdmpk;
	}
	public void setWdmpk(int wdmpk) {
		this.wdmpk = wdmpk;
	}
	public String getWdmid() {
		return wdmid;
	}
	public void setWdmid(String wdmid) {
		this.wdmid = wdmid;
	}
	public String getWdmpw() {
		return wdmpw;
	}
	public void setWdmpw(String wdmpw) {
		this.wdmpw = wdmpw;
	}
	public String getWdmnick() {
		return wdmnick;
	}
	public void setWdmnick(String wdmnick) {
		this.wdmnick = wdmnick;
	}
	public String getWdmemail() {
		return wdmemail;
	}
	public void setWdmemail(String wdmemail) {
		this.wdmemail = wdmemail;
	}
	public String getWdmgender() {
		return wdmgender;
	}
	public void setWdmgender(String wdmgender) {
		this.wdmgender = wdmgender;
	}
	public String getWdmmbti() {
		return wdmmbti;
	}
	public void setWdmmbti(String wdmmbti) {
		this.wdmmbti = wdmmbti;
	}
	public String getNemail() {
		return nemail;
	}
	public void setNemail(String nemail) {
		this.nemail = nemail;
	}
	public String getKemail() {
		return kemail;
	}
	public void setKemail(String kemail) {
		this.kemail = kemail;
	}
	public int getWdmvip() {
		return wdmvip;
	}
	public void setWdmvip(int wdmvip) {
		this.wdmvip = wdmvip;
	}
	@Override
	public String toString() {
		return "WdmemberVO [wdmpk=" + wdmpk + ", wdmid=" + wdmid + ", wdmpw=" + wdmpw + ", wdmnick=" + wdmnick
				+ ", wdmemail=" + wdmemail + ", wdmgender=" + wdmgender + ", wdmmbti=" + wdmmbti + ", nemail=" + nemail
				+ ", kemail=" + kemail + ", wdmvip=" + wdmvip + "]";
	}
	
	
}
