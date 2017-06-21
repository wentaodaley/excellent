package cn.edu.zut.excellent.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.zut.excellent.entity.Student;
import cn.edu.zut.excellent.entity.Teacher;
import cn.edu.zut.excellent.entity.Teacount;
import cn.edu.zut.excellent.entity.VirtualChoose;
import cn.edu.zut.excellent.supervisor.DaoFit;
import cn.edu.zut.excellent.supervisor.ServiceFit;

public class DataStaticServiceTest {
	private DaoFit daoFit;
	
	private ServiceFit serviceFit;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring-sql.xml",
				"classpath:conf/spring-mvc.xml" });
		daoFit = (DaoFit) context.getBean("daoFit");
		serviceFit = (ServiceFit) context.getBean("serviceFit");
	}
	
	@Test
	public void test(){
//		List<Teacher> list = new ArrayList<>();
//		RowBounds rowBounds = new RowBounds(1, 10);
////		list = daoFit.getStudentDao().getallStu(rowBounds);
//		list  = daoFit.getTeacherDao().getallTeacher();
//		System.out.println(list.size());
		List<Teacount> list = new ArrayList<>();
		list = daoFit.getTeacountDao().slectTeacount();
		for(Teacount teacount:list){
			System.out.println(teacount.toString());
		}
		Teacount teacount = new Teacount();
		teacount.setStuCount(8);
		teacount.setTeaRoleId(2);
		int succ = daoFit.getTeacountDao().updateAllTeacount(teacount);
		System.out.println(succ);
		list = daoFit.getTeacountDao().slectTeacount();
		for(Teacount teacounts:list){
			System.out.println(teacounts.toString());
		}
	}
}


