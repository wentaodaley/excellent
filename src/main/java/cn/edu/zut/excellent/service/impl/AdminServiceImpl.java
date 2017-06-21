package cn.edu.zut.excellent.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.zut.excellent.entity.Teacount;
import cn.edu.zut.excellent.service.AdminService;
import cn.edu.zut.excellent.supervisor.DaoFit;
import cn.edu.zut.excellent.supervisor.ResultDo;
@Service("AdminService")
public class AdminServiceImpl implements AdminService {
	@Resource
	public DaoFit daoFit;
	@Override
	public ResultDo selectTeacount() {
		ResultDo resultDo = new ResultDo();
		List<Teacount> list = new ArrayList<>();
	list = daoFit.getTeacountDao().slectTeacount();
		if (list.size() > 0){
			resultDo.setResult(list);
			resultDo.setSuccess(true);
		}
		else{
			resultDo.setMessage("查询失败");
		}
		return resultDo;
	}


	@Override
	public ResultDo updateTeacount(Teacount teacount) {
		ResultDo resultDo = new ResultDo();
		int succ = 0;
		if (teacount != null){
			succ = daoFit.getTeacountDao().updateTeacount(teacount);
		}
		if(succ > 0){
			resultDo.setResult(succ);
			resultDo.setSuccess(true);
		}else{
			resultDo.setMessage("更新失败");
		}
		return resultDo;
	}


	@Override
	public ResultDo updateAllTeacount(Teacount teacount) {
		// TODO Auto-generated method stub
		ResultDo resultDo = new ResultDo();
		int succ = 0;
		if (teacount != null){
			succ = daoFit.getTeacountDao().updateAllTeacount(teacount);
		}
		if(succ > 0){
			resultDo.setResult(succ);
			resultDo.setSuccess(true);
		}else{
			resultDo.setMessage("更新失败");
		}
		return resultDo;
	}

}
