package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.controller;

public class guiBtnFunction {
	private static guiBtnFunction instance = null;
	private guiBtnFunction() {
	}
	public static guiBtnFunction getInstance() {
		if (instance == null) instance = new guiBtnFunction();
		return instance;
	}
	////////////////////////////////////////////////////////////
	
	public ActionListener returnBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.getInstance().gui.mainDisplay();
		}
	};
	
	////////////////////////////////////////////////////////////
	
	public ActionListener mainMemberBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.getInstance().gui.memberDisplay();
		}
	};
	public ActionListener mainBoardBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.getInstance().gui.boardDisplay();
		}
	};
	public ActionListener mainCommentBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.getInstance().gui.contentDisplay();
		}
	};
	public ActionListener mainAdminBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.getInstance().gui.adminDisplay();
		}
	};
	
	////////////////////////////////////////////////////////////
	
	public ActionListener memberJoinBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public ActionListener memberLoginBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public ActionListener memberModifyBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public ActionListener memberExitBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	////////////////////////////////////////////////////////////
	
	public ActionListener boardCreateBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public ActionListener boardModifyBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public ActionListener boardDeleteBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public ActionListener boardList = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public ActionListener boardSearchBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	////////////////////////////////////////////////////////////
	
	public ActionListener commentCreateBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public ActionListener commentModifyBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public ActionListener commentDeleteBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public ActionListener commentList = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public ActionListener commentSearchBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	////////////////////////////////////////////////////////////
	
	public ActionListener adminMemberBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public ActionListener adminManagerBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
}
