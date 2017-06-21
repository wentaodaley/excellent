package cn.edu.zut.excellent.service;

import java.io.File;

import cn.edu.zut.excellent.entity.Student;
import cn.edu.zut.excellent.entity.Teacher;

public interface UploadService {
	/**
	 * 基于Excel的文本上传
	 * 教师上传信息
	 * @param teacher
	 * @param file
	 * @return
	 */
	public boolean uploadTeacher(Teacher teacher,File file);
	/**
	 * 基于Excel的文本上传
	 * 学生上传信息
	 * @param student
	 * @param file
	 * @return
	 */
	public boolean upladStudent(Student student,File file);
}
