package cn.edu.zut.excellent.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zut.excellent.entity.Chooseteacher;

@Repository
public interface ChooseteacherDao {
/*
 * 查询选报的所有导师
 */
	List<Chooseteacher>  getChooseteacher();
}
