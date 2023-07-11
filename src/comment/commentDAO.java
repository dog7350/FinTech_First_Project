package comment;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnect;

public class commentDAO {
	DBConnect db;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public commentDAO() {
		db = DBConnect.getInstance();
	}
	
	int result = 0;

	public int cmtCreate(commentDTO dto) {	//댓글 작성
		String sql = "insert into cmt values(?, ?, ?, ?)";
		try {
			ps = db.getConnect().prepareStatement(sql);
			ps.setInt(1, dto.getBno());
			ps.setInt(2, dto.getCno());
			ps.setString(3, dto.getcWriter());
			ps.setString(4, dto.getcContent());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int cmtModify(int bno, int cno, String cContent) {	//댓글 수정
		String sql = "update cmt set C_CONTENT =? where bno=? and cno=?";
		try {
			ps = db.getConnect().prepareStatement(sql);
			ps.setString(1, cContent);
			ps.setInt(2, bno);
			ps.setInt(3, cno);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int cmtDelete(int bno, int cno) {	//댓글 삭제
		String sql = "delete from cmt where bno =? and cno=?";
		try {
			ps = db.getConnect().prepareStatement(sql);
			ps.setInt(1, bno);
			ps.setInt(2, cno);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<commentDTO> cmtList(int bno) {		// 해당 게시글 댓글 목록
		ArrayList<commentDTO> list = new ArrayList<>();
		String sql = "select * from cmt where bno = ?";
		try {
			ps = db.getConnect().prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			while(rs.next()) {
				commentDTO dto = new commentDTO();
				dto.setBno(rs.getInt("BNO"));
				dto.setCno(rs.getInt("CNO"));
				dto.setcWriter(rs.getString("C_WRITER"));
				dto.setcContent(rs.getString("C_CONTENT"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<commentDTO> cmtSearch(String cWriter) {	// 댓글 검색 (관리자)
		ArrayList<commentDTO> list = new ArrayList<>();
		String sql = "select * from cmt where c_Writer = ? order by cno asc";
		try {
			ps = db.getConnect().prepareStatement(sql);
			ps.setString(1, cWriter);
			rs = ps.executeQuery();
			while(rs.next()) {
				commentDTO dto = new commentDTO();
				dto.setBno(rs.getInt("BNO"));
				dto.setCno(rs.getInt("CNO"));
				dto.setcWriter(rs.getString("C_WRITER"));
				dto.setcContent(rs.getString("C_CONTENT"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int cmtMax(int bno) {
		int num = 0;
		String sql = "SELECT max(cno) FROM cmt WHERE bno=" + bno;
		try {
			ps = db.getConnect().prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) num = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}



}
