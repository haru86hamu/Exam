package bean;

public class ClassNum extends School implements java.io.Serializable {
<<<<<<< HEAD
	private String school; //学校コード
	private String ClassNum; //クラス番号
	
	public String getSchool() {
		return school;
	}
	public String getClassNum() {
		return ClassNum;
	}
	
	public void setSchool(String school) {
		this.school= school;
	}
	public void setClassNum(String ClassNum) {
		this.ClassNum = ClassNum;
=======
	private School school; //学校コード
	private String classnum; //クラス番号
	
	public School getSchool() {
		return school;
	}
	public String getClassNum() {
		return classnum;
	}
	
	public void setSchool(School school) {
		this.school= school;
	}
	public void setClassNum(String classnum) {
		this.classnum = classnum;
>>>>>>> branch 'master' of https://github.com/haru86hamu/Exam.git
	}

}
