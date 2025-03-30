package in.ineuron.main;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.Model.Employee;


public class TestApp {

	public static void main(String[] args) 
	{
		// Step 1: Creating the Configuration object 
		Configuration cfg = new Configuration();

		//Step 2: configure the hibernate.cfg.xml file to Configuration Object
		cfg.configure();
		
		//Step 3: build SessionFactory Object 
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// Step 4: Create one session
		Session session = sessionFactory.openSession();
		
		// Step 5: Begin the transation within a session
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setEmpId(102);
		employee.setEmpName("Dhoni");
		employee.setEmpSalary(11000);
		
		//Step 6: Perform operation 
		Serializable object = session.save(employee);
		System.out.println(object);
		
		//Step 7: Perform  the Transaction operation
		transaction.commit();
		
		//Step 8: Close the session
		session.close();
		
	}

}
