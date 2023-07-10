package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import common.DBConnect;
import common.myInfo;

public class boardDAO {
	DBConnect db;
	PreparedStatement ps;
	ResultSet rs;

	public boardDAO() {
		db = DBConnect.getInstance();
	}

	public int insert(boardDTO dto) {
		String sql = "insert into BOARD(b_writer, b_title, b_content, b_time, inquiry, report) values(?, ?, ?, sysdate, 0, 0)";
		int result = 0;
		

		try {
			ps = db.getConnect().prepareStatement(sql);
			ps.setString(1, myInfo.getInstance().id);
			ps.setString(2, dto.getbTitle());
			ps.setString(3, dto.getbContent());
			
			/*
			 * Query: select에서만 Query를 사용한다. 결과값이 ResultSet
			 * Update : select를 제외한 모든 명령어에서 사용한다.
			 */
			result = ps.executeUpdate();
			//			ps.executeQuery();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}
	
	public ArrayList<boardDTO> boardList() {
		String sql = "SELECT * FROM board";
		ArrayList<boardDTO> list = null;
		try {
			ps = db.getConnect().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				boardDTO d = new boardDTO(rs.getInt("BNO"), rs.getString("B_WRITER"),rs.getString("B_TITLE"),rs.getString("B_COMTENT"),
						rs.getDate("B_TIME"),rs.getInt("INQUIRY"),rs.getInt("REPORT"));
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
	public int modify(boardDTO md) {
		String sql = "UPDATE BOARD SET B_TITLE = ?,B_CONTANT = ? where b_writer = ?";
		int result = 0;
		try {
			ps = db.getConnect().prepareStatement(sql);
			ps.setString(1, md.getbTitle());
			ps.setString(2, md.getbContent());
			ps.setString(3, md.getbWriter());
			
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	public int delete(boardDTO dd) {
		String sql = "DELETE FROM BOARD WHERE B_WRITER = ? AND B_TITLE";
		int result = 0;
		try {
			ps = db.getConnect().prepareStatement(sql);
			ps.setString(1, dd.getbWriter());
			ps.setString(2, dd.getbTitle());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boardDTO search(int bno) {
		boardDTO dto = null;
		String sql = "SELECT * FROM BOARD WHERE BNO = '"+bno+"'";
		try {
			ps = db.getConnect().prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new boardDTO(rs.getInt("BNO"), rs.getString("B_WRITER"),rs.getString("B_TITLE"),rs.getString("B_COMTENT"),
						rs.getDate("B_TIME"),rs.getInt("INQUIRY"),rs.getInt("REPORT"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
		
		
		
	}
	
	

}
