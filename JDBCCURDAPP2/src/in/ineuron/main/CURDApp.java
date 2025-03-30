package in.ineuron.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import in.ineuron.controller.IStudentController;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentControllerFactory;
public class CURDApp {

	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String status = "";
		IStudentController studentController = null;
		Student student = null;
		Integer id=null;
		try
		{
			while(true)
			{
				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.println("Please choose your options in b/w [1,2,3,4,5] ::");
				Integer option = Integer.parseInt(br.readLine());
				
				switch(option)
				{
					case 1: 
						System.out.println("Enter Your Name ::");
						String name = br.readLine();
						System.out.println("Enter Your Email :: ");
						String email = br.readLine();
						System.out.println("Enter Your City :: ");
						String city = br.readLine();
						System.out.println("Enter Your Country ::");
						String country = br.readLine();
						
						student = new Student();
						student.setName(name);
						student.setEmail(email);
						student.setCity(city);
						student.setCountry(country);
						studentController = StudentControllerFactory.getStudentController();
						status = studentController.save(student);
						if(status.equals("success"))
						{
							System.out.println("Record Inserted Successful");
						}else if(status.equals("failure")){
							System.out.println("Record Insertion Failed");
						}else
						{
							System.out.println("Oop's Sorry try again.");
						}
						break;
					case 2:
						System.out.println("Enter your ID ::");
						id = Integer.parseInt(br.readLine());
						student = new Student();
						student.setId(id);
						studentController = StudentControllerFactory.getStudentController();
						student = studentController.findById(id);
						if(student != null)
						{
							System.out.println(student);
						}else if(student == null){
							System.out.println("Record Not Found");
						}
						
						break;
					case 3: 
						break;
					case 4:
						System.out.println("Enter Id to delete ::");
						id = Integer.parseInt(br.readLine());
						studentController = StudentControllerFactory.getStudentController();
						status = studentController.deleteById(id);
						if(status.equals("success"))
							System.out.println("Record Delete Successful");
						else if(status.equals("failure"))
							System.out.println("Unable to delete");
						else
							System.out.println("Record Not Available");
						
						
						break;
					case 5:
						System.out.println("Thank You So Much For Use Our Application");
						System.exit(0);
					default:
						System.out.println("Please Enter Correct Number");
						break;
				}
				
			}
		}catch(Exception n)
		{
			n.printStackTrace();
			
		}
		
	}

}
