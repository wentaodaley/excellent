package cn.edu.zut.excellent.entity.model1;

import org.apache.ibatis.type.Alias;

/**
 * Created by cc on 16/9/30.
 */
@Alias("StudentAndTeaId")
public class StudentAndTeaId {

	private String id;
	private String teaId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeaId() {
		return teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	@Override
	public String toString() {
		return "StudentAndTeaId{" + "id='" + id + '\'' + ", teaId='" + teaId
				+ '\'' + '}';
	}
}
