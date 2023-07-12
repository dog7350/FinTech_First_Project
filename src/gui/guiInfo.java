package gui;

public class guiInfo {
	private static guiInfo instance = null;
	private guiInfo() {}
	
	public static guiInfo getInstance() {
		if (instance == null) instance = new guiInfo();
		return instance;
	}
	public void setInstance(String id, String pw, String name, String addr, String phone, String email, int admin) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.email = email;
		this.admin = admin;
	}
	public void resetInstance() {
		instance = null;
	}
	
	public String id, pw, name, addr, phone, email;
	public int admin;
}
