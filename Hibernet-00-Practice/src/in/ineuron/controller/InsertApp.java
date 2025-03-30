package in.ineuron.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class InsertApp {

	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student std = new Student();
		std.setId(102);
		std.setName("Sahil");
		std.setEmail("sahil@gmail.com");
		std.setCity("Shimla");
		
		session.save(std);
		transaction.commit();
		session.close();
	}

}
