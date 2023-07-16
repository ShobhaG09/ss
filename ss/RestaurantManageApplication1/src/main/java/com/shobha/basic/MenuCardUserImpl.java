package com.shobha.basic;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.shobha.basic.model.MenuCard;
import com.shobha.basic.model.Staff;
import com.shobha.basic.service.MenuCardService;
import com.shobha.basic.validation.Validation;


public class MenuCardUserImpl implements MenuCardUser{

	private ApplicationContext applicationContext=SpringApplication.run(RestaurantManageApplication.class);
	private MenuCardService menuService=applicationContext.getBean(MenuCardService.class);
	private Scanner scanner=new Scanner(System.in);
	
	private String FoodName;
	private Double FoodPrice;
	private String FoodSpecifier;
	private Double stock;
	
	@Override
	public void addMenu() {
		Boolean flagFoodName=true;
		Boolean flagFoodSpecifier=true;
		MenuCard menuCard=new MenuCard();
		
		while(flagFoodName)
		{
		System.out.printf("Enter Menu_Food Name :");
		 FoodName=scanner.next();
		 if(Validation.checkValidName(FoodName))
		 {
			 menuCard.setFoodName(FoodName);
			 flagFoodName=false;
			 
			 while(flagFoodSpecifier)
			{
				System.out.printf("Enter Menu_Food  Specifier :");
				FoodSpecifier=scanner.next();
				if(Validation.checkValidName(FoodSpecifier))
				{
					menuCard.setFoodSpecifier(FoodSpecifier);
					flagFoodSpecifier=false;
						
					System.out.printf("Enter Menu_Food Price :");
					FoodPrice=scanner.nextDouble();
					menuCard.setFoodPrice(FoodPrice);
					
					
					
		
					System.out.println(menuService.addMenu(menuCard));
					
				}
				else
					System.err.println("Enter Valid Specifier Name . ");
			 }
		 }
		 else
			 System.out.println("Enter Valid Food Name .");
		}
		
	}

	@Override
	public void updateMenu() {
		System.out.println("Enter Menu Id :");
		Integer menuId=scanner.nextInt();
		MenuCard menucard=menuService.findMenuDetails(menuId);
		Boolean flagFoodName=true;
		Boolean flagFoodSpecifier=true;
		MenuCard menuCard=new MenuCard();
		if(menucard!=null)
		{
			while(flagFoodName)
			{
			System.out.printf("Enter Menu_Food Name :");
			 FoodName=scanner.next();
			 if(Validation.checkValidName(FoodName))
			 {
				 menucard.setFoodName(FoodName);
				 flagFoodName=false;
				 
				 while(flagFoodSpecifier)
				{
					System.out.printf("Enter Menu_Food  Specifier :");
					FoodSpecifier=scanner.next();
					if(Validation.checkValidName(FoodSpecifier))
					{
						menucard.setFoodSpecifier(FoodSpecifier);
						flagFoodSpecifier=false;
							
						System.out.printf("Enter Menu_Food Price :");
						FoodPrice=scanner.nextDouble();
						menucard.setFoodPrice(FoodPrice);
						
						
			
						System.out.println(menuService.updateMenu(menucard));
					}
					else
						System.err.println("Enter Valid Specifier Name . ");
				 }
			 }
			 else
				 System.out.println("Enter Valid Food Name .");
			}
		}
		else
			System.out.println("Record not Found..");
	}

	@Override
	public void updateMenuFoodName() {
		Boolean flagFoodName=true;
		
		System.out.printf("Enter Menu Id :");
		Integer menuId=scanner.nextInt();
		
		MenuCard menucard=menuService.findMenuDetails(menuId);
		
		if(menucard != null)
		{
			
			while(flagFoodName)
			{
				System.out.printf("Enter Menu Food Name : ");
				String foodName=scanner.next();
				if(Validation.checkValidName(foodName))
				{
					menucard.setFoodName(foodName);
					System.out.println(menuService.updateMenuName(foodName, menuId));
					flagFoodName=false;
				}
				else
				{
					System.out.println("--------------------------");
					System.out.println("Enter Proper Menu Food name");
					System.out.println("--------------------------");
				}
			}		
		}
		else
		{
			System.out.println("--------------------------");
			System.out.println("Menu Record Not Found.");
			System.out.println("--------------------------");
		}
		
	}

	@Override
	public void updateMenuFoodPrice() {
		
		
		
		System.out.printf("Enter Menu Id :");
		Integer menuId=scanner.nextInt();
		MenuCard menucard=menuService.findMenuDetails(menuId);
		if(menucard != null)
		{
			System.out.printf("Enter Menu Food Priice : ");
				Double foodPrice=scanner.nextDouble();
				
					menucard.setFoodPrice(foodPrice);
					System.out.println(menuService.updateMenuPrice(foodPrice, menuId));
					
				
					
		}
		else
		{
			System.out.println("--------------------------");
			System.out.println("Menu Record Not Found.");
			System.out.println("--------------------------");
		}
		
	}

	@Override
	public void updateMenuFoodSpecifier() {
		Boolean flagFoodSpecifier=true;
		Integer menuId=0;
		
		System.out.printf("Enter Menu Id :");
		menuId=scanner.nextInt();
		MenuCard menucard=menuService.findMenuDetails(menuId);
		if(menucard != null)
		{
			
			while(flagFoodSpecifier)
			{
				System.out.printf("Enter Menu Food Specifier Name : ");
				String FoodSpecifier=scanner.next();
				if(Validation.checkValidName(FoodSpecifier))
				{
					menucard.setFoodSpecifier(FoodSpecifier);
					System.out.println(menuService.updateMenuSpecifier(FoodSpecifier, menuId));
					flagFoodSpecifier=false;
				}
				else
				{
					System.out.println("---------------------------------------");
					System.out.println("Enter Proper Menu Food Specifier name");
					System.out.println("---------------------------------------");
				}
			}		
		}
		else
		{
			System.out.println("--------------------------");
			System.out.println("Menu Record Not Found.");
			System.out.println("--------------------------");
		}
		
		
	}
	

	
	@Override
	public void deleteMenu() {
		System.out.printf("Enter Menu Id :");
		Integer menuId=scanner.nextInt();
		MenuCard menucard=menuService.findMenuDetails(menuId);
		if(menucard!=null)
		{
			menuService.deleteMenu(menuId); 
		}
		else
			System.out.println("Record not Found..");
	}

	@Override
	public void findMenuDetailsById() {
		System.out.printf("Enter Menu Id :");
		Integer menuId=scanner.nextInt();
		MenuCard menucard=menuService.findMenuDetails(menuId);
		if(menucard!=null)
		{
			System.out.println("Menu Id :"+menucard.getMenuId()
							+"\n Menu Food Name :"+menucard.getFoodName()
							+"\n Menu Food Price : "+menucard.getFoodPrice()
							+"\n Food Specifier :"+ menucard.getFoodSpecifier());
			
		}
		else
			System.out.println("Record not Found..");
	}

	@Override
	public void displayMenu() {
		
		List<MenuCard> list=menuService.displayAllMenu();
		Iterator<MenuCard> itr=list.iterator();
		System.out.println("--------------------------------------------------");
		System.out.println("Menu Id\tFood Name\tFood Price\tFood Specifier ");
		System.out.println("--------------------------------------------------");
		while(itr.hasNext())
		{
			MenuCard menucard=itr.next();
			System.out.println(menucard.getMenuId()+"\t"+menucard.getFoodName()+"\t\t"+menucard.getFoodPrice()+"\t\t"+menucard.getFoodSpecifier());
			
		}
	}

	@Override
	public void findByFoodNameLike() {
		Boolean flagFoodName=true;
		while(flagFoodName)
		{
			System.out.printf("Enter Menu Food Name :");
			String FoodName=scanner.next();
		if(Validation.checkValidFName(FoodName))
		{
			flagFoodName=false;
			List<MenuCard> menucard1=menuService.findByFoodNameLike(FoodName);
			System.out.println("--------------------------");
			if(menucard1!=null)
			{
				menucard1.forEach(menucard->System.out.println("Menu Id :"+menucard.getMenuId()
								+"\n Menu Food Name :"+menucard.getFoodName()
								+"\n Menu Food Price : "+menucard.getFoodPrice()
								+"\n Food Specifier :"+ menucard.getFoodSpecifier()));
				System.out.println("--------------------------");
				
				
			}
			else
				System.out.println("Record not Found..");
			
			
		}
		else
			System.out.println("Enter Valid Food Name.");
		}
	}

	@Override
	public void findByFoodPrice() {
		
		List<MenuCard> menucard1=menuService.findByOrderByFoodPriceAsc();
		System.out.println("--------------------------");
		if(!menucard1.isEmpty())
		{
			
				menucard1.forEach(menucard->System.out.println("Menu Id :"+menucard.getMenuId()
							+"\n Menu Food Name :"+menucard.getFoodName()
							+"\n Menu Food Price : "+menucard.getFoodPrice()
							+"\n Food Specifier :"+ menucard.getFoodSpecifier()));
				System.out.println("--------------------------");
			
			
		}
		
	}

	

	@Override
	public void findByFoodSpecifier() {
		
		Boolean flagFoodSpecifier=true;
		while(flagFoodSpecifier)
		{
			System.out.printf("Enter Menu Food Name :");
			String foodSpecifier=scanner.next();
		if(Validation.checkValidFName(foodSpecifier))
		{
			
			List<MenuCard> menucard1=menuService.findByFoodSpecifier(foodSpecifier);
			System.out.println("--------------------------");
			if(menucard1!=null)
			{
				
				menucard1.forEach(menucard->System.out.println("Menu Id :"+menucard.getMenuId()
								+"\n Menu Food Name :"+menucard.getFoodName()
								+"\n Menu Food Price : "+menucard.getFoodPrice()
								+"\n Food Specifier :"+ menucard.getFoodSpecifier()));
				
				flagFoodSpecifier=false;
				System.out.println("--------------------------");
			}
			else
				System.out.println("Record not Found..");
			
			
		}
		else
			System.out.println("Enter Valid Food Name.");
		}
	}

	

	
}
