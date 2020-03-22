package com.jakey.dao;

/**

* Copyright (C), 03.06-03.11

* FileName: SelectionTeacherDao.java

* �����Խ�ʦ����

* @author Lipeishan
* @Date  2020.03.07

* @version 1.00

*/
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import com.jakey.pojo.Teacher;
import com.jakey.pojo.Teacherinfo;

//��ʦ��ѯ
public class SelectionTeacherDao {
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
	 * @param Connection con �������ݿ�
	 * 
	 */
	public SelectionTeacherDao(Connection con) {

		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * ��ӽ�ʦ��Ϣ
	 * 
	 * @param con     �������ݿ�
	 * @param teacher ���Teacher��ʵ��
	 * @return ���ؽ����
	 */
	public int AddTeacher(Connection con, Teacher teacher) throws SQLException {
		String sql = "insert into teacher value(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, teacher.getTeacher_id());
		pstmt.setString(2, teacher.getTeacher_name());
		pstmt.setString(3, teacher.getSex());
		pstmt.setString(4, teacher.getT_pro());
		pstmt.setString(5, teacher.getT_city());
		return pstmt.executeUpdate();
	}

	/**
	 * 
	 * ��ӽ�ʦ������Ϣ
	 * 
	 * @param con   �������ݿ�
	 * @param tinfo ���Teacherinfo��ʵ��
	 * @return ���ؽ����
	 * 
	 */
	public int AddTeacherInfo(Connection con, Teacherinfo tinfo) throws SQLException {
		String sql = "insert into teacher_info value(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, tinfo.getTeacher_id());
		pstmt.setString(2, tinfo.getSymptom());
		pstmt.setString(3, tinfo.getCheck());
		pstmt.setBigDecimal(4, tinfo.getTemperature());
		pstmt.setDate(5, (java.sql.Date) tinfo.getDate());
		return pstmt.executeUpdate();
	}
	

	public void SelectByDateIdTeacher(Connection con, Date date, int id) throws SQLException {
		String sql = "select * from teacher t, teacher_info t1 where t.teacher_id = t1.teacher_id and t1.date = ? and t.teacher_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setDate(1, (java.sql.Date) date);
		pstmt.setInt(2, id);
		rs = pstmt.executeQuery();
		display();
	}

	/** ��ʾ���н�ʦ��Ϣ */
	public void selectAllTeacher() throws SQLException {
		String sql = "select * from teacher t, teacher_info t1 where t.teacher_id = t1.teacher_id order by t.teacher_id";
		rs = stmt.executeQuery(sql);
		System.out.println("��ʦ��Ϣ");
		System.out.println("����\t����\t�Ա�\t����ʡ��\t����\t�����¶�\t֢״\t�ʱ��\t\t�Ƿ�ȷ��\t");
		display();
	}

	/**
	 * ���ݹ��Ų�ѯ��Ϣ
	 *
	 * @param con        �������ݿ�
	 * @param teacher_id ���teacher_id���в�ѯ
	 */
	public void selectTeacherById(Connection con, int teacher_id) throws SQLException {
		String sql = "select * from teacher t, teacher_info t1 where t.teacher_id = t1.teacher_id and t.teacher_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, teacher_id);
		rs = pstmt.executeQuery();
		display();
	}

	/**
	 * �����ݶ�����ѯ��������
	 * 
	 * @throws �׳�SQLException
	 */
	private void display() throws SQLException {
		// TODO Auto-generated method stub
		while (rs.next()) {
			String id = rs.getString("teacher_id");
			String name = rs.getString("teacher_name");
			String sex = rs.getString("sex");
			String t_pro = rs.getString("t_pro");
			String t_city = rs.getString("t_city");
			BigDecimal temprature = rs.getBigDecimal("temprature");
			Date date = rs.getDate("date");
			String symptom = rs.getString("symptom");
			String check = rs.getString("check1");
			System.out.print(id + "\t" + name + "\t" + sex + "\t" + t_pro + "\t" + t_city + "\t" + temprature + "\t"
					+ symptom + "\t" + date + "\t" + check + "\n" + "\n");
		}
	}

}
