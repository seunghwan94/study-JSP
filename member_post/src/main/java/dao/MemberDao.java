package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mariadb.jdbc.Driver;

import utils.DBConn;
import vo.Member;

public class MemberDao {

	
	// 싱글톤
	private static final MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	private MemberDao() {}
	
	// CRUD
	public int insert(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. connection 객체 취득
			conn = DBConn.getConnection();
			// 2. 문장생성 (파라미터 지정)
			String sql = "insert into tbl_member (id, pw, name, email, road_addr, detail_addr) values (?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			pstmt.setString(idx++, member.getId());
			pstmt.setString(idx++, member.getPw());
			pstmt.setString(idx++, member.getName());
			pstmt.setString(idx++, member.getEmail());
			pstmt.setString(idx++, member.getRoadAddr());
			pstmt.setString(idx++, member.getDetailAddr());
			
			// 3. 실행
			return pstmt.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException ignore) {}
			
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
//		int rlt = dao.insert(Member.builder().id("aa").pw("123").name("뭔데").build());
//		System.out.println(rlt);
		Member m = dao.selectOne("test244");
		System.out.println(m);
	}
	
	public Member selectOne(String id) {
		Member member = null;
		String sql = "select * from tbl_member where id = ?";
		
		try(Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				member = Member.builder()
						.id(rs.getString("id"))
						.pw(rs.getString("pw"))
						.name(rs.getString("name"))
						.email(rs.getString("email"))
						.roadAddr(rs.getString("road_addr"))
						.detailAddr(rs.getString("detail_addr"))
						.createDate(rs.getDate("create_date"))
						.build();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}

}
