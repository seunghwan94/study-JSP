package service;

import java.util.List;

import vo.Post;

public interface PostService {
	// select1 => 단일 조회
	Post findBy(int pno);
	
	// selectlist => 리스트
	List<Post> selectList();
	
	// 게시글 수정
	boolean modifyPost(int pno, String title, String content);
	
	// 게시글 생성
	boolean addPost(String title, String content);
	
	// 게시글 삭제
	boolean removePost(int pno);
	
}
