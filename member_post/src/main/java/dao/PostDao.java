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
	
	// 목록 가져오기
	public static List<Post> list() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. connection 객체 취득
			conn = DBConn.getConnection();
			// 2. 문장생성 (파라미터 지정)
			String sql = "select * from tbl_post";
			pstmt = conn.prepareStatement(sql);
	
			Post post = null;
			List<Post> arrList = new ArrayList<>();
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				post = Post.builder()
						.pno(rs.getLong("pno"))
						.title(rs.getString("title"))
						.writer(rs.getString("writer"))
						.content(rs.getString("content"))
						.build();
				arrList.add(post);
			}
					
			for (Post p : arrList) {
				System.out.println(p);
			}
			
			return arrList;
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException ignore) {}
			
		}
		
		return null;
	}
	
	// 하나 가져오기
	public static Post selectOne(Long pno) {
		Post post = null;
		String sql = "select * from tbl_post where pno = ?";
		
		try(Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1,pno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				post = Post.builder()
						.pno(rs.getLong("pno"))
						.title(rs.getString("title"))
						.writer(rs.getString("writer"))
						.content(rs.getString("content"))
						.build();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return post;
	}
	
	// 추가
	public static int addPost(String title, String content, String writer) {
		String sql = "insert tbl_post into (title,content,writer) values (?,?,?) ";
		
		try(Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setString(3,writer);
			
			return pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	// 삭제
	public static int removePost(Long pno) {
		String sql = "delete tbl_post where pno = ?";
		
		try(Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1,pno);
			
			return pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// 삭제
	public static int modifyPost(Long pno, String title, String content) {
		String sql = "update tbl_post set title = ? , content = ?  where pno = ?";
		
		try(Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setLong(3,pno);
			
			return pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}	
	public static void main(String[] args) {
		PostDao pao = new PostDao();
//		int rlt = dao.insert(Member.builder().id("aa").pw("123").name("뭔데").build());
//		System.out.println(rlt);

	}



	
}
