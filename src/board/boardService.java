package board;

import java.util.*;

public interface boardService {
	public void boardCreate();
	public void boardModify();
	public void boardDelete();
	public ArrayList<boardDTO> boardList();
	public boardDTO boardSearch();
}
