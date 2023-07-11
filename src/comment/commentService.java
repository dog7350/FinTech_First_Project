package comment;


import java.util.*;

public interface commentService {
	public void cmtCreate(); // 댓글 작성
	public void cmtModify(); // 댓글 수정
	public void cmtDelete(); // 댓글 삭제
	public ArrayList<commentDTO> cmtList(); // 해당 게시글 댓글 목록
	public commentDTO cmtSearch(); // 댓글 검색 (관리자)
}
