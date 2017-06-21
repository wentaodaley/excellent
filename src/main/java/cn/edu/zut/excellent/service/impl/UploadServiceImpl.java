package cn.edu.zut.excellent.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import cn.edu.zut.excellent.entity.Student;
import cn.edu.zut.excellent.entity.Teacher;
import cn.edu.zut.excellent.service.UploadService;
import cn.edu.zut.excellent.supervisor.DaoFit;
@Service("UploadService")
public class UploadServiceImpl implements UploadService {

	
	 @Resource
	 private DaoFit daoFit;
	@Override
	public boolean uploadTeacher(Teacher tea, File file) {
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Workbook hssfWorkbook = null;
        try {
            hssfWorkbook = WorkbookFactory.create(new FileInputStream(file));
        } catch (IOException | InvalidFormatException e1) {
            e1.printStackTrace();
        }
        Teacher teacher = new Teacher();
        List<Teacher> list = new ArrayList<Teacher>();
        Sheet hssfSheet = hssfWorkbook.getSheetAt(0);
        // 循环行Row
        for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            Row hssfRow = hssfSheet.getRow(rowNum);

            // 循环列Cell
            Cell teaTeacherId = hssfRow.getCell(0);
            if (teaTeacherId == null || teaTeacherId.equals("")) {
                teacher.setTeaTeacherId(null);
            } else {
            	teaTeacherId.setCellType(teaTeacherId.CELL_TYPE_STRING);
                teacher.setTeaTeacherId(getValue(teaTeacherId));
            }
            Cell teaName = hssfRow.getCell(1);
            teaName.setCellType(teaName.CELL_TYPE_STRING);
            if (getValue(teaName) == null || getValue(teaName).equals("")) {
                teacher.setTeaName(null);
            } else {
                teacher.setTeaName(getValue(teaName));
                teacher.setTeaTeacherId(getValue(teaTeacherId));
            }
            Cell teaSex = hssfRow.getCell(2);
            if (getValue(teaSex) == null || getValue(teaSex).equals("")) {
                teacher.setTeaSex(false);
            } else {
                teacher.setTeaSex(Boolean.parseBoolean(getValue(teaSex)));
            }
            Cell teaQualifications = hssfRow.getCell(3);

            if (getValue(teaQualifications) == null || getValue(teaQualifications).equals("")) {
                teacher.setTeaQualifications(1);
            } else {
                teaQualifications.setCellType(teaQualifications.CELL_TYPE_STRING);
                teacher.setTeaQualifications(Integer.parseInt(getValue(teaQualifications)));
            }
            Cell teaTell = hssfRow.getCell(4);

            if (getValue(teaTell) == null || getValue(teaTell).equals("")) {
                teacher.setTeaTell(null);
            } else {
                teaTell.setCellType(teaTell.CELL_TYPE_STRING);
                teacher.setTeaTell(getValue(teaTell));
            }


            Cell teaEmail = hssfRow.getCell(5);

            if (getValue(teaEmail) == null || getValue(teaEmail).equals("")) {
                teacher.setTeaEmail(null);
            } else {
                teaEmail.setCellType(teaEmail.CELL_TYPE_STRING);
                teacher.setTeaEmail(getValue(teaEmail));
            }

            Cell teaQQ = hssfRow.getCell(6);

            if (getValue(teaQQ) == null || getValue(teaQQ).equals("")) {
                teacher.setTeaEmail(null);
            } else {
                teaQQ.setCellType(teaQQ.CELL_TYPE_STRING);
                teacher.setTeaEmail(getValue(teaQQ));
            }

            daoFit.getTeacherDao().insertTeacher(teacher);
        }
        return true;
	}

	@Override
	public boolean upladStudent(Student s, File file) {
		 Workbook hssfWorkbook = null;
	        try {
	            hssfWorkbook = WorkbookFactory.create(new FileInputStream(file));
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        } catch (InvalidFormatException e1) {
	            e1.printStackTrace();
	        }
	        Student student = new Student();
	        List<Student> list = new ArrayList<Student>();
	        Sheet hssfSheet = hssfWorkbook.getSheetAt(0);
	        // 循环行Row
	        System.out.println(hssfSheet.getLastRowNum());
	        for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
	            Row hssfRow = hssfSheet.getRow(rowNum);

	            // 循环列Cell
	            Cell stuStudentId = hssfRow.getCell(0);                //学号
	           System.out.println("学生----------" + stuStudentId);
	            if (stuStudentId == null || stuStudentId.equals("")) {
	                student.setStuStudentId(null);
	            } else {
	            	stuStudentId.setCellType(stuStudentId.CELL_TYPE_STRING);
	                student.setStuStudentId(getValue(stuStudentId));
	            }
	            Cell stuName = hssfRow.getCell(1);                    //学生姓名
//	            System.out.println("***********************" + getValue(stuName));
	            //	                teaName.setCellType(teaName.CELL_TYPE_STRING);
	            if (getValue(stuName) == null || getValue(stuName).equals("")) {
	                student.setStuName(null);
	            } else {
	                student.setStuName(getValue(stuName));
	            }
	            Cell sex = hssfRow.getCell(2);                //性别
	            if (getValue(sex) == null || getValue(sex).equals("")) {
	                student.setStuSex(false);
	            } else {
	                    student.setStuSex(Boolean.parseBoolean(getValue(sex)));
	            }
			Cell stuClass = hssfRow.getCell(3); // 班级

			if (getValue(stuClass) == null || getValue(stuClass).equals("")) {
				student.setStuClass(null);
			} else {
				stuClass.setCellType(stuClass.CELL_TYPE_STRING);
				student.setStuClass(getValue(stuClass));
			}

//	            Cell stutel = hssfRow.getCell(4);//TelPhone
//	            if (getValue(stutel) == null || getValue(stutel).equals("")) {
//	                student.setStuTell(null);
//	            } else {
//	                stutel.setCellType(stutel.CELL_TYPE_STRING);
//	                student.setStuTell(getValue(stutel));
//	            }
//
//
//	            Cell stuEmail = hssfRow.getCell(5);            //Email
//
//	            if (getValue(stuEmail) == null || getValue(stuEmail).equals("")) {
//	                student.setStuEmail(null);
//	            } else {
//	                stuEmail.setCellType(stuEmail.CELL_TYPE_STRING);
//	                student.setStuEmail(getValue(stuEmail));
//	            }
	            System.out.println(student);
	            daoFit.getStudentDao().insert(student);
	        }
	        return true;
	}
	@SuppressWarnings("static-access")
    private String getValue(Cell hssfCell) {
        if (hssfCell == null) {
            return null;
        }
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}
