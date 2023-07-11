package board;

import java.util.*;

public interface boardService {
	public void boardCreate(); // 게시판 작성 분기점
	public void boardFileRead(); // 텍스트 파일 읽어오기
	public void boardFileWrite(); // 작성한 텍스트 C드라이브 저장
	public void boardDBSend(boardDTO dto); // 읽어오거나 작성한 게시글 DB 전송
	public void boardContent(); // 게시글 본문
	public void boardModify(); // 게시글 수정
	public void boardDelete(); // 게시글 삭제
	public ArrayList<boardDTO> boardList(); // 게시글 목록
	public boardDTO boardSearch(); // 게시글 검색
	
}
