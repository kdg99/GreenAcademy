package kr.ac.college.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.college.bean.LecBean;
import kr.ac.college.bean.RegBean;
import kr.ac.college.bean.StdBean;
import kr.ac.college.config.DBCP;
import kr.ac.college.config.Sql;

public class CollegeDAO {
	private static CollegeDAO instance = new CollegeDAO();
	public static CollegeDAO getInstance() {
		return instance;
	}
	private CollegeDAO() {};
	
	//CRUD 구현
	//Lecture
	public List<LecBean> selectLectures() {
		List<LecBean> lectures = null;
		try {
			lectures = new ArrayList<>();
			Connection conn = DBCP.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_LECTURES);
			while(rs.next()) {
				LecBean lb = new LecBean();	
				lb.setLecNo(rs.getInt(1));
				lb.setLecName(rs.getString(2));
				lb.setLecCredit(rs.getInt(3));
				lb.setLecTime(rs.getInt(4));
				lb.setLecClass(rs.getString(5));
				
				lectures.add(lb);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lectures;
	}
	
	public int insertLecture(LecBean lb) {
		int result = 0;
		try {
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_LECTURE);
			psmt.setInt(1, lb.getLecNo());
			psmt.setString(2, lb.getLecName());
			psmt.setInt(3, lb.getLecCredit());
			psmt.setInt(4, lb.getLecTime());
			psmt.setString(5, lb.getLecClass());
			
			result = psmt.executeUpdate();
			System.out.println(result);
			psmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//
	
	//Register
	public List<RegBean> selectRegisters() {
		List<RegBean> registers = null;
		try {
			registers = new ArrayList<>();
			Connection conn = DBCP.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_REGISTERS);
			while(rs.next()) {
				RegBean rb = new RegBean();	
				rb.setRegStdNo(rs.getString(1));
				rb.setRegLecNo(rs.getString(2));
				rb.setRegMidScore(rs.getString(3));
				rb.setRegFinalScore(rs.getString(4));
				rb.setRegTotalScore(rs.getString(5));
				rb.setRegGrade(rs.getString(6));
				rb.setRegStdName(rs.getString(7));
				rb.setRegLecName(rs.getString(8));
				
				registers.add(rb);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return registers;
	}
	
	public int insertRegister(RegBean rb) {
		int result = 0;
		try {
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_REGISTER);
			psmt.setString(1, rb.getRegStdNo());
			psmt.setString(2, rb.getRegLecNo());
			
			result = psmt.executeUpdate();
			System.out.println(result);
			psmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//
	
	//Student
	public List<StdBean> selectStudents() {
		List<StdBean> students = null;
		try {
			students = new ArrayList<>();
			Connection conn = DBCP.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_STUDENTS);
			while(rs.next()) {
				StdBean sb = new StdBean();	
				sb.setStdNo(rs.getString(1));
				sb.setStdName(rs.getString(2));
				sb.setStdHp(rs.getString(3));
				sb.setStdYear(rs.getInt(4));
				sb.setStdAddress(rs.getString(5));
				
				students.add(sb);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return students;
	}
	
	public int insertStudent(StdBean sb) {
		int result = 0;
		try {
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_STUDENT);
			psmt.setString(1, sb.getStdNo());
			psmt.setString(2, sb.getStdName());
			psmt.setString(3, sb.getStdHp());
			psmt.setInt(4, sb.getStdYear());
			psmt.setString(5, sb.getStdAddress());
			
			result = psmt.executeUpdate();
			System.out.println(result);
			psmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//
	
}
