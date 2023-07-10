package common;

import java.util.*;

import board.boardServiceImpl;
import comment.commentServiceImpl;
import gui.guiServiceImpl;
import member.memberServiceImpl;

public class controller {
	Scanner sc = new Scanner(System.in);
	memberServiceImpl member = memberServiceImpl.getInstance();
	boardServiceImpl board = boardServiceImpl.getInstance();
	commentServiceImpl comment = commentServiceImpl.getInstance();
	
	public void guiStart() {
		guiServiceImpl gui = new guiServiceImpl();
		gui.run();
	}
	
	public void cliStart() {
		boolean flag = true;
		
		while (flag) {
			screen.clear();
			System.out.print("member : 회원\nboard : 게시판\ncomment : 댓글\nadmin : 관리자 옵션\nreturn : 돌아가기\n명령어 입력\n>> ");
			
			switch (sc.next()) {
				case "member" :
					memberOpt();
					break;
				case "board" :
					boardOpt();
					break;
				case "comment" :
					commentOpt();
					break;
				case "admin" :
					adminOpt();
					break;
				case "return" :
					flag = false;
					break;
			}
		}
	}
	
	void memberOpt() {
		boolean flag = true;
		
		while (flag) {
			//screen.clear();
			System.out.print("join : 회원가입\nlogin : 로그인\nmodify : 정보 수정\nexit : 회원 탈퇴\nreturn : 돌아가기\n명령어 입력\n>> ");
			switch (sc.next()) {
				case "join" :
					member.memberJoin();
					break;
				case "login" :
					member.memberLogin();
					break;
				case "modify" :
					member.memberModify();
					break;
				case "exit" :
					member.memberExit();
					break;
				case "return" :
					flag = false;
					break;
			}
		}
	}
	
	void boardOpt() {
		boolean flag = true;
		
		while (flag) {
			screen.clear();
			System.out.print("create : 게시판 작성\nmodify : 게시판 수정\ndelete : 게시판 삭제\nlist : 게시판 불러오기\nsearch : 게시판 검색\nreturn : 돌아가기\n명령어 입력\n>> ");
			switch (sc.next()) {
				case "create" :
					board.boardCreate();
					break;
				case "modify" :
					board.boardModify();
					break;
				case "delete" :
					board.boardDelete();
					break;
				case "list" :
					board.boardList();
					break;
				case "search" :
					board.boardSearch();
					break;
				case "return" :
					flag = false;
					break;
			}
		}
	}
	
	void commentOpt() {
		boolean flag = true;
		
		while (flag) {
			screen.clear();
			System.out.print("create : 댓글 작성\nmodify : 댓글 수정\ndelete : 댓글 삭제\nlist : 댓글 불러오기\nsearch : 댓글 검색\nreturn : 돌아가기\n명령어 입력\n>> ");
			switch (sc.next()) {
				case "create" :
					comment.cmtCreate();
					break;
				case "modify" :
					comment.cmtModify();
					break;
				case "delete" :
					comment.cmtDelete();
					break;
				case "list" :
					comment.cmtList();
					break;
				case "search" :
					comment.cmtSearch();
					break;
				case "return" :
					flag = false;
					break;
			}
		}
	}
	
	void adminOpt() {
		boolean flag = true;
		
		while (flag) {
			screen.clear();
			System.out.print("out : 회원 강퇴\nmanager : 관리자 임명\nmemberL : 전체 회원 조회\nmemberS : 회원 검색\nboardD : 게시판 삭제\ncommentD : 댓글 삭제\nreturn : 돌아가기\n명령어 입력\n>> ");
			switch (sc.next()) {
				case "out" :
					member.memberOut();
					break;
				case "manager" :
					member.memberManager();
					break;
				case "memberL":
					member.memberList();
					break;
				case "memberS":
					member.memberSearch();
					break;
				case "boardD" :
					board.boardDelete();
					break;
				case "commentD" :
					comment.cmtDelete();
					break;
				case "return" :
					flag = false;
					break;
			}
		}
	}
}
