package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.tribes.util.Arrays;

import utils.DBConn;
import vo.Post;

public class PostDao {
	
	// 추가
	public int insert(Post post) {
		String sql = "insert into tbl_post (title,content,writer) values (?,?,?) ";
		
		try(Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			int idx = 1;
			
			pstmt.setString(idx++,post.getTitle());
			pstmt.setString(idx++,post.getContent());
			pstmt.setString(idx++,post.getWriter());
			
			return pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// 하나 가져오기
	public Post selectOne(Long pno) {
		Post post = null;
		String sql = "select pno, title, writer, content, view_count, create_date, update_date from tbl_post where pno = ?";
		
		try(Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1,pno);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int idx = 1;
				
				post = Post.builder()
						.pno(rs.getLong(idx++))
						.title(rs.getString(idx++))
						.writer(rs.getString(idx++))
						.content(rs.getString(idx++))
						.viewCount(rs.getLong(idx++))
						.createDate(rs.getDate(idx++))
						.updateDate(rs.getDate(idx++))
						.build();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return post;
	}
		
		
	// 목록 가져오기
	public List<Post> selectList() {
		List<Post> posts = new ArrayList<>();
		
		String sql = "select pno, title, writer, view_count, create_date, update_date from tbl_post order by pno desc";
		try(Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {


			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx = 1;
				Post post = Post.builder()
						.pno(rs.getLong(idx++))
						.title(rs.getString(idx++))
						.writer(rs.getString(idx++))
						.viewCount(rs.getLong(idx++))
						.createDate(rs.getDate(idx++))
						.updateDate(rs.getDate(idx++))
						.build();
				posts.add(post);
			}
			return posts;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return posts;
	}
	
	
	// 수정
	public int update(Post post) {
		String sql = "update tbl_post set title = ? , content = ?, update_date = now()  where pno = ?";
		
		try(Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			int idx = 1;
			
			pstmt.setString(idx++,post.getTitle());
			pstmt.setString(idx++,post.getContent());
			pstmt.setLong(idx++,post.getPno());
			
			return pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}	

	
	// 삭제
	public int delete(Long pno) {
		String sql = "delete from tbl_post where pno = ?";
		
		try(Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1,pno);
			
			return pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public static void main(String[] args) {
		PostDao pao = new PostDao();

//		Post post = Post.builder().title("test").writer("test").content("wwww").build();
//		
//		int rlt = pao.insert(post);
//		System.out.println(rlt);
//		
		Post post = pao.selectOne((long) 15);
		System.out.println(post);
//		
//		int p4 = pao.update(post);
//		System.out.println(p4);
//		
//		int p3 = pao.delete((long) post.getPno());
//		System.out.println(p3);
//		
//		
//		List<Post> arr = pao.selectList();
//		for (Post p : arr) {
//			System.out.println(p);
//		}
		
//		pao.selectList().forEach(System.out::print);
	}

	// view count 수정
	public int increaseViewCount(Long pno) {
		String sql = "update tbl_post set view_count = view_count + 1 where pno = ?";
		
		try(Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			int idx = 1;
			pstmt.setLong(idx++,pno);
			
			return pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}	



	
}
