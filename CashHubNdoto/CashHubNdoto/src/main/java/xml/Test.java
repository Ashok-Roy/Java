package xml;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	
	public static void main(String[] args) throws IOException {
		check();
	}
	 public static boolean check() throws IOException {
	        File file = new File("D:\\Projects\\STS Ndoto\\winhubpotal\\winhubgame\\src\\main\\java\\sample.json");

	        ObjectMapper mapper = new ObjectMapper();
	        Map<?, ?> map = mapper.readValue(file, Map.class);
	        for (Map.Entry<?, ?> entry : map.entrySet()) {
	           
	        	System.out.println(entry.getValue());
	        	
	        }

	        return false;
	    }


}
