package cn.edu.zut.excellent.entity;

import org.apache.ibatis.type.Alias;


/*
 *Created by hb on 16/9/29
 * */
//@Alias("Student")
public class Student {
	public static int zeroStatus=0;//未选报
	public static int oneStatus=1; //选报中
	public static int twoStatus=2; //确认选报
	public static int threeStatus=3; //取消选报

	private String stuStudentId;//学号
	private String stuName;// 姓名
	private boolean stuSex ;//性别：0男，1女
	private String stuClass;// 班级
	private String stuTell;// 电话
	private String stuQQ;// qq
	private String stuEmail;// Eamil
	private int stuRole;// 权限
	private int stuStatus;//  选报状态,未选报为0,选报中为1，确认选报为2，取消选报为3
	private String stuPassword="123456";// 密码
	
	private String stuTeacherId;// 指导教师Id
	
	private Teacher teacher;

	public String getStuStudentId() {
		return stuStudentId;
	}

	public void setStuStudentId(String stuStudentId) {
		this.stuStudentId = stuStudentId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public boolean isStuSex() {
		return stuSex;
	}

	public void setStuSex(boolean stuSex) {
		this.stuSex = stuSex;
	}

	public String getStuClass() {
		return stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	public String getStuTell() {
		return stuTell;
	}

	public void setStuTell(String stuTell) {
		this.stuTell = stuTell;
	}

	public String getStuQQ() {
		return stuQQ;
	}

	public void setStuQQ(String stuQQ) {
		this.stuQQ = stuQQ;
	}

	public String getStuEmail() {
		return stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public int getStuRole() {
		return stuRole;
	}

	public void setStuRole(int stuRole) {
		this.stuRole = stuRole;
	}

	public String getStuPassword() {
		return stuPassword;
	}

	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}

	public String getStuTeacherId() {
		return stuTeacherId;
	}

	public void setStuTeacherId(String stuTeacherId) {
		this.stuTeacherId = stuTeacherId;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getStuStatus() {
		return stuStatus;
	}

	public void setStuStatus(int stuStatus) {
		this.stuStatus = stuStatus;
	}

	@Override
	public String toString() {
		return "Student [stuStudentId=" + stuStudentId + ", stuName=" + stuName
				+ ", stuSex=" + stuSex + ", stuClass=" + stuClass
				+ ", stuTell=" + stuTell + ", stuQQ=" + stuQQ + ", stuEmail="
				+ stuEmail + ", stuRole=" + stuRole + ", stuStatus="
				+ stuStatus + ", stuPassword=" + stuPassword
				+ ", stuTeacherId=" + stuTeacherId + "]";
	}
	
	
	
}
