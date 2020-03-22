package com.jakey.pojo;

/**

* Copyright (C), 03.06-03.11

* FileName: Main.java

* ����ʵ��

* @author Lipeishan
* @Date    2020.03.06

* @version 1.00

*/
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;

import org.omg.DynamicAny.DynAnyOperations;

import com.jakey.barchart.BarChartStudent;
import com.jakey.barchart.BarChartTeacher;
import com.jakey.dao.SelectionAllDao;
import com.jakey.dao.SelectionStudentDao;
import com.jakey.dao.SelectionTeacherDao;
import com.jakey.pojo.Student;
import com.jakey.pojo.Studentinfo;
import com.jakey.pojo.Teacher;
import com.jakey.pojo.Teacherinfo;
import com.jakey.util.DbUtil;


public class Main {
	public static void main(String[] args) throws Exception {
		Menu();
		ArrayList<Teacher> t = new ArrayList<Teacher>();
		ArrayList<Teacherinfo> tinfo = new ArrayList<Teacherinfo>();
		ArrayList<Student> s = new ArrayList<Student>();
		ArrayList<Studentinfo> sinfo = new ArrayList<Studentinfo>();
		int choice;
		int choice1;
		int choice2;
		int choice3;
		int choice4;
		// �˵���ʾ
		while (true) {
			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
			switch (choice) {
			case 1:
				// ��Ӳ���
				MenuAdd();
				do {
					Scanner in_addteacher = new Scanner(System.in);
					choice3 = in_addteacher.nextInt();
					switch (choice3) {
					case 1:
						// ��ӽ�ʦ��Ϣ
						TeacherAdd(t);
						MenuAdd();
						break;

					case 2:
						// ���ѧ����Ϣ
						StudentAdd(s);
						MenuAdd();
						break;

					case 3:
						// ��ӽ�ʦ������Ϣ
						AddTeacherInfo(tinfo);
						MenuAdd();
						break;

					case 4:
						// ���ѧ��������Ϣ
						AddStudentInfo(sinfo);
						MenuAdd();
						break;

					}
				} while (choice3 != 5);
				break;

			case 2:
				// ȫ����Ϣ��ʾ
				Menu1();
				do {
					Scanner in1 = new Scanner(System.in);
					choice1 = in1.nextInt();
					switch (choice1) {
					case 1:
						// ��ʦ��Ϣ
						SelectionAllTeacher();
						Menu1();
						break;

					case 2:
						// ѧ����Ϣ
						SelectionAllStudent();
						Menu1();
						break;
						

					case 3:
						// �鿴ѧ��ȷ�����
						SelectionStudentCheck();
						Menu2();
						break;

					case 4:
						// �鿴��ʦȷ�����
						SelectionTeacherCheck();
						Menu2();
						break;
					}
				} while (choice1 != 5);
				break;

			case 3:
				// ������ѯ
				Menu2();
				do {
					Scanner in2 = new Scanner(System.in);
					choice2 = in.nextInt();
					switch (choice2) {
					case 1:
						// ���ݹ��Ų�ѯ
						SelectionTeacherById();
						Menu2();
						break;

					case 2:
						// ����ѧ�Ų�ѯ
						SelectionStudentById();
						Menu2();
						break;
						
					case 3:
						SelectTeacherByIdDate();
						Menu2();
						break;


					case 4:
						// �������ڲ�ѯ��Ϣ
						SelectionDate();
						Menu2();
						break;

					case 5:
						// �������������ѯ��Ϣ
						SelctionDateBetween();
						Menu2();
						break;

					}

				} while (choice2 != 6);
				break;

			case 4:
				// ��״ͼ
				MenuFrame();
				do {
					Scanner in4 = new Scanner(System.in);
					choice4 = in.nextInt();
					switch (choice4) {
					case 1:
						// ��ʦȷ����Ů���ͼ
						TeacherCheckInfo();
						MenuFrame();
						break;

					case 2:
						// ѧ��ȷ����Ů���ͼ
						StudentCheckInfo();
						MenuFrame();
						break;
					}
				} while (choice4 != 3);
				break;
				
			case 5:
				System.exit(0);

			}
			Menu();
		}
	}



	/**
	 * �˵�
	 */
	private static void Menu() {
		// TODO Auto-generated method stub
		System.out.println("*************��������Ҫ���еĲ���:***************************");
		System.out.println("*                      1.�����Ϣ                                               *");
		System.out.println("************************2.��ѯȫ����Ϣ");
		System.out.println("3.������ѯ");
		System.out.println("4.��״ͼ");
		System.out.println("5.�˳�ϵͳ");
	}

	/**
	 * �����Ϣ�˵�
	 */
	private static void MenuAdd() {
		// TODO Auto-generated method stub
		System.out.println("��������Ҫ���еĲ���:");
		System.out.println("1.��ӽ�ʦ");
		System.out.println("2.���ѧ��");
		System.out.println("3.��ӽ�ʦ������Ϣ");
		System.out.println("4.���ѧ��������Ϣ");
		System.out.println("5.������һ��");
	}

	/**
	 * ��ʾ��Ϣ�˵�
	 */
	private static void Menu1() {
		// TODO Auto-generated method stub
		System.out.println("��������Ҫ���еĲ���:");
		System.out.println("1.��ѯȫ����ʦ��Ϣ");
		System.out.println("2.��ѯȫ��ѧ����Ϣ");
		System.out.println("3.��ʾѧ��ȷ����Ϣ");
		System.out.println("4.��ʾ��ʦȷ����Ϣ");
		System.out.println("5.������һ��");
	}

	/**
	 * ������ѯ�˵�
	 */
	private static void Menu2() {
		// TODO Auto-generated method stub
		System.out.println("��������Ҫ���еĲ���:");
		System.out.println("1.���ݹ��Ų�ѯ��ʦ��Ϣ");
		System.out.println("2.����ѧ�Ų�ѯѧ����Ϣ");
		System.out.println("3.��������/id��ѯ��Ϣ");
		System.out.println("4.��ѯ������Ϣ");
		System.out.println("5.��ѯ��ʱ����Ϣ");
		System.out.println("6.������һ��");

	}

	/**
	 * ��״ͼ�˵�
	 */
	private static void MenuFrame() {
		// TODO Auto-generated method stub
		System.out.println("��������Ҫ���еĲ���:");
		System.out.println("1.��ʦÿ��ȷ�����");
		System.out.println("2.ѧ��ÿ��ȷ�����");
		System.out.println("3.������һ��");
	}

	/**
	 * ��ʦ��Ϣ���
	 * 
	 * @param arrayList
	 * @return
	 * @throws Exception
	 */
	private static ArrayList<Teacher> TeacherAdd(ArrayList<Teacher> arrayList) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		SelectionTeacherDao dao = new SelectionTeacherDao(con);
		System.out.println("�������ʦ��Ϣ(������,����,�Ա�,���ڳ���,����ʡ��)��");
		Scanner t = new Scanner(System.in);
		int teacher_id = t.nextInt();
		String teacher_name = t.next();
		String sex = t.next();
		String t_pro = t.next();
		String t_city = t.next();
		Teacher teacher = new Teacher();
		teacher.setTeacher_id(teacher_id);
		teacher.setTeacher_name(teacher_name);
		teacher.setSex(sex);
		teacher.setT_pro(t_pro);
		teacher.setT_city(t_city);

		try {
			dao.AddTeacher(con, teacher);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con);
		}
		if (arrayList != null) {
			System.out.println("��ӳɹ�");
			return arrayList;
		}
		System.out.println("���ʧ��");
		return null;

	}

	/**
	 * ѧ����Ϣ���
	 * 
	 * @param arrayList ѧ����Ϣ
	 * @return arrayList
	 * @throws Exception
	 */
	private static ArrayList<Student> StudentAdd(ArrayList<Student> arrayList) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		SelectionStudentDao dao = new SelectionStudentDao(con);
		System.out.println("������ѧ����Ϣ(��ѧ��,����,�Ա�,���ڳ���,����ʡ��)��");
		Scanner t = new Scanner(System.in);
		int student_id = t.nextInt();
		String student_name = t.next();
		String stu_sex = t.next();
		String student_pro = t.next();
		String student_city = t.next();
		Student student = new Student();
		student.setStudent_id(student_id);
		student.setStu_name(student_name);
		student.setStu_sex(stu_sex);
		student.setStu_pro(student_pro);
		student.setStu_city(student_city);

		try {
			dao.AddStudent(con, student);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con);
		}
		if (arrayList != null) {
			System.out.println("��ӳɹ�");
			return arrayList;
		}
		System.out.println("���ʧ��");
		return null;
	}

	/**
	 * ��ʦ������Ϣ���
	 * 
	 * @param arrayList ��ʦ������Ϣ
	 * @return arrayList
	 * @throws Exception
	 */
	private static ArrayList<Teacherinfo> AddTeacherInfo(ArrayList<Teacherinfo> arrayList) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		SelectionTeacherDao dao = new SelectionTeacherDao(con);

		System.out.println("�������ʦ������Ϣ(������,����֢״(Y/N),�Ƿ�ȷ��(Y/N),�¶�)��");
		Scanner info = new Scanner(System.in);
		int teacher_id = info.nextInt();
		String symptom = info.next();
		String check = info.next();
		BigDecimal temperature = info.nextBigDecimal();

		java.util.Date curDate = new java.util.Date();
		// �������ڵ�ת��
		java.sql.Date date = new java.sql.Date(curDate.getTime());

		Teacherinfo tinfo = new Teacherinfo();
		tinfo.setTeacher_id(teacher_id);
		tinfo.setSymptom(symptom);
		tinfo.setCheck(check);
		tinfo.setTemperature(temperature);
		tinfo.setDate(date);

		try {
			dao.AddTeacherInfo(con, tinfo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con);
		}

		if (arrayList != null) {
			System.out.println("��ӳɹ�");
			return arrayList;
		}
		System.out.println("���ʧ��");
		return null;

	}

	/**
	 * ѧ��������Ϣ���
	 * 
	 * @param arrayList ѧ��������Ϣ
	 * @return arrayList
	 * @throws Exception
	 */
	private static ArrayList<Studentinfo> AddStudentInfo(ArrayList<Studentinfo> arrayList) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		SelectionStudentDao dao = new SelectionStudentDao(con);

		System.out.println("������ѧ��������Ϣ(��ѧ��,����֢״(Y/N),�Ƿ�ȷ��(Y/N),�¶�)��");
		Scanner info = new Scanner(System.in);
		int student_id = info.nextInt();
		String symptom = info.next();
		String check = info.next();
		BigDecimal temperature = info.nextBigDecimal();
		java.util.Date curDate = new java.util.Date();
		java.sql.Date date = new java.sql.Date(curDate.getTime());

		Studentinfo sinfo = new Studentinfo();
		sinfo.setStudent_id(student_id);
		sinfo.setSymptom(symptom);
		sinfo.setCheck(check);
		sinfo.setTemperature(temperature);
		sinfo.setDate(date);
		try {
			dao.AddStudentInfo(con, sinfo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con);
		}

		if (arrayList != null) {
			System.out.println("��ӳɹ�");
			return arrayList;
		}
		System.out.println("���ʧ��");
		return null;

	}

	/**
	 * ��ʦȷ����Ϣ
	 * 
	 * @throws Exception
	 */
	private static void SelectionTeacherCheck() throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		SelectionAllDao dao = new SelectionAllDao(con);
		try {
			dao.selectTeacherCheck();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con);
		}
	}

	/**
	 * ѧ��ȷ����Ϣ
	 * 
	 * @throws Exception
	 */
	private static void SelectionStudentCheck() throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		SelectionAllDao dao = new SelectionAllDao(con);
		try {
			dao.selectStudentCheck();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con);
		}
	}

	/**
	 * ����ѧ�Ž���ѧ����Ϣ��ѯ
	 * 
	 * @throws Exception
	 */
	private static void SelectionStudentById() throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		Scanner in = new Scanner(System.in);
		System.out.println("������ѧ�ţ�");
		int id = in.nextInt();
		SelectionStudentDao dao = new SelectionStudentDao(con);
		try {
			dao.selectStudentById(con, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con);
		}
	}

	/**
	 * ���ݹ��Ž��н�ʦ��Ϣ��ѯ
	 * 
	 * @throws Exception
	 */
	private static void SelectionTeacherById() throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		Scanner in = new Scanner(System.in);
		System.out.println("�������ʦ���ţ�");
		int id = in.nextInt();
		SelectionTeacherDao dao = new SelectionTeacherDao(con);
		try {
			dao.selectTeacherById(con, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con);
		}

	}

	/**
	 * ��ʾ����ѧ����Ϣ�Լ�������Ϣ
	 * 
	 * @throws Exception
	 */
	private static void SelectionAllStudent() throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		SelectionStudentDao dao = new SelectionStudentDao(con);
		try {
			dao.selectAllStudent();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con);
		}

	}

	/**
	 * ��ʾ���н�ʦ��Ϣ�Լ�������Ϣ
	 * 
	 * @throws Exception
	 */
	private static void SelectionAllTeacher() throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		SelectionTeacherDao dao = new SelectionTeacherDao(con);
		try {
			dao.selectAllTeacher();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con);
		}

	}
	/**
	 * ����id�����ڲ�ѯ��Ϣ
	 * @throws Exception
	 */
	private static void SelectTeacherByIdDate() throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		Scanner in = new Scanner(System.in);
		System.out.println("�������ѯ�����Լ�id");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = in.next();
		Date date = sdf.parse(str);
		java.sql.Date date1 = new java.sql.Date(date.getTime());
		int id=in.nextInt();
		SelectionTeacherDao dao1 = new SelectionTeacherDao(con);
		SelectionStudentDao dao2=new SelectionStudentDao(con);
		System.out.println("��ѯ�����");
		System.out.println("id\t\t����\t�Ա�\t����ʡ��\t����\t�����¶�\t֢״\t�ʱ��\t\t�Ƿ�ȷ��\t");
		try {
			dao2.SelectByDateIdStudent(con, date1, id);
		    dao1.SelectByDateIdTeacher(con, date1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con);
		}
	}
	/**
	 * �������ڲ�ѯѧ���Լ���ʦ������Ϣ
	 * 
	 * @throws Exception
	 */
	private static void SelectionDate() throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		Scanner in = new Scanner(System.in);
		System.out.println("�������ѯ����(YYYY-MM-DD)��");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = in.next();
		Date date = sdf.parse(str);
		java.sql.Date date1 = new java.sql.Date(date.getTime());
		SelectionAllDao dao = new SelectionAllDao(con);
		try {
			dao.selectDate(con, date1);
			dao.selectDateTeacher(con, date1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con);
		}

	}

	/**
	 * �������������ѯѧ���Լ���ʦ������Ϣ
	 * 
	 * @throws Exception
	 */
	private static void SelctionDateBetween() throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		Scanner in = new Scanner(System.in);
		System.out.println("�������ѯ��������(YYYY-MM-DD)��");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String start = in.next();
		String end = in.next();
		Date date = sdf.parse(start);
		Date end_date = sdf.parse(end);
		java.sql.Date date1 = new java.sql.Date(date.getTime());
		java.sql.Date date2 = new java.sql.Date(end_date.getTime());
		SelectionAllDao dao = new SelectionAllDao(con);
		try {
			dao.selectBetweenDateS(con, date1, date2);
			dao.selectBetweenDateT(con, date1, date2);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeCon(con);
		}
	}

	/**
	 * ��ʦÿ��ȷ�����
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	private static void TeacherCheckInfo() throws SQLException, Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		JFrame frame = new JFrame("��״ͼ");
		frame.add(new BarChartTeacher().getChartPanel()); // �������ͼ
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);

	}

	/**
	 * ѧ��ÿ��ȷ�����
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	private static void StudentCheckInfo() throws SQLException, Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		JFrame frame = new JFrame("��״ͼ");
		frame.add(new BarChartStudent().getChartPanel()); // �������ͼ
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);

	}

}
