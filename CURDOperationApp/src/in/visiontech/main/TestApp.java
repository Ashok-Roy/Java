package in.visiontech.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import in.visiontech.controller.IEmployeeController;
import in.visiontech.dto.Employee;
import in.visiontech.factory.EmployeeControllerFactory;

public class TestApp
{
	public static void main(String[] args)
	{
		IEmployeeController employeeController = null;
		Employee employee = null;
		String ename = null;
		String email= null;
		String city= null;
		String status= null;
		Integer eid = null;
		
		while(true)
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			
			try
			{
				System.out.println("Please Choose Option b/w [1,2,3,4,5] :");
				Integer option = Integer.parseInt(br.readLine());
				switch(option)
				{
				case 1:
					System.out.print("Enter Your Name : ");
					ename = br.readLine();
					System.out.print("Enter Your Email :");
					email = br.readLine();
					System.out.print("Enter Your City :");
					city = br.readLine();
					
					employee = new Employee();
					employee.setEname(ename);
					employee.setEmail(email);
					employee.setCity(city);
					
					employeeController = EmployeeControllerFactory.getEmployeeController();
					status = employeeController.save(employee);
					if(status.equalsIgnoreCase("success"))
					{
						System.out.println("Insertion Successful");
					}else if(status.equalsIgnoreCase("fail")){
						System.out.println("Insertion Failed");
					}else
					{
						System.out.println("Some Problem Occured");
					}
					break;
				case 2:
					System.out.println("Enter Your ID :");
					eid = Integer.parseInt(br.readLine());
					employeeController = EmployeeControllerFactory.getEmployeeController();
					employee = employeeController.findById(eid);
					if(employee != null)
					{
						System.out.println(employee);
					}else
					{
						System.out.println("Record Not Found");
					}
					
					break;
				case 3:
					System.out.println("Enter ID To Update : ");
					eid = Integer.parseInt(br.readLine());
					
					Employee newEmployee = new Employee();
					newEmployee.setEid(eid);
					employeeController = EmployeeControllerFactory.getEmployeeController();
					employee = employeeController.findById(eid);
					if(employee != null)
					{
						System.out.println("Enter New Name :[Old Name is: "+employee.getEname()+"]");
						String newName = br.readLine();
						if(newName == null || newName.equals(""))
						{
							newEmployee.setEname(employee.getEname());
						}else
						{
							newEmployee.setEname(newName);
						}
						System.out.println("Enter New Email :[Old Email is: "+employee.getEmail()+"]");
						String newEmail = br.readLine();
						if(newEmail == null || newEmail.equals(""))
						{
							newEmployee.setEmail(employee.getEmail());
						}else
						{
							newEmployee.setEmail(newEmail);
						}
						System.out.println("Enter New City :[Old City is: "+employee.getCity()+"]");
						String newCity = br.readLine();
						if(newCity == null || newCity.equals(""))
						{
							newEmployee.setCity(employee.getCity());
						}else
						{
							newEmployee.setCity(newCity);
						}
						
						status = employeeController.updateById(newEmployee);
						
						if(status.equalsIgnoreCase("success"))
						{
							System.out.println("Record Updation Successful");
						}else if(status.equalsIgnoreCase("failure"))
						{
							System.out.println("Record Updation Failed");
						}else
						{
							System.out.println("Some Problem Occured...!");
						}
					}else
					{
						System.out.println("Record Not Found!");
					}
					
					break;
				case 4:
					System.out.println("Enter ID To Delete : ");
					eid = Integer.parseInt(br.readLine()); 
					employeeController = EmployeeControllerFactory.getEmployeeController();
					employee = employeeController.findById(eid);
					if(employee != null)
					{
						status = employeeController.deleteById(eid);
						if(status.equalsIgnoreCase("success"))
						{
							System.out.println("Record Deletion Successful");
						}else{
							System.out.println("Unable To Delete!");
						}
					}else
					{
						System.out.println("Record Not Found!");
					}
					
					break;
					
				case 5:
					System.out.println("Thank You For Using Our Application");
					System.exit(0);
				default:
					System.out.println("Please Choose Your Option b/w[1,2,3,4,5]");
					break;
					
				}
				
			}catch(IOException io)
			{
				io.printStackTrace();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
