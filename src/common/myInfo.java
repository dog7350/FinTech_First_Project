package common;


public class myInfo {
	private static myInfo instance = null;
	private myInfo() {}
	
	public static myInfo getInstance() {
		if (instance == null) instance = new myInfo();
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
	
	public String id, pw, name, addr, phone, email;
	public int admin;
}
