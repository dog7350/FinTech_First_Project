package gui;

import java.awt.*;
import javax.swing.*;

public class guiServiceImpl extends Thread implements guiService {
	guiBtnFunction btnFunc = guiBtnFunction.getInstance();
	guiFrame gui = null;
	
	public void run() {
		mainDisplay();
	}

	@Override
	public void mainDisplay() {
		gui = guiFrame.getInstance();
		gui.getCon().removeAll();
		JButton memberBtn = new JButton("회원 관리");
		memberBtn.addActionListener(btnFunc.getInstance().mainMemberBtn);
		JButton boardBtn = new JButton("게시판 관리");
		boardBtn.addActionListener(btnFunc.getInstance().mainBoardBtn);
		JButton commentBtn = new JButton("댓글 관리");
		commentBtn.addActionListener(btnFunc.getInstance().mainCommentBtn);
		JButton adminBtn = new JButton("관리자");
		adminBtn.addActionListener(btnFunc.getInstance().mainAdminBtn);
		
		gui.getCon().add(memberBtn);
		gui.getCon().add(boardBtn);
		gui.getCon().add(commentBtn);
		gui.getCon().add(adminBtn);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

	@Override
	public void memberDisplay() {
		gui.getCon().removeAll();
		
		JButton joinBtn = new JButton("회원가입");
		joinBtn.addActionListener(btnFunc.getInstance().memberJoinBtn);
		JButton loginBtn = new JButton("로그인");
		loginBtn.addActionListener(btnFunc.getInstance().memberLoginBtn);
		JButton modifyBtn = new JButton("정보 수정");
		modifyBtn.addActionListener(btnFunc.getInstance().memberModifyBtn);
		JButton exitBtn = new JButton("회원탈퇴");
		exitBtn.addActionListener(btnFunc.getInstance().memberExitBtn);
		
		gui.getCon().add(joinBtn);
		gui.getCon().add(loginBtn);
		gui.getCon().add(modifyBtn);
		gui.getCon().add(exitBtn);
		
		JButton returnBtn = new JButton("돌아가기");
		returnBtn.addActionListener(btnFunc.getInstance().returnBtn);
		gui.getCon().add(returnBtn);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

	@Override
	public void boardDisplay() {
		gui.getCon().removeAll();
		
		// list load, content = modify, delete
		
		JButton createBtn = new JButton("게시글 작성");
		createBtn.addActionListener(btnFunc.getInstance().boardCreateBtn);
		JButton searchBtn = new JButton("게시글 검색");
		searchBtn.addActionListener(btnFunc.getInstance().boardSearchBtn);
		
		gui.getCon().add(createBtn);
		gui.getCon().add(searchBtn);
		
		JButton returnBtn = new JButton("돌아가기");
		returnBtn.addActionListener(btnFunc.getInstance().returnBtn);
		gui.getCon().add(returnBtn);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

	@Override
	public void contentDisplay() {
		gui.getCon().removeAll();
		
		// comment search, list
		
		JButton boardModifyBtn = new JButton("게시글 수정");
		boardModifyBtn.addActionListener(btnFunc.getInstance().boardModifyBtn);
		JButton boardDeleteBtn = new JButton("게시글 검색");
		boardDeleteBtn.addActionListener(btnFunc.getInstance().boardDeleteBtn);
		
		JButton commentCreateBtn = new JButton("댓글 작성");
		commentCreateBtn.addActionListener(btnFunc.getInstance().commentCreateBtn);
		JButton commentModifyBtn = new JButton("댓글 수정");
		commentModifyBtn.addActionListener(btnFunc.getInstance().commentModifyBtn);
		JButton commentDeleteBtn = new JButton("댓글 삭제");
		commentDeleteBtn.addActionListener(btnFunc.getInstance().commentDeleteBtn);

		gui.getCon().add(boardModifyBtn);
		gui.getCon().add(boardDeleteBtn);

		gui.getCon().add(commentCreateBtn);
		gui.getCon().add(commentModifyBtn);
		gui.getCon().add(commentDeleteBtn);
		
		JButton returnBtn = new JButton("돌아가기");
		returnBtn.addActionListener(btnFunc.getInstance().returnBtn);
		gui.getCon().add(returnBtn);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

	@Override
	public void adminDisplay() {
		gui.getCon().removeAll();
		
		JButton outBtn = new JButton("게시글 수정");
		outBtn.addActionListener(btnFunc.getInstance().adminMemberBtn);
		JButton managerBtn = new JButton("게시글 검색");
		managerBtn.addActionListener(btnFunc.getInstance().adminManagerBtn);
		JButton boardDeleteBtn = new JButton("게시글 검색");
		boardDeleteBtn.addActionListener(btnFunc.getInstance().boardDeleteBtn);
		JButton commentDeleteBtn = new JButton("게시글 검색");
		commentDeleteBtn.addActionListener(btnFunc.getInstance().commentDeleteBtn);

		gui.getCon().add(outBtn);
		gui.getCon().add(managerBtn);
		gui.getCon().add(boardDeleteBtn);
		gui.getCon().add(commentDeleteBtn);
		
		JButton returnBtn = new JButton("돌아가기");
		returnBtn.addActionListener(btnFunc.getInstance().returnBtn);
		gui.getCon().add(returnBtn);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

}
