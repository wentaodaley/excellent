package cn.edu.zut.excellent.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.edu.zut.excellent.entity.Student;
import cn.edu.zut.excellent.supervisor.ResultDo;

public interface StudentService {
	/**
	 * 验证学生登录信息
	 */
	ResultDo getStuinfo(String stuStudentId,String stuPassword);
	/**
	 *  根据学生的学号信息的到一个指定的对象
	 * @param stuId
	 * @return
	 */
	ResultDo selectStudent(String stuStudentId);
	/**
	 *  根据学生的姓名信息的到一个指定的对象
	 * @param stuId
	 * @return
	 */
	ResultDo selectStudentbyName(String stuName);
	/**
	 * 更新学生的基本信息
	 * @param student
	 * @return
	 */
	ResultDo updateStudent(Student student);
	/**
	 * 查询所有的学生信息
	 * @param rowRecord
	 * @return
	 */
	ResultDo findAll(Student student ,RowBounds rowBounds);
	/**
	 * 更新学生账号密码
	 */
	ResultDo upPawd(String stuStudentId, String stuPassword);
	/**
	 * 插入一个学生信息
	 */
	ResultDo insert(Student student);
	/**
	 * 根据学生姓名查找
	 * @param stuname
	 * @return
	 */
	ResultDo getStuName(String stuName);
	/**
	 * 设置学生选报状态
	 */
	ResultDo setStuStatus(String stuStudentId,int stuStatus,String teaTeacherId);
	/**
	 * 
	 * 查询导师信息
	 */
	ResultDo getStuTeaInfo(String stuStudentId);
	/**
	 * 
	 * 查询所有学生选报信息
	 */
	ResultDo<Map<String,Student>> getStuChooInfo();
}
