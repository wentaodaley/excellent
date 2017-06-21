package cn.edu.zut.excellent.controller;


import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.zut.excellent.conf.Role;
import cn.edu.zut.excellent.supervisor.ConfigDo;
import cn.edu.zut.excellent.supervisor.ResultDo;
import cn.edu.zut.excellent.supervisor.ServiceFit;





@Controller
@RequestMapping("/")
public class LoginController  implements ConfigDo {

	@Resource
	private ServiceFit serviceFit;
	private ResultDo resultDo;
	@RequestMapping("index")
	public String index(){
		return "./index";
	}
	@RequestMapping("login")
	public ModelAndView  login(@RequestParam("p") String p,@RequestParam("u") String u,HttpSession session){
		Role role = null;
        Date date=new Date();
        resultDo = new ResultDo();
        System.out.println("AdminUser.equals(u)"+AdminUser.equals(u)+"登录时间的账号和密码");
        if (AdminUser.equals(u)){
            role = Role.ADMIN;
            if(AdminPwd.equals(p)){
            	resultDo.setResult("admin");
				resultDo.setSuccess(true);
            }
        }else if (u.length() == 12){
            role = Role.STU;
            resultDo = serviceFit.getStudentService().getStuinfo(u,p);
        }else {
            role = Role.TEA;
            resultDo = serviceFit.getTeacherService().getTeainfo(u,p);
        }
        System.out.println(resultDo);
        if(resultDo.isSuccess()){
        	session.setAttribute("user", resultDo.getResult());
        	session.setAttribute("role", role);
        	session.setAttribute("pathCode", role.getName());
        	return new ModelAndView("redirect:./"+role.getName() + "/home.do");
        }else{
        	return new ModelAndView("index","mag",resultDo.getMessage());
        }
    }


	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "./index";
	}

}
