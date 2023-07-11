package board;


import java.util.Date;

import oracle.sql.*;

public class boardDTO {
	private int bno, inquiry, report;
	private String bWriter, bTitle, bContent;
	private Date bTime;
	
	public boardDTO() {}
	public boardDTO(int bno, String bWriter, String bTitle, String bContent, Date bTime, int inquiry, int report) {
		this.bno = bno;
		this.bWriter = bWriter;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bTime = bTime;
		this.inquiry = inquiry;
		this.report = report;
	}
	
	public int getBno() { return bno; }
	public void setBno(int bno) { this.bno = bno; }
	
	public int getInquiry() { return inquiry; }
	public void setInquiry(int inquiry) { this.inquiry = inquiry; }
	
	public int getReport() { return report; }
	public void setReport(int report) { this.report = report; }
	
	public String getbWriter() { return bWriter; }
	public void setbWriter(String bWriter) { this.bWriter = bWriter; }
	
	public String getbTitle() { return bTitle; }
	public void setbTitle(String bTitle) { this.bTitle = bTitle; }
	
	public String getbContent() { return bContent; }
	public void setbContent(String bContent) { this.bContent = bContent; }
	
	public Date getbTime() { return bTime; }
	public void setbTime(Date bTime) { this.bTime = bTime; }
}
