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
		ArrayList<boardDTO> list = new ArrayList<>();
		try {
			ps = db.getConnect().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				boardDTO d = new boardDTO(rs.getInt("bno"), rs.getString("b_writer"),rs.getString("b_title"),rs.getString("b_content"),
						rs.getDate("b_time"),rs.getInt("inquiry"),rs.getInt("report"));
				
				list.add(d);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
	public int modify(boardDTO md) {
		String sql = "UPDATE BOARD SET B_TITLE = ?,B_CONTANT = ?";
		int result = 0;
		try {
			ps = db.getConnect().prepareStatement(sql);
			ps.setString(1, md.getbTitle());
			ps.setString(2, md.getbContent());
			
			
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	public int delete(boardDTO dd) {
		String sql = "DELETE FROM board WHERE bno = ?";
		int result = 0;
		try {
			ps = db.getConnect().prepareStatement(sql);
			ps.setInt(1, dd.getBno());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boardDTO search(int bno) {
		boardDTO dto = null;
		String sql = "SELECT * FROM BOARD WHERE bno = '"+bno+"'";
		try {
			ps = db.getConnect().prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new boardDTO(rs.getInt("bno"), rs.getString("b_writer"),rs.getString("b_title"),rs.getString("b_content"),
						rs.getDate("b_time"),rs.getInt("inquiry"),rs.getInt("report"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
		
		
		
	}
	public ArrayList<boardDTO> search2(String b_title) {
		ArrayList<boardDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM board WHERE b_title LIKE '%"+b_title+"%'";
		try {
			ps = db.getConnect().prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				boardDTO dto = new boardDTO(rs.getInt("bno"), rs.getString("b_writer"),rs.getString("b_title"),rs.getString("b_content"),
						rs.getDate("b_time"),rs.getInt("inquiry"),rs.getInt("report"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
		
		
	}
	
	

}
