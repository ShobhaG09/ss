package com.shobha.basic;
import java.util.Scanner;

import javax.swing.JPasswordField;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.shobha.basic.model.Admin;
import com.shobha.basic.service.AdminService;
import com.shobha.basic.validation.Validation;

public class AdminUserImpl implements AdminUser{

	private ApplicationContext applicationContext=SpringApplication.run(RestaurantManageApplication.class);
	private AdminService adminService=applicationContext.getBean(AdminService.class);
	private Admin admin=new Admin();
	private RestaurantManageApplication rest=new RestaurantManageApplication();
	private Scanner scanner=new Scanner(System.in);
	
	 public void login()
	 {
		 Integer choice=0;
		 Boolean x=true;
		 System.out.println("Enter Admin EmailId : ");
			String  emailId=scanner.next();
			if(adminService.findByAdminEmailId(emailId) != null)
			{
				admin=adminService.findByAdminEmailId(emailId);
				if(emailId.equals(admin.getEmailId()))
				{
					System.out.println("Enter PassWord :");
					String password=scanner.next();
					
					if(password.equals(admin.getPassword()))
					{
						
						System.out.println("Login SuccessFully !!!!");
						RestaurantManageApplication rest=new RestaurantManageApplication();
		
						Integer ch=0;
						do
						{
							System.out.println("--- Select Choice ---");
							System.out.println("Press 1 for Access Orders Details.");
							System.out.println("Press 2 for Access Staff Details.");
							System.out.println("Press 3 for Access MenuCard Details.");
							System.out.println("Press 4 for Exit.");
							System.out.println("Entet ur choice :");
							ch=scanner.nextInt();
							switch(ch)
							{
								case 1:rest.order();
									   break;
									
								case 2:rest.staff();
									   break;
									
								case 3:rest.Menu();
									   break;
									
								case 4:System.out.println("Exited.");
									   break;
										
								default : System.out.println("Choose Proper Input !!!!");
							}
							
							
						}while(ch!=4); 	
					}
					else
					{
						System.out.println("Password Does Not Exist ...");
						while(x)
						{
							System.out.println("\n");
							System.out.println("------ Login Issue ---------");
							System.out.println("\n");
							System.out.println("1.LogIn Again .");
							System.out.println("2.Reset Password.");
							System.out.println("3.Exit");
							System.out.println("----------------------------");
							System.out.println("Enter Choice :");
							
							choice=scanner.nextInt();
							switch(choice)
							{
							case 1: login();
								break;
								
							case 2:resetPassword();
							   break;
							   
							case 3:
								break;
								
							default : System.out.println(" Enter The Correct choice .");
							
							}
						}
					}
				}
				else {
					System.out.println("Enter Valid Email Id.");
				
				}
			}
			else
				System.out.println("Admin details Not Exist");
			
			
		} 
	 
	 public void resetPassword()
	 {
		String  emailId=null;
		Boolean  checkPassword = true;
		Boolean  checkEmail = true;
		Admin admin=new Admin();
		int count=0;
		while(checkEmail)
		{
		 System.out.println("Enter Your Mail Id :");
		   emailId=scanner.next();
		 if(adminService.findByAdminEmailId(emailId) != null)
			{
			 	admin.setEmailId(emailId);
				checkEmail=false;
				
			 Admin admin1=adminService.findByAdminEmailId(emailId);
			 
				if(admin1.getEmailId()!=null)
				{
					
					while(checkPassword)
					{
						System.out.print("\n------------------------------------------------------------"
								+ "-----------------------------------------------------------------------------------");
						System.out.println("\nSet password (Please use 6 or more characters with a "+"\n"
								+ "mix of at least 1 uppercase, 1 digit & 1 special "+"\n"
								+ "character like - Nediaz@123 or nediAz#123)");
						System.out.print("------------------------------------------------------------"
								+ "-----------------------------------------------------------------------------------\n\n");
						System.out.print("Enter The New Password : ");
						String password=scanner.next();
						if(Validation.checkPassword(password))
						{
							admin.setPassword(password);
							
							
							adminService.updateAdmin(admin);
							checkPassword=false;
							System.out.println("Password is Reset Successfully ! Please Go to Login Page .");
							
						}
						else
							System.out.println("Enter Valid Password..");

					}
				}
				
				else
				{
					System.out.print("\n-----------------------------");
					System.out.println("\nIncorrect Id...");
					System.out.print("-----------------------------\n\n");
					count++;
				}
				if(count==3)
				{
					System.out.println("---------------------------");
					System.out.println("You Cannot Try AnyMore ");
					System.out.println("---------------------------\n\n");
					System.exit(0);
				}
				
			}
		 else {
			 System.out.println("This Email Id is not valid for AdminLogin ");
			 count++;
		 }

			if(count==3)
			{
				System.out.println("---------------------------");
				System.out.println("You Cannot Try AnyMore ");
				System.out.println("---------------------------\n\n");
				System.exit(0);
			}
		 
	 }
	
}

//	@Override
//	public void adminLogin() {
//		
//		Integer choice=0;
//		Scanner scanner=new Scanner(System.in);
//		Integer ch=0;
//		do
//		{
//			System.out.println("--- Select Choice ---");
//			System.out.println("Press 1 for Admin Login");
//			System.out.println("Press 2 for Reset Password.");
//			System.out.println("Press 3 for Back.");
//			System.out.println("Entet ur choice :");
//			ch=scanner.nextInt();
//			switch(ch)
//			{
//			case 1:login();
//				   break;
//				
//			case 2:resetPassword();
//				   break;
//				
//			
//			case 3 :System.out.println("Exited.");
//				break;
//					
//					
//			default : System.out.println("Choose Proper Input !!!!");
//			}
//			
//			
//		}while(ch!=3); 
//	}

	

	

}
