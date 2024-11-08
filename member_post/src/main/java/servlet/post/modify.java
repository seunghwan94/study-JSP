package servlet.post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PostService;
import service.PostServiceImpl;
import utils.Commons;
import vo.Member;
import vo.Post;

@WebServlet("/post/modify")
public class modify extends HttpServlet{
	private PostService service = new PostServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pnoString = req.getParameter("pno");
		Object memberObj = req.getSession().getAttribute("member");

		if (pnoString == null || memberObj == null) {
			Commons.printMsg("비정상적인 접근입니다.", "list", resp);
			return;
		}
		
		Long bno = Long.valueOf(pnoString);
		
		req.setAttribute("post", service.findBy(bno));
		req.getRequestDispatcher("/WEB-INF/jsp/post/modify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object memberObj = req.getSession().getAttribute("member");
		
		if(memberObj == null) {
			Commons.printMsg("비정상적인 접근입니다.", "list", resp);
			return;
		}
		Member m = (Member) memberObj;
		
		Post post =service.findBy(Long.valueOf(req.getParameter("pno")));
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String pnoStr = req.getParameter("pno");
		Long pno = Long.valueOf(pnoStr);

		if(!m.getId().equals(service.findBy(pno).getWriter())) {
			Commons.printMsg("본인이 작성한 글만 수정할 수 있습니다.", "list", resp);
			return;
		}
		
		service.modify(Post.builder().pno(pno).title(title).content(content).build());
		
		Commons.printMsg("수정이 완료되었습니다.", "view?pno="+pno, resp);
	}
	
}
