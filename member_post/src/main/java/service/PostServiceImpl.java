package service;

import java.util.List;

import dao.PostDao;
import vo.Post;

public class PostServiceImpl implements PostService {

	@Override
	public Post findBy(int pno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> selectList() {
		
		return PostDao.list();
	}

	@Override
	public boolean modifyPost(int pno, String title, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPost(String title, String content) {
		return false;
	}

	@Override
	public boolean removePost(int pno) {
		return false;
	}
	
}
