package cn.edu.zut.excellent.entity;

import java.util.Date;


/*
 *Created by hb on 16/9/29
 * */
public class Chooseteacher {

	private String chooseId;
	private String chooseTeacherId;
	private Date  chooseCreatetime;
	private boolean chooseStatus;
	public String getChooseId() {
		return chooseId;
	}
	public void setChooseId(String chooseId) {
		this.chooseId = chooseId;
	}
	public String getChooseTeacherId() {
		return chooseTeacherId;
	}
	public void setChooseTeacherId(String chooseTeacherId) {
		this.chooseTeacherId = chooseTeacherId;
	}
	public Date getChooseCreatetime() {
		return chooseCreatetime;
	}
	public void setChooseCreatetime(Date chooseCreatetime) {
		this.chooseCreatetime = chooseCreatetime;
	}
	public boolean isChooseStatus() {
		return chooseStatus;
	}
	public void setChooseStatus(boolean chooseStatus) {
		this.chooseStatus = chooseStatus;
	}
	
	
	
	
}
