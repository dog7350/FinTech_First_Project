package common;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		controller ct = controller.getInstance();
		boolean flag = true;
		
		while (flag) {
			screen.clear();
			System.out.print("cli : 콘솔\ngui : 그래픽\nexit : 프로그램 종료\n명령어 입력\n>> ");
			switch (sc.next()) {
				case "cli" :
					ct.cliStart();
					break;
				case "gui" :
					ct.guiStart();
					break;
				case "exit" :
					flag = false;
					break;
			}
		}
	}
}