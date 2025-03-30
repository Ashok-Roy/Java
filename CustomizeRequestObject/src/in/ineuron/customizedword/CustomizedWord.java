package in.ineuron.customizedword;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomizedWord extends HttpServletRequestWrapper {

	
	public CustomizedWord(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		
		String word = super.getParameter(name);
		if(word.equals("Java") || word.equals("SpringBoot") || word.equals("JEE"))
			return "iNeuron";
		else
			return word;
	}

}
