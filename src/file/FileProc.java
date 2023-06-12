package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dto.AccountBookDto;
import singleton.Singleton;

public class FileProc {

	private File file = null;
	
	public FileProc(String filename) {
		file = new File("c:\\tmp\\"	+ filename + ".txt");
		
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 성공");
			}else {
				System.out.println("파일 생성 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write() {
		Singleton s = Singleton.getInstance();
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (int i = 0; i < s.accountList.size(); i++) {
				AccountBookDto dto = s.accountList.get(i);
				pw.println(dto.print());
				//pw.println(s.addressList.get(i).print()); // 두줄로 쓰는게 헷갈리지 않고 좋음
			}
			pw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("파일에 저장되었습니다");
		System.out.println();
	}
	
	public void read() {
		Singleton s = Singleton.getInstance();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = "";
			while((str=br.readLine())!=null) {
				//System.out.println(str);
				String split[] = str.split("/");
				// split[0] : date
				// split[1] : title 
				// split[2] : inOut-> int
				// split[3] : amount-> int
				// split[4] : content
				
				//AccountBookDto dto = new AccountBookDto(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), split[4]);
				AccountBookDto dto = new AccountBookDto(split[0], split[1], split[2], Integer.parseInt(split[3]), split[4]);
				s.accountList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("데이터를 모두 읽어냈습니다");
	}
	
	
	
	
	
	
}
