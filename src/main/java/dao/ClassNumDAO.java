package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ClassNum;

public class ClassNumDAO extends DAO {
	
	public List<ClassNum> get(String keyword) throws Exception {
		Connection con = getConnection();
		List<ClassNum> classlist = new ArrayList<>();
		
		PreparedStatement st = con.prepareStatement("select * from class_num where school_cd like ?");
		st.setString(1,keyword);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			ClassNum classNum = new ClassNum();
			classNum.setClassNum(rs.getString("Class_Num"));
			classlist.add(classNum); 
		}
		
		st.close();
		con.close();
		
		return classlist;
	}
}
