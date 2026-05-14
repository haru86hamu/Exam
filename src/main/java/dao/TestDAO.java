package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.Test;

public class TestDAO extends DAO {

	public List<Test> get(String studentno, String subject, int count) throws Exception {
		Connection con = getConnection();
		List<Test> tests = new ArrayList<>();

		PreparedStatement st = con.prepareStatement("select * from test where student_no = ? and subject_cd = ? and no = ?");
		st.setString(1, studentno);
		st.setString(2, subject);
		st.setInt(3, count);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Test t = new Test();
			Student student = new Student();
			student.setNo(rs.getString("student_no"));
			t.setStudent(student);
			t.setPoint(rs.getInt("point"));
			tests.add(t);
		}

		rs.close();
		st.close();
		con.close();

		return tests;
	}

	public boolean insert(List<Test> test) throws Exception {
		Connection con  = getConnection();
		con.setAutoCommit(false);

		for (Test t : test) {
			PreparedStatement st = con.prepareStatement("insert into test(student_no,subject_cd,school_cd,no,point,class_num) values(?,?,?,?,?,?)");

			st.setString(1, t.getStudent().getNo());
			st.setString(2, t.getSubject().getCd());
			st.setString(3, t.getSchool().getCd());
			st.setInt(4, t.getNo());
			st.setInt(5, t.getPoint());
			st.setString(6, t.getClassNum().getClassNum());
			int line = st.executeUpdate();

			st.close();

			if (line != 1) {
				con.rollback();
				con.setAutoCommit(true);
				con.close();

				return false;
			}
		}

		con.commit();
		con.setAutoCommit(true);
		con.close();

		return true;
	}

	public boolean update(List<Test> list) throws Exception {
		Connection con  = getConnection();
		con.setAutoCommit(false);
		
		for (Test l : list) {
			PreparedStatement st = con.prepareStatement("update test set point = ? where school_cd = ? and student_no = ? and subject_cd = ? and no = ?");

			st.setInt(1, l.getPoint());
			st.setString(2, l.getSchool().getCd());
			st.setString(3, l.getStudent().getNo());
			st.setString(4, l.getSubject().getCd());
			st.setInt(5, l.getNo());
			int line = st.executeUpdate();

			st.close();

			if (line != 1) {
				con.rollback();
				con.setAutoCommit(true);
				con.close();

				return false;
			}
		}

		con.commit();
		con.setAutoCommit(true);
		con.close();

		return true;
	}
}