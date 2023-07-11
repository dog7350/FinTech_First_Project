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
		Container menu = new Container();
		menu.setLayout(new FlowLayout(FlowLayout.CENTER));
		gui.getCon().add(menu, BorderLayout.CENTER);
		
		JButton memberBtn = new JButton("회원 관리");
		memberBtn.addActionListener(btnFunc.getInstance().mainMemberBtn);
		JButton boardBtn = new JButton("게시판 관리");
		boardBtn.addActionListener(btnFunc.getInstance().mainBoardBtn);
		JButton commentBtn = new JButton("본문"); // 게시글 본문
		commentBtn.addActionListener(btnFunc.getInstance().mainCommentBtn);
		JButton adminBtn = new JButton("관리자");
		adminBtn.addActionListener(btnFunc.getInstance().mainAdminBtn);
		
		menu.add(memberBtn);
		menu.add(boardBtn);
		menu.add(commentBtn);
		menu.add(adminBtn);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

	@Override
	public void memberDisplay() {
		gui.getCon().removeAll();
		Container menu = new Container();
		menu.setLayout(new FlowLayout(FlowLayout.CENTER));
		gui.getCon().add(menu, BorderLayout.CENTER);
		
		JButton returnBtn = new JButton("돌아가기");
		returnBtn.addActionListener(btnFunc.getInstance().returnBtn);
		menu.add(returnBtn);
		
		JButton joinBtn = new JButton("회원가입");
		joinBtn.addActionListener(btnFunc.getInstance().memberJoinBtn);
		JButton loginBtn = new JButton("로그인");
		loginBtn.addActionListener(btnFunc.getInstance().memberLoginBtn);
		JButton modifyBtn = new JButton("정보 수정");
		modifyBtn.addActionListener(btnFunc.getInstance().memberModifyBtn);
		JButton exitBtn = new JButton("회원탈퇴");
		exitBtn.addActionListener(btnFunc.getInstance().memberExitBtn);
		
		menu.add(joinBtn);
		menu.add(loginBtn);
		menu.add(modifyBtn);
		menu.add(exitBtn);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

	@Override
	public void boardDisplay() {
		gui.getCon().removeAll();
		Container menu = new Container();
		menu.setLayout(new FlowLayout(FlowLayout.LEFT));
		gui.getCon().add(menu, BorderLayout.NORTH);
		
		// list load, content = modify, delete
		
		JButton returnBtn = new JButton("돌아가기");
		returnBtn.addActionListener(btnFunc.getInstance().returnBtn);
		menu.add(returnBtn);
		
		JButton createBtn = new JButton("게시글 작성");
		createBtn.addActionListener(btnFunc.getInstance().boardCreateBtn);
		JTextField searchBar = new JTextField("", 25);
		JButton searchBtn = new JButton("게시글 검색");
		searchBtn.addActionListener(btnFunc.getInstance().boardSearchBtn);
		
		menu.add(createBtn);
		menu.add(searchBar);
		menu.add(searchBtn);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

	@Override
	public void contentDisplay() {
		gui.getCon().removeAll();
		
		Container topMenu = new Container();
		topMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
		gui.getCon().add(topMenu, BorderLayout.NORTH);
		
		Container content = new Container();
		content.setLayout(new FlowLayout(FlowLayout.LEFT));
		gui.getCon().add(content, BorderLayout.CENTER);
		
		Container bottom = new Container();
		bottom.setLayout(new FlowLayout(FlowLayout.LEFT));
		gui.getCon().add(bottom, BorderLayout.SOUTH);
		Container bottomMenu = new Container();
		bottomMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
		bottom.add(bottomMenu, BorderLayout.NORTH);
		Container bottomContent = new Container();
		bottomContent.setLayout(new FlowLayout(FlowLayout.LEFT));
		bottom.add(bottomContent, BorderLayout.CENTER);
		Container bottomList = new Container();
		bottomList.setLayout(new FlowLayout(FlowLayout.CENTER));
		bottom.add(bottomList, BorderLayout.SOUTH);
		
		JButton returnBtn = new JButton("돌아가기");
		returnBtn.addActionListener(btnFunc.getInstance().returnBtn);
		topMenu.add(returnBtn);
		
		// comment search, list
		
		JButton boardModifyBtn = new JButton("게시글 수정");
		boardModifyBtn.addActionListener(btnFunc.getInstance().boardModifyBtn);
		JButton boardDeleteBtn = new JButton("게시글 삭제");
		boardDeleteBtn.addActionListener(btnFunc.getInstance().boardDeleteBtn);
		
		JButton commentCreateBtn = new JButton("댓글 작성");
		commentCreateBtn.addActionListener(btnFunc.getInstance().commentCreateBtn);
		JButton commentModifyBtn = new JButton("댓글 수정");
		commentModifyBtn.addActionListener(btnFunc.getInstance().commentModifyBtn);
		JButton commentDeleteBtn = new JButton("댓글 삭제");
		commentDeleteBtn.addActionListener(btnFunc.getInstance().commentDeleteBtn);

		topMenu.add(boardModifyBtn);
		topMenu.add(boardDeleteBtn);

		bottomMenu.add(commentCreateBtn);
		bottomMenu.add(commentModifyBtn);
		bottomMenu.add(commentDeleteBtn);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

	@Override
	public void adminDisplay() {
		gui.getCon().removeAll();
		Container menu = new Container();
		menu.setLayout(new FlowLayout(FlowLayout.CENTER));
		gui.getCon().add(menu, BorderLayout.CENTER);
		
		JButton returnBtn = new JButton("돌아가기");
		returnBtn.addActionListener(btnFunc.getInstance().returnBtn);
		menu.add(returnBtn);
		
		JButton outBtn = new JButton("회원 강퇴");
		outBtn.addActionListener(btnFunc.getInstance().adminMemberBtn);
		JButton managerBtn = new JButton("관리자 임명");
		managerBtn.addActionListener(btnFunc.getInstance().adminManagerBtn);
		JButton boardDeleteBtn = new JButton("게시글 삭제");
		boardDeleteBtn.addActionListener(btnFunc.getInstance().boardDeleteBtn);
		JButton commentDeleteBtn = new JButton("댓글 삭제");
		commentDeleteBtn.addActionListener(btnFunc.getInstance().commentDeleteBtn);

		menu.add(outBtn);
		menu.add(managerBtn);
		menu.add(boardDeleteBtn);
		menu.add(commentDeleteBtn);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

}
