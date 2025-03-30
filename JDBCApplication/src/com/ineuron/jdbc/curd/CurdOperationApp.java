package com.ineuron.jdbc.curd;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CurdOperationApp {

	public static void main(String[] args) throws SQLException 
	{
		Scanner scanner =null;
		System.out.println("*****!!==========!!..WELCOMES YOU..!!==========!!*****");
		System.out.println("       ========================================       ");
		System.out.println("             =============================            ");
		char ch='y';
		while(ch =='y' || ch=='Y')
		{
			 scanner = new Scanner(System.in);
			int choice = 0;
			try{
				System.out.println("Select the option for CURD Operation: ");
				System.out.println("Select operation          : : 1");
				System.out.println("Insert operation          : : 2");
				System.out.println("Delete operation          : : 3");
				System.out.println("Update operation          : : 4");
				System.out.println("Exit from the application : : 5");
				choice = scanner.nextInt();
			}catch(InputMismatchException ime)
			{
				System.out.println("Enter the right option...");
				CurdOperationApp.main(args);
			}
			switch(choice)
			{
				case 1:
					SelectOperation.selectOperation();
					break;
				case 2:
					InsertOperation.insertOperation();
					SelectOperation.selectOperation();
					break;
				case 3:
					SelectOperation.selectOperation();
					DeleteOperation.deleteOperation();
					break;
				case 4:
					SelectOperation.selectOperation();
					UpdateOperation.updateOperation();
					SelectOperation.selectOperation();
					break;
				case 5:
					System.out.println("========Thank you========");
					System.exit(0);
					break;
				default:
					System.out.println("Please choice the right option...");
					break;
			}
			
			System.out.println("If want to continue type 'y' or type anything to exit.");
			ch = scanner.next().charAt(0);
		}
		System.out.println("=========Thank you========");
		if(scanner != null)
		{
			scanner.close();
		}
	}
}
