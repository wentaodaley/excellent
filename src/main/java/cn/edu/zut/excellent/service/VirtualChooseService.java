package cn.edu.zut.excellent.service;

import java.util.List;

import cn.edu.zut.excellent.entity.Student;
import cn.edu.zut.excellent.supervisor.ResultDo;

public interface VirtualChooseService {
	
	
	/**
	 * 得到全部的导师
	 * @param 
	 * @return
	 */
	ResultDo findAllChooseteacher();
	/**
	 * 根据教师id得到学生信息
	 * @param teaTeacherId
	 * @return
	 */
	ResultDo<List<Student>> getStuByteaId(String teaTeacherId);
	/**
	 * 根据学生姓名查询学生
	 * 
	 */
	ResultDo findStuByName(String stuName,String teaTeacherId);
	/**
	 * 查询导师的学生信息
	 * 
	 */
	ResultDo<List<Student>>  getTeaStuList(String teaTeacherId);
	
	/**
	 * 插入信息
	 * 
	 * 
	 */
	ResultDo insert(String stuStudentId,String teaTeacherId);
	
	/**
	 * 
	 * 删除一条信息
	 */
	ResultDo delete(String stuStudentId);
	/**
	 * 
	 * 根据学生id得到教师信息
	 */
	ResultDo getTeacher(String stuStudentId);
	/**
	 * 
	 * 
	 * 根据学生id查教师id
	 */
	ResultDo isInfo(String stuStudentId,String teaTeacherId);
}
