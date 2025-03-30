package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.Model.Employee;

public class StandardApp {

	public static void main(String[] args) {

		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Integer idValue = null;
		boolean flag = false;

		cfg = new Configuration();
		cfg.configure();
		System.out.println(cfg.getProperties());

		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();

		Employee employee = new Employee();
		employee.setEmpId(10);
		employee.setEmpName("sachin");
		employee.setEmpSal(54556.7);

		try {
			transaction = session.beginTransaction();// connection.setAutoCommit(false)
			idValue = (Integer) session.save(employee);
			System.out.println("Generated idvalue is :: " + idValue);
			flag = true;
			System.out.println("id value is :: " + employee.getEmpId());

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (flag == true) {
				transaction.commit();// con.commit()
			} else {
				transaction.rollback();// con.rollback()
			}
			session.close();
			sessionFactory.close();
		}

	}
}
