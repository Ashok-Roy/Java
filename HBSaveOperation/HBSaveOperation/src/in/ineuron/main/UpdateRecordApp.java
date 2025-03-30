package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class UpdateRecordApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Employee employee = new Employee();
				employee.setEmpId(7);
				employee.setEmpName("dhoni");
				employee.setEmpSal(7777.7);

				session.saveOrUpdate(employee);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
				System.out.println("Record updated succesfully...");
			}

			else {
				transaction.rollback();
				System.out.println("Record updation failed...");
			}

			HibernateUtil.closeSession(session);
		}

	}
}
