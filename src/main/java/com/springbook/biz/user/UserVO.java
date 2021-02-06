package com.springbook.biz.user;

//VO(Value Object)
public class UserVO {
	private String uname;
	private String upw;
	private String uemail;
	private int uage;
	private boolean ujob;
	

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public boolean getUjob() {
		return ujob;
	}
	public void setUjob(boolean ujob) {
		this.ujob = ujob;
	}
	@Override
	public String toString() {
		return "UserVO [uname=" + uname + ", upw=" + upw + ", uemail=" + uemail + ", uage=" + uage + ", ujob=" + ujob
				+ "]";
	}
}