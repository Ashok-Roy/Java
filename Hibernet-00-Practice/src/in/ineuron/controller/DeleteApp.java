package in.ineuron.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class DeleteApp {

	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int id = 101;
		Student std = session.get(Student.class,id);
		session.delete(std);
		transaction.commit();
		session.close();
	}

}
