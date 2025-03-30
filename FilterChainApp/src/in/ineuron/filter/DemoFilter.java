package in.ineuron.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/test")
public class DemoFilter implements Filter {
	static{
		System.out.println("Log Filter loading... ");
	}
    public DemoFilter() {
       System.out.println("Log Filter Instantiation...");
    }

    public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Log Filter Initialization...");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Request processing phase...");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>This line is added by log filter before processing the request</h1>");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		out.println("<h1>This line is added by log filter after processing the request</h1>");
	}

	
	public void destroy() {
		System.out.println("Log Filter Destroy...");
	}

}
