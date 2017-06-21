package cn.edu.zut.excellent.service;

import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import cn.edu.zut.excellent.entity.StuTeacher;
import cn.edu.zut.excellent.entity.Teacher;
import cn.edu.zut.excellent.supervisor.ResultDo;

public interface TeacherService {
	/**
	 * 验证账户和密码信息
	 * @param teaName
	 * @param password
	 * @return
	 */
	ResultDo getTeainfo(String teaName,String password);
	/**
	 *  根据教师的工号信息的到一个指定的对象
	 * @param teaId
	 * @return
	 */
	ResultDo selectTeacher(String teaTeacherId);
	/**
	 * 更新教师的信息
	 * @param teacher
	 * @return
	 */
	ResultDo updateTeacher(Teacher teacher);
	/**
	 * 查询全部的教师信息
	 * @param rowBounds
	 * @return
	 */
	ResultDo findAll(Teacher teacher,RowBounds rowBounds);
	/**
	 * 更新教师密码
	 * @param teaTeacherId
	 * @param password
	 * @return
	 */
	ResultDo upPawd(String teaTeacherId, String password);
	/**
	 * 插入一个教师信息
	 * @param teacher
	 * @return
	 */
	ResultDo insert(Teacher teacher);
	/**
	 * 根据教师名称查询教师
	 * @param teaName
	 * @return
	 */
	ResultDo getTeacher(String teaName);
	/**
	 * 根据教师在数据库中的默认添加的Id进行查询
	 * @param id
	 * @return
	 */
	ResultDo getteaTeahcerId(String teaTeacherId);
	
	/**
	 * 
	 * 查询教师信息及选报状态
	 */
	ResultDo<Map<Teacher,StuTeacher>> getTeacherAllInfo();
}
