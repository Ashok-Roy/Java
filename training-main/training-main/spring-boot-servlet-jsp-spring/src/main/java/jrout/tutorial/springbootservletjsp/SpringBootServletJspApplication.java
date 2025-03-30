package jrout.tutorial.springbootservletjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringBootServletJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServletJspApplication.class, args);
	}

}
