package cn.edu.zut.excellent.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zut.excellent.entity.StuTeacher;

@Repository
public interface StuTeacherDao {
	/**
	 * 查询所有教师的选报状态信息
	 * 
	 */
	List<StuTeacher> getAllStuTeacher();
	
	/**
	 * 根据教师id查询教师选报状态
	 * 
	 */
	StuTeacher getStuTeacherByTeaId(String teaTeacherId);
	
	/**
	 * 根据教师id更新教师选报状态
	 * 
	 */
	int upStuCount(String teaTeacherId);
	/**
	 * 学生选报数减一
	 * @param teaTeacherId
	 * @return
	 */
	int cutStuCount(String teaTeacherId);

}
