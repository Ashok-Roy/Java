package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.Model.Department;
import in.ineuron.util.HibernateUtil;

public class RetrevialApp {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		try{
			Department department = session.get(Department.class, "IPL-16");
			System.out.println(department);
			
		}catch(HibernateException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
