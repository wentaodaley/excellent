package cn.edu.zut.excellent.supervisor;


import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.zut.excellent.service.AdminService;
import cn.edu.zut.excellent.service.VirtualChooseService;
import cn.edu.zut.excellent.service.StudentService;
import cn.edu.zut.excellent.service.TeacherService;
import cn.edu.zut.excellent.service.UploadService;
@Repository
public class ServiceFit {
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private AdminService adminService;
    @Resource
    private VirtualChooseService virtualChooseService;
    @Resource
	private UploadService uploadService;
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public VirtualChooseService getVirtualChooseService() {
		return virtualChooseService;
	}
	public void setVirtualChooseService(VirtualChooseService virtualChooseService) {
		this.virtualChooseService = virtualChooseService;
	}
	public UploadService getUploadService() {
		return uploadService;
	}
	public void setUploadService(UploadService uploadService) {
		this.uploadService = uploadService;
	}
    
}