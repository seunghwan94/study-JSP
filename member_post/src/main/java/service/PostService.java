package service;

import java.util.List;

import vo.Post;

public interface PostService {
	// 메서드의 시그니처를 만들어야된다.
	// 현실적인 이름을 사용해야된다.
	// 메서드 정의를 해야된다. 
	
	int write(Post post);
	
	int modify(Post post);
	
	int remove(Long pno);
	
	Post findBy(Long pno);
	
	List<Post> list();
	
}
