package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.Model.Branch;
import in.ineuron.util.HibernateUtil;

public class RetrevialApp {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		try{
			Branch branch = session.get(Branch.class, "CS");
			System.out.println(branch);
			
		}catch(HibernateException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
