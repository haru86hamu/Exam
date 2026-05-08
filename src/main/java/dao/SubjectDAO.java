package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDAO extends DAO {

	public List<Subject> search(School keyword) throws Exception {
		List<Subject> list = new ArrayList<>();
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("select * from subject where school_cd = ?");
		st.setString(1, keyword.getCd());
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Subject s = new Subject();
			s.setSchool(keyword);
			s.setCd(rs.getString("cd"));
			s.setName(rs.getString("name"));
			list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	
	public int insert(Subject subject) throws Exception {
		Connection con = getConnection();
		
		
		PreparedStatement st = con.prepareStatement("insert into subject(School_cd,cd,name) values(?,?,?)");
		st.setString(1, subject.getSchool().getCd());
		st.setString(2, subject.getCd());
		st.setString(3,subject.getName());

		int line = st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	
}
