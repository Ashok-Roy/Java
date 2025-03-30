package in.ineuron.target;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import in.ineuron.comp.Courier;

// Target object 
@Component(value="fpkt")
@PropertySource(value="in/ineuron/commons/info.properties")
//@PropertySource(value={"in/ineuron/commons/info.properties", ""}) // for multiple properties file 
public class FlipKart {
	// Dependent object 
	@Autowired
	@Qualifier("dtdc")
	private Courier courier;
	
	@Autowired
	private Date date;
	
	@Value("${fpkt.info.url}")
	private String url;
	
	@Value("${fpkt.info.discount}")
	private int discount;
	
	@Value("${os.name}")
	private String os;
	
	@Value("${Path}")
	private String pathValue;
	
	static{
		System.out.println("FlipKart.calss file is loading....");
	}
	
	public FlipKart()
	{
		System.out.println("FlipKart object is created....");
	}
	
	public String shopping(String[] items, float[] prices)
	{
		System.out.println(courier.getClass().getName());
		System.out.println("Date object details :" + date);
		System.out.println("Url value is :" + url);
		System.out.println("Discount value is :" + discount);
		System.out.println("Path Value is : " + pathValue);
		System.out.println("OS Version  : " + os);
		Random random = null;
		float billAmount = 0.0f;
		int oid = 0;
		for(float price : prices)
		{
			billAmount += price;
			
		}
		random = new Random();
		oid = random.nextInt(1000);
		String msg = courier.deliver(oid);
		
		return Arrays.toString(items) + " are purches having prices " + Arrays.toString(prices)
		+" with the bill amount : : " + billAmount+"-----> "+ msg;
	}

}
