package comment;


public class commentDTO {
	private int bno, cno;
	private String cWriter, cContent;
	
	public commentDTO() {}
	public commentDTO(int bno, int cno, String cWriter, String cContent) {
		this.bno = bno;
		this.cno = cno;
		this.cWriter = cWriter;
		this.cContent = cContent;
	}
	
	public int getBno() { return bno; }
	public void setBno(int bno) { this.bno = bno; }
	
	public int getCno() { return cno; }
	public void setCno(int cno) { this.cno = cno; }
	
	public String getcWriter() { return cWriter; }
	public void setcWriter(String cWriter) { this.cWriter = cWriter; }
	
	public String getcContent() { return cContent; }
	public void setcContent(String cContent) { this.cContent = cContent; }
}
