package vo;

import java.util.Date;

import lombok.Data;

@Data
public class Post {
	private Long pno;
	private String title;
	private String writer;
	private String content;
	private int viewCount;
	private Date createDate;
	private Date updateDate;
	
	public Post() {}

	public Post(Long pno, String title, String writer, String content, int viewCount, Date createDate, Date updateDate) {
		this.pno = pno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.viewCount = viewCount;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	public static P builder() {
		return new P();
	}
	public static class P {
		Long pno;
		String title;
		String writer;
		String content;
		int viewCount;
		Date createDate;
		Date updateDate;
		
		public P pno(Long pno) {
			this.pno = pno;
			return this;
		}

		public P title(String title) {
			this.title = title;
			return this;
		}

		public P writer(String writer) {
			this.writer = writer;
			return this;
		}

		public P content(String content) {
			this.content = content;
			return this;
		}

		public P viewCount(int viewCount) {
			this.viewCount = viewCount;
			return this;
		}

		public P createDate(Date createDate) {
			this.createDate = createDate;
			return this;
		}

		public P updateDate(Date updateDate) {
			this.updateDate = updateDate;
			return this;
		}
		public Post build() {
			return new Post(pno,title,writer,content,viewCount, createDate, updateDate);
		}
	}
	
}
