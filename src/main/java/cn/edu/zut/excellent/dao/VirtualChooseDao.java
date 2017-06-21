package cn.edu.zut.excellent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import cn.edu.zut.excellent.entity.Student;
import cn.edu.zut.excellent.entity.Teacher;

@Repository
public interface VirtualChooseDao {
	/**
	 * 
	 * 插入一条记录
	 */
	
	int insertVirtualchoose(@Param(value="stuStudentId")String stuStudentId,@Param(value="teaTeacherId")String teaTeacherId);
	/*
	 * 得到所有导师
	 */
	List<Teacher> getAllTeacher();
	/*
	 * 根据教师id得到学生信息
	 */
	List<Student> getStuByteaId(String teaTeacherId);
	/*
	 * 根据学生姓名查询学生信息
	 */
	List<Student> findStuByName(@Param(value="stuName")String stuName,@Param(value="teaTeacherId")String teaTeacherId);
	/*
	 * 查询导师学生信息
	 */
	List<Student> teaStuList(String teaTeacherId);
	/**
	 * 
	 * 查询导师信息
	 */
	Teacher getTeaByStuId(String stuStudentId);
	/**
	 * 
	 * 根据学生id删除一条记录
	 */
	int deleteInfoByStuId(String stuStudentId);
	/**
	 * 
	 * 根据学生id查教师id
	 */
	String getTeaId(String stuStudentId);
}
