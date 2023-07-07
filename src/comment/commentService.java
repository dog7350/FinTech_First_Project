package comment;

import java.util.*;

public interface commentService {
	public void cmtCreate();
	public void cmtModify();
	public void cmtDelete();
	public ArrayList<commentDTO> cmtList();
	public commentDTO cmtSearch();
}
