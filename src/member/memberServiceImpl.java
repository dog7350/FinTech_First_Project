package member;

import java.util.ArrayList;

public class memberServiceImpl implements memberService {
	private static memberServiceImpl instance = null;
	private memberServiceImpl() {}
	public static memberServiceImpl getInstance() {
		if (instance == null) instance = new memberServiceImpl();
		return instance;
	}

	@Override
	public void memberJoin() {
		
	}

	@Override
	public void memberLogin() {
		
	}

	@Override
	public void memberModify() {
		
	}

	@Override
	public void memberExit() {
		
	}

	@Override
	public void memberOut() {
		
	}

	@Override
	public void memberManager() {
		
	}

	@Override
	public ArrayList<memberDTO> memberList() {
		return null;
	}

	@Override
	public memberDTO memberSearch() {
		return null;
	}

}
