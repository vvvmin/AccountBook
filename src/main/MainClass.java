package main;

import java.util.Scanner;

import dao.AccountBookDao;
import file.FileProc;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AccountBookDao dao = new AccountBookDao();
		FileProc fp = new FileProc("accountBook");
		
		// file read 호출
		fp.read();
		
		// 메뉴 구성 -> 무한루프
		while(true){
			System.out.println("-- 나만의 가계부 --");
			System.out.println("1. 가계부 등록");
			System.out.println("2. 가계부 삭제");
			System.out.println("3. 가계부 수정");
			System.out.println("4. 가계부 검색");
			System.out.println("5. 가계부 전체출력");
			System.out.println("6. 가계부 월별조회");
			System.out.println("7. 가계부 기간조회");
			System.out.println("8. 가계부 저장");
			System.out.println("9. 가계부 종료");
			
			System.out.print("번호를 입력해주세요 >> ");
			int number = sc.nextInt();
			
			switch(number) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.update();
					break;
				case 4:
					dao.select();
					break;
				case 5:
					dao.allDataPrint();
					break;
				case 6:
					dao.month();
					break;
				case 7:
					break;
				case 8:
					fp.write();
					break;
				case 9:
					System.out.println("가계부 종료");
					sc.close();
		            System.exit(0);
					break;
				default:
	                System.out.println("없는 메뉴입니다. 다시 시도하세요.");
	                break;
			}
			
			
		}
		
	}

}
