package comment;

import java.util.ArrayList;

public class commentServiceImpl implements commentService {
	private static commentServiceImpl instance = null;
	private commentServiceImpl() {}
	public static commentServiceImpl getInstance() {
		if (instance == null) instance = new commentServiceImpl();
		return instance;
	}

	@Override
	public void cmtCreate() {
		
	}

	@Override
	public void cmtModify() {
		
	}

	@Override
	public void cmtDelete() {
		
	}

	@Override
	public ArrayList<commentDTO> cmtList() {
		return null;
	}

	@Override
	public commentDTO cmtSearch() {
		return null;
	}

}
