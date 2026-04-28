package bean;

public class Subject extends School implements java.io.Serializable {
	private School school; //学生名
	private String cd; //コース番号
	private String name;
	
	public School getSchool() {
		return school;
	}
	public String getCd() {
		return cd;
	}
	public String getName() {
		return name;
	}
	
	public void setSchool(School school) {
		this.school= school;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public void setName(String name) {
		this.name = name;
	}

}