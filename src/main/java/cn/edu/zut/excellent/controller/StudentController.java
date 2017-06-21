package cn.edu.zut.excellent.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.zut.excellent.conf.Role;
import cn.edu.zut.excellent.entity.StuTeacher;
import cn.edu.zut.excellent.entity.Student;
import cn.edu.zut.excellent.entity.Teacher;
import cn.edu.zut.excellent.supervisor.ConfigDo;
import cn.edu.zut.excellent.supervisor.ResultDo;
import cn.edu.zut.excellent.supervisor.ServiceFit;





@Controller
@RequestMapping("/student")
public class StudentController  {
	
	@Resource
	private ServiceFit serviceFit;
	private Role r = Role.STU;
	
	@RequestMapping("home")
	public String homePage(Model model) {
		return r.getName() + "/home";
	}
	@RequestMapping("stuInfo")
	public String stuInfo(Model model, HttpSession session){
		Student student = (Student)session.getAttribute("user");
		ResultDo resultDo = serviceFit.getStudentService().selectStudent(student.getStuStudentId());
		if (resultDo.isSuccess()) {
			model.addAttribute("student", resultDo.getResult());
		} else {
			model.addAttribute("mag", resultDo.getMessage());
		}
		model.addAttribute("menuSelected1", ConfigDo.STUINFO);
		return r.getName() + "/stuInfo";
		
	}
	/**
	 * 用于对学生的个人信息的更改
	 * @param model
	 * @param session
	 * @param student
	 * @return
	 */
	@RequestMapping("upstuInfo")
	public String upstuInfo(Model model,HttpSession session,Student student){
		ResultDo  resultDo = new ResultDo();
		student.setStuStudentId(((Student)session.getAttribute("user")).getStuStudentId());
		resultDo = serviceFit.getStudentService().updateStudent(student);
		if (resultDo.isSuccess()){
			student = (Student)resultDo.getResult();
		}else{
			model.addAttribute("mag",resultDo.getMessage());
		}
		model.addAttribute("student", student);
		model.addAttribute("user", student);
		model.addAttribute("menuSelected1", ConfigDo.STUINFO);
		return r.getName() + "/stuInfo";
	}
	/**
	 * 选报导师
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("chooTea")
	public String chooTea(Model model,HttpSession session){
		Student student=(Student)session.getAttribute("user");
		ResultDo stu = this.serviceFit.getStudentService().selectStudent(student.getStuStudentId());
		session.setAttribute("user", stu.getResult());
		ResultDo<Map<Teacher,StuTeacher>> resultDo=new ResultDo<Map<Teacher,StuTeacher>>();
		resultDo= serviceFit.getTeacherService().getTeacherAllInfo();
		
		if(resultDo.isSuccess()){
			model.addAttribute("teaMap",resultDo.getResult());
		}else{
			model.addAttribute("mag",resultDo.getMessage());
		}
		model.addAttribute("menuSelected1", ConfigDo.STUCHOOSE);
		model.addAttribute("menuSelected2", ConfigDo.STUTEACHERINFO);
		return r.getName() +"/chooTea";
		
	}
	@RequestMapping("chooTeaByName")
	public String chooTeaByName(Model model,@RequestParam("teaName") String teaName){
		ResultDo<Map<Teacher,StuTeacher>> resultDo=new ResultDo<Map<Teacher,StuTeacher>>();
		resultDo= serviceFit.getTeacherService().getTeacherAllInfo();
		if(resultDo.isSuccess()){
			Map<Teacher,StuTeacher> map=resultDo.getResult();
			Set<Map.Entry<Teacher,StuTeacher>> set=map.entrySet();
			Iterator<Map.Entry<Teacher,StuTeacher>> it=set.iterator();
			boolean b=false;
			while(it.hasNext()){
				Map.Entry<Teacher,StuTeacher> mapEntry=it.next();
				if(mapEntry.getKey().getTeaName().equals(teaName)){
					Map<Teacher,StuTeacher> m=new HashMap<Teacher,StuTeacher>();
					m.put(mapEntry.getKey(), mapEntry.getValue());
					System.out.println(mapEntry.getKey().toString()+"----######----"+mapEntry.getValue().toString());
					model.addAttribute("teaMap",m);
					b=true;
				}
			}
			if(b==false){
				model.addAttribute("mag",resultDo.getMessage());
			}
		}else{
			model.addAttribute("mag",resultDo.getMessage());
		}
		model.addAttribute("menuSelected1", ConfigDo.STUCHOOSE);
		model.addAttribute("menuSelected2", ConfigDo.STUTEACHERINFO);
		return r.getName() +"/chooTea";
	}
	@RequestMapping("makeTea")
	public String makeTea(Model model,HttpSession session,@RequestParam("teaTeacherId")String teaTeacherId){
		Student student=(Student)session.getAttribute("user");
		ResultDo<Map<Teacher,StuTeacher>> resultDo=new ResultDo<Map<Teacher,StuTeacher>>();
		ResultDo result=serviceFit.getVirtualChooseService().isInfo(student.getStuStudentId(), teaTeacherId);
		if(!result.isSuccess()){
			return r.getName() +"/chooTea";
		}
		ResultDo resultDo1=serviceFit.getVirtualChooseService().insert(student.getStuStudentId(), teaTeacherId);
		if(!resultDo1.isSuccess()){
			model.addAttribute("mag",resultDo1.getMessage());
		}
		resultDo= serviceFit.getTeacherService().getTeacherAllInfo();		
		if(resultDo.isSuccess()){
			model.addAttribute("teaMap",resultDo.getResult());
		}
		Student stu=(Student) serviceFit.getStudentService().selectStudent(student.getStuStudentId()).getResult();
		session.removeAttribute("user");
		session.setAttribute("user", stu);
		model.addAttribute("tea", ConfigDo.STUCHOOSETEACHER);
		return this.chooTeaInfo(model, session);
		
	}
	/**
	 * 选报导师信息
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("chooTeaInfo")
	public String chooTeaInfo(Model model,HttpSession session){
		Student student=(Student)session.getAttribute("user");
		ResultDo resultDo=serviceFit.getVirtualChooseService().getTeacher(student.getStuStudentId());
		if(resultDo.isSuccess()){
			model.addAttribute("teacher",resultDo.getResult());
		}
		
		model.addAttribute("menuSelected1", ConfigDo.STUCHOOSE);
		model.addAttribute("menuSelected2", ConfigDo.ADMINSTUDENTCHOOSE);
		return r.getName() +"/chooTeaInfo";
	}
	/**
	 * 放弃选报
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("giveUpChoose")
	public String giveUpChoose(Model model,HttpSession session){
		Student student=(Student)session.getAttribute("user");
		ResultDo resultDo=new ResultDo();
		resultDo=serviceFit.getVirtualChooseService().delete(student.getStuStudentId());
		System.out.println("$$$$$-----"+student.toString());
		if(resultDo.isSuccess()){
			model.addAttribute("tea",resultDo.getResult());
		}
		else{
			model.addAttribute("mag",resultDo.getMessage());
		}
		Student stu=(Student) serviceFit.getStudentService().selectStudent(student.getStuStudentId()).getResult();
		session.removeAttribute("user");
		session.setAttribute("user", stu);
		
		model.addAttribute("menuSelected1", ConfigDo.STUCHOOSE);
		model.addAttribute("menuSelected2", ConfigDo.ADMINSTUDENTCHOOSE);
		return this.chooTeaInfo(model, session);
		
	}
	
	@RequestMapping("stuChoose")
	public String stuChoose(Model model,@RequestParam("teaName") String teaName){
		
		
		
		return null;
		
	}
}
