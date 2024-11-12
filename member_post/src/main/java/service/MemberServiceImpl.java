package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mapper.MemberMapper;
import utils.Mybatisinit;
import vo.Member;

public class MemberServiceImpl implements MemberService{
	
	@Override
	public int register(Member member) {
		try(SqlSession session =  Mybatisinit.getInstance().sqlSessionFactory().openSession(true)){
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			return mapper.insert(member);
		}
	}

	@Override
	public Member findBy(String id) {
		try(SqlSession session =  Mybatisinit.getInstance().sqlSessionFactory().openSession(true)){
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			return mapper.selectOne(id);
		}
	}

	@Override
	public boolean login(String id, String pw) {
		Member m = findBy(id);
		return m != null && m.getPw().equals(pw);
	}

	@Override
	public List<Member> list() {
		return null;
	}

	@Override
	public boolean remove(String id) {
		return false;
	}

	@Override
	public boolean modify(Member member) {
		return false;
	}
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
//		service.list().forEach(System.out::println);
		System.out.println(service.findBy("test"));
//		System.out.println(service.now());
//		System.out.println(service.write(Post.builder().title("ㄱㄱㄱㄱㄱ").content("ㄷㄷㄷㄷㄷ").writer("test").build()));
		
	}
}
