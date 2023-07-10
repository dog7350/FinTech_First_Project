package gui;

import java.awt.*;
import javax.swing.*;

public class guiFrame extends Frame {
	private static guiFrame instance = null;
	public static guiFrame getInstance() {
		if (instance == null) instance = new guiFrame();
		return instance;
	}
	
	private guiFrame() {
		frame = new JFrame();
		c = frame.getContentPane();
		
		frame.setTitle("게시판 회원 관리 GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));

        frame.setLocation(1000, 200);
        frame.setPreferredSize(new Dimension(770, 500));
        frame.pack();
        
        frame.setVisible(true);
	}
	private JFrame frame = null;
    private Container c = null;
    
    public JFrame getFrame() { return frame; }
    public Container getCon() { return c; }
}
