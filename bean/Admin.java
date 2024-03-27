package bean;

public class Admin {
	private String email;
	private String passward;
	
	public Admin() {
		this.email = null;
		this.passward = null;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassward() {
		return passward;
	}
	
	public void setPassward(String passward) {
		this.passward = passward;
	}
}
