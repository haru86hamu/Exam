package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ClassNum;
import bean.School;

public class ClassNumDAO extends DAO {
	
	public List<ClassNum> get(School keyword) throws Exception {
		Connection con = getConnection();
		List<ClassNum> classlist = new ArrayList<>();
		
		PreparedStatement st = con.prepareStatement("select * from class_num where school_cd like ?");
		st.setString(1, keyword.getCd());
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			ClassNum classNum = new ClassNum();
			classNum.setSchool(keyword);
			classNum.setClassNum(rs.getString("Class_Num"));
			classlist.add(classNum); 
		}
		
		st.close();
		con.close();
		
		return classlist;
	}
}
