package dao;
<<<<<<< HEAD
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
		
		PreparedStatement st = con.prepareStatement("select * from subject where school_cd=?");
		st.setString(1, keyword);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Subject s= new Subject();
			s.setCd(rs.getString("cd"));
			s.setName(rs.getString("name"));
			list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	// 指定した科目コードと学校コードに一致する科目を取得（重複チェック用）
	public Subject get(String cd, String schoolCd) throws Exception {
		Subject subject = null;
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
			"select * from subject where cd = ? and school_cd = ?"
		);
		st.setString(1, cd);
		st.setString(2, schoolCd);
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

	// 科目データをデータベースに登録
	public int insert(Subject subject) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
			"insert into subject (cd, name, school_cd) values (?, ?, ?)"
		);
		st.setString(1, subject.getCd());
		st.setString(2, subject.getName());
		st.setString(3, subject.getSchool());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
	// 科目データを更新
	public int update(Subject subject) throws Exception {
		Connection con = getConnection();

		// 指定した学校の、指定した科目コードの「名前」を更新する
		PreparedStatement st = con.prepareStatement(
			"update subject set name = ? where cd = ? and school_cd = ?"
		);
		st.setString(1, subject.getName());
		st.setString(2, subject.getCd());
		st.setString(3, subject.getSchool());

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
		st.setString(2, subject.getSchool());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}


		
	}

=======

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
>>>>>>> branch 'master' of https://github.com/haru86hamu/Exam.git
