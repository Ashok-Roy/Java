package in.ineuron.main;

import org.hibernate.Session;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class DBToEntityObject {

	public static void main(String[] args) 
	{
		Employee employee  = null;
		Session session = HibernateUtil.getSession();
		
		try{
			Integer id = 103;
			employee = session.get(Employee.class, id);
			if(employee != null)
			{
				System.out.println(" Old Employee : " + employee);
				System.in.read();
				
				session.refresh(employee);
				System.out.println("Updated Employee : "+ employee);
				
			}else{
				System.out.println("Record Not Found!");
				System.exit(0);
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
