package cn.edu.zut.excellent.supervisor;

import org.springframework.stereotype.Repository;

import cn.edu.zut.excellent.dao.ChooseteacherDao;
import cn.edu.zut.excellent.dao.FileModelDao;
import cn.edu.zut.excellent.dao.IDao;
import cn.edu.zut.excellent.dao.StuTeacherDao;
import cn.edu.zut.excellent.dao.StudentDao;
import cn.edu.zut.excellent.dao.TeacherDao;
import cn.edu.zut.excellent.dao.TeacountDao;
import cn.edu.zut.excellent.dao.VirtualChooseDao;
import cn.edu.zut.excellent.entity.StuTeacher;
import cn.edu.zut.excellent.entity.Teacount;



import javax.annotation.Resource;

@Repository
public class DaoFit {
	@Resource
	private ChooseteacherDao chooseteacherDao;
	@Resource
	private FileModelDao fileModelDao;
	@Resource
	private IDao iDao;
	@Resource
	private StudentDao studentDao;
	@Resource
	private TeacherDao teacherDao;
	@Resource
	private VirtualChooseDao virtualChooseDao;
	@Resource
	private StuTeacherDao stuTeacherDao;
	
	@Resource
	private TeacountDao teacountDao;

	public ChooseteacherDao getChooseteacherDao() {
		return chooseteacherDao;
	}

	public void setChooseteacherDao(ChooseteacherDao chooseteacherDao) {
		this.chooseteacherDao = chooseteacherDao;
	}

	public FileModelDao getFileModelDao() {
		return fileModelDao;
	}

	public void setFileModelDao(FileModelDao fileModelDao) {
		this.fileModelDao = fileModelDao;
	}

	public IDao getiDao() {
		return iDao;
	}

	public void setiDao(IDao iDao) {
		this.iDao = iDao;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public VirtualChooseDao getVirtualChooseDao() {
		return virtualChooseDao;
	}

	public void setVirtualChooseDao(VirtualChooseDao virtualChooseDao) {
		this.virtualChooseDao=virtualChooseDao;
	}
	
	public StuTeacherDao getStuTeacherDao(){
		return stuTeacherDao;
	}
	public void setStuTeacherDao(StuTeacherDao stuTeacherDao){
		this.stuTeacherDao=stuTeacherDao;
	}

	public TeacountDao getTeacountDao() {
		return teacountDao;
	}

	public void setTeacountDao(TeacountDao teacountDao) {
		this.teacountDao = teacountDao;
	}
 
 
}