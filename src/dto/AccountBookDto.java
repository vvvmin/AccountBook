package dto;

public class AccountBookDto {
	//날짜, 용도, 수입/지출, 금액, 내용
	private String date;
	private String title;
	private String inOut;
	private int amount;
	private String content;
	
	// 기본생성자
	public AccountBookDto() {
	}

	// 생성자
	public AccountBookDto(String date, String title, String inOut, int amount, String content) {
		super();
		this.date = date;
		this.title = title;
		this.inOut = inOut;
		this.amount = amount;
		this.content = content;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInOut() {
		return inOut;
	}

	public void setInOut(String inOut) {
		this.inOut = inOut;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "날짜: " + date + ", 제목: " + title + ", 입금/지출: " + inOut
				+ ", 금액: " + amount + ", 내용: " + content;
	}

	public String print() {
		return "날짜: "+date+" /제목: "+title+" /입금/지출: "+inOut+" / 금액: "+amount+"/ 내용: "+content;
	}

	
}
