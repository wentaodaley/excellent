package cn.edu.zut.excellent.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.zut.excellent.conf.Role;
import cn.edu.zut.excellent.entity.Student;
import cn.edu.zut.excellent.entity.Teacher;
import cn.edu.zut.excellent.supervisor.ConfigDo;
import cn.edu.zut.excellent.supervisor.ServiceFit;

import java.io.File;

@Controller
@RequestMapping("/admin/")
public class UploadController implements ConfigDo{

	@Resource
	private ServiceFit serviceFit;

	private Role r = Role.ADMIN;

	@RequestMapping("touploadTeacher")
	public String touploadTeacher( Model model){
		  	model.addAttribute("menuSelected1", ConfigDo.ADMINTEACHER); 
	        model.addAttribute("menuSelected2", ConfigDo.AMDINTEACHERUPLOAD); 
		return r.getName()+"/uploadTeacher";
	}
	@RequestMapping("touploadStudent")
	public String touploadStudent(Model model){
		model.addAttribute("menuSelected1", ConfigDo.ADMINSTUDENT); 
		model.addAttribute("menuSelected2", ConfigDo.ADMINSTUDENTUPLOAD); 
		return r.getName()+"/uploadStudent";
	}
	@RequestMapping("uploadTeacher")
	public String upload(@RequestParam(value="file",required=false) MultipartFile file,HttpServletRequest request, ModelMap model){
		System.out.println("开始");
		/*
		 * 获取到上传的文件的地址
		 */
		String path = request.getSession().getServletContext()
				.getRealPath("upload");
		String fileName = file.getOriginalFilename();
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()){
			targetFile.mkdirs();
		}
		//保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("fileUrl", request.getContextPath() + "/upload/"
				+ fileName);
            serviceFit.getUploadService().uploadTeacher(((Teacher)request.getSession().getAttribute("teacher")), targetFile);
			return "redirect:/admin/touploadTeacher.do";
	}
	@RequestMapping("uploadStudent")
	public String uploadStudent(@RequestParam(value="file",required=false) MultipartFile file,HttpServletRequest request, ModelMap model){
		
		System.out.println("开始");
		/*
		 * 获取到上传的文件的地址
		 */
		String path = request.getSession().getServletContext()
				.getRealPath("upload");
		String fileName = file.getOriginalFilename();
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()){
			targetFile.mkdirs();
		}
		//保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("fileUrl", request.getContextPath() + "/upload/"
				+ fileName);
		serviceFit.getUploadService().upladStudent(((Student) request.getSession().getAttribute("student")), targetFile);
		return "redirect:/admin/touploadStudent.do"; 
	}

}
