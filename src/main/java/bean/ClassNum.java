package bean;

public class ClassNum extends School implements java.io.Serializable {

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
	}

}