package gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import board.boardDAO;
import board.boardDTO;
import comment.commentDAO;
import comment.commentDTO;

import java.util.*;

import common.controller;
import common.myInfo;
import member.memberDAO;
import member.memberDTO;

public class guiServiceImpl extends Thread implements guiService {
	guiBtnFunction btnFunc = guiBtnFunction.getInstance();
	guiFrame gui = null;
	
	memberDAO mbDAO = null;
	boardDAO boDAO = null;
	commentDAO cmDAO = null;
	
	public void run() {
		mbDAO = new memberDAO();
		boDAO = new boardDAO();
		cmDAO = new commentDAO();
		mainDisplay();
	}

	@Override
	public void mainDisplay() {
		gui = guiFrame.getInstance();
		gui.getCon().removeAll();
		Container menu = new Container();
		menu.setLayout(new GridLayout(0, 1));
		gui.getCon().add(menu, BorderLayout.CENTER);
		
		JLabel info = new JLabel();
		if (guiInfo.getInstance().id == null) info.setText("님 로그인 하세요.");
		else info.setText(guiInfo.getInstance().id + "(" + guiInfo.getInstance().name + ") 님 환영합니다! ^^");
		
		JButton memberBtn = new JButton("회원 관리"); // 완료
		memberBtn.addActionListener(btnFunc.getInstance().mainMemberBtn);
		JButton boardBtn = new JButton("게시판 관리"); // 완료
		boardBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (guiInfo.getInstance().id == null) {
					info.setText("로그인 하시라고");
					return;
				}
				boardDisplay("%");
			}
		});
		JButton adminBtn = new JButton("관리자"); // 완료
		adminBtn.addActionListener(btnFunc.getInstance().mainAdminBtn);
		
		menu.add(info);
		
		menu.add(memberBtn);
		menu.add(boardBtn);
		if (guiInfo.getInstance().admin == 1) menu.add(adminBtn);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

	@Override
	public void memberDisplay() {
		gui.getCon().removeAll();
		Container menu = new Container();
		menu.setLayout(new GridLayout(0, 2));
		gui.getCon().add(menu, BorderLayout.CENTER);
		
		JButton returnBtn = new JButton("돌아가기"); // 완료
		returnBtn.addActionListener(btnFunc.getInstance().returnBtn);
		menu.add(returnBtn);
		
		JButton joinBtn = new JButton("회원가입"); // 완료
		joinBtn.addActionListener(btnFunc.getInstance().memberJoinBtn);
		
		JButton loginBtn = new JButton("로그인"); // 완료
		Container txtBox = new Container();
		txtBox.setLayout(new GridLayout(2, 1));
		JTextField idTxt = new JTextField();
		JTextField pwTxt = new JTextField();
		txtBox.add(idTxt);
		txtBox.add(pwTxt);
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mbDAO.login(idTxt.getText(), pwTxt.getText()).equals("로그인 성공!")) {
					memberDTO dto = mbDAO.search(idTxt.getText());
					guiInfo.getInstance().setInstance(dto.getId(), dto.getPw(), dto.getName(), dto.getAddr(), dto.getPhone(), dto.getEmail(), dto.getAdmin());
					mainDisplay();
				} else {
					idTxt.setText("아이디 또는");
					pwTxt.setText("비밀번호가 틀렸습니다.");
				}
			}
		});
		JButton logoutBtn = new JButton("로그아웃"); // 완료
		logoutBtn.addActionListener(btnFunc.getInstance().memberLogoutBtn);
		
		JButton modifyBtn = new JButton("정보 수정"); // 완료
		modifyBtn.addActionListener(btnFunc.getInstance().memberModifyBtn);
		JButton exitBtn = new JButton("회원탈퇴"); // 완료
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (myInfo.getInstance().id.equals(idTxt.getText()) && myInfo.getInstance().pw.equals(pwTxt.getText())) {
					mbDAO.memberOut(myInfo.getInstance().id);
					guiInfo.getInstance().resetInstance();
					mainDisplay();
				}
			}
		});
		
		menu.add(joinBtn);
		if (guiInfo.getInstance().id != null) {
			menu.add(logoutBtn);
			menu.add(modifyBtn);
			menu.add(exitBtn);
			menu.add(txtBox);
		} else {
			menu.add(loginBtn);
			menu.add(txtBox);
		}
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}
	
	@Override
	public void jmDisplay(String mod) {
		gui.getCon().removeAll();
		Container menu = new Container();
		menu.setLayout(new GridLayout(0, 2));
		gui.getCon().add(menu, BorderLayout.CENTER);
		
		// String id, String pw, String name, String addr, String phone, String email
		JLabel idGuide = new JLabel("ID");
		JTextField idTxt = new JTextField();
		JLabel pwGuide = new JLabel("PassWord");
		JTextField pwTxt = new JTextField();
		JLabel nameGuide = new JLabel("이름");
		JTextField nameTxt = new JTextField();
		JLabel addrGuide = new JLabel("주소");
		JTextField addrTxt = new JTextField();
		JLabel phoneGuide = new JLabel("전화번호");
		JTextField phoneTxt = new JTextField();
		JLabel emailGuide = new JLabel("E-Mail");
		JTextField emailTxt = new JTextField();
		JButton okBtn = new JButton("Submit");
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//String id, String pw, String name, String addr, String phone, String email, int admin
				memberDTO dto = null;
				if (mod.equals("join")) {
					dto = new memberDTO(idTxt.getText(), pwTxt.getText(), nameTxt.getText(), addrTxt.getText(), phoneTxt.getText(), emailTxt.getText(), 0);
					mbDAO.join(dto);
				}
				else {
					dto = new memberDTO(guiInfo.getInstance().id, pwTxt.getText(), nameTxt.getText(), addrTxt.getText(), phoneTxt.getText(), emailTxt.getText(), 0);
					mbDAO.modify(dto);
				}
				mainDisplay();
			}
		});
		
		if (mod.equals("join")) {
			menu.add(idGuide);
			menu.add(idTxt);
		}
		menu.add(pwGuide);
		menu.add(pwTxt);
		menu.add(nameGuide);
		menu.add(nameTxt);
		menu.add(addrGuide);
		menu.add(addrTxt);
		menu.add(phoneGuide);
		menu.add(phoneTxt);
		menu.add(emailGuide);
		menu.add(emailTxt);
		
		JButton returnBtn = new JButton("돌아가기"); // 완료
		returnBtn.addActionListener(btnFunc.getInstance().returnBtn);
		menu.add(returnBtn);
		menu.add(okBtn);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

	@Override
	public void boardDisplay(String title) {
		gui.getCon().removeAll();
		Container menu = new Container();
		menu.setLayout(new FlowLayout(FlowLayout.LEFT));
		gui.getCon().add(menu, BorderLayout.NORTH);
		JScrollPane scroll = new JScrollPane();
		scroll.setLayout(new ScrollPaneLayout());
		gui.getCon().add(scroll, BorderLayout.CENTER);

		Container View = new Container();
		View.setLayout(new GridLayout(0, 1));
		scroll.setViewportView(View);
		// list load, content = modify, delete
		
		JButton returnBtn = new JButton("돌아가기"); // 완료
		returnBtn.addActionListener(btnFunc.getInstance().returnBtn);
		menu.add(returnBtn);
		
		ArrayList<boardDTO> boardList = boDAO.titleSearch(title);
		
		JTextField searchBar = new JTextField("", 25);
		JButton searchBtn = new JButton("게시글 검색"); // 완료
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boardDisplay(searchBar.getText());
			}
		});
		JButton createBtn = new JButton("게시글 작성"); // 완료
		createBtn.addActionListener(btnFunc.getInstance().boardCreateBtn);
		
		for (boardDTO b : boardList) {
			JButton btn = new JButton(b.getBno() + " | " + b.getbTitle() + " | " + b.getbWriter() + " | " + b.getbTime() + " | " + b.getInquiry() + " | " + b.getReport());
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					contentDisplay(b.getBno());
				}
			});
			View.add(btn);
		}
		
		menu.add(createBtn);
		menu.add(searchBtn);
		menu.add(searchBar);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}
	
	public void bcmDisplay(String mod, int bno) {
		gui.getCon().removeAll();
		Container menu = new Container();
		menu.setLayout(new GridLayout(0, 2));
		gui.getCon().add(menu, BorderLayout.CENTER);
		
		JLabel titleGuide = new JLabel("제목");
		JTextField title = new JTextField();
		JLabel contentGuide = new JLabel("내용");
		JTextField content = new JTextField();
		JButton submit = new JButton("Submit");
		
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boardDTO dto = new boardDTO();
				dto.setbWriter(guiInfo.getInstance().id);
				dto.setbTitle(title.getText());
				dto.setbContent(content.getText());
				if (mod.equals("create")) {
					boDAO.insert(dto);
				} else if (mod.equals("modify")) {
					dto.setBno(bno);
					boDAO.modify(dto);
				}
				boardDisplay("%");
			}
		});
		
		menu.add(titleGuide);
		menu.add(title);
		menu.add(contentGuide);
		menu.add(content);
		menu.add(submit);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

	@Override
	public void contentDisplay(int bno) {
		gui.getCon().removeAll();
		
		boardDTO boDTO = boDAO.search(bno);
		ArrayList<commentDTO> cmtList = cmDAO.cmtList(bno);
		
		Container topMenu = new Container();
		topMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
		gui.getCon().add(topMenu, BorderLayout.NORTH);
		
		Container content = new Container();
		content.setLayout(new BorderLayout());
		gui.getCon().add(content, BorderLayout.CENTER);
		JLabel bTitle = new JLabel(boDTO.getbTitle());
		JLabel bContent = new JLabel(boDTO.getbContent());
		content.add(bTitle, BorderLayout.NORTH);
		content.add(bContent, BorderLayout.CENTER);
		
		Container bottom = new Container();
		bottom.setLayout(new GridLayout(0, 1));
		gui.getCon().add(bottom, BorderLayout.SOUTH);
		Container bottomMenu = new Container();
		bottomMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
		bottom.add(bottomMenu, BorderLayout.NORTH);
		Container bottomContent = new Container();
		bottomContent.setLayout(new FlowLayout(FlowLayout.LEFT));
		bottom.add(bottomContent, BorderLayout.SOUTH);
		Container bottomList = new Container();
		bottomList.setLayout(new GridLayout(0, 3));
		bottomContent.add(bottomList);
		
		JButton returnBtn = new JButton("돌아가기"); // 완료
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boardDisplay("%");
			}
		});
		topMenu.add(returnBtn);
		
		JButton boardModifyBtn = new JButton("게시글 수정"); // 완료
		boardModifyBtn.addActionListener(btnFunc.getInstance().boardModify(bno));
		JButton boardDeleteBtn = new JButton("게시글 삭제"); // 완료
		boardDeleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boardDTO dto = new boardDTO();
				dto.setBno(bno);
				boDAO.delete(dto);
			}
		});
		
		JTextField commentTxt = new JTextField("", 50);
		JButton commentCreateBtn = new JButton("댓글 작성"); // 완료
		commentCreateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				commentDTO dto = new commentDTO();
				dto.setBno(bno);
				dto.setCno(cmDAO.cmtMax(bno) + 1);
				dto.setcWriter(guiInfo.getInstance().id);
				dto.setcContent(commentTxt.getText());
				cmDAO.cmtCreate(dto);
				contentDisplay(bno);
			}
		});

		if (boDTO.getbWriter().equals(guiInfo.getInstance().id) || guiInfo.getInstance().admin == 1) {
			topMenu.add(boardModifyBtn);
			topMenu.add(boardDeleteBtn);
		}

		bottomMenu.add(commentTxt);
		bottomMenu.add(commentCreateBtn);
		
		for (commentDTO c : cmtList) {
			JButton cmtM = new JButton("수정");
			cmtM.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (c.getcWriter().equals(guiInfo.getInstance().id) || guiInfo.getInstance().admin == 1) {
						cmtModify(bno, c);
					}
				}
			});
			JButton cmtD = new JButton("삭제");
			cmtD.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (c.getcWriter().equals(guiInfo.getInstance().id) || guiInfo.getInstance().admin == 1) {
						cmDAO.cmtDelete(c.getBno(), c.getCno());
						contentDisplay(bno);
					}
				}
			});
			JLabel cmt = new JLabel(c.getcWriter() + " : " + c.getcContent());
			
			bottomList.add(cmt);
			bottomList.add(cmtM);
			bottomList.add(cmtD);
		}
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}
	
	void cmtModify(int bno, commentDTO cmt) {
		gui.getCon().removeAll();
		Container menu = new Container();
		menu.setLayout(new FlowLayout(FlowLayout.LEFT));
		gui.getCon().add(menu, BorderLayout.NORTH);
		
		JButton returnBtn = new JButton("돌아가기"); // 완료
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentDisplay(bno);
			}
		});
		menu.add(returnBtn);

		JTextField comment = new JTextField("", 30);
		JButton submit = new JButton("submit");
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cmDAO.cmtModify(bno, cmt.getCno(), comment.getText());
				contentDisplay(bno);
			}
		});
		menu.add(submit);
		menu.add(comment);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

	@Override
	public void adminDisplay() {
		gui.getCon().removeAll();
		Container menu = new Container();
		menu.setLayout(new GridLayout(0, 2));
		gui.getCon().add(menu, BorderLayout.CENTER);

		JTextField outTxt = new JTextField("", 25);
		JButton outBtn = new JButton("회원 강퇴"); // 완료
		outBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mbDAO.memberOut(outTxt.getText());
				outTxt.setText("퇴출");
			}
		});
		JTextField managerTxt = new JTextField("", 25);
		JButton managerBtn = new JButton("관리자 임명"); // 완료
		managerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mbDAO.memberManager(managerTxt.getText());
				managerTxt.setText("임명");
			}
		});
		JTextField boardTxt = new JTextField("", 25); // 완료
		JButton boardDeleteBtn = new JButton("게시글 삭제 (입력 : bno)");
		boardDeleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boardDTO dto = new boardDTO();
				dto.setBno(Integer.parseInt(boardTxt.getText()));
				boDAO.delete(dto);
				boardTxt.setText("삭제 완료");
			}
		});
		JTextField commentTxt = new JTextField("", 25); // 완료
		JButton commentDeleteBtn = new JButton("댓글 삭제 (입력 : bno/cno)");
		commentDeleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] str = commentTxt.getText().split("/");
				cmDAO.cmtDelete(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
				commentTxt.setText("삭제 완료");
			}
		});

		menu.add(outBtn);
		menu.add(outTxt);
		menu.add(managerBtn);
		menu.add(managerTxt);
		menu.add(boardDeleteBtn);
		menu.add(boardTxt);
		menu.add(commentDeleteBtn);
		menu.add(commentTxt);
		
		JButton returnBtn = new JButton("돌아가기");
		returnBtn.addActionListener(btnFunc.getInstance().returnBtn);
		menu.add(returnBtn);
		
		gui.getCon().revalidate();
		gui.getCon().repaint();
	}

}
