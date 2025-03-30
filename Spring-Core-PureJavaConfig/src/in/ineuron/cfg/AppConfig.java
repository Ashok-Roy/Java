package in.ineuron.cfg;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ="in.ineuron")
public class AppConfig {
	
	static{
		System.out.println("AppConfig.class file generate..");
	}
	public AppConfig(){
		System.out.println("AppConfig zero constructor generate..");
	}
	
	@Bean
	public LocalDateTime getSysDateTime(){
		LocalDateTime date = LocalDateTime.now();
		return date;
		
	}

}
