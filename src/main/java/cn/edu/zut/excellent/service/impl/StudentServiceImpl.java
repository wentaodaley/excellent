 package cn.edu.zut.excellent.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.alibaba.druid.filter.AutoLoad;

import cn.edu.zut.excellent.entity.Student;
import cn.edu.zut.excellent.entity.Teacher;
import cn.edu.zut.excellent.service.StudentService;
import cn.edu.zut.excellent.supervisor.DaoFit;
import cn.edu.zut.excellent.supervisor.ResultDo;
@Service("StudentService")
public class StudentServiceImpl implements StudentService {
	@Resource
	public DaoFit daoFit;
	@Override
	public ResultDo getStuinfo(String stuStudentId, String stuPassword) {
		ResultDo<Student> resultDo = new ResultDo<Student>();
		Student student =  new Student();
		student = daoFit.getStudentDao().getstuBystuStudentId(stuStudentId);
		if (student != null && student.getStuPassword().equals(stuPassword)) {
			resultDo.setResult(student);
			resultDo.setSuccess(true);
		} else {
			resultDo.setMessage("账号或者密码错误！");
		}
		return resultDo;
	}

	@Override
	public ResultDo selectStudent(String stuStudentId) {
		ResultDo resultDo = new ResultDo();
		if(stuStudentId != null && !"".equals(stuStudentId.trim())){
			Student student = daoFit.getStudentDao().getstuBystuStudentId(stuStudentId);
			if(student != null){
				resultDo.setResult(student);
				resultDo.setSuccess(true);
			}else{
				resultDo.setResult(null);
				resultDo.setSuccess(false);
				resultDo.setMessage("学生信息获取失败");
			}
		}
		return resultDo;
	}
	@Override
	public ResultDo selectStudentbyName(String stuStudentName){
		ResultDo resultDo = new ResultDo();
		if(stuStudentName !=null && !"".endsWith(stuStudentName)){
			List<Student> stu=daoFit.getStudentDao().getstuByName(stuStudentName);
			if(stu!=null){
				resultDo.setResult(stu);
				resultDo.setSuccess(true);
			}else{
				resultDo.setResult(null);
				resultDo.setSuccess(false);
				resultDo.setMessage("学生查找失败");
			}
		}
		return resultDo;
		
	}


	@Override
	public ResultDo updateStudent(Student student) {
		ResultDo resultDo = new ResultDo();
		if (student != null){
			int  count = daoFit.getStudentDao().updateStudent(student);
			if(count > 0){
				resultDo.setResult(student);
				resultDo.setSuccess(true);
			}
		}else{
			resultDo.setMessage("更新学生信息错误！");
			resultDo.setSuccess(false);
		}
		return resultDo;
	}

	@Override
	public ResultDo findAll(Student student ,RowBounds rowBounds) {
		ResultDo resultDo = new ResultDo();
		List<Student> list;
		if(student.getStuName().equals("")){
			list=daoFit.getStudentDao().getallStu(rowBounds);
		}
		else{
			list=daoFit.getStudentDao().getstuByName(student.getStuName());
		}
		if (list.size() > 0) {
			resultDo.setResult(list);
			resultDo.setSuccess(true);
		} else {
			resultDo.setMessage("查询不到全部的学生信息");
			resultDo.setSuccess(false);
		}
		return resultDo;
	}
	@Override
	public ResultDo upPawd(String stuStudentId, String stuPassword) {
		ResultDo resultDo = new ResultDo();
		int succ = daoFit.getStudentDao().updateStudentPasswd(stuStudentId, stuPassword);
		if (succ > 0) {
			resultDo.setSuccess(true);
		} else {
			resultDo.setMessage("不能正常更新密码！请检查你的密码是否符合要求。");
			resultDo.setSuccess(false);
		}
		return resultDo;
	}
	@Override
	public ResultDo insert(Student student) {
		ResultDo resultDo = new ResultDo();
		if (student != null ) {
			System.out.println(student.getStuStudentId().equals(""));
			if (student.getStuStudentId() != null){
				int success = daoFit.getStudentDao().insert(student);
				if (success > 0 ) {
					resultDo.setSuccess(true);
				}else{
					resultDo.setMessage("检查添加学生的信息是否正确！");
					resultDo.setSuccess(false);
				}
			}
		} else{
			resultDo.setMessage("没有填写学生的基本信息");
			resultDo.setSuccess(false);
		}
		return resultDo;
	}
	@Override
	public ResultDo getStuName(String stuname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDo setStuStatus(String stuStudentId, int stuStatus,String teaTeacherId) {
		// TODO Auto-generated method stub
		ResultDo resultdo=new ResultDo();
		int success=daoFit.getStudentDao().setStuStatus(stuStudentId, stuStatus);
		if(success>0){
			System.out.println("学生状态更新成功");
			if(stuStatus==Student.twoStatus){//确认选择
				int upStuCount=daoFit.getStuTeacherDao().upStuCount(teaTeacherId);
				int upStuTeaId=daoFit.getStudentDao().updatTeaId(stuStudentId, teaTeacherId);
			}
			else if(stuStatus==Student.threeStatus){//取消选报
				String teacherId=((Student)daoFit.getStudentDao().getstuBystuStudentId(stuStudentId)).getStuTeacherId();
				if(teacherId!=null){
					int upStuTeaId=daoFit.getStudentDao().updatTeaId(stuStudentId, null);
					int cutStuCount=daoFit.getStuTeacherDao().cutStuCount(teaTeacherId);
				}				
			}else if(stuStatus==Student.oneStatus){//重置
				Teacher tea=daoFit.getVirtualChooseDao().getTeaByStuId(stuStudentId);
				boolean bo=false;
				if(tea!=null){
					bo=(teaTeacherId.equals(tea.getTeaTeacherId()));
				}
				if(bo==false){
					int vcAdd=daoFit.getVirtualChooseDao().insertVirtualchoose(stuStudentId, teaTeacherId);
				}				
			}
			resultdo.setSuccess(true);
		}else{
			resultdo.setMessage("学生选报状态更新失败");
			resultdo.setSuccess(false);
		}
		return resultdo;
	}

	@Override
	public ResultDo getStuTeaInfo(String stuStudentId) {
		// TODO Auto-generated method stub
		ResultDo resultDo=new ResultDo();
		Teacher teacher=daoFit.getVirtualChooseDao().getTeaByStuId(stuStudentId);
		if(teacher!=null){
			resultDo.setSuccess(true);
			resultDo.setResult(teacher);
		}else{
			System.out.println("-------------null");
			resultDo.setMessage("查询失败");
			resultDo.setSuccess(false);
		}
		return resultDo;
	}

	@Override
	public ResultDo<Map<String, Student>> getStuChooInfo() {
		// TODO Auto-generated method stub
//		ResultDo<Map<String,Student>> resultDo=new ResultDo<Map<String,Student>>();
//		Map<String,Student> map=new HashMap<String,Student>();
		ResultDo resultDo = new ResultDo();
		List<Student> stus=daoFit.getStudentDao().getallStu2();
		for(Student student :stus){
			Teacher tea=daoFit.getVirtualChooseDao().getTeaByStuId(student.getStuStudentId());
			student.setTeacher(tea);
		}
		if(stus.size()>0){
			resultDo.setResult(stus);
			resultDo.setSuccess(true);
		}else{
			resultDo.setMessage("查询失败");
			resultDo.setSuccess(false);
		}
		return resultDo;
	}
}
