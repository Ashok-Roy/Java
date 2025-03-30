package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Account;
import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class DeleteApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		boolean flag = false;
		try{
			if(session!=null){
				Employee employee = session.get(Employee.class, 5);
				transaction = session.beginTransaction();
				if(employee!=null){
					Account account = employee.getAccount();
					 if (account != null) {
						 
                        // Disassociate the account first to avoid foreign key constraint violation
//                        employee.setAccount(null);
//                        session.update(employee);

                        // Delete the associated Account entity
                        //session.delete(account);
                    }

					 session.delete(employee);
	                    // Delete the Employee entity
//	                    session.delete(employee);
//					System.out.println("Employee Deleted");
					flag=true;
				}else{
					System.out.println("Employee Not Found!");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(flag){
				transaction.commit();
			}else{
				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
		}

	}

}
