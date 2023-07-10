package board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import common.myInfo;


public class boardServiceImpl implements boardService {
	private static boardServiceImpl instance = null;
	private boardServiceImpl() {}
	public static boardServiceImpl getInstance() {
		if (instance == null) instance = new boardServiceImpl();
		return instance;
	}
	Scanner sc = new Scanner(System.in);

	boardDTO dto = new boardDTO();
	boardDAO dao = new boardDAO();
	myInfo info = myInfo.getInstance(); 

	ArrayList<boardDTO> list;
	boolean flag = true;
	int num = 0;

	@Override
	public void boardCreate() {

		dto.setbWriter(info.id);
		System.out.print("게시글 제목 : ");
		dto.setbTitle(sc.next());
		System.out.print("게시글 내용 : ");
		dto.setbContent(sc.next());
		num++;
		dto.setBno(num);
		Date date = new Date();
		dto.setbTime(date);
		

		System.out.println("해당 게시글을 저장할 곳을 선택해주세요 : ");
		System.out.println("1.C드라이브");
		System.out.println("2.DataBase");
		System.out.println("3.취소하기");

		switch(sc.nextInt()) {
		case 1 :
			boardFileWrite();
			break;
		case 2 :
			boardDBSend(dto);
			break;
		case 3:
			flag = false;
		}


	}

	public void boardFileRead() {
		System.out.println("불러올 파일명 입력 : ");
		
		File ffile = new File("C:\\pro\\" + sc.next() +".txt");
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(ffile);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			boardDTO dto = (boardDTO)ois.readObject();
			ois.close();
			bis.close();
			fis.close();
			
			System.out.println("제목 : " +dto.getbTitle());
			System.out.println("내용 : " +dto.getbContent());
		} catch (Exception e) {
			System.out.println("해당 파일은 존재하지 않습니다.");
		}

	}

	public void boardFileWrite() {
		File path = new File("C:\\pro\\" + dto.getbTitle() +".txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(path);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(dto.getbContent());
			System.out.println("저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if( oos != null )
				try {
					oos.close();
					bos.close();
					fos.close();
				} catch (Exception e2) {

					e2.printStackTrace();
				}

		}




	}

	public void boardDBSend(boardDTO dto) {
		dao.insert(dto);



	}

	@Override
	public void boardModify() {
		dao.modify(dto);
	}

	@Override
	public void boardDelete() {
		dao.delete(dto);
	}

	@Override
	public ArrayList<boardDTO> boardList() {
		list = dao.boardList();
		for (boardDTO d : list) {
			System.out.print(d.getBno()+"\t");
			System.out.print(d.getbWriter()+"\t");
			System.out.print(d.getbTitle()+"\t");
			System.out.print(d.getbContent()+"\t");
			System.out.print(d.getbTime()+"\t");
			System.out.print(d.getInquiry()+"\t");
			System.out.print(d.getReport());
		}
		//			(int bno, String bWriter, String bTitle, String bContent, Date bTime, int inquiry, int report)
		return list;
	}

	@Override
	public boardDTO boardSearch(int bno) {
		boardDTO dto =  dao.search(bno);
		
		return dto;
	}
	@Override
	public void boardContent() {
		System.out.println("검색 글 번호입력: ");
		boardDTO dto = boardSearch(sc.nextInt());
		if(dto == null) {
			System.out.println("존재하지 않는 글 입니다.");
		}else {
			System.out.print(dto.getbTitle());
			System.out.print(dto.getbTime());
			System.out.print(dto.getInquiry());
			System.out.print(dto.getReport());
			System.out.println(dto.getbContent());
		}
		
		
	}



}
