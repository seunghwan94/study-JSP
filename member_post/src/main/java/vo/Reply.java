package vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Reply {
	private Long rno;
	private String content;
	private Date createDate;
	private Date updateDate;
	private boolean hidden;
	private int likes;
	private String writer;
	private Long pno; 
}
