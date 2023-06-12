package dao;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dto.AccountBookDto;
import singleton.Singleton;

public class AccountBookDao {
	
	private Scanner sc = new Scanner(System.in);
	
	public AccountBookDao() {
	}
	
	// 입력
	public void insert() {
		// TODO : insert()
		System.out.println("가계부 입력 페이지입니다 :-) ");
		System.out.print("날짜(ex.2023.06.09) >> ");
		String date = sc.next();
		
		System.out.print("제목(ex.커피) >> ");
		String title = sc.next();
		
		System.out.print("입금/출금 >> ");
		String inOut = sc.next();
		
		System.out.print("금액 >> ");
		 int amount = sc.nextInt();
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("내용 >> ");
		String content = "";
		try {
			content = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		Singleton s = Singleton.getInstance();
		s.accountList.add(new AccountBookDto(date, title, inOut, amount, content));
		System.out.println(); // 공백
	}
	
	// 삭제
	public void delete() {
		// TODO : delete()
		System.out.println("가계부 삭제 페이지입니다 :-) ");
		System.out.print("삭제할 날짜(ex.2023.06.09) >> ");
		String date = sc.next();
		
		int index = search(date);
		if(index == -1) {
			System.out.println("날짜에 해당하는 가계부가 없습니다.");
		}else {
			Singleton s = Singleton.getInstance();
			s.accountList.remove(index);
			System.out.println("삭제되었습니다.");
		}
		System.out.println(); // 공백
	}	
	
	// 수정
	public void update() {
		// TODO : update()
		System.out.println("가계부 수정 페이지입니다 :-) ");
		System.out.print("수정할 날짜(ex.2023.06.09) >> ");
		String date = sc.next();
		
		int index = search(date);
		if(index == -1) {
			System.out.println("날짜에 해당하는 가계부가 없습니다.");
			return;
		}
		
		System.out.print("제목(ex.커피) >> ");
		String title = sc.next();
		
		System.out.print("입금/출금 >> ");
		String inOut = sc.next();
		
		System.out.print("금액 >> ");
		 int amount = sc.nextInt();

		System.out.print("내용 >> ");
		String content = sc.next();
		
		Singleton s = Singleton.getInstance();
		
		AccountBookDto dto = s.accountList.get(index);
		dto.setTitle(title);
		dto.setInOut(inOut);
		dto.setAmount(amount);
		dto.setContent(content);
		
		System.out.println("수정을 완료했습니다");
		System.out.println(); // 공백
	}
	
	// 검색
	public void select() {
		// TODO : select()	
		System.out.println("가계부 검색 페이지입니다 :-) ");
		System.out.print("제목검색(1) / 날짜검색(2) >> ");
		int num = sc.nextInt();
		
		if(num==1) {
			System.out.print("제목 입력 >> ");
			String title = sc.next();
			
			Singleton s = Singleton.getInstance();
			List<AccountBookDto> findTitleList = new ArrayList<AccountBookDto>();
			
			for (int i = 0; i < s.accountList.size(); i++) {
				AccountBookDto dto = s.accountList.get(i);
				if(dto.getTitle().contains(title)) {
					findTitleList.add(dto); //
				}
			}
			if(findTitleList.size()==0) {
				System.out.println("날짜에 해당하는 가계부가 없습니다.");
			}
			System.out.println("검색된 제목의 가계부 입니다 ---");
			for (int i = 0; i < findTitleList.size(); i++) {
				System.out.println(findTitleList.get(i).toString());
			}
			
		}else if(num==2) {
			System.out.print("검색할 날짜 입력(ex.2023.06.09) >> ");
			String date = sc.next();
			
			Singleton s = Singleton.getInstance();
			List<AccountBookDto> findDateList = new ArrayList<AccountBookDto>();
			
			for (int i = 0; i < s.accountList.size(); i++) {
				AccountBookDto dto = s.accountList.get(i);
				if(date.equals(dto.getDate())) {
					findDateList.add(dto); // 같은 날짜 정보 출력
				}
			}
			if(findDateList.size()==0) {
				System.out.println("날짜에 해당하는 가계부가 없습니다.");
			}
			System.out.println("검색된 날짜의 가계부 입니다 ---");
			for (int i = 0; i < findDateList.size(); i++) {
				System.out.println(findDateList.get(i).toString());
			}	
		}	
		System.out.println(); // 공백
	}
	
	public int search(String date) {
		// TODO : search() -> 추가, 수정, 삭제 작업을 하기 위한 메서드를 따로 만듬
		Singleton s = Singleton.getInstance();
		int index = -1;
		for (int i = 0; i < s.accountList.size(); i++) {
			AccountBookDto dto = s.accountList.get(i);
			if(date.equals(dto.getDate())) {
				index = i;
				break;
			}
		}
		return index;
	}

	
	// 전체출력
	public void allDataPrint() { 
		// TODO : allDataPrint()
		System.out.println("가계부 전체출력 페이지입니다 :-) ");
		Singleton s = Singleton.getInstance();
		
		if(s.accountList.isEmpty()) {
			System.out.println("저장된 데이터가 없습니다");
			return;
		}
		for (int i = 0; i < s.accountList.size(); i++) {
			System.out.println(s.accountList.get(i).toString());
		}
		System.out.println(); // 공백
	}
	
	// 월별 조회
	public void month() {
		System.out.println("월별조회 페이지입니다 :-) ");
		System.out.print("검색하려는 연도를 입력하세요(숫자만) >> ");
		String year = sc.next();
		sc.nextLine();
		
		
		System.out.print("검색하려는 월을 입력하세요.(숫자만) >> ");
        String month = sc.next();
        sc.nextLine();
        
        System.out.println("****************************");
        
        Singleton s = Singleton.getInstance();
		List<AccountBookDto> findMonthSearch = new ArrayList<AccountBookDto>();
		
		int in = 0;
		int out = 0;
		int sum;
		for (int i = 0; i < s.accountList.size(); i++) {
			AccountBookDto dto = s.accountList.get(i);
			String date[] = dto.getDate().split("\\.");
			
			if(date[0].equals(year)&&date[1].equals(month)) {
				//System.out.println(dto.getInOut()); // 입금
				if(dto.getInOut().equals("입금")) {
						in += dto.getAmount();	
				}
				else if(dto.getInOut().equals("출금")) {
					out += dto.getAmount();
				}
				findMonthSearch.add(dto);
			}
			
		}
		System.out.println(year+"년 "+month+"월");
		System.out.println("입금 :" + in);
		System.out.println("출금 :" + out);
		System.out.println("잔액 :" + (in-out));
	}
	
	// 기간 출력
	public void period() {
		
		System.out.println("기간 조회 할 날짜를 입력해주세요. (ex.2023.01.01 ~ 2023.06.12)");
		System.out.print("시작 년도를 입력하세요(숫자만) >> ");
//		String firstYear = sc.next();
		String firstYear = "2023";
		sc.nextLine();
		
		
		System.out.print("시작 월을 입력하세요.(숫자만) >> ");
        //String firstMonth = sc.next();
        String firstMonth = "01";
        sc.nextLine();
        
        System.out.print("시작 일을 입력하세요.(숫자만) >> ");
        //String firstDay = sc.next();
        String firstDay = "01";
        sc.nextLine();
        
        System.out.print("종료 년도를 입력하세요(숫자만) >> ");
		//String endtYear = sc.next();
		String endtYear = "2023";
		sc.nextLine();
		
		
		System.out.print("종료 월을 입력하세요.(숫자만) >> ");
       // String endtMonth = sc.next();
        String endtMonth = 	"06";
        sc.nextLine();
        
        System.out.print("종료 일을 입력하세요.(숫자만) >> ");
        //String endtDay = sc.next();
        String endtDay = "30";
        sc.nextLine();
        
        Singleton s = Singleton.getInstance();
		List<AccountBookDto> findMonthSearch = new ArrayList<AccountBookDto>();
		
        int in = 0;
		int out = 0;
		
		for (int i = 0; i < s.accountList.size(); i++) {
			AccountBookDto dto = s.accountList.get(i);
			String date[] = dto.getDate().split("\\.");
			
		}
		
//		if(date[0].equals(year)&&date[1].equals(month)) {
//			//System.out.println(dto.getInOut()); // 입금
//			if(dto.getInOut().equals("입금")) {
//					in += dto.getAmount();	
//			}
//			else if(dto.getInOut().equals("출금")) {
//				out += dto.getAmount();
//			}
//			findMonthSearch.add(dto);
//		}
		
	}
//	System.out.println(year+"년 "+month+"월");
//	System.out.println("입금 :" + in);
//	System.out.println("출금 :" + out);
//	System.out.println("잔액 :" + (in-out));
	
}
