package servlet.reply;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import service.ReplyService;
import service.ReplyServiceImpl;
import vo.Reply;

// restfull api 
@WebServlet("/reply/*")
public class ReplyController extends HttpServlet{
	private ReplyService service = ReplyServiceImpl.getInstance();
	private Gson gson = new GsonBuilder().setDateFormat("yyy/MM/dd-HH:mm:ss").create();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		uri = uri.replace(req.getContextPath()+"/reply/","");
		Object ret = null;
		if(uri.startsWith("list")) {
			
			int tmpIdx =uri.lastIndexOf("/");
			Long pno = 0L;
			if(tmpIdx != -1) {
				pno = Long.valueOf(uri.substring(tmpIdx + 1));
			}
			ret = service.list(pno);
		}else {
			Long rno = Long.valueOf(uri);
			ret = service.findBy(rno);
		}
		
		System.out.println(ret);
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().print(gson.toJson(ret));
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		char[] chs = new char[req.getContentLength()];
		req.getReader().read(chs);
		String str = new String(chs);
		System.out.println(str);
		
		Reply reply = gson.fromJson(str, Reply.class);
		System.out.println(reply);
		
		service.write(reply);
		
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		char[] chs = new char[req.getContentLength()];
		req.getReader().read(chs);
		String str = new String(chs);
		System.out.println(str);
		
		Reply reply = gson.fromJson(str,Reply.class);
		System.out.println(reply);
		
		service.modify(reply);
		
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		uri = uri.replace(req.getContextPath()+"/reply/","");
		if(uri.startsWith("list")) {
			int tmpIdx =uri.lastIndexOf("/");
			Long pno = 0L;
			if(tmpIdx != -1) {
				pno = Long.valueOf(uri.substring(tmpIdx + 1));
			}
			service.removeAll(pno);
		}else {
			Long rno = Long.valueOf(uri);
			service.remove(rno);
		}
	}
}
