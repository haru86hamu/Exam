package bean;

public class Student extends School  implements java.io.Serializable {
	private String no; //学生名
	private String name; //コース番号
	private int entYear;
<<<<<<< HEAD
	private String classNum;
	private boolean isAttend;
	private String school;
	
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public int getEntYear() {
		return entYear;
	}
	public String getClassNum() {
		return classNum;
	}
	public boolean getIsAttend() {
		return isAttend;
	}
	public String getSchool() {
		return school;
	}
	
	
	public void setNo(String no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEntYear(int entYear) {
		this.entYear = entYear;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	public void setIsAttend(boolean isAttend) {
		this.isAttend = isAttend;	
	}
	public void setSchool(String school) {
=======
	private ClassNum classNum;
	private boolean isAttend;
	private School school;
	
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public int getEntYear() {
		return entYear;
	}
	public ClassNum getClassNum() {
		return classNum;
	}
	public boolean getIsAttend() {
		return isAttend;
	}
	public School getSchool() {
		return school;
	}
	
	
	public void setNo(String no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEntYear(int entYear) {
		this.entYear = entYear;
	}
	public void setClassNum(ClassNum classnum) {
		this.classNum = classnum;
	}
	public void setIsAttend(boolean isAttend) {
		this.isAttend = isAttend;	
	}
	public void setSchool(School school) {
>>>>>>> branch 'master' of https://github.com/haru86hamu/Exam.git
		this.school= school;
	}



}