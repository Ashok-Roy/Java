package in.ineuron.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import in.ineuron.controller.IStudentController;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentControllerFactory;

public class TestApp 
{
	public static void main(String[] args)
	{
		
		IStudentController studentController = null; 
		String status = null;
		Student studentRecord = null;
		Integer sid = null;
		
		try
		{
			while(true)
			{
				studentController = StudentControllerFactory.getStudentController();
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.println("Please Choose between [1,2,3,4,5] ::");
				Integer option = Integer.parseInt(br.readLine());
				
				switch(option)
				{
				case 1:
					System.out.print("Enter Your Name: ");
					String name = br.readLine();
					System.out.print("Enter Your Email: ");
					String email = br.readLine();
					System.out.print("Enter Your City: ");
					String city = br.readLine();
					System.out.print("Enter Your Country: ");
					String country = br.readLine();
					
					Student student = new Student();
					student.setName(name);
					student.setEmail(email);
					student.setCity(city);
					student.setCountry(country);
					
					// continuously used code
					//studentController = StudentControllerFactory.getStudentController();
					status = studentController.save(student);
					if(status.equalsIgnoreCase("success"))
					{
						System.out.println("Record Inserted Successful");
					}else if(status.equalsIgnoreCase("failure"))
					{
						System.out.println("Record Insertion Failed");
					}else
					{
						System.out.println("Some Problem Occured...!");
					}
					break;
				case 2:
					
					System.out.println("Enter Student ID ::");
					sid = Integer.parseInt(br.readLine());
					studentRecord = studentController.findById(sid);
					if(studentRecord != null)
						System.out.println(studentRecord);
					else
						System.out.println("Student Record Not Found");
					break;
				case 3:
					System.out.println("Enter The Id recored To Be Updated");
					sid = Integer.parseInt(br.readLine());
					Student newStudent = new Student();
					newStudent = studentController.findById(sid);
					newStudent.setSid(sid);
					if(studentRecord != null)
					{
						System.out.println("Enter New Name :[Old Name is: "+studentRecord.getName()+"]");
						String newName = br.readLine();
						if(newName == null || newName.equals(""))
						{
							newStudent.setName(studentRecord.getName());
						}else
						{
							newStudent.setName(newName);
						}
						
						System.out.println("Enter New Email :[Old Email is: "+studentRecord.getEmail()+"]");
						String newEmail = br.readLine();
						if(newEmail == null || newEmail.equals(""))
						{
							newStudent.setEmail(studentRecord.getEmail());
						}else
						{
							newStudent.setEmail(newEmail);
						}
						System.out.println("Enter New City :[Old City is: "+studentRecord.getCity()+"]");
						String newCity = br.readLine();
						if(newCity == null || newCity.equals(""))
						{
							newStudent.setCity(studentRecord.getCity());
						}else
						{
							newStudent.setCity(newCity);
						}
						
						System.out.println("Enter New Country :[Old Country is: "+studentRecord.getCountry()+"]");
						String newCountry = br.readLine();
						if(newCountry == null || newCountry.equals(""))
						{
							newStudent.setCountry(studentRecord.getCountry());
						}else
						{
							newStudent.setCountry(newCountry);
						}
						
						status = studentController.updateById(newStudent);
						if(status.equalsIgnoreCase("success"))
						{
							System.out.println("Record Inserted Successful");
						}else if(status.equalsIgnoreCase("failure"))
						{
							System.out.println("Record Insertion Failed");
						}else
						{
							System.out.println("Some Problem Occured...!");
						}
						
					}	
					else
						System.out.println("Student Record Not Found");
					break;
				case 4:
					System.out.println("Enter Student ID ::");
					sid = Integer.parseInt(br.readLine());
					status = studentController.deleteById(sid);
					if(status.equalsIgnoreCase("success"))
					{
						System.out.println("Record Deleted Successful");
					}else if(status.equalsIgnoreCase("failure"))
					{
						System.out.println("Record Deletion Failed");
					}else
					{
						System.out.println("Record Not Found For This Id");
					}
					break;
				case 5:
					System.out.println("Thank You For Using Our Application");
					System.exit(0);
				default:
					System.out.println("Please Enter Correct Number");
					break;
				}
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
