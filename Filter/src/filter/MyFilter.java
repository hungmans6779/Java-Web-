package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

	public void destroy() {
	}

	public void init(FilterConfig config) {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		out.println("request �Q�B�z�e");
		System.out.println("request �Q�B�z�e");
		out.println("<hr>");
		
		
		
		chain.doFilter(request, response);
		
		
		
		
		out.println("<hr>");
		System.out.println("request �Q�B�z��, response ��F�Τ���s����...");
		out.println("request �Q�B�z��, response ��F�Τ���s����...<br>");
		
	}

}
