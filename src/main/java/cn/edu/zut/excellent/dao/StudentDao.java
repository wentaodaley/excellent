package cn.edu.zut.excellent.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.edu.zut.excellent.entity.Student;

/**
 * Create by hb on 16/9/30
 * */
@Repository
public interface StudentDao {
/**
 * 添加学生信息
 * @param student
 * @return
 * */
int insert (Student student);
/**
 * 根据学号获得一个学生的信息
 * @param stuId
 * @return
 */
Student getstuBystuStudentId(String stuStudentId);
/**
 * 获得全部的学生信息
 * @return
 */
<RowBounds>List<Student> getallStu(RowBounds rowBounds);

List<Student> getallStu2();

/**
 * 根据指导教师的工号查询
 * 该指导教师指导的学生
 * @param teaId
 * @return
 */
//List<Student> getstuByteaTeacherId(String stuTeacherId);
/**
 * 根据学生的姓名进行模糊查询
 * @param teaName
 * @return
 */
List<Student> getstuByName(@Param("p")String stuName);
/**
 * 根据学生的id更新学生的信息
 * @param stuId
 * @return
 */
int updateStudent(Student student);
/**
 * 根据学生的信息更改密码
 * @param id
 * @param passwd
 * @return
 */
int updateStudentPasswd(String stuStudentId,String passwd);
/**
 * 学生选择指导教师
 * @param stuId
 * @param teaId
 * @return
 */
int setstuTeaId(String stuStudentId,String teaTeacherId);
/*
 * 设置学生选报状态
 */
int setStuStatus(@Param(value="stuStudentId")String stuStudentId,@Param(value="stuStatus")int stuStatus);
/**
 * 
 * 更新学生教师id
 */
int updatTeaId(@Param(value="stuStudentId")String stuStudentId,@Param(value="stuTeacherId")String stuTeacherId);
/**
 * 
 * 查找导师id
 */
String getStuTeacherId(@Param(value="stuStudentId")String stuStudentId,@Param(value="stuTeacherId")String stuTeacherId);
}

