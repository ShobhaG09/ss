package com.shobha.basic;


import java.util.Scanner;


import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RestaurantManageApplication {

	void admin()
	{
		
	}
	void customer()
	{
		OrderUser orderUser=new OrderUserImpl();
		RestaurantManageApplication rest=new RestaurantManageApplication();
		Scanner scanner=new Scanner(System.in);
		Integer ch=0;
		do
		{
			System.out.println("--- Select Choice ---");
			System.out.println("Press 1 for Book Orders .");
			
			System.out.println("Press 2 for Exit.");
			System.out.println("Entet ur choice :");
			ch=scanner.nextInt();
			switch(ch)
			{
			case 1:
					orderUser.addRecord();
				break;
				
			
			case 2:
					System.out.println("Exited.");
					break;
					
			default : System.out.println("Choose Proper Input !!!!");
			}
			
			
		}while(ch!=2);
	}

	 void order() {
		OrderUser orderUser=new OrderUserImpl();
		Scanner scanner1=new Scanner(System.in);
		Integer choice=0;
		do
		{
			
			System.out.println("--- Select The Choice ---");
			System.out.println("Press 1 For Add Order .");
			System.out.println("Press 2 For Update Order.");
			System.out.println("Press 3 For Update Order by Customer Name.");
			System.out.println("Press 4 For Find Order Details By Id.");
			
			System.out.println("Press 5 For Display All Order Details.");
			System.out.println("Press 6 For Exit.");
			System.out.println("Enter Ur Choice.");
			choice=scanner1.nextInt();
			switch(choice)
			{
			case 1:orderUser.addRecord();
					break;
					
			case 2 : orderUser.updateRecord();
					break;

			case 3 : orderUser.updateCustomer();
			break;
			
			case 4 : orderUser.findById();
					break;
					
			case 5 : orderUser.displayAllRecords();
					break;

			case 6 :
					System.out.println("Exited.");
					break;
					
			default : System.out.println("Choose Proper Input !!!!");		
					
			}
			
			
		}while(choice!=6);
	}
	 void findStaff()
	 {
		 StaffUser staffUser=new StaffUserImpl();
		Scanner scanner=new Scanner(System.in);
		Integer option=0;
		do{
			System.out.println("-----------------------------------\n");
			System.out.println("------Find Staff Details-------");
			System.out.println("-----------------------------------\n");
			System.out.println("--- Select The Option ---");
			
			System.out.println("Press 1 for Find Staff Details By Id.");
			System.out.println("Press 2 for Find Staff Details By Name.");
			System.out.println("Press 3 for Find Staff Details By Department.");
			System.out.println("Press 4 for Find Staff Details By Contact Number.");
			System.out.println("Press 5 for Find Staff Details By EmailId.");
			System.out.println("Press 6 for Exit.");
			System.out.println("Entet ur choice :");
			option=scanner.nextInt();
			switch(option)
			{
			
				case 1 :staffUser.findStaffRecord();
						break;
						
				case 2 :staffUser.findByStaffNameLike();
						break;
				
				case 3 :staffUser.findByStaffDepartment();
						break;
				
				case 4 :staffUser.findByStaffContact();
						break;
				
				case 5 :staffUser.findByStaffEmailId();
						break;
						
				case 6 :System.out.println("Exited.");
						break;
						
						
				default : System.out.println("Choose Proper Input !!!!");
				
			}
			
			
		}while(option!=6);
	 }
	 void updateSatff()
	 {
		 StaffUser staffUser=new StaffUserImpl();
		Scanner scanner=new Scanner(System.in);
		Integer option=0;
		do{
			System.out.println("-----------------------------------");
			System.out.println("--- Update Staff Details ---");
			System.out.println("-----------------------------------\n");
			System.out.println("--- Select The Option ---");
			
			System.out.println("Press 1 for Update Staff Details By Id.");
			System.out.println("Press 2 for Update Staff Details By Name.");
			System.out.println("Press 3 for Update Staff Details By Department.");
			System.out.println("Press 4 for Update Staff Details By Contact Number.");
			System.out.println("Press 5 for Update Staff Details By EmailId.");
			System.out.println("Press 6 for Update Staff Details By Salary.");
			System.out.println("Press 7 for Update Staff Details By Gender.");
			System.out.println("Press 8 for Exit.");
			System.out.println("Entet ur choice :");
			option=scanner.nextInt();
			switch(option)
			{
			
				case 1 :staffUser.modifyStaffRecord();
						break;
						
				case 2 :staffUser.updateStaffByName();
						break;
				
				case 3 :staffUser.updateStaffDepartment();
						break;
				
				case 4 :staffUser.updateStaffByContact();
						break;
				
				case 5 :staffUser.updateStaffEmailId();
						break;
						
				case 6 :staffUser.updateStaffSalary();
						break;
				
				case 7 :staffUser.updateStaffGender();
						break;
				
				case 8 :System.out.println("Exited.");
						break;
						
						
				default : System.out.println("Choose Proper Input !!!!");
				
			}
		}while(option!=8);
	 }
	 void staff()
	{
		StaffUser staffUser=new StaffUserImpl();
		Scanner scanner=new Scanner(System.in);
		Integer option=0;
		do{
			System.out.println("--- Select The Option ---");
			System.out.println("Press 1 for Add Staff Details .");
			System.out.println("Press 2 for Update Staff Details.");
			System.out.println("Press 3 for Find Staff Details");
			System.out.println("Press 4 for display All Staff Records.");
			System.out.println("Press 5 for Exit.");
			System.out.println("Entet ur choice :");
			option=scanner.nextInt();
			switch(option)
			{
				case 1:staffUser.addStaffRecord();
						break;
						
				case 2:updateSatff();
						break;
						
				case 3 : findStaff();
						break;

				case 4 :staffUser.displayAllStaffRecord();
					break;
					
				case 5 :
				break;	
						
				default : System.out.println("Choose Proper Input !!!!");
				
			}
			
			
		}while(option!=5);
		
	}
	
	 void findMenu()
	 {
		 MenuCardUser menu=new MenuCardUserImpl();
			Scanner scanner=new Scanner(System.in);
			Integer option=0;
			do{
				System.out.println("--- Select The Option ---");
				
				System.out.println("Press 1 for Find Menu Card Details By Id.");
				System.out.println("Press 2 for Find Menu Card Details By Food Name.");
				System.out.println("Press 3 for Find Menu Card Details By Food Price.");
				System.out.println("Press 4 for Find Menu Card Details By Food Specifier.");
				System.out.println("Press 5 for Exit.");
				System.out.println("Entet ur choice :");
				option=scanner.nextInt();
				switch(option)
				{
					
					case 1 : menu.findMenuDetailsById();
							break;
							
					case 2:menu.findByFoodNameLike();
							break;
							
					case 3:menu. findByFoodPrice();
							break;
					
					case 4:menu.findByFoodSpecifier();
							
							break;
							
					case 5:
						System.out.println("Exited.");
						break;
							
					default : System.out.println("Choose Proper Input !!!!");
					
				}
				
				
			}while(option!=5);
	 }
	 void updateMenu()
	 {
		 MenuCardUser menu=new MenuCardUserImpl();
			Scanner scanner=new Scanner(System.in);
			Integer option=0;
			do{
				System.out.println("--- Select The Option ---");
				
				System.out.println("Press 1 for Update Menu Card Details By Id.");
				System.out.println("Press 2 for Update Menu Card Details By Food Name.");
				System.out.println("Press 3 for Update Menu Card Details By Food Price.");
				System.out.println("Press 4 for Update Menu Card Details By Food specifier Name.");
				System.out.println("Press 5 for Exit.");
				System.out.println("Entet ur choice :");
				option=scanner.nextInt();
				switch(option)
				{
					
					case 1 : menu.updateMenu();
							break;
							
					case 2:menu.updateMenuFoodName();
							break;
							
					case 3:menu.updateMenuFoodPrice();
							break;
					
					case 4:menu.updateMenuFoodSpecifier();
							break;
							
					case 5:
							System.out.println("Exited.");
							break;
							
					default : System.out.println("Choose Proper Input !!!!");
					
				}
				
				
			}while(option!=4);
	 }
	 void Menu()
	 {
		 MenuCardUser menu=new MenuCardUserImpl();
			Scanner scanner=new Scanner(System.in);
			Integer option=0;
			do{
				System.out.println("--- Select The Option ---");
				System.out.println("Press 1 for Add Menu Card Details .");
				System.out.println("Press 2 for Update Menu Card Details.");
				System.out.println("Press 3 for Delete Menu Card Details.");
				System.out.println("Press 4 for Find Menu Card Details.");
				System.out.println("Press 5 for display All Menu Card Records.");
				System.out.println("Press 6 for Exit.");
				System.out.println("Entet ur choice :");
				option=scanner.nextInt();
				switch(option)
				{
					case 1:menu.addMenu();
							break;
							
					case 2:updateMenu();
							break;
							
					case 3:menu.deleteMenu();
							break;
							
					case 4:findMenu();
					break;
					case 5:menu.displayMenu();
							break;
					case 6:
							System.out.println("Exited.");
							break;
							
					default : System.out.println("Choose Proper Input !!!!");
					
				}
				
				
			}while(option!=6);
			
	 }
	public static void main(String[] args) {
		
		RestaurantManageApplication rest=new RestaurantManageApplication();
		AdminUserImpl adminUserImpl=new AdminUserImpl();
		//System.out.println("-------------------------- Restaurant Management System  --------------------------");
		//System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("-------------------------- WELLCOME TO RESTAURANT --------------------------");
		Scanner scanner=new Scanner(System.in);
		Integer ch=0;
		do
		{
			System.out.println("--- Select Choice ---");
			System.out.println("Press 1 for Admin Panel");
			System.out.println("Press 2 for Customer Panel.");
			System.out.println("Press 3 for Exit.");
			System.out.println("Entet ur choice :");
			ch=scanner.nextInt();
			switch(ch)
			{
			case 1:adminUserImpl.login();
					break;
				
			case 2:rest.customer();
					break;
				
			
			case 3 :System.exit(0);
					System.out.println("Exited.");
					
			default : System.out.println("Choose Proper Input !!!!");
			}
			
			
		}while(ch!=3); 
	}
}
