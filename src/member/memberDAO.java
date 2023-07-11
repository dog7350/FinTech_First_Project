package member;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnect;

public class memberDAO {
	DBConnect db;
	Connection con; //DB연결객체
	PreparedStatement ps; //sql명령어 전송 객체
	ResultSet rs; //결과 저장 객체
	
	public memberDAO() {
		db = DBConnect.getInstance();
	}
	
	public int join(memberDTO dto){
		//id,pw,name,addr,phone,email,admin
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, 0)";
		int result =0;
		try {
			ps = db.getConnect().prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getAddr());
			ps.setString(5, dto.getPhone());
			ps.setString(6, dto.getEmail());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String login(String id, String pw) {
		
		String sql = "select id,pw from member where id=? and pw=?";
		try {
			ps=db.getConnect().prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, pw);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				return "로그인 성공!";
			}else {
				return "로그인실패ㅠ";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public int modify(memberDTO d) {
		String sql = "update member set pw=?,name=?,addr=?,phone=?,email=?,admin=0 where id=?";
		int result =0;
		try {
			ps=db.getConnect().prepareStatement(sql);
		
			ps.setString(1, d.getPw());
			ps.setString(2, d.getName());
			ps.setString(3,  d.getAddr());
			ps.setString(4, d.getPhone());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getId());
			
			result= ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public memberDTO search(String id) {
		memberDTO dto = null;
		
		String sql = "select * from member where id like ?";
		try {
			ps=db.getConnect().prepareStatement(sql);
			ps.setString(1, '%' + id + '%');
			rs=ps.executeQuery();
			
			if(rs.next()) {
				dto = new memberDTO(rs.getString("id"),rs.getString("pw"),
						rs.getString("name"),rs.getString("addr"),
						rs.getString("phone"),rs.getString("email"),rs.getInt("admin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public ArrayList<memberDTO> allView() {
		ArrayList<memberDTO> list = new ArrayList<>();
		memberDTO dto = null;
		int result=0;
		
		String sql = "select * from member";
		
		try {
			ps=db.getConnect().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				dto = new memberDTO(rs.getString("id"),rs.getString("pw"),
						rs.getString("name"),rs.getString("addr"),
						rs.getString("phone"),rs.getString("email"),rs.getInt("admin"));
			list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int memberManager(String id) {
		String sql="update member set admin='1' where id=?";
		int result =0;
		try {
			ps=db.getConnect().prepareStatement(sql);
			ps.setString(1, id);
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int memberOut(String id) {
		String sql = "delete from member where id=?";
		int result=0;
		try {
			ps=db.getConnect().prepareStatement(sql);
			ps.setString(1,  id);
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	

	
	
}//class








































































