package member;


import java.util.ArrayList;
import java.util.Scanner;

import common.myInfo;

public class memberServiceImpl implements memberService {
	private static memberServiceImpl instance = null;
	private memberServiceImpl() {}
	public static memberServiceImpl getInstance() {
		if (instance == null) instance = new memberServiceImpl();
		return instance;
	}
	
	memberDAO dao = new memberDAO();
	memberDTO dto;
	Scanner sc = new Scanner(System.in);
	String id,pw, name, addr, email, phone;
		

	@Override //회원가입(id,pw, 이름, 주소, 전화번호, email,관리자여부)
	public void memberJoin() {
		dto = new memberDTO();
		System.out.println(" --- 회원가입 ---");
		System.out.println("ID입력>>");
		id = sc.next();
		dto.setId(id);
		System.out.println("PW입력>>");
		pw = sc.next();
		dto.setPw(pw);
		System.out.println("이름입력>>");
		name = sc.next();
		dto.setName(name);
		System.out.println("주소입력>>");
		addr=sc.next();
		dto.setAddr(addr);
		System.out.println("전화번호 입력>>");
		phone = sc.next();
		dto.setPhone(phone);
		System.out.println("Email입력>>");
		email = sc.next();
		dto.setEmail(email);
		//System.out.println("관리자번호);
		
		int result = dao.join(dto);
		
		if(result != 0)
			System.out.println("회원가입이 완료되었습니다.");
	}
		
	@Override //로그인
	public void memberLogin() {
		System.out.println("ID입력>>");
		id=sc.next();
		System.out.println("PW입력>>");
		pw=sc.next();
		
		String result = dao.login(id, pw);
		System.out.println(result);
		
		memberDTO dto = dao.search(id);
		myInfo.getInstance().setInstance(dto.getId(), dto.getPw(), dto.getName(), dto.getAddr(), dto.getPhone(), dto.getEmail(), dto.getAdmin());
	}

	@Override //정보수정
	public void memberModify() {
		memberDTO d = search(myInfo.getInstance().id);
		
		System.out.println("정보수정 PW입력>>");
		pw=sc.next();
		System.out.println("정보수정 이름입력>>");
		name=sc.next();
		System.out.println("정보수정 주소입력>>");
		addr=sc.next();
		System.out.println("정보수정 전화번호입력>>");
		phone=sc.next();
		System.out.println("정보수정 이메일입력>>");
		email=sc.next();
		System.out.println("관리자여부(일반회원일 경우 0입력/관리자인경우 1입력)>>");
		
		d = new memberDTO(id,pw,name,addr,phone,email,d.getAdmin());
		int result = modify(d);
		
		if(result==1) 
			System.out.println("정보수정 완료.");
		else
			System.out.println("정보수정 실패.");
	}

	@Override //회원탈퇴
	public void memberExit() {
		int result=dao.memberOut(myInfo.getInstance().id);
		if(result==1)
			System.out.println("탈퇴되었습니다.");
		else
			System.out.println("탈퇴실패");
	}

	@Override // 관리자 : 회원 강퇴
	public void memberOut() {
		System.out.println("강퇴할 ID입력>>");
		id=sc.next();
		
		int result = dao.memberOut(id);
		if(result==1)
			System.out.println("강퇴되었습니다.");
		else
			System.out.println("강퇴실패");
	}

	@Override// 관리자 : 관리자 임명
	public void memberManager() {
		System.out.println("관리자로 임명할 ID입력>>");
		id=sc.next();
		
		int result = dao.memberManager(id);
		if(result==1)
			System.out.println("관리자로 임명되었습니다.");
		else
			System.out.println("임명실패");
	}

	@Override // // 전체 회원 목록
	public ArrayList<memberDTO> memberList() {
		ArrayList<memberDTO> list =	dao.allView();
		
		for(int i=0; i<list.size();i++) {
			System.out.println("\n=============");
			System.out.println("ID: "+list.get(i).getId());
			System.out.println("PW: "+list.get(i).getPw());
			System.out.println("이름: "+list.get(i).getName());
			System.out.println("주소: "+list.get(i).getAddr());
			System.out.println("전화번호: "+list.get(i).getPhone());
			System.out.println("이메일: "+list.get(i).getEmail());
			System.out.println("관리자여부(0:일반회원, 1:관리자): "+list.get(i).getAdmin());
		}
		
		return null;
	}

	@Override // 회원 검색
	public memberDTO memberSearch() {
		System.out.println("검색할 ID입력>>");
		id=sc.next();
		
		dto = new memberDTO();
		dto =dao.search(id);
	
		System.out.println("ID: "+dto.getId());
		System.out.println("PW: "+dto.getPw());
		System.out.println("이름: "+dto.getName());
		System.out.println("주소: "+dto.getAddr());
		System.out.println("전화번호: "+dto.getPhone());
		System.out.println("이메일: "+dto.getEmail());
		System.out.println("관리자여부(0:일반사용자, 1:관리자): "+dto.getAdmin());
		
		return dto;
	}
	
	public memberDTO search(String id) {
		memberDTO dto = dao.search(id);
		return dto;
	}
	
	public int modify(memberDTO d) {
		return dao.modify(d);
	}

}//class
