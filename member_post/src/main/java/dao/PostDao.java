package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.tribes.util.Arrays;

import utils.DBConn;
import vo.Member;
import vo.Post;

public class PostDao {
	
	
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
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				post = Post.builder()
						.pno(rs.getLong("pno"))
						.title(rs.getString("title"))
						.writer(rs.getString("writer"))
						.content(rs.getString("content"))
//						.roadAddr(rs.getString("road_addr"))
//						.detailAddr(rs.getString("detail_addr"))
//						.createDate(rs.getDate("create_date"))
						.build();
				System.out.println(post);
			}
			
			
					
					
					
					
			
			
//			List<Post> arrList = new ArrayList<>(pstmt.executeQuery());
			
//			return arrList;
			
			
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
	
	public static void main(String[] args) {
		PostDao pao = new PostDao();
//		int rlt = dao.insert(Member.builder().id("aa").pw("123").name("뭔데").build());
//		System.out.println(rlt);
		List<Post> p = pao.list();
		System.out.println(p);
	}
	
}
