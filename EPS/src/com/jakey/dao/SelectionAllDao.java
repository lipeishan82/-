package com.jakey.dao;

/**

* Copyright (C), 03.06-03.11

* FileName: SelectionAllDao.java

* �����Խ�ʦ��ѧ����ͬ����

* @author Lipeishan
* @Date    2020.03.09

* @version 1.00

*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class SelectionAllDao {
	/** ����Statement���� */
	Statement stmt;
	/** ��������� */
	ResultSet rs;

	public Statement getStmt() {
		return stmt;
	}

	/**
	 * 
	 * ������eps_management.sql������
	 * 
	 * @param con �������ݿ�
	 * 
	 */
	public SelectionAllDao(Connection con) {
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ��ѯ����ȷ��ѧ����Ϣ
	 */

	public void selectStudentCheck() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from student s,stu_info s1 where s1.check1='Y' and s.student_id = s1.s_id order by s.student_id";
		rs = stmt.executeQuery(sql);
		System.out.println("ȷ��ѧ����Ϣ");
		System.out.println("ѧ��\t" + "\t����\t�Ա�\t����ʡ��\t����\t�����¶�\t" + "    " + "����");
		displayStudent();
	}

	/**
	 * ��ѯ����ȷ���ʦ��Ϣ
	 */

	public void selectTeacherCheck() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from teacher t, teacher_info t1 where t.teacher_id = t1.teacher_id and t1.check1='Y' order by t.teacher_id";
		rs = stmt.executeQuery(sql);
		System.out.println("ȷ���ʦ��Ϣ");
		System.out.println("����\t����\t�Ա�\t����ʡ��\t����\t�����¶�\t�ʱ��\t");
		displayTeacher();

	}

	/**
	 * �������ڲ�ѯѧ����Ϣ
	 *
	 * @param con  �������ݿ�
	 * @param date ���date���в�ѯ
	 */

	public void selectDate(Connection con, Date date) throws SQLException {
		String sql = "select * from student s, stu_info s1 where s.student_id = s1.s_id and s1.date like ? order by s.student_id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		// ���������ʱ����ص���Ϣ
		pstmt.setDate(1, (java.sql.Date) date);
		rs = pstmt.executeQuery();
		System.out.println("������Ϣ");
		System.out.println("ѧ����Ϣ");
		displayStudent();
	}

	/**
	 * �������ڲ�ѯ��ʦ��Ϣ
	 *
	 * @param con  �������ݿ�
	 * @param date ���date���в�ѯ
	 */
	public void selectDateTeacher(Connection con, Date date) throws SQLException {
		String sql = "select * from teacher t, teacher_info t1 where t.teacher_id = t1.teacher_id and t1.date like ?\"%\" order by t.teacher_id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setDate(1, (java.sql.Date) date);
		rs = pstmt.executeQuery();
		System.out.println("��ʦ��Ϣ");
		displayTeacher();
	}

	/**
	 * �������������ѯ��ʦ��Ϣ
	 *
	 * @param con   �������ݿ�
	 * @param date1 ���>=date1���в�ѯ
	 * @param date2 ���<=date1���в�ѯ
	 */
	public void selectBetweenDateT(Connection con, Date date1, Date date2) throws SQLException {
		String sql = "select * from teacher t, teacher_info t1 where t.teacher_id = t1.teacher_id and t1.date>= ? and t1.date<= ? order by t.teacher_id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setDate(1, (java.sql.Date) date1);
		pstmt.setDate(2, (java.sql.Date) date2);
		rs = pstmt.executeQuery();
		System.out.println("��ʦ��Ϣ");
		displayTeacher();

	}

	/**
	 * �������������ѯѧ����Ϣ
	 *
	 * @param con   �������ݿ�
	 * @param date1 ���>=date1���в�ѯ
	 * @param date2 ���<=date1���в�ѯ
	 */
	public void selectBetweenDateS(Connection con, Date date1, Date date2) throws SQLException {
		String sql = "select * from student s,stu_info s1 where s.student_id = s1.s_id  and s1.date>= ? and s1.date<= ? order by s.student_id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setDate(1, (java.sql.Date) date1);
		pstmt.setDate(2, (java.sql.Date) date2);
		rs = pstmt.executeQuery();
		System.out.println("ѧ����Ϣ:");
		displayStudent();

	}


	/**
	 * �����ݶ�����ѯ����ѧ����������
	 * 
	 * @throws �׳�SQLException
	 */
	public void displayStudent() throws SQLException {
		while (rs.next()) {
			String id = rs.getString("s_id");
			String name = rs.getString("student_name");
			String stu_sex = rs.getString("stu_sex");
			String student_pro = rs.getString("student_pro");
			String student_city = rs.getString("student_city");
			Float temprature = rs.getFloat("temperature");
			Date date = rs.getDate("date");
			System.out.print(id + "\t" + name + "\t" + stu_sex + "\t" + student_pro + "\t" + student_city + "\t"
					+ temprature + "\t" + date + "\t" + "\n" + "\n");
		}
	}

	/**
	 * �����ݶ������ڽ�ʦ��ѯ��������
	 * 
	 * @throws �׳�SQLException
	 */
	public void displayTeacher() throws SQLException {
		while (rs.next()) {
			String id = rs.getString("teacher_id");
			String name = rs.getString("teacher_name");
			String sex = rs.getString("sex");
			String t_pro = rs.getString("t_pro");
			String t_city = rs.getString("t_city");
			Float temprature = rs.getFloat("temprature");
			Date date = rs.getDate("date");
			System.out.print(id + "\t" + name + "\t" + sex + "\t" + t_pro + "\t" + t_city + "\t" + temprature + "\t"
					+ date + "\n" + "\n");
		}
	}

}
