package cn.edu.zut.excellent.entity;

import org.apache.ibatis.type.Alias;

/*
 * 教师 @author hb
 * */
//@Alias("Teacher")
public class Teacher {

	
	    private String teaId;//主键  
	    private String teaTeacherId;//教师工号
	    private String teaName;//教师姓名
	    private boolean teaSex;//性别：0男，1女
	    private int teaQualifications;//职称等级，4教授；3副教授；2讲师；1助教
	    private String teaTell;//手机号
	    private String teaOfficeTell;//办公室电话
	    private String teaEmail;//教师	Eamil
	    private String teaQQ;//教师qq
	    private boolean teaRole;//权限
	    private String Password="123456";// 密码
		public String getTeaId() {
			return teaId;
		}
		public void setTeaId(String teaId) {
			this.teaId = teaId;
		}
		public String getTeaTeacherId() {
			return teaTeacherId;
		}
		public void setTeaTeacherId(String teaTeacherId) {
			this.teaTeacherId = teaTeacherId;
		}
		public String getTeaName() {
			return teaName;
		}
		public void setTeaName(String teaName) {
			this.teaName = teaName;
		}
		public boolean isTeaSex() {
			return teaSex;
		}
		public void setTeaSex(boolean teaSex) {
			this.teaSex = teaSex;
		}
		public int getTeaQualifications() {
			return teaQualifications;
		}
		public void setTeaQualifications(int teaQualifications) {
			this.teaQualifications = teaQualifications;
		}
		public String getTeaTell() {
			return teaTell;
		}
		public void setTeaTell(String teaTell) {
			this.teaTell = teaTell;
		}
		public String getTeaOfficeTell() {
			return teaOfficeTell;
		}
		public void setTeaOfficeTell(String teaOfficeTell) {
			this.teaOfficeTell = teaOfficeTell;
		}
		public String getTeaEmail() {
			return teaEmail;
		}
		public void setTeaEmail(String teaEmail) {
			this.teaEmail = teaEmail;
		}
		public String getTeaQQ() {
			return teaQQ;
		}
		public void setTeaQQ(String teaQQ) {
			this.teaQQ = teaQQ;
		}
		public boolean isTeaRole() {
			return teaRole;
		}
		public void setTeaRole(boolean teaRole) {
			this.teaRole = teaRole;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		@Override
		public String toString() {
			return "Teacher [teaId=" + teaId + ", teaTeacherId=" + teaTeacherId
					+ ", teaName=" + teaName + ", teaSex=" + teaSex
					+ ", teaQualifications=" + teaQualifications + ", teaTell="
					+ teaTell + ", teaOfficeTell=" + teaOfficeTell
					+ ", teaEmail=" + teaEmail + ", teaQQ=" + teaQQ
					+ ", teaRole=" + teaRole + ", Password=" + Password + "]";
		}
	    
	    
	    
}
