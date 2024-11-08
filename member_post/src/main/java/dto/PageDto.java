package dto;

import lombok.Data;

@Data
public class PageDto {
	private Criteria cri;
	private int total = 123;
	private int startPage;
	private int endPage;
	private int pageCount;
	
	public PageDto(int total) {
		this(new Criteria(),total);		
	}
	
	public PageDto(Criteria cri, int total) {
		this(cri, total, 10);
	}

	public PageDto(Criteria cri, int total, int pageCount) {
		this.cri = cri;
		this.total = total;
		this.pageCount = pageCount;
		
		endPage = (cri.getPage() + pageCount - 1) / pageCount * pageCount;
		startPage = endPage - pageCount + 1;
		
		int realEnd = (total + cri.getAmount() - 1) / cri.getAmount();
		
		if(realEnd < endPage) {
			endPage = realEnd;
		}
		
	}
	

	public static void main(String[] args) {
		PageDto dto = new PageDto(225);
		System.out.println(dto);
	}
	
	
}
