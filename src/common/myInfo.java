package common;

public class myInfo {
	private static myInfo instance = null;
	private myInfo() {}
	
	public static myInfo getInstance() {
		if (instance == null) instance = new myInfo();
		return instance;
	}
	
	public String id, pw, name, addr, phone, eamil;
	public int admin;
}
