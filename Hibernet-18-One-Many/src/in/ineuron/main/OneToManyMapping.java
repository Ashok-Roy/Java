package in.ineuron.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Department;
import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class OneToManyMapping {
	public static void main(String[] args) {
		
		
		Session session = HibernateUtil.getSession();
		Transaction transaction =null;
		boolean flag = false;
		try{
			transaction = session.beginTransaction();
			
			Set<Employee> employee = new HashSet<>();
			employee.add(new Employee("Dhoni",1000,"CSK"));
			employee.add(new Employee("Kholi",2000,"RCB"));
			employee.add(new Employee("Sachin",3000,"CSK"));
			
			Department department = new Department();
			department.setDeptId("IPL-16");
			department.setEmployee(employee);
			department.setDeptName("Cricket");
			session.save(department);
			flag=true;
				
			
		}catch(HibernateException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(flag){
				transaction.commit();
				System.out.println("Object saved");
			}else{
				transaction.rollback();
				System.out.println("Object not saved");
			}
			
			HibernateUtil.closeSession(session);
		}
		
	}

}	
