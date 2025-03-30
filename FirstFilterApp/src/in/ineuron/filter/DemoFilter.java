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
		System.out.println("Demo Filter Loading...");
	}
    public DemoFilter()
    {
        System.out.println("Demo Filter Instantiation...");
    }
	
    public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Demo Filter Initialization...");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("<h1>The line is added by demo filter before processing the request</h1>");
		
		// because of this line we are connected to the target servlet
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		out.println("<h1>This line is added by demo filter after processing</h1>");
	}
	
	public void destroy() {
		System.out.println("Demo filter destroy");
		
	}

}
