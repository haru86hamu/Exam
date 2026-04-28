package bean;

public class User implements java.io.Serializable {
	private boolean isAuthenticated;
	
	public boolean getIsAuthenticated() {
		return isAuthenticated;
	}
	
	public void setIsAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
}
