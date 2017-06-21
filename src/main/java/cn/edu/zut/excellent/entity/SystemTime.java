package cn.edu.zut.excellent.entity;

import java.sql.Date;

public class SystemTime {
	private String adminName;
	private Date openTime;
	private Date closeTime;
	private Date setTime;
	public SystemTime(){}
	public SystemTime(String adminName, Date openTime, Date closeTime,
			Date setTime) {
		super();
		this.adminName = adminName;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.setTime = setTime;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	public Date getSetTime() {
		return setTime;
	}
	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}
	@Override
	public String toString() {
		return "SystemTime [adminName=" + adminName + ", openTime=" + openTime
				+ ", closeTime=" + closeTime + ", setTime=" + setTime + "]";
	}
	
	

}
