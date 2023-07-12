package gui;


import java.awt.event.*;

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
			controller.getInstance().gui.jmDisplay("join");
		}
	};
	
	public ActionListener memberLogoutBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			guiInfo.getInstance().resetInstance();
			controller.getInstance().gui.mainDisplay();
		}
	};
	
	public ActionListener memberModifyBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.getInstance().gui.jmDisplay("modify");
		}
	};
	
	////////////////////////////////////////////////////////////
	
	public ActionListener boardCreateBtn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.getInstance().gui.bcmDisplay("create", -1);
		}
	};
	
	public ActionListener boardModify(int bno) {
		ActionListener modify = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.getInstance().gui.bcmDisplay("modify", bno);
			}
		};
		return modify;
	}

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
