package cn.edu.zut.excellent.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.zut.excellent.conf.Role;
import cn.edu.zut.excellent.entity.Student;
import cn.edu.zut.excellent.entity.Teacher;
import cn.edu.zut.excellent.supervisor.ConfigDo;
import cn.edu.zut.excellent.supervisor.ResultDo;
import cn.edu.zut.excellent.supervisor.ServiceFit;


@Controller
@RequestMapping("/teacher")
public class TeacherController  {
	@Resource
	private ServiceFit serviceFit;
	private Role r = Role.TEA;
	
	@RequestMapping("home")
	public String homePage(Model model) {
		return r.getName() + "/home";
	}
	/**
	 * 教师信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("teaInfo")
	public String topicInfo(Model model, HttpSession session) throws Exception {
		Teacher teacher = (Teacher) session.getAttribute("user");
		//System.out.println((Teacher) session.getAttribute("user"));
		ResultDo resultDo = serviceFit.getTeacherService().selectTeacher(teacher.getTeaTeacherId());
		if (resultDo.isSuccess()) {
			model.addAttribute("teacher", resultDo.getResult());
		} else {
			model.addAttribute("mag", resultDo.getMessage());
		}
		model.addAttribute("menuSelected1", ConfigDo.TEAINFO);
		return r.getName() + "/teaInfo";
	}
	/**
	 * 更新教师信息
	 * @param model
	 * @param session
	 * @param teacher
	 * @return
	 */
	@RequestMapping("upteaInfo")
	public String upteaInfo(Model model,HttpSession session,Teacher teacher){
		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getTeacherService().updateTeacher(teacher);
		if (resultDo.isSuccess()){
			model.addAttribute("teacher",resultDo.getResult());
		}else {
			model.addAttribute("mag", resultDo.getMessage());
		}
		model.addAttribute("menuSelected1", ConfigDo.TEAINFO);
		return r.getName()+"/teaInfo";
	}
	/**
	 * 学生选报
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("chooStu")
	public String chooStu(Model model, HttpSession session)throws Exception{
		Teacher teacher = (Teacher) session.getAttribute("user");
		System.out.println(teacher);
		//查询所有virtualChoose表中学生信息
		ResultDo<List<Student>> resultDo = serviceFit.getVirtualChooseService().getStuByteaId(teacher.getTeaTeacherId()); 
		if (resultDo.isSuccess()) {
			model.addAttribute("stuList", resultDo.getResult());
		} else {
			model.addAttribute("mag", resultDo.getMessage());
		}
		model.addAttribute("menuSelected1", ConfigDo.TEASTUINFO);
		model.addAttribute("menuSelected2", ConfigDo.STUCHOOSETEACHER);
		return r.getName() + "/chooStu";
	}
	@RequestMapping("chooStubyName")
	public String chooStuInfo(Model model,HttpSession session,@RequestParam("stuName") String stuName){
		Teacher teacher = (Teacher) session.getAttribute("user");
		System.out.println(stuName);
		ResultDo stu=serviceFit.getVirtualChooseService().findStuByName(stuName,teacher.getTeaTeacherId());
		if(stu.isSuccess()){
			model.addAttribute("stuList", stu.getResult());
		}
		else{
			model.addAttribute("mag", stu.getMessage());
		}
		model.addAttribute("menuSelected1", ConfigDo.TEASTUINFO);
		model.addAttribute("menuSelected2", ConfigDo.STUCHOOSETEACHER);
		return r.getName()+ "/chooStu";
	
	}
	@RequestMapping("toOperateStu")
	public String toOperateStu(HttpSession session,Model model,@RequestParam("stuStudentId")String stuStudentId,@RequestParam("choo")String op){
		Teacher teacher=(Teacher) session.getAttribute("user");
		ResultDo stuDo=serviceFit.getStudentService().selectStudent(stuStudentId);
		Student student=(Student) stuDo.getResult();
//		ResultDo stu1= this.serviceFit.getStudentService().selectStudent(student.getStuStudentId());
//		session.setAttribute("user", stu1.getResult());			
	//	System.out.println(stuStudentId+"....."+op+"######");
		ResultDo stu=serviceFit.getStudentService().setStuStatus(stuStudentId, Integer.parseInt(op),teacher.getTeaTeacherId());
		if(!stu.isSuccess()){
			model.addAttribute("mag", stu.getMessage());
		}
		ResultDo<List<Student>> resultDo = serviceFit.getVirtualChooseService().getStuByteaId(teacher.getTeaTeacherId());
		if (resultDo.isSuccess()) {
			model.addAttribute("stuList", resultDo.getResult());
		} else {
			model.addAttribute("mag", resultDo.getMessage());
		}		
		model.addAttribute("stuList1", ConfigDo.TEASTUINFO);
		return r.getName()+ "/chooStu";
		
	}
	/**
	 * 导师所带学生
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("teaStuList")
	public String teaStuList(Model model, HttpSession session){
		Teacher teacher = (Teacher) session.getAttribute("user");
		System.out.println(teacher);
		ResultDo<List<Student>> resultDo = serviceFit.getVirtualChooseService().getTeaStuList(teacher.getTeaTeacherId());
		if (resultDo.isSuccess()) {
			model.addAttribute("stuList", resultDo.getResult());
		} else {
			model.addAttribute("mag", resultDo.getMessage());
		}
		model.addAttribute("menuSelected1", ConfigDo.TEASTUINFO);
		model.addAttribute("menuSelected2", ConfigDo.TEASTULIST);
		return r.getName() + "/teaStuList";
		
	}

}
