package cn.edu.zut.excellent.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.edu.zut.excellent.entity.StuTeacher;
import cn.edu.zut.excellent.entity.Teacher;
import cn.edu.zut.excellent.service.TeacherService;
import cn.edu.zut.excellent.supervisor.ConfigDo;
import cn.edu.zut.excellent.supervisor.DaoFit;
import cn.edu.zut.excellent.supervisor.ResultDo;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService, ConfigDo {

	@Resource
	public DaoFit daoFit;


	@Override
	public ResultDo getTeainfo(String teaName, String password) {
		ResultDo<Teacher> resultDo = new ResultDo<Teacher>();
		Teacher teacher = new Teacher();
		teacher = daoFit.getTeacherDao().findTeabyName(teaName);
		if (teacher != null && teacher.getPassword().equals(password)) {
			resultDo.setResult(teacher);
			resultDo.setSuccess(true);
		} else {
			resultDo.setMessage("账户或者密码错误");
		}
		return resultDo;
	}

	@Override
	public ResultDo selectTeacher(String teaTeacherId) {
        ResultDo resultDo=new ResultDo();
        if(teaTeacherId!=null&&!" ".equals(teaTeacherId.trim())){
        	Teacher teacher=daoFit.getTeacherDao().getTeaById(teaTeacherId);
        	if(teacher!=null){
        		resultDo.setResult(teacher);
        		resultDo.setSuccess(true);
        	}else{
        		resultDo.setResult(null);
        		resultDo.setSuccess(false);
        		resultDo.setMessage("教师信息获取失败");
        	}
        }
		return resultDo;
	}

	@Override
	public ResultDo updateTeacher(Teacher teacher) {
		ResultDo resultDo = new ResultDo();
		if (teacher != null){
			int  count = daoFit.getTeacherDao().updateTea(teacher);
			System.out.println("*****************************************************"+teacher.toString());
			if(count > 0){
				resultDo.setResult(teacher);
				resultDo.setSuccess(true);
			}
		}else{
			resultDo.setMessage("更新教师信息错误！");
			resultDo.setSuccess(false);
		}
		return resultDo;
	}

	@Override
	public ResultDo findAll(Teacher teacher,RowBounds rowBounds) {
		ResultDo resultDo = new ResultDo();
		List<Teacher> list;
		//若教师的teaName是""则查询全部的教师信息
		//若教师的teaName不为空则根据教师的姓名进行查询
		if (teacher.getTeaName().equals("")){
			list =daoFit.getTeacherDao().getteaList(rowBounds);
		}else{
			list = daoFit.getTeacherDao().getTeaByName(teacher.getTeaName());
		}
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
	public ResultDo upPawd(String teaTeacherId, String password) {
		ResultDo resultDo = new ResultDo();
		int success;
		if (teaTeacherId != null && !password.equals("") && password != null && !teaTeacherId.equals("")) {
			success = daoFit.getTeacherDao().updatePassword(teaTeacherId, password);
			if (success > 0) {
				resultDo.setSuccess(true);
			}
			else {
				resultDo.setMessage("不能正常更新密码！请检查你的密码是否符合要求。");
				resultDo.setSuccess(false);
			}
		}
		return resultDo;
	}
	@Override
	public ResultDo insert(Teacher teacher) {
		System.out.println(teacher.toString()+"-----------------------------------------------");
		ResultDo resultDo = new ResultDo();
		int succ ;
		if (teacher != null && !teacher.getTeaName().equals("")) {
			succ = daoFit.getTeacherDao().insertTeacher(teacher);
			if (succ > 0 ){
				resultDo.setSuccess(true);
			}
		} else {
			resultDo.setMessage("添加教师信息失败");
		}
		return resultDo;
	}
	
	@Override
	public ResultDo getTeacher(String teaName) {
		ResultDo resultDo = new ResultDo();;
		Teacher teacher ;
		if (teaName.equals("") || teaName == null){
			List list = daoFit.getTeacherDao().getteaList(new RowBounds());
			resultDo.setResult(list);
			resultDo.setSuccess(true);
		} else {
			teacher = daoFit.getTeacherDao().findTeabyName(teaName);
			resultDo.setResult(teacher);
			resultDo.setSuccess(true);
		}

		return resultDo;
	}
	@Override
	public ResultDo getteaTeahcerId(String id) {
		ResultDo resultDo = new ResultDo();;
		Teacher teacher ;
		if (id.equals("") || id == null){
			resultDo.setMessage("查询失败");
			resultDo.setSuccess(true);
		} else {
			teacher = daoFit.getTeacherDao().getTeaById(id);;
			resultDo.setResult(teacher);
			resultDo.setSuccess(true);
		}

		return resultDo;
	}


	@Override
	public ResultDo<Map<Teacher,StuTeacher>> getTeacherAllInfo() {
		ResultDo<Map<Teacher,StuTeacher>> resultDo=new ResultDo<Map<Teacher,StuTeacher>>();
		Map<Teacher,StuTeacher> teaMap=new HashMap<Teacher,StuTeacher>();
		List<Teacher> tea=daoFit.getTeacherDao().getallTeacher();
		Iterator<Teacher> it=tea.iterator();
		while(it.hasNext()){
			Teacher t=it.next();
			StuTeacher s=daoFit.getStuTeacherDao().getStuTeacherByTeaId(t.getTeaTeacherId());
			if(s!=null){
				teaMap.put(t, s);
			}
		}
		if(teaMap.isEmpty()){
			resultDo.setMessage("查询失败");
			resultDo.setSuccess(false);
		}else{
			resultDo.setSuccess(true);
			resultDo.setResult(teaMap);
		}
		return resultDo;
	}
	
}


