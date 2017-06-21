package cn.edu.zut.excellent.service.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.zut.excellent.entity.StuTeacher;
import cn.edu.zut.excellent.entity.Student;
import cn.edu.zut.excellent.entity.Teacher;
import cn.edu.zut.excellent.service.VirtualChooseService;
import cn.edu.zut.excellent.supervisor.DaoFit;
import cn.edu.zut.excellent.supervisor.ResultDo;
@Service("ChooseteacherService")
public class VirtualChooseServiceImpl implements VirtualChooseService {
	
	@Resource
	public DaoFit daoFit;
	
	@Override
	public ResultDo findAllChooseteacher() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultDo<List<Student>> getStuByteaId(String teaTeacherId) {
		ResultDo<List<Student>>  resultDo = new ResultDo<List<Student>> ();
		List<Student> list  = daoFit.getVirtualChooseDao().getStuByteaId(teaTeacherId);
		if (list.size() > 0){
			System.out.println("---------getStuByteaId"+list.size());
			resultDo.setResult(list);
			resultDo.setSuccess(true);
		}else{
			resultDo.setMessage("查询失败");
			resultDo.setSuccess(false);
		}
		return resultDo;
	}
	@Override
	public ResultDo findStuByName(String stuName,String teaTeacherId) {
		// TODO Auto-generated method stub
		ResultDo resultDo=new ResultDo();
		List<Student> stu=daoFit.getVirtualChooseDao().findStuByName(stuName,teaTeacherId);
		if(stu!=null){
			resultDo.setResult(stu);
			resultDo.setSuccess(true);
		}
		else{
			resultDo.setMessage("查询失败");
			resultDo.setSuccess(false);
		}
		return resultDo;
	}
	@Override
	public ResultDo<List<Student>> getTeaStuList(String teaTeacherId) {
		ResultDo<List<Student>>  resultDo = new ResultDo<List<Student>> ();
		List<Student> list  = daoFit.getVirtualChooseDao().teaStuList(teaTeacherId);
		if (list.size() > 0){
			resultDo.setResult(list);
			resultDo.setSuccess(true);
		}else{
			resultDo.setMessage("查询失败");
			resultDo.setSuccess(false);
		}
		return resultDo;
	}
	@Override
	public ResultDo insert(String stuStudentId, String teaTeacherId) {
		// TODO Auto-generated method stub
		ResultDo resultDo=new ResultDo();
		StuTeacher st=daoFit.getStuTeacherDao().getStuTeacherByTeaId(teaTeacherId);
		if(st!=null){
			int b=st.getStuCount()-st.getNowStuCount();
			Teacher tea=null;
			tea=daoFit.getVirtualChooseDao().getTeaByStuId(stuStudentId);
			boolean bo=false;
			if(tea!=null){
				bo=(teaTeacherId.equals(tea.getTeaTeacherId()));
			}
			int count=0;
			if(b>0&&bo==false){
				count=daoFit.getVirtualChooseDao().insertVirtualchoose(stuStudentId, teaTeacherId);	
			}		
			int stuStatus=daoFit.getStudentDao().setStuStatus(stuStudentId, Student.oneStatus);
			Teacher teacher=daoFit.getTeacherDao().getTeaById(teaTeacherId);
			resultDo.setSuccess(true);
			resultDo.setResult(teacher);
			System.out.println("信息插入成果");
		}
		else{
			resultDo.setSuccess(false);
			resultDo.setMessage("数据更新失败");
		}
		return resultDo;
	}
	@Override
	public ResultDo delete(String stuStudentId) {
		// TODO Auto-generated method stub
		ResultDo resultDo=new ResultDo();
		int count=daoFit.getVirtualChooseDao().deleteInfoByStuId(stuStudentId);
		int stuStatus=daoFit.getStudentDao().setStuStatus(stuStudentId, Student.zeroStatus);
		System.out.println("----delete-----count:"+count);
		System.out.println("----delete-----stuStatus:"+stuStatus);
		if(count==0){
			resultDo.setMessage("删除失败");
			resultDo.setSuccess(false);
		}else{
			resultDo.setResult(count);
			resultDo.setSuccess(true);
		}
		return resultDo;
	}
	@Override
	public ResultDo getTeacher(String stuStudentId) {
		// TODO Auto-generated method stub
		ResultDo resultDo=new ResultDo();
		Teacher teacher=daoFit.getVirtualChooseDao().getTeaByStuId(stuStudentId);
		if(teacher!=null){
			resultDo.setResult(teacher);
			resultDo.setSuccess(true);
		}else{
			resultDo.setMessage("查询失败");
			resultDo.setSuccess(false);
		}
		return resultDo;
	}
	@Override
	public ResultDo isInfo(String stuStudentId,String teaTeacherId) {
		// TODO Auto-generated method stub
		ResultDo resultDo=new ResultDo();
		String teaId=daoFit.getVirtualChooseDao().getTeaId(stuStudentId);
		if(teaId==null){
			resultDo.setResult(false);
			resultDo.setSuccess(true);
			return resultDo;
		}else if(teaTeacherId.equals(teaId)){
			resultDo.setResult(true);
			resultDo.setSuccess(false);
		}else{
			int n=daoFit.getVirtualChooseDao().deleteInfoByStuId(stuStudentId);
			resultDo.setResult(false);
			resultDo.setSuccess(true);
		}
		
		return resultDo;
	}

}
