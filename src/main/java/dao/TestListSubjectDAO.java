package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import bean.ClassNum;
import bean.School;
import bean.Student;
import bean.TestListSubject;

public class TestListSubjectDAO extends DAO {

	public List<TestListSubject> selectsubject(School keyword, int entYear, String classnum, String subject, List<Student> studentno) throws Exception {
		Connection con = getConnection();
		List<TestListSubject> tests = new ArrayList<>();
		Map<String, TestListSubject> testMap = new LinkedHashMap<>();
		StudentDAO dao = new StudentDAO();
		ResultSet rs = null;
		PreparedStatement st = null;

		for (Student s : studentno) {
			st = con.prepareStatement("select * from test where school_cd = ? and student_no = ? and class_num = ? and subject_cd = ?");
			st.setString(1, keyword.getCd());
			st.setString(2, s.getNo());
			st.setString(3, classnum);
			st.setString(4, subject);

			rs = st.executeQuery();

			while (rs.next()) {
				String studentNo = rs.getString("student_no");
				TestListSubject t = testMap.get(studentNo);

				if (t == null) {
					t = new TestListSubject();
					ClassNum class_num = new ClassNum();
					Map<Integer, Integer> pointMap = new HashMap<>();

					t.setEntYear(entYear);
					class_num.setClassNum(rs.getString("class_num"));
					t.setClassNum(class_num);
					t.setStudentNo(studentNo);
					t.setStudentName(dao.searchName(keyword, studentNo));
					t.setPoints(pointMap);

					testMap.put(studentNo, t);
				}

				t.getPoints().put(rs.getInt("no"), rs.getInt("point"));
			}

			rs.close();
			st.close();
		}

		tests.addAll(testMap.values());
		con.close();

		return tests;
	}

	

}
