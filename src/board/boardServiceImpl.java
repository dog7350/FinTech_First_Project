package board;

import java.util.ArrayList;

public class boardServiceImpl implements boardService {
	private static boardServiceImpl instance = null;
	private boardServiceImpl() {}
	public static boardServiceImpl getInstance() {
		if (instance == null) instance = new boardServiceImpl();
		return instance;
	}
	
	@Override
	public void boardCreate() {
		
	}
	
	public void boardFileRead() {
		
	}
	
	public void boardFileWrite() {
		
	}
	
	public void boardDBSend() {
		
	}
	
	@Override
	public void boardModify() {
		
	}
	
	@Override
	public void boardDelete() {
		
	}
	
	@Override
	public ArrayList<boardDTO> boardList() {
		return null;
	}
	
	@Override
	public boardDTO boardSearch() {
		
		return null;
	}

	

}
