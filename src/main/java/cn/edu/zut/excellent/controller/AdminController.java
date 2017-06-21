package cn.edu.zut.excellent.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tag.BaseController;
import cn.edu.zut.excellent.conf.Role;
import cn.edu.zut.excellent.entity.StuTeacher;
import cn.edu.zut.excellent.entity.Student;
import cn.edu.zut.excellent.entity.Teacher;
import cn.edu.zut.excellent.entity.Teacount;
import cn.edu.zut.excellent.supervisor.ConfigDo;
import cn.edu.zut.excellent.supervisor.ResultDo;
import cn.edu.zut.excellent.supervisor.ServiceFit;
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@Autowired
	private ServiceFit serviceFit;
	private Role r = Role.ADMIN;

	@RequestMapping("home")
	public String homePage(Model model) {
		return r.getName() + "/home";
	}
	/**
	 * 
	 * @param model
	 * @param teacher 获取全部教师
	 * @return
	 */
	@RequestMapping("allTeaList")
	public ModelAndView findAlltea(Map<String, Object> model,Teacher teacher,@RequestParam(value = "pageNum", required = false, defaultValue = "1") int l,
			@RequestParam(value = "pageSize", required = false, defaultValue = "20") int s) {
		ResultDo resultDo;
		Teacher teacher1 = new Teacher();
		teacher1.setTeaName("");
		System.out.println(teacher.getTeaName()+"<****************************************>");
		if (teacher.getTeaName() == null) {
			teacher.setTeaName("");
		}
		resultDo = serviceFit.getTeacherService().findAll(teacher,new RowBounds((l - 1) * s, s));
		int count = ((List) serviceFit.getTeacherService().findAll(teacher1, new RowBounds()).getResult()).size();
		initPage(model, l, s, count);
		if (resultDo.isSuccess()) {
			model.put("teaList", resultDo.getResult());
		} else {
			model.put("mag", resultDo.getMessage());
		}
		model.put("menuSelected1", ConfigDo.ADMINTEACHER);
		model.put("menuSelected2", ConfigDo.ADMINTEACHERLIST);
		return new ModelAndView(r.getName() + "/allTeaList");
	}

	@RequestMapping("addTeacher")
	public ModelAndView AddTeacher() {
		return new ModelAndView(r.getName() +"/teacherUpDaile");
	}
/**

 * @param model
 * @param teacher 添加教师信息
 * @return
 */

	@RequestMapping("addTea")
	public ModelAndView updateTea(Map<String, String> model, Teacher teacher) {
		if (teacher != null) {
			serviceFit.getTeacherService().insert(teacher);
		} else {
			model.put("mag", "不存在数据");
		}
		model.put("menuSelected1", ConfigDo.ADMINTEACHER);
		model.put("menuSelected2", ConfigDo.ADMINTEACHERLIST);
		return new ModelAndView("redirect:./allTeaList.do");
	}

	@RequestMapping("UpdateTeacher")
	public ModelAndView teacherUpDaile(Map<String, Object> 	model,	@RequestParam("id") String id) {//@RequestParam中的参数是不是写的数据库的参数?
		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getTeacherService().getteaTeahcerId(id);
		Teacher teacher = (Teacher) resultDo.getResult();
		if (resultDo.isSuccess()) {
			model.put("teacher", resultDo.getResult());
		} else {
			model.put("mag", resultDo.getMessage());
		}
		model.put("menuSelected1", ConfigDo.ADMINTEACHER);
		model.put("menuSelected2", ConfigDo.ADMINTEACHERLIST);
		return new ModelAndView(r.getName() + "/UpdateTeacher", model);
	}
	/**
	 * @param model
	 * @param teacher 更新教师信息
	 * @return
	 */
	@RequestMapping("teacherUp")
	public ModelAndView teacherUp(Map<String, String> model,Teacher teacher) {
		ResultDo resultDo = new ResultDo();
		System.out.println(teacher.toString());
		resultDo = serviceFit.getTeacherService().updateTeacher(teacher);
		if (resultDo.isSuccess()) {
			return new ModelAndView("redirect:./allTeaList.do");
		} else {
			return new ModelAndView("redirect:./UpdateTeacher.do");
		}
	}
/**
 * @param session
 * @param stuStudentId  重置密码
 * @return
 */

	@RequestMapping("restartPwd")
	public @ResponseBody Map<String, Object> restartPwd(HttpSession session,@RequestParam("stuStudentId") String stuStudentId) {
		Map<String, Object> map = new HashMap<String,Object>();
		String user = (String) session.getAttribute("user");
		String mag = "";
		boolean flag = false;
		ResultDo resultDo;
		if ("admin".equals(user)) {
			System.out.println(stuStudentId.length()+"------------------------------------------");
			if (stuStudentId.length() != 12) {
				resultDo = serviceFit.getTeacherService().upPawd(stuStudentId,"123456");
			} else {
				resultDo = serviceFit.getStudentService().upPawd(stuStudentId,"123456");
			}
			if (resultDo.isSuccess()) {
				flag = true;
				mag = "重置密码成功.";
			} else { 
				mag = resultDo.getMessage();
			}
		} else {
			mag = "非管理员不可以重置密码";
		}
		map.put("status", flag);
		map.put("mag", mag);
		return map;
	}
/*
 * 导师对接学生信息	
 */
	@RequestMapping("teaAndstuList")
	public ModelAndView teaAndstuList(Map<String,Object> model,Teacher teacher){
		ResultDo<Map<Teacher,StuTeacher>> resultDo=new ResultDo<Map<Teacher,StuTeacher>>();
		resultDo=serviceFit.getTeacherService().getTeacherAllInfo();
		if(teacher.getTeaName()!=null&&teacher.getTeaName()!=""&&resultDo.isSuccess()){
			Set<Map.Entry<Teacher,StuTeacher>> set=resultDo.getResult().entrySet();
			Iterator<Map.Entry<Teacher,StuTeacher>> it=set.iterator();
			boolean b=false;
			while(it.hasNext()){
				Map.Entry<Teacher,StuTeacher> mapEntry=it.next();
				if(mapEntry.getKey().getTeaName().equals(teacher.getTeaName())){
					resultDo.getResult().clear();
					resultDo.getResult().put(mapEntry.getKey(), mapEntry.getValue());
					b=true;
					break;
				}
			}
			if(b==false){
				model.put("mag",resultDo.getMessage());
			}
		}
		if (!resultDo.isSuccess()) {
			model.put("mag", resultDo.getMessage());
		}else{
			model.put("teaMap", resultDo.getResult());
		}
		model.put("menuSelected1", ConfigDo.ADMINTEACHER);
		model.put("menuSelected2", ConfigDo.TEASTUINFO);
		return new ModelAndView(r.getName() + "/teaAndstuList",model);
		
	}
	/**
	 * 学生信息
	 * @param model
	 * @param teaId
	 * @return
	 */
	@RequestMapping("stuInfo")
	public String stuInfo(Model model,@RequestParam("teaId") String teaId){
		ResultDo resultDo=new ResultDo();
		resultDo=serviceFit.getVirtualChooseService().getStuByteaId(teaId);		
		if(resultDo.isSuccess()){
			model.addAttribute("stuList", resultDo.getResult());
			System.out.println("-------------stuInfo"+resultDo.getResult());
		}else{
			model.addAttribute("mag", resultDo.getMessage());
		}
		model.addAttribute("menuSelected1", ConfigDo.ADMINTEACHER);
		model.addAttribute("menuSelected2", ConfigDo.TEASTUINFO);
		return r.getName() + "/stuInfo";
		
	}
	
	@RequestMapping("allStulist")
	public ModelAndView allStulist(
			Map<String, Object> model, Student student, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int l,
			@RequestParam(value = "pageSize", required = false, defaultValue = "20") int s) {
		ResultDo resultDo;
		Student student1 = new Student();
		student1.setStuName("");
		if (student.getStuName() == null) {
			student.setStuName("");
		}
		resultDo = serviceFit.getStudentService().findAll(student,
				new RowBounds((l - 1) * s, s));
		int count = ((List)serviceFit.getStudentService().findAll(student1, new RowBounds()).getResult()).size();
		if (resultDo.isSuccess()) {
			model.put("stuList", resultDo.getResult());
		} else {
			model.put("mag", resultDo.getMessage());
		}
		initPage(model, l, s, count);
		model.put("menuSelected1", ConfigDo.ADMINSTUDENT);
		model.put("menuSelected2",ConfigDo.ADMINSTUDENTLIST);
		return new ModelAndView(r.getName() + "/allStuList");

	}
	/**
	 * 添加学生信息
	 * @return
	 */
	@RequestMapping("addStu")
	public ModelAndView AddStudent() {
		return new ModelAndView(r.getName() + "/studentUpDaile");
	}

	@RequestMapping("addStudent")
	public ModelAndView updateStu(Map<String, String> model, Student student) {
		System.out.println(student);
		if (student != null) {
			serviceFit.getStudentService().insert(student);
		} else {
			model.put("mag", "不存在数据");
		}
		model.put("menuSelected1", ConfigDo.ADMINSTUDENT);
		model.put("menuSelected2",ConfigDo.ADMINSTUDENTLIST);
		return new ModelAndView("redirect:./allStulist.do");
	}
    /**
     * 更新学生信息
     * @param model
     * @param id
     * @return
     */
	@RequestMapping("UpdateStudent")
	public ModelAndView studentUpDaile(Map<String, Object> model,
			@RequestParam("id") String id) {
		ResultDo resultDo = new ResultDo();
		System.out.println(id);
		resultDo = serviceFit.getStudentService().selectStudent(id);
		Student student = (Student) resultDo.getResult();
		System.out.println(student.toString()+"*******************8");
		if (resultDo.isSuccess()) {
			model.put("student", resultDo.getResult());
		} else {
			model.put("mag", resultDo.getMessage());
		}
		model.put("menuSelected1", ConfigDo.ADMINSTUDENT);
		model.put("menuSelected2",ConfigDo.ADMINSTUDENTLIST);
		return new ModelAndView(r.getName() + "/UpdateStudent", model);
	}
   /**
    * 详细信息
    * @param model
    * @param student
    * @return
    */
	@RequestMapping("studentUp")
	public ModelAndView teacherUp(Map<String, String> model, Student student) {
		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getStudentService().updateStudent(student);
		if (resultDo.isSuccess()) {
			return new ModelAndView("redirect:./allStulist.do");
		} else {
			return new ModelAndView("redirect:./UpdateStudent.do");
		}
	}
	/**
	 * 选报导师信息
	 * @param model
	 * @param student
	 * @return
	 */
	@RequestMapping("chooTeaInfo")
	public ModelAndView chooTeaInfo(Model model,Student student){
		ResultDo<Map<String,Student>> resultDo=new ResultDo<Map<String,Student>>();
		resultDo=serviceFit.getStudentService().getStuChooInfo();
		boolean b=(student.getStuName()==null||"".equals(student.getStuName()));
		if(b==true&&resultDo.isSuccess()){
			model.addAttribute("stuList", resultDo.getResult());
		}else if(b==false&&resultDo.isSuccess()){
			Set<Map.Entry<String,Student>> set=resultDo.getResult().entrySet();
			Iterator<Map.Entry<String,Student>> it=set.iterator();
			while(it.hasNext()){
				Map.Entry<String,Student> mapEntry=it.next();
				if(mapEntry.getValue().getStuName().equals(student.getStuName())){
					resultDo.getResult().clear();
					resultDo.getResult().put(mapEntry.getKey(), mapEntry.getValue());
					break;
				}
			}
			model.addAttribute("stuList", resultDo.getResult());
		}else{
			model.addAttribute("mag", resultDo.getMessage());
		}
		model.addAttribute("menuSelected1", ConfigDo.ADMINSTUDENT);
		model.addAttribute("menuSelected2", ConfigDo.ADMINSTUDENTCHOOSE);
		return new ModelAndView(r.getName() + "/chooTeaInfo");
	}
	/**
	 * 根据职称获取导师人数
	 * @param model
	 * @return
	 */
	@RequestMapping("teacount")
	public ModelAndView selectCount(Model model){
		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getAdminService().selectTeacount();
		if (resultDo.isSuccess()){
			model.addAttribute("list", resultDo.getResult());
		}else{
			model.addAttribute("msg", resultDo.getMessage());
		}
		model.addAttribute("menuSelected1", ConfigDo.ADMINTEACHER);
		model.addAttribute("menuSelected2", ConfigDo.ADMINTEACHERCOUNT);
		return new ModelAndView(r.getName() + "/teacherCount");
	}
	/**
	 * 根据职称设置导师所带人数
	 * @param model
	 * @param teaRoleId
	 * @param stuCount
	 * @return
	 */
	@RequestMapping("upteacount")
	public ModelAndView updateCount(Model model,@RequestParam("teaRoleId")String teaRoleId,@RequestParam("stuCount")String stuCount ){
		ResultDo resultDo = new ResultDo();
		ResultDo resultDo1 = new ResultDo();
		ResultDo resultDo2 = new ResultDo();
		Teacount teacount = new Teacount ();
		Integer sCount = Integer.valueOf(stuCount);
		teacount.setStuCount(sCount);
		Integer tRoleId = Integer.valueOf(teaRoleId);
		teacount.setTeaRoleId(tRoleId);
		System.out.println(teaRoleId+"  "+stuCount);
		
		resultDo = serviceFit.getAdminService().updateTeacount(teacount);
		resultDo1 = serviceFit.getAdminService().updateAllTeacount(teacount);
		resultDo2 = serviceFit.getAdminService().selectTeacount();
		if (resultDo.isSuccess()&&resultDo1.isSuccess()){
			model.addAttribute("list", resultDo2.getResult());
		}else{
			model.addAttribute("msg", resultDo.getMessage());
		}
		return new ModelAndView(r.getName() + "/teacherCount");
	}
}
