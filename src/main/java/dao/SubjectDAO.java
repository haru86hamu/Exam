package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class SubjectDAO extends DAO {

	public List<Subject> search(String keyword) throws Exception {
		List<Subject> list = new ArrayList<>();
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("select * from subject where school_cd = ?");
		st.setString(1, keyword);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Subject s = new Subject();
			s.setCd(rs.getString("cd"));
			s.setName(rs.getString("name"));
			list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}

	
}
