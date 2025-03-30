package in.ineuron.main;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Branch;
import in.ineuron.Model.Student;
import in.ineuron.util.HibernateUtil;

public class ManyToOneMapping {
	public static void main(String[] args) {
		
		
		Session session = HibernateUtil.getSession();
		Transaction transaction =null;
		boolean flag = false;
		try{
			transaction = session.beginTransaction();
			
			
			
			Branch branch = new Branch();
			branch.setBranchId("101");
			branch.setBranchName("CS");
			branch.setBranchLocation("Bengaluru");
			
			Student s1 = new Student("Sachin","Bengaluru",branch);
			Student s2 = new Student("Dhoni","Bengaluru",branch);
			Student s3 = new Student("Kholi","Bengaluru",branch);
			session.save(s1);
			session.save(s2);
			session.save(s3);
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
