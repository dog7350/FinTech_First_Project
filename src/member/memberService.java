package member;

import java.util.*;

public interface memberService {
	public void memberJoin(); // 회원가입
	public void memberLogin(); // 로그인
	public void memberModify(); // 정보 수정
	public void memberExit(); // 탈퇴
	public void memberOut(); // 관리자 : 회원 강퇴
	public void memberManager(); // 관리자 : 관리자 임명
	public ArrayList<memberDTO> memberList(); // 전체 회원 목록
	public memberDTO memberSearch(); // 회원 검색
}
