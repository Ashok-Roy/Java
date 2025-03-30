package in.ineuron.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.PersonInfo;
import in.ineuron.util.HibernateUtil;

public class TestApp {
// Check the console correctly 
	public static void main(String[] args)
	{
		Transaction transaction = null;
		boolean flag = false;
		try{
		Session session = HibernateUtil.getSession();
		if(session != null)
			transaction = session.beginTransaction();
		if(transaction != null)
		{
			PersonInfo obj = new PersonInfo();
			obj.setPname("sachin");
			obj.setDob(LocalDate.of(1996, 12, 17));
			obj.setDom(LocalDateTime.of(1996, 6,21,12,35));
			obj.setDoj(LocalTime.of(10, 15));
			session.save(obj);
			flag=true;
		}
		}catch(HibernateException e)
		{
			transaction.rollback();
			e.printStackTrace();
		}finally{
			if(flag)
			{
				transaction.commit();
				System.out.println("Insertion Successful...");
			}else{
				transaction.rollback();
				System.out.println("Insertion Failed");
			}
		}
	}

}
