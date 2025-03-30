package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class RetrevialApp {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		try{
			Employee employee = session.get(Employee.class, 2);
			System.out.println(employee);
			
		}catch(HibernateException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
