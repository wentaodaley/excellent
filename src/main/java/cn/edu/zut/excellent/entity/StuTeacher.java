package cn.edu.zut.excellent.entity;

public class StuTeacher {
	private String teaTeacherId;//教师工号;
	private int stuCount;
	private int nowStuCount;
	private Teacher teacher;
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getTeaTeacherId() {
		return teaTeacherId;
	}
	public void setTeaTeacherId(String teaTeacherId) {
		this.teaTeacherId = teaTeacherId;
	}
	public int getStuCount() {
		return stuCount;
	}
	public void setStuCount(int stuCount) {
		this.stuCount = stuCount;
	}
	public int getNowStuCount() {
		return nowStuCount;
	}
	public void setNowStuCount(int nowStuCount) {
		this.nowStuCount = nowStuCount;
	}
	@Override
	public String toString() {
		return "StuTeacher [teaTeacherId=" + teaTeacherId + ", stuCount="
				+ stuCount + ", nowStuCount=" + nowStuCount + "]";
	}
	

}
