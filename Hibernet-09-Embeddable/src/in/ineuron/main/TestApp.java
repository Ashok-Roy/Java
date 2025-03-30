package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.ProgrammerProjectInfo;
import in.ineuron.Model.ProjectInfo;
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
		if(transaction != null){
			ProjectInfo info = new ProjectInfo(101, 111);
			ProgrammerProjectInfo pinfo = new ProgrammerProjectInfo("Sachin", 101, "Java", info);
			session.save(pinfo);
			flag = true;
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
