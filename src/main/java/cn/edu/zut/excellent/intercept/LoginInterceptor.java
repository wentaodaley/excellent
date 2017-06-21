package cn.edu.zut.excellent.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.zut.excellent.conf.Role;
import cn.edu.zut.excellent.entity.Student;
import cn.edu.zut.excellent.entity.Teacher;


@Repository
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		System.out.println("进入拦截器");
		Role role = (Role) request.getSession().getAttribute("role");
		if (role == null){
			response.sendRedirect(request.getContextPath());
			return false;
		}
		System.out.println(handler);
		if(handler == null){
			request.getRequestDispatcher("./index.do").forward(request, response);
			return false;
		}
		if (role.getIndex() == Role.TEA.getIndex()){
			Teacher teacher = (Teacher) request.getSession().getAttribute("user");
			if (teacher.getTeaTell() == null || teacher.getTeaTell().trim().equals("") || teacher.getTeaEmail() == null || teacher.getTeaEmail().equals("")){
				request.getRequestDispatcher(role.getName() +"./teaInfo.do").forward(request,response);
				return false;
			}
		}
		else if(role.getIndex() ==Role.STU.getIndex()){
			Student student =(Student)request.getSession().getAttribute("user");
        	if(student.getStuTell() == null || student.getStuTell().equals("")){
        		request.getRequestDispatcher("./stuInfo").forward(request, response);
        		return false;
        	}
		}
		return true;
	}
}
