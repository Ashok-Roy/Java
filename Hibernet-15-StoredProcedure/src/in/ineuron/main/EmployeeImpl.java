package in.ineuron.main;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class EmployeeImpl implements IEmployeeDao{

	@Override
	public List<Employee> getSalaryWithinRange(int start, int end) 
	{
		Session session = HibernateUtil.getSession();
		ProcedureCall procedureCall =  session.createStoredProcedureCall("Get_Salary_By_Range",Employee.class);
		procedureCall.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(start);
		procedureCall.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(end);
		
		List<Employee> list = procedureCall.getResultList();

		
		return list;
	}

	@Override
	public String[]  getEmployeeById(int id) 
	{
		Session session = HibernateUtil.getSession();
		ProcedureCall procedureCall =  session.createStoredProcedureCall("Get_By_Id");
		procedureCall.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(id);
		procedureCall.registerParameter(2, String.class, ParameterMode.OUT);
		procedureCall.registerParameter(3, String.class, ParameterMode.OUT);
		
		String name = (String)procedureCall.getOutputParameterValue(2);
		String salary = (String)procedureCall.getOutputParameterValue(3);
		String result[] = {name,salary};
		
		
		return result;
	}
	
}
