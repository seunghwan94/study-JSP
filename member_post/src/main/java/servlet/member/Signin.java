package servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import service.MemberServiceImpl;
import vo.Member;

@WebServlet("/signin")
public class Signin extends HttpServlet{
	
	private MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/signin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String rememberId = req.getParameter("remember-id");
		
		
		
		
		if(service.login(id,pw)) {
			// 세션 생성
			HttpSession session =  req.getSession();
			session.setAttribute("member", service.findBy(id));
			
//			// 쿠키 과제 - 쿠키에 아이디 기억 여부 처리
//			Cookie cookie = new Cookie("id", id);
//			Cookie rememberIdCookie = new Cookie("rememberId", rememberId);
//			
//			if(rememberId == null) {
//				rememberIdCookie.setMaxAge(0);
//			}
//			
//			resp.addCookie(cookie);
//			resp.addCookie(rememberIdCookie);

			
			// 쿠키 쌤 코드
			if(rememberId != null) {
				Cookie cookie = new Cookie("remember-id",id);
				cookie.setMaxAge(60 * 60 * 24 * 7);
				resp.addCookie(cookie);
			} else {
				// 아이디 기억 안할때 처리할 일
				Cookie[] cookies = req.getCookies();
				for (Cookie c : cookies) {
					if (c.getName().equals("remember-id")){
						c.setMaxAge(0);
						resp.addCookie(c);
						break;
					}
				}
				
			}
			
			
			
			// 로그인 성공
			resp.sendRedirect(req.getContextPath()+"/index");
			
		}else {
			System.out.println("실패");
			// 로그인 실패
			resp.sendRedirect("login?msg=fail");			
		}
		
		
		
		
	}
	
	
	
}
