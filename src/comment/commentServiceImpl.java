package comment;


import java.util.ArrayList;
import java.util.Scanner;

import common.myInfo;

public class commentServiceImpl implements commentService {
	private static commentServiceImpl instance = null;
	private commentServiceImpl() {}
	public static commentServiceImpl getInstance() {
		if (instance == null) instance = new commentServiceImpl();
		return instance;
	}

	commentDAO dao = new commentDAO();
	Scanner sc = new Scanner(System.in);
	myInfo info = myInfo.getInstance();

	int result, bno, cno =1;
	String cWriter, cContent;

	@Override		//댓글작성		//게시판번호, 댓글번호, 작성자, 내용
	public void cmtCreate() {

		System.out.print("게시판 번호 입력 : ");
		bno = sc.nextInt();

		int maxnum = dao.cmtMax(bno);

		cWriter = myInfo.getInstance().id; //info.id;
		System.out.print("댓글 내용 입력 : ");
		cContent = sc.next();

		commentDTO dto = new commentDTO(bno, ++maxnum, cWriter, cContent);
		result = dao.cmtCreate(dto);

		if(result == 1)
			System.out.println("댓글이 생성되었습니다.");
		else System.out.println("댓글 생성 실패!!!");
	}

	@Override		// 댓글 수정
	public void cmtModify() {
		System.out.print("게시판 번호 입력 : ");
		bno = sc.nextInt();
		System.out.print("댓글 번호 입력 : ");
		cno = sc.nextInt();

		commentDTO cto = dao.cmtS(bno, cno);
		if (myInfo.getInstance().id.equals(cto.getcWriter()) || myInfo.getInstance().admin == 1) {
			System.out.print("수정할 댓글 내용 입력 : ");
			cContent = sc.next();
			result = dao.cmtModify(bno, cno, cContent);

			if(result == 1)
				System.out.println("댓글이 수정되었습니다.");
			else System.out.println("댓글 수정 실패!!!");
		} else {
			System.out.println("관리자도... 작성자도... 아닙니다...ㅡㅡ");
		}
	}

	@Override		// 댓글 삭제
	public void cmtDelete() {
		System.out.print("게시판 번호 입력 : ");
		bno = sc.nextInt();
		System.out.print("댓글 번호 입력 : ");
		cno = sc.nextInt();

		commentDTO cto = dao.cmtS(bno, cno);
		if (myInfo.getInstance().id.equals(cto.getcWriter()) || myInfo.getInstance().admin == 1) {
			result = dao.cmtDelete(bno, cno);

			if(result == 1)
				System.out.println("댓글이 삭제되었습니다.");
			else System.out.println("댓글 삭제 실패!!!");
		} else {
			System.out.println("관리자도... 작성자도... 아닙니다...ㅡㅡ");
		}
	}

	@Override		// 해당 게시글 댓글 목록
	public ArrayList<commentDTO> cmtList() {
		System.out.print("게시판 번호 입력 : ");
		bno = sc.nextInt();

		ArrayList<commentDTO> list = dao.cmtList(bno);
		System.out.println("===========================================");
		for(commentDTO d : list) {
			System.out.println(d.getCno()+". "+d.getcWriter()+" : "+d.getcContent());
			System.out.println("-------------------------------------------");
		}
		return null;
	}

	@Override		// 댓글 검색 (관리자)
	public commentDTO cmtSearch() {
		//관리자 여부 확인 필요
		if (myInfo.getInstance().admin == 1) {
			System.out.print("작성자 입력 : ");
			cWriter = sc.next();
			ArrayList<commentDTO> list = dao.cmtSearch(cWriter);
			System.out.println("===========================================");
			System.out.println("게시글 번호\t댓글 번호\t 작성자\t댓글 내용");
			for(commentDTO d : list) {
				System.out.println("-------------------------------------------");
				System.out.println(d.getBno()+"\t\t"+d.getCno()+"\t "+d.getcWriter()+"\t"+d.getcContent());
			}
			System.out.println("==========================================="); 
			return null;
		} else {
			System.out.println("관리자가 아닙니다.");
			return null;
		}
	}

}

