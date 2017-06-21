package cn.edu.zut.excellent.entity;

//@Alias("VirtualChoose")
public class VirtualChoose {

	private String Id;
	private String stuStudentId;
	private String teateacherId;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getStuStudentId() {
		return stuStudentId;
	}
	public void setStuStudentId(String stuStudentId) {
		this.stuStudentId = stuStudentId;
	}
	public String getTeateacherId() {
		return teateacherId;
	}
	public void setTeateacherId(String teateacherId) {
		this.teateacherId = teateacherId;
	}
	@Override
	public String toString() {
		return "VirtualChoose [Id=" + Id + ", stuStudentId=" + stuStudentId
				+ ", teateacherId=" + teateacherId + "]";
	}
	
	
	
}
