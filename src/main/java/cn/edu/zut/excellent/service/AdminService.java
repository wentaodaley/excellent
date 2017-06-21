package cn.edu.zut.excellent.service;

import cn.edu.zut.excellent.entity.Teacount;
import cn.edu.zut.excellent.supervisor.ResultDo;

public interface AdminService {
	
	ResultDo selectTeacount();
	
	ResultDo updateTeacount(Teacount teacount);
	
	ResultDo updateAllTeacount (Teacount teacount);

}
