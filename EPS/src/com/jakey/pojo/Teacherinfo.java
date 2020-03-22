package com.jakey.pojo;
/**

* Copyright (C), 03.06-03.11

* FileName: Teacherinfo.java

* 教师信息表的实体类

* @author Lipeishan
* @Date    2020.03.06

* @version 1.00

*/
import java.math.BigDecimal;
import java.util.Date;

public class Teacherinfo {
	/** 教师工号 */
	private int teacher_id = -1;
	/** 教师确诊人数 */
	private int checknum;
	/** 教师当天温度 */
	private BigDecimal temperature;
	/** 教师是否有症状 */
	private String symptom;
	/** 教师防疫信息填写日期 */
	private Date date;
	/** 教师确诊情况 */
	private String check;
	/** 教师性别 */
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Teacherinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacherinfo(int teacher_id, BigDecimal temperature, String symptom, Date date, String check) {
		super();
		this.teacher_id = teacher_id;
		this.temperature = temperature;
		this.symptom = symptom;
		this.date = date;
		this.check = check;

	}

	public Teacherinfo(java.sql.Date date, String sex, int checknum) {
		// TODO Auto-generated constructor stub
		super();
		this.date = date;
		this.sex = sex;
		this.setChecknum(checknum);
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public int getChecknum() {
		return checknum;
	}

	public void setChecknum(int checknum) {
		this.checknum = checknum;
	}

}
