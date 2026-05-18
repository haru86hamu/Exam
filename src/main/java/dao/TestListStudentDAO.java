package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.TestListStudent;

public class TestListStudentDAO extends DAO {
	public List<TestListStudent> selectstudent(School keyword, String no) throws Exception {
		Connection con = getConnection();
		SubjectDAO sub = new SubjectDAO();
		List<TestListStudent> stlist = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement st = null;
		
		st = con.prepareStatement("select * from test where school_cd = ? and student_no = ?");
		st.setString(1, keyword.getCd());
		st.setString(2,no);
		
		rs = st.executeQuery();
		
		while (rs.next()) {
			TestListStudent testst = new TestListStudent();
			testst.setSubjectName(sub.getname(rs.getString("subject_cd"), keyword));
			testst.setSubjectCd(rs.getString("subject_cd"));
			testst.setNum(rs.getInt("no"));
			testst.setPoint(rs.getInt("point"));
			stlist.add(testst);
			}
		return stlist;
	}
}
