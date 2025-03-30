package in.ineuron.main;


import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectOperationUsingLoad {

	public static void main(String[] args)
	{
		Session session = null;
		int id = 10;
		Employee employee = new Employee();
		try {
			session = HibernateUtil.getSession();
			if(session != null)
				employee = session.load(Employee.class, id);
			if(employee != null)
			{
				System.out.println("EId is : " + employee.getEmpId());
				System.in.read();
				System.out.println("EId is : " + employee.getEmpName());
				System.out.println("EId is : " + employee.getEmpSalary());
			}else{
				
				System.out.println("Employee Not Found..." + id);
			}

		} catch (HibernateException e) {
			
			System.out.println("Record Not Found");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession(session);
		}
	}

}
