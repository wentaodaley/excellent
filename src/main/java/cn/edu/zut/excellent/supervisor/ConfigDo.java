package cn.edu.zut.excellent.supervisor;

public interface ConfigDo {

    public final String AppsName = "软件学院卓越班选报平台";

    public final String AdminUser = "zzti";

    public final String AdminPwd = "zzti00";

	public final String defPwd="123456";
	/*
     * 一级导航
     */
	/**
	 * 空连接
	 */
	public static final String EMPTY="empty";
	
    /**
     * 首页
     */
	public static final String INDEX="index";
	/*
	 *管理员一级导航 
	 */
	/**
	 * 教师管理
	 */
	public static final String ADMINTEACHER = "adminTeacher";
	/**
	 * 学生管理
	 */
	public static final String ADMINSTUDENT = "adminStudent";
	/*
	 * 学生一级导航
	 */
	/**
	 *学生选报管理
	 */
	public static final String STUCHOOSE = "stuChoose";
	/**
	 * 学生个人信息
	 */
	public static final String STUINFO = "stuInfo";
	/*
	 * 教师一级导航
	 */
	/**
	 *对接学生信息
	 */
	public static final String TEASTUINFO = "teaStuInfo";
	/**
	 * 教师个人信息
	 */
	public static final String TEAINFO = "teaInfo";
	
	/*
	 * 二级导航
	 */
	/*
	 * 管理员
	 */
	/**
	 * 添加教师
	 */
	public static final String ADMIINTEACHERINFO = "aminTeacherInfo";
	/**
	 * 批量上传教师信息
	 */
	public static final String AMDINTEACHERUPLOAD = "adminTeacherUpload";
	/**
	 * 教师基本信息
	 */
	public static final String ADMINTEACHERLIST = "adminTeacherList";
	/**
	 * 人数设定
	 */
	public static final String ADMINTEACHERCOUNT="adminTeacherCount";
	/**
	 * 添加学生
	 */
	public static final String ADMINSTUDENTINFO = "adminStudentInfo";
	/**
	 * 批量上传学生信息
	 */
	public static final String ADMINSTUDENTUPLOAD = "adminStudentUpload";
	/*
	 * 学生基本信息查看
	 */
	/*
	 * 学生基本信息
	 */
	public static final String ADMINSTUDENTLIST="adminStudentList";
	/**
	 * 学生选报信息
	 */
	public static final String ADMINSTUDENTCHOOSE = "adminStudentChoose";
	/**
	 * 导师基本信息
	 */
	public static final String STUTEACHERINFO="stuTeacherInfo";
	/**
	 * 学生选报
	 */
	public static final String STUCHOOSETEACHER = "stuChooseTeacher";
	/*
	 * 教师
	 */
	/**
	 * 对接学生
	 */
	public static final String TEASTULIST = "teaStuList";
	/**
	 * 学生选报
	 */
	public static final String TEACHOOSE = "teaChoose";
	
}