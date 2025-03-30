package in.ineuron.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestDemoListener implements ServletRequestListener {
	public static int count = 0;
    
	// This is the listener method 
    public void requestInitialized(ServletRequestEvent arg0)  { 
         count++;
         System.out.println("Request object got created : " + new java.util.Date());
         
         System.out.println("No of hit for this application is : "+count);
    }
    public void requestDestroyed(ServletRequestEvent arg0)  { 
        System.out.println("Request Object Destroyed "+  new java.util.Date());
   }
}
