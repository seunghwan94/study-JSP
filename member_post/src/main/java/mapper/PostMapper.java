package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import dto.Criteria;
import vo.Post;

public interface PostMapper {

	List<Post> selectList(Criteria cri);

	int insert(Post post);

	int update(Post post);

	int delete(Long pno);

	Post selectOne(Long pno);

	int getCount(Criteria cri);

	void increaseViewCount(Long pno);
	
	
	
}
