package cn.edu.zut.excellent.entity;

public class Teacount {

	private int teaRoleId;
	
	private int stuCount;

	public int getTeaRoleId() {
		return teaRoleId;
	}

	public void setTeaRoleId(int teaRoleId) {
		this.teaRoleId = teaRoleId;
	}

	public int getStuCount() {
		return stuCount;
	}

	public void setStuCount(int stuCount) {
		this.stuCount = stuCount;
	}

	@Override
	public String toString() {
		return "Teacount [teaRoleId=" + teaRoleId + ", stuCount=" + stuCount
				+ "]";
	}
	
	
}
