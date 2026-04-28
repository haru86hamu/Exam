package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;

public class TeacherDAO extends DAO {
	public Teacher login(String id,String password) throws Exception {
		Teacher teacher = null;
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("select * from teacher where id=? and password=?");
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			teacher= new Teacher();
			teacher.setId(rs.getString("id"));
			teacher.setPassword(rs.getString("password"));
			teacher.setName(rs.getString("name"));
			teacher.setSchool(rs.getString("school_cd"));
		}
		
		st.close();
		con.close();
		
		return teacher;
	}
	
/*
	public int insert(Customer customer) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("insert into customer(login,password) values(?,?)");
		st.setString(1, customer.getLogin());
		st.setString(2, customer.getPassword());
		int line = st.executeUpdate();
		
		st.close();
		con.close();q
		return line;
	}
*/	


}
