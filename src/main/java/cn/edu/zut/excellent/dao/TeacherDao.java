package cn.edu.zut.excellent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.edu.zut.excellent.entity.Teacher;

@Repository
public interface TeacherDao {
	
	/**
	 * 查询所有的教师信息
	 * 
	 */
	List<Teacher> getallTeacher();
	/**
	 * 添加一个教师的信息
	 * @param teacher
	 * @return
	 */
	 int insertTeacher(Teacher teacher);
	 /**
	  * 查询所有的教师信息
	  * @param rowBounds
	  * @return
	  */
    <RowBounds>List<Teacher> getteaList(RowBounds rowBounds);
	 /**
	  * 根据教师的Id得到教师的基本信息
	  * @param teaTeacherId
	  * @return
	  */
	 Teacher getTeaById(String teaTeacherId); 
	 /**
	  * 模糊查询
	  * @param teaName
	  * @return
	  */
	 List<Teacher> getTeaByName(@Param("p")String teaName);
	 /**
	  * 很据教师的工号进行更新教师的基本信息
	  * @param teaTeacherId
	  * @return
	  */
	 int updateTea(Teacher teacher);
	 /**
	  * 导师选择学生
	  * @param teaTeacherId
	  * @param stuStudentId
	  * @return
	  * */
	 int setteaStudentId(String teaTeacherId,String stuStudentId);
	 /**
	  * 登录
	  */
	 Teacher findTeabyName(String teaName);
	 /**
	  * 更新教师账号密码
	  * @param teaId
	  * @param password
	  * @return
	  */
	int updatePassword(String teaTeacherId, String password);
}
