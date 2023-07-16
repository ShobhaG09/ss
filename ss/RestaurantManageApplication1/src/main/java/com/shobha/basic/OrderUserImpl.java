package com.shobha.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import com.shobha.basic.model.Food;
import com.shobha.basic.model.MenuCard;
import com.shobha.basic.model.Order1;
import com.shobha.basic.service.MenuCardService;
import com.shobha.basic.service.OrderService;
import com.shobha.basic.validation.Validation;


public class OrderUserImpl implements OrderUser{

	private ApplicationContext applicationContext=SpringApplication.run(RestaurantManageApplication.class);
	private OrderService orderService=applicationContext.getBean(OrderService.class);
	private MenuCardService menuService=applicationContext.getBean(MenuCardService.class);
	private Scanner scanner=new Scanner(System.in);
	private MenuCardUser menu=new MenuCardUserImpl();
	private MenuCard menuCard=new MenuCard();
	MenuCard searchMenu;
	private Date orderdate=new Date();
	@Override
	public void addRecord() {
		Double foodPrice;
		Double totalBill=0.0;
		Integer quantity;
		Date  orderDate;
		//Boolean flagFoodName=true;
		Character choice;
		String customerName;
		Order1 order=new Order1();
		String foodName;
		Double stock=null ;
		menu.displayMenu();
		
		System.out.println("Do you want order by your Name ?\n Enter y | Y to continue");
		choice = scanner.next().charAt(0);
		if(choice=='y' || choice=='Y')
		{
			System.out.println("Enter Your  Name");
			customerName = scanner.next();
			order.setCustomerName(customerName);
		}
		else
		{
			order.setCustomerName("GuestUser");
		}

		SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/yyyy");
		orderdate.getDate();
		
		List<Food> food=new ArrayList<>();
		
		System.out.println("Enter The Food Details :");
		System.out.println("----------------------------------");
	while(true)
			{
					System.out.println("Enter Quantity Per Head :");
					 quantity=scanner.nextInt();
					
					 
					System.out.println("Enter Menu Id :");
					Integer menuId=scanner.nextInt();
					searchMenu = menuService.findMenuDetails(menuId);
					if(searchMenu!= null)
					{
						Food food1=new Food();
						food1.setFoodName(searchMenu.getFoodName());
						food1.setFoodPrice(searchMenu.getFoodPrice());
						food1.setFoodQuantity(quantity);
						
							food.add(food1);
							
							totalBill=(totalBill+(food1.getFoodPrice()*food1.getFoodQuantity()));
							
							System.out.println("Do u want To Add More Food :");
							Character choice1=scanner.next().charAt(0);
							if(choice1=='n' || choice1=='N') {
								break;
								
							}
					}
					else
						System.out.println("Menu Not Exist!!");
			 }
	
		
		order.setOrderdate(orderdate);
		order.setTotalBill(totalBill);
		
		
		 
		order.setFood(food);
		System.out.println(orderService.addOrder(order));
		
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                  Invoice Bill Generation                          \n ");
		System.out.println("OrderId : "+order.getOrderId() +"\nOrder Date :"+order.getOrderdate()+"\n Customer Name :"+order.getCustomerName());
		System.out.println("\n===========================================================================");
		System.out.println(" Food Name\tQuantity\tPrice\tAmount  ");
		List<Food> add=order.getFood();
		System.out.println("===========================================================================");
		add.forEach(food1-> System.out.println(food1.getFoodName()+"\t\t"+food1.getFoodQuantity()+"\t\t"+food1.getFoodPrice()+"\t"+(food1.getFoodPrice()*food1.getFoodQuantity())));
		System.out.println("===========================================================================");
		System.out.println("\n      Total Bill Is      "+totalBill);
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("\n<----- Amount Received From Customer = "+totalBill+"----->");
		System.out.println("\n...Thank You Visit Again ...");
		
		
	}

	@Override
	public void updateRecord() {
		Double foodPrice;
		Double totalBill=0.0;
		Integer quantity=null;
		Date  orderDate = null;
		Double amount=0.0;
		Boolean flagFoodName=true;
		Character choice;
		String customerName;
		Boolean flag=false;
		List<Food> food=new ArrayList<>();
		System.out.println("Enter the OrderId : ");
		Integer orderId=scanner.nextInt();
		Order1 order=orderService.findOrderDetail(orderId);
		if(order != null)
		{
			menu.displayMenu();
			System.out.println("Do you want order by your Name ?\n Enter y | Y to continue");
			choice = scanner.next().charAt(0);
			if(choice=='y' || choice=='Y')
			{
				System.out.println("Enter Your  Name");
				customerName = scanner.next();
				order.setCustomerName(customerName);
			}
			else
			{
				order.setCustomerName("GuestUser");
			}

			SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/yyyy");
			orderdate.getDate();
		
			System.out.println("Enter The Food Details :");
			System.out.println("----------------------------------");
		while(true)
				{
						System.out.println("Enter Quantity Per Head :");
						 quantity=scanner.nextInt();
						
						 
						System.out.println("Enter Menu Id :");
						Integer menuId=scanner.nextInt();
						searchMenu = menuService.findMenuDetails(menuId);
						if(searchMenu!= null)
						{
							Food food1=new Food();
							food1.setFoodName(searchMenu.getFoodName());
							food1.setFoodPrice(searchMenu.getFoodPrice());
							food1.setFoodQuantity(quantity);

								food.add(food1);
								
								totalBill=(totalBill+(food1.getFoodPrice()*food1.getFoodQuantity()));
								
								System.out.println("Do u want To Add More Food :");
								Character choice1=scanner.next().charAt(0);
								if(choice1=='n' || choice1=='N') {
									break;
									
								}
						}
						else
							System.out.println("Menu Not Exist!!");
				 }
		
			
			
			
		}
		order.setOrderdate(orderdate);
		order.setTotalBill(totalBill);
	order.setOrderId(orderId);
		 
		order.setFood(food);
		System.out.println(orderService.updateOrder(order));
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                  Invoice Bill Generation                          \n ");
		System.out.println("OrderId : "+order.getOrderId() +"\nOrder Date :"+order.getOrderdate()+"\n Customer Name :"+order.getCustomerName());
		System.out.println("\n===========================================================================");
		System.out.println(" Food Name \t Quantity \t Price \t Amount  ");
		List<Food> add=order.getFood();
		System.out.println("===========================================================================");
		add.forEach(food1-> System.out.println(food1.getFoodName()+"\t\t\t"+food1.getFoodQuantity()+"\t"+food1.getFoodPrice()+"\t"+(food1.getFoodPrice()*food1.getFoodQuantity())));
		System.out.println("===========================================================================");
		System.out.println("\n      Total Bill Is      "+totalBill);
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("\n<----- Amount Received From Customer = "+totalBill+"----->");
		System.out.println("\n...Thank You Visit Again ...");
	}

	@Override
	public void updateCustomer() {
		Boolean flagCustomerName=true;
		Integer orderId=0;
		
		System.out.println("Enter Order Id :");
		orderId=scanner.nextInt();
		Order1 order=orderService.findOrderDetail(orderId);
		if(order != null)
		{
			
			while(flagCustomerName)
			{
				System.out.println("Enter Customer Name : ");
				String customerName=scanner.next();
				if(Validation.checkValidName(customerName))
				{
					order.setCustomerName(customerName);
					System.out.println(orderService.updateCustomerName(customerName, orderId));
					flagCustomerName=false;
				}
				else
				{
					System.out.println("--------------------------");
					System.out.println("Enter Proper customer name");
					System.out.println("--------------------------");
				}
			}		
		}
		else
		{
			System.out.println("--------------------------");
			System.out.println("Order Record Not Found.");
			System.out.println("--------------------------");
		}
		
	}
	
	@Override
	public void deleteRecord() {
		
		System.out.println("Enter The Order Id : ");
		Integer orderId = scanner.nextInt();
		Order1 order=orderService.findOrderDetail(orderId);
		if(order != null)
		{
			System.out.println(orderService.deleteOrder(orderId));
			
		}
		else
			System.out.println("Employee Object Not Found...");
	}

	@Override
	public void findById() {
		System.out.println("Enter Order ID :");
		Integer orderId=scanner.nextInt();
		Order1 order=orderService.findOrderDetail(orderId);
		if(order != null)
		{
			System.out.println("Order ID Is :"+order.getOrderId());
			
			System.out.println("Order Date Is :"+order.getOrderdate());
			System.out.println("Customer Name :"+order.getCustomerName());
			
			List<Food> add=order.getFood();
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("Food Id\t\tFood Quantity \t\tFood Name\t\tFood Price\t\tAmount ");
			System.out.println("--------------------------------------------------------------------------------------");
			add.forEach(food -> System.out.println(food.getFoodId()+"\t\t"+food.getFoodQuantity()+"\t\t\t"+food.getFoodName()+"\t\t\t"+food.getFoodPrice()+"\t\t\t"+(food.getFoodPrice()*food.getFoodQuantity())));
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("Total Bill -> "+order.getTotalBill());
		}
		
	}

	@Override
	public void displayAllRecords() 
	{
		List<Order1> list=orderService.displayAllOrderDetails();
		Iterator<Order1> itr=list.iterator();

		while(itr.hasNext())
		{
			Order1 order1=itr.next();
			List<Food> add=order1.getFood();
			System.out.println("OrderId : "+order1.getOrderId()
								
								+"\n order Date :"+order1.getOrderdate()
								+"\nCustomer Name :"+order1.getCustomerName());
			
			System.out.println("-------------------------------------------------------------------------------------------------------------------");
			System.out.println("Food Id\t\tFood Quantity\t\tFood Name\t\tFood Price\t\tAmount ");
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
			add.forEach(food -> System.out.println(food.getFoodId()+"\t\t"+food.getFoodQuantity()+"\t\t"+food.getFoodName()+"\t\t\t"+food.getFoodPrice()+"\t\t\t"+(food.getFoodPrice()*food.getFoodQuantity())));
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
			System.out.println("Total Bill -> "+order1.getTotalBill());
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
			System.out.println("\n\n");
		}
		
	}

	@Override
	public void updateStock() {
		
		
	}

	



	

}
