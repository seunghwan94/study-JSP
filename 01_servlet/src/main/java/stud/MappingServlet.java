package stud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/maptest")
public class MappingServlet extends HttpServlet{
// servlet이 url에 mapping 한다. => web.xml 볼것
// WebServlet("/maptest") 이게 어노테이션으로 mapping 
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("mapping");
	}
	
}
