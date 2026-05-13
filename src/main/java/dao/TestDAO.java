package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.Test;

public class TestDAO extends DAO {
	
	@SuppressWarnings("unused")
	public List<Test> get(int no) throws Exception {
		Connection con  = getConnection();
		List<Test> No = new ArrayList<>();
		
		PreparedStatement st = con.prepareStatement("select * from test where Student_no = ?");
		st.setInt(1,no);

		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			Test t = new Test();
			Student student = new Student();
			student.setCd(rs.getString("no"));
			t.setSchool(student);
			No.add(t);
		}
		
		
		if (No != null) {
			
			return No;
		}
		
		return No;
		
	}
	
	public boolean insert(List<Test> test ,String keyword) throws Exception {
		Connection con  = getConnection();
		con.setAutoCommit(false);
		
		for (Test t : test) {
			PreparedStatement st = con.prepareStatement("insert into test(student_no,subject_cd,school_cd,no,point,class_num) values(?,?,?,?,?,?)");
			
			st.setString(1, t.getStudent().getNo());
			st.setString(2, t.getSubject().getCd());
			st.setString(3, t.getSchool().getCd());
			st.setInt(4, t.getNo());
			st.setInt(5,t.getPoint());
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
}
