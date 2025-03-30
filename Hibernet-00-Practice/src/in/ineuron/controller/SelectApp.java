package in.ineuron.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class SelectApp {

	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Student student = session.load(Student.class, 102);
		System.out.println(student);
		session.close();
	}

}
