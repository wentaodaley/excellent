package cn.edu.zut.excellent.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zut.excellent.entity.Teacount;

@Repository
public interface TeacountDao {
	
	List<Teacount>	slectTeacount();
	
	int updateTeacount(Teacount teacount);
	
	int updateAllTeacount (Teacount teacount);
}
