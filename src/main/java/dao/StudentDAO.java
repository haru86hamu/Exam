package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class StudentDAO extends DAO {
	public List<Student> search(String keyword, String entYear, String classNum, String attend) throws Exception {
		List<Student> list = new ArrayList<>();
		Connection con = getConnection();
		
		StringBuilder sql = new StringBuilder("select * from students where school_cd = ?");
		List<Object> params = new ArrayList<>();
		params.add(keyword);
		
		if (entYear != null && !entYear.isEmpty()) {
			sql.append(" and ent_year = ?");
			params.add(Integer.parseInt(entYear));
		}
		
		if (classNum != null && !classNum.isEmpty()) {
			sql.append(" and class_num = ?");
			params.add(classNum);
		}
		
		if (attend != null) {
			sql.append(" and is_attend = ?");
			params.add(true);
		}
		
		PreparedStatement st = con.prepareStatement(sql.toString());
		for (int i = 0; i < params.size(); i++) {
			Object param = params.get(i);
			if (param instanceof Integer) {
				st.setInt(i + 1, (Integer) param);
			} else if (param instanceof Boolean) {
				st.setBoolean(i + 1, (Boolean) param);
			} else {
				st.setString(i + 1, String.valueOf(param));
			}
		}
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Student p = new Student();
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setEntYear(rs.getInt("ent_Year"));
			p.setClassNum(rs.getString("class_Num"));
			p.setIsAttend(rs.getBoolean("is_Attend"));
			//p.setSchool(rs.getString("school_cd"));
			list.add(p);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	
	public List<Student> selectNo(String keyword,String no) throws Exception {
		List<Student> stlist = new ArrayList<>();
		Connection con = getConnection(); 
		
		PreparedStatement st = con.prepareStatement("select * from students where school_cd = ? and no = ?");
		st.setString(1,keyword);
		st.setString(2, no);
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Student s = new Student();
			s.setNo(rs.getString("no"));
			s.setName(rs.getString("name"));
			s.setEntYear(rs.getInt("ent_Year"));
			s.setClassNum(rs.getString("class_Num"));
			s.setIsAttend(rs.getBoolean("is_Attend"));
			stlist.add(s);
		}
		
		st.close();
		con.close();
		
		return stlist;
	}
	
	public int searchNo(String no) throws Exception {
		List<Student> Nolist = new ArrayList<>();
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("select * from students where no = ?");
		st.setString(1,no);

		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			Student s = new Student();
			s.setNo(rs.getString("no"));
			Nolist.add(s);
		}
		int count = Nolist.size();

		return count;
	}
	

	public int insert(Student student) throws Exception {
		Connection con = getConnection();
		
		
		PreparedStatement st = con.prepareStatement("insert into students(no,name,ent_year,class_num,is_attend,school_cd) values(?,?,?,?,?,?)");
		st.setString(1, student.getNo());
		st.setString(2, student.getName());
		st.setInt(3, student.getEntYear());
		st.setString(4, student.getClassNum());
		st.setBoolean(5, student.getIsAttend());
		st.setString(6, student.getSchool());
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}

	public int update(Student student) throws Exception{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("update students set name = ?,class_num = ?,is_attend = ? where no = ?");
		st.setString(1, student.getName());
		st.setString(2, student.getClassNum());
		st.setBoolean(3, student.getIsAttend());
		st.setString(4, student.getNo());
		int line = st.executeUpdate();

		st.close();
		con.close();
		
		return line;
	}

}
