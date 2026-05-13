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

	public Subject get(String cd, School school) throws Exception {
		Subject subject = null;
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
			"select * from subject where cd = ? and school_cd = ?"
		);
		st.setString(1, cd);
		st.setString(2, school.getCd());
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			subject = new Subject();
			subject.setCd(rs.getString("cd"));
			subject.setName(rs.getString("name"));
		}

		st.close();
		con.close();

		return subject;
	}
	
	public String getname(String cd, School school) throws Exception {
		String name = null;
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
			"select name from subject where cd = ? and school_cd = ?"
		);
		st.setString(1, cd);
		st.setString(2, school.getCd());
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			name = rs.getString("name");
		}

		st.close();
		con.close();

		return name;
	}
	

	


	public int update(Subject subject) throws Exception {
		Connection con = getConnection();

		
		PreparedStatement st = con.prepareStatement(
			"update subject set name = ? where cd = ? and school_cd = ?"
		);
		st.setString(1, subject.getName());
		st.setString(2, subject.getCd());
		st.setString(3, subject.getSchool().getCd());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	public int delete(Subject subject) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
			"delete from subject where cd = ? and school_cd = ?"
		);
		st.setString(1, subject.getCd());
		st.setString(2, subject.getSchool().getCd());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}


		
}

	
