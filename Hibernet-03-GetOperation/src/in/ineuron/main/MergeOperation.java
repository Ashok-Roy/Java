package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class MergeOperation
{
	public static void main(String[] args)
	{
		Employee emp1 = null;
		Employee emp2 = null;
		Employee emp3 = null;
		boolean flag = false;
		Transaction transaction = null;
		Session session = HibernateUtil.getSession();
		try{
			Integer id = 104;
			System.out.println("Getting the Data from Database for id : "+ id);
			// Getting the data form database 
			// if id is not present we will get NullPointerException 
			emp1 = session.get(Employee.class,id); // present in L1 cache(available inside session )
			
			System.out.println("Setting the new data ");
			emp2 = new Employee();
			emp2.setEmpId(id);
			emp2.setEmpName("Sourav");
			emp2.setEmpSalary(130000);
			
			transaction = session.beginTransaction(); // setAutoCommit = false;
			// To merge given object data to already loaded same object data 
			// [102, 'Rahul', 1300000] -->emp2 -->L1 cache(emp1, emp3)
			// L1 cache can't be duplicate value/object so emp1 and emp3 will be refer same object reference 
			// So hash value same 
			emp3 = (Employee)session.merge(emp2);
			flag = true;
			
			System.out.println(emp1);
			System.out.println(emp2);
			System.out.println(emp3);
			System.out.println(emp1.hashCode()+" : " + emp2.hashCode()+" : " + emp3.hashCode());
			
			
		}catch(HibernateException h)
		{
			flag = false;
			h.printStackTrace();
		}finally{
			if(flag)
			{
				transaction.commit(); // con.commit()
			}else{
				transaction.rollback(); // con.rollback()
			}
		}
	}

}
