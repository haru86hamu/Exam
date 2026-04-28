package bean;

public class School implements java.io.Serializable {
	private String cd; //学生名
	private String name; //コース番号
	
	public String getCd() {
		return cd;
	}
	public String getName() {
		return name;
	}
	
	public void setCd(String cd) {
		this.cd= cd;
	}
	public void setName(String name) {
		this.name = name;
	}


}