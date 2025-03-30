package in.ineuron.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/test")
public class LogFilter implements Filter 
{
	private FilterConfig config;
	static{
		System.out.println("Log Filter loading... ");
	}
    public LogFilter() {
       System.out.println("Log Filter Instantiation...");
    }

    public void init(FilterConfig config) throws ServletException {
		System.out.println("Log Filter Initialization...");
		this.config = config;
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("<h1>This line is added by the log filter before processing the request</h1>");
		
		ServletContext context = config.getServletContext();
		HttpServletRequest req = (HttpServletRequest) request;
		context.log("A request is coming from: "+req.getRemoteHost()
			+" for URL :"+req.getRequestURL()+" at date : "+ new Date());

		// pass the request along the filter chain
		chain.doFilter(request, response);
		out.println("<h1>This line is added by log filter after processing the request </h1>");
	}

	
	public void destroy() {
		config =null;
		System.out.println("Log Filter Destroy...");
	}

}
