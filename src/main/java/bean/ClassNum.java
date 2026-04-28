package bean;

public class ClassNum extends School implements java.io.Serializable {
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
	}

}
