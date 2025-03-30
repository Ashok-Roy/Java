package in.ieuron.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import in.ineuron.customizedword.CustomizedWord;


@WebFilter("/test")
public class WordFilter implements Filter {
		
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Pre-processing logic of filter");
		
		CustomizedWord customizeRequest = new CustomizedWord((HttpServletRequest) request);
		chain.doFilter(customizeRequest, response);
		
		System.out.println("Post-processing logic of filter");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
