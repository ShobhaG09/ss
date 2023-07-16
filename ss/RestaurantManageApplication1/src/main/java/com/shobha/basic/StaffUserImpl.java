package com.shobha.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.shobha.basic.model.Address;
import com.shobha.basic.model.Staff;
import com.shobha.basic.service.StaffService;
import com.shobha.basic.validation.Validation;

public class StaffUserImpl implements StaffUser
{

	private ApplicationContext applicationContext=SpringApplication.run(RestaurantManageApplication.class);
	private StaffService staffService=applicationContext.getBean(StaffService.class);
	private Scanner scanner=new Scanner(System.in);
	
	private String staffName;
	private Date Doj;
	private String staffContact;
	private String staffDepartment;
	private Double staffSalary;
	private String staffGender;
	private String staffEmailId;
	
	@Override
	public void addStaffRecord() 
	{
		Boolean flagStaffName=true;
		Boolean flagStaffDoj=true;
		Boolean flagContact=true;
		Boolean flagDept=true;
		Boolean flagSalary=true;
		Boolean flagGender=true;
		Boolean flagEmail=true;
		
		Staff staff=new Staff();
		
		System.out.println("Enter Staff Joineing Date :");
		SimpleDateFormat sdf= new SimpleDateFormat("mm/dd/yyyy");
		 Doj=null;
		try {
			Doj = sdf.parse(scanner.next());
		} catch (ParseException e){
			e.printStackTrace();
		}
		staff.setDoj(Doj);
		
		while(flagStaffName)
		{
			System.out.println("Enter Staff Employee Name : ");
			 staffName=scanner.next();
			if(Validation.checkValidName(staffName))
			{
				staff.setStaffName(staffName);
				flagStaffName=false;
				
				while(flagContact)
				{
					System.out.println("Enter Staff Contact number :");
					staffContact=scanner.next();
					if(Validation.checkMobileNumber(staffContact))
					{
						staff.setStaffContact(staffContact);
						flagContact=false;
						
						while(flagSalary)
						{
							System.out.println("Enter Staff Salary :");
							staffSalary=scanner.nextDouble();
							if(Validation.checkSalary(staffSalary))
							{
								staff.setStaffSalary(staffSalary);
								flagSalary=false;
								while(flagGender)
								{
									System.out.println("Enter Staff gender : ");
									staffGender=scanner.next();
									if(Validation.checkGender(staffGender))
									{
										staff.setStaffGender(staffGender);
										flagGender=false;
										while(flagEmail)
										{
											System.out.println("Enter Staff Email Id :");
											staffEmailId=scanner.next();
											if(Validation.checkEmail(staffEmailId))
											{
												staff.setStaffEmailId(staffEmailId);
												flagEmail=false;
												while(flagDept)
												{
													System.out.println("Assign Staff Department : ");
													staffDepartment=scanner.next();
													if(Validation.checkValidName(staffDepartment))
													{
														staff.setStaffDepartment(staffDepartment);
														flagDept=false;
														
														List<Address> listAddress=new ArrayList<>();
														System.out.println("Enter The Address Details:");
														System.out.println("----------------------------------------");
														while(true)
														{
															System.out.println("Enter The House No : ");
															String houseNo=scanner.next();
															System.out.println("Enter The House Name :");
															String houseName=scanner.next();
															System.out.println("Enter The Pincode :");
															String pinCode=scanner.next();
															System.out.println("Enter The City : ");
															String city = scanner.next();
															
															Address address= new Address();
															address.setHouseNo(houseNo);
															address.setHouseName(houseName);
															address.setPinCode(pinCode);
															address.setCity(city);
															listAddress.add(address);
															
															System.out.println("Do u Want To Add More Address Y|N : ");
															Character choice=scanner.next().charAt(0);
															if(choice=='n' || choice=='N') {
																break;
																
															}
															
														}
														staff.setStaffAddress(listAddress);
														System.out.println(staffService.addStaff(staff));
													}
													else
														System.out.println("Enter Valid Staff Department.");
												}
											}
											else
												System.out.println("Enter Valid Email Id .");
											
										}
									}
									else
										System.out.println("Enter Valid Gender Type. ");
									
								}
								
							}
							else
								System.out.println("Enter Proper Salary . It Should Be in Number Format Only .");
						}
					}
					else
						System.out.println("Enter Valid Contact Number ");
				}
			}
			else
				System.out.println("Enter Valid Staff Name.");
			}
		}
		
	

	@Override
	public void modifyStaffRecord() 
	{
		Boolean flagStaffName=true;
		Boolean flagStaffDoj=true;
		Boolean flagContact=true;
		Boolean flagDept=true;
		Boolean flagSalary=true;
		Boolean flagGender=true;
		Boolean flagEmail=true;
		System.out.println("Enter Staff Id :");
		Integer staffId=scanner.nextInt();
		Staff staff=staffService.findStaffRecord(staffId);
		if(staff != null)
			{
			System.out.println("Enter Staff Joineing Date :");
			SimpleDateFormat sdf= new SimpleDateFormat("mm/dd/yyyy");
			Date Doj=null;
			try {
				Doj = sdf.parse(scanner.next());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			staff.setDoj(Doj);
			while(flagStaffName)
			{
				System.out.println("Enter Staff Employee Name : ");
				 staffName=scanner.next();
				if(Validation.checkValidName(staffName))
				{
					staff.setStaffName(staffName);
					flagStaffName=false;
					
					while(flagContact)
					{
						System.out.println("Enter Staff Contact number :");
						staffContact=scanner.next();
						if(Validation.checkMobileNumber(staffContact))
						{
							staff.setStaffContact(staffContact);
							flagContact=false;
							
							while(flagSalary)
							{
								System.out.println("Enter Staff Salary :");
								staffSalary=scanner.nextDouble();
								if(Validation.checkSalary(staffSalary))
								{
									staff.setStaffSalary(staffSalary);
									flagSalary=false;
									while(flagGender)
									{
										System.out.println("Enter Staff gender : ");
										staffGender=scanner.next();
										if(Validation.checkGender(staffGender))
										{
											staff.setStaffGender(staffGender);
											flagGender=false;
											while(flagEmail)
											{
												System.out.println("Enter Staff Email Id :");
												staffEmailId=scanner.next();
												if(Validation.checkEmail(staffEmailId))
												{
													staff.setStaffEmailId(staffEmailId);
													flagEmail=false;
													while(flagDept)
													{
														System.out.println("Assign Staff Department : ");
														staffDepartment=scanner.next();
														if(Validation.checkValidName(staffDepartment))
														{
															staff.setStaffDepartment(staffDepartment);
															flagDept=false;
															
															List<Address> listAddress=new ArrayList<>();
															System.out.println("Enter The Address Details:");
															System.out.println("----------------------------------------");
															while(true)
															{
																System.out.println("Enter The House No : ");
																String houseNo=scanner.next();
																System.out.println("Enter The House Name :");
																String houseName=scanner.next();
																System.out.println("Enter The Pincode :");
																String pinCode=scanner.next();
																System.out.println("Enter The City : ");
																String city = scanner.next();
																
																Address address= new Address();
																address.setHouseNo(houseNo);
																address.setHouseName(houseName);
																address.setPinCode(pinCode);
																address.setCity(city);
																listAddress.add(address);
																
																System.out.println("Do u Want To Add More Address Y|N : ");
																Character choice=scanner.next().charAt(0);
																if(choice=='n' || choice=='N') {
																	break;
																	
																}
															}
															staff.setStaffAddress(listAddress);
															System.out.println(staffService.updateStaff(staff));
														
														}
														else
															System.out.println("Enter Valid Staff Department.");
													}
												}
												else
													System.out.println("Enter Valid Email Id .");
												
											}
										}
										else
											System.out.println("Enter Valid Gender Type. ");
										
									}
									
								}
								else
									System.out.println("Enter Proper Salary . It Should Be in Number Format Only .");
							}
						}
						else
							System.out.println("Enter Proper Contact Number ");
					}
				}
				else
					System.out.println("Enter Valid Staff Name.");
				}
					
			}		
				
	}
	@Override
	public void updateStaffByName() {
		
		System.out.println("Enter Staff Id :");
		Integer staffId=scanner.nextInt();
		Staff staff=staffService.findStaffRecord(staffId);
		if(staff != null)
		{
			Boolean flagStaffName=true;
			while(flagStaffName)
			{
				System.out.println("Enter Staff Employee Name : ");
				 staffName=scanner.next();
				if(Validation.checkValidName(staffName))
				{
					staff.setStaffName(staffName);
					System.out.println(staffService.updateStaffByName(staffName,staffId));
					flagStaffName=false;
				}
				else
				{
					System.out.println("--------------------------");
					System.out.println("Enter Proper Staff name");
					System.out.println("--------------------------");
				}
			}		
		}
		else
		{
			System.out.println("--------------------------");
			System.out.println("Staff Record Not Found.");
			System.out.println("--------------------------");
		}
	}



	@Override
	public void updateStaffByContact() {
		
		System.out.println("Enter Staff Id :");
		Integer staffId=scanner.nextInt();
		Staff staff=staffService.findStaffRecord(staffId);
		if(staff != null)
		{
			Boolean flagStaffContactNo=true;
			while(flagStaffContactNo)
			{
				System.out.println("Enter Staff Contact Number : ");
				staffContact=scanner.next();
				if(Validation.checkMobileNumber(staffContact))
				{
					staff.setStaffContact(staffContact);
					System.out.println(staffService.updateStaffByContact(staffContact,staffId));
					flagStaffContactNo=false;
				}
				else
				{
					System.out.println("--------------------------");
					System.out.println("Enter Proper Staff Contact Number.");
					System.out.println("--------------------------");
				}
			}		
		}
		else
		{
			System.out.println("--------------------------");
			System.out.println("Staff Record Not Found.");
			System.out.println("--------------------------");
		}
	}



	@Override
	public void updateStaffDepartment() {
		System.out.println("Enter Staff Id :");
		Integer staffId=scanner.nextInt();
		Staff staff=staffService.findStaffRecord(staffId);
		if(staff != null)
		{
			Boolean flagStaffDept=true;
			while(flagStaffDept)
			{
				System.out.println("Enter Staff Department : ");
				staffDepartment=scanner.next();
				if(Validation.checkValidName(staffDepartment))
				{
					staff.setStaffDepartment(staffDepartment);
					System.out.println(staffService.updateStaffDepartment(staffDepartment,staffId));
					flagStaffDept=false;
				}
				else
				{
					System.out.println("--------------------------");
					System.out.println("Enter Proper Staff Department.");
					System.out.println("--------------------------");
				}
			}		
		}
		else
		{
			System.out.println("--------------------------");
			System.out.println("Staff Record Not Found.");
			System.out.println("--------------------------");
		}
	}



	@Override
	public void updateStaffEmailId() {
		System.out.println("Enter Staff Id :");
		Integer staffId=scanner.nextInt();
		Staff staff=staffService.findStaffRecord(staffId);
		if(staff != null)
		{
			Boolean flagStaffEmailId=true;
			while(flagStaffEmailId)
			{
				System.out.println("Enter Staff Email Id : ");
				staffEmailId=scanner.next();
				if(Validation.checkEmail(staffEmailId))
				{
					staff.setStaffDepartment(staffEmailId);
					System.out.println(staffService.updateStaffEmailId(staffEmailId,staffId));
					flagStaffEmailId=false;
				}
				else
				{
					System.out.println("--------------------------");
					System.out.println("Enter Proper Staff Mail Id.");
					System.out.println("--------------------------");
				}
			}		
		}
		else
		{
			System.out.println("--------------------------");
			System.out.println("Staff Record Not Found.");
			System.out.println("--------------------------");
		}
	}



	@Override
	public void updateStaffGender() {
		System.out.println("Enter Staff Id :");
		Integer staffId=scanner.nextInt();
		Staff staff=staffService.findStaffRecord(staffId);
		if(staff != null)
		{
			Boolean flagStaffGender=true;
			while(flagStaffGender)
			{
				System.out.println("Enter Staff Gender : ");
				staffGender=scanner.next();
				if(Validation.checkGender(staffGender))
				{
					staff.setStaffDepartment(staffGender);
					System.out.println(staffService.updateStaffGender(staffGender,staffId));
					flagStaffGender=false;
				}
				else
				{
					System.out.println("--------------------------");
					System.out.println("Enter Proper Staff Gender.");
					System.out.println("--------------------------");
				}
			}		
		}
		else
		{
			System.out.println("--------------------------");
			System.out.println("Staff Record Not Found.");
			System.out.println("--------------------------");
		}
	}



	@Override
	public void updateStaffSalary() {
		System.out.println("Enter Staff Id :");
		Integer staffId=scanner.nextInt();
		Staff staff=staffService.findStaffRecord(staffId);
		if(staff != null)
		{
			Boolean flagStaffSalary=true;
			while(flagStaffSalary)
			{
				System.out.println("Enter Staff Salary : ");
				staffSalary=scanner.nextDouble();
				if(Validation.checkSalary(staffSalary))
				{
					staff.setStaffSalary(staffSalary);
					System.out.println(staffService.updateStaffSalary(staffSalary,staffId));
					flagStaffSalary=false;
				}
				else
				{
					System.out.println("--------------------------");
					System.out.println("Enter Proper Staff Gender.");
					System.out.println("--------------------------");
				}
			}		
		}
		else
		{
			System.out.println("--------------------------");
			System.out.println("Staff Record Not Found.");
			System.out.println("--------------------------");
		}
	}
//
//	@Override
//	public void deleteStaffRecord() 
//	{
//		System.out.println("Enter Staff Id :");
//		Integer staffId=scanner.nextInt();
//		Staff staff=staffService.findStaffRecord(staffId);
//		if(staff != null)
//		{
//			staffService.deleteStaff(staffId);
//		}
//		else
//			System.out.println("Record Not Found");
//		
//	}

	@Override
	public void findStaffRecord() 
	{
		System.out.println("Enter Staff Id :");
		Integer staffId=scanner.nextInt();
		Staff staff=staffService.findStaffRecord(staffId);
		if(staff != null)
		{
			System.out.println("Staff Id Is :"+staff.getStaffId()
								+"\n Staff Name Is :"+staff.getStaffName()
								+"\n Staff Joining Date Is :"+staff.getDoj()
								+"\n Staff Contact Number Is :"+staff.getStaffContact()
								+"\n Staff Salary is :"+staff.getStaffSalary()
								+"\n Staff Gender Is : "+staff.getStaffGender()
								+"\n Staff Email Id Is:"+staff.getStaffEmailId()
								+"\n Staff Department Is :"+staff.getStaffDepartment());
			List<Address> add=staff.getStaffAddress();
			System.out.println("Address ->");
			System.out.println("-----------------------------------------");
			System.out.println("House No \t HouseName \t PinCode \t City");
			System.out.println("------------------------------------------");
			add.forEach(address -> System.out.println(address.getHouseNo()+"\t"+address.getHouseName()+"\t"+address.getPinCode()+"\t"+address.getCity()));
			System.out.println("---------------------------------------------");
			System.out.println("------------------------------------------------------------------");
		}
		else
			System.out.println("Record Not Found");
		
	}

	@Override
	public void displayAllStaffRecord() 
	{
	
		List<Staff> list=staffService.displayAllStaffRecord();
		Iterator<Staff> itr=list.iterator();
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("staffId\tStaffName\tDateOfJoining\tContactNo\tSalary\tGender\tEmailId\t\tDepartment ");
		System.out.println("------------------------------------------------------------------------------------------------");
		while(itr.hasNext())
		{
			Staff staff1=itr.next();
			List<Address> add=staff1.getStaffAddress();	
			System.out.println(""+staff1.getStaffId()+"\t\t"
	 				+staff1.getStaffName()+"\t"
	 				+staff1.getDoj()+"\t"
	 				+staff1.getStaffContact()+"\t"
	 				+staff1.getStaffSalary()+"\t"
	 				+staff1.getStaffGender()+"\t"
	 				+staff1.getStaffEmailId()+"\t"
	 				+staff1.getStaffDepartment());
			System.out.println("\n");
			System.out.println("\t\t\t..........................Address Of Staff.........................................");
			System.out.println("\t\t\tHouse No\t HouseName\t PinCode\t City");
			System.out.println("\t\t\t...................................................................");
			 for(Address address : add )
				 {
				 	System.out.println("\t\t\t"+address.getHouseNo()+"\t\t"+address.getHouseName()+"\t"+address.getPinCode()+"\t\t"+address.getCity());
				 }
			 System.out.println("\t\t\t...................................................................");
			 System.out.println("\n");
			 System.out.println("===============================================================================================================");
			 
			
		}
	}



	@Override
	public void findByStaffNameLike() {
		Boolean flagStaffName=true;
		while(flagStaffName)
		{
			System.out.println("Enter Staff Name :");
			String staffName=scanner.next();
			
			if(Validation.checkValidName(staffName))
			{
				List<Staff> staff1=staffService.findByStaffNameLike(staffName);
				if(staff1 != null)
				{
					staff1.forEach(staff->{
							System.out.println("Staff Id Is :"+staff.getStaffId());
							System.out.println("Staff Name Is :"+staff.getStaffName());
							System.out.println("Staff Joining Date Is :"+staff.getDoj());
							System.out.println("Staff Contact Number Is :"+staff.getStaffContact());
							System.out.println("Staff Salary is :"+staff.getStaffSalary());
							System.out.println("Staff Gender Is : "+staff.getStaffGender());
							System.out.println("Staff Email Id Is:"+staff.getStaffEmailId());
							System.out.println("Staff Department Is :"+staff.getStaffDepartment());				
					List<Address> add=staff.getStaffAddress();				
					System.out.println("--------------------"+"Address Of Staff :"+"---------------------");
					System.out.println("House No \t HouseName \t PinCode \t City");
					System.out.println("------------------------------------------------------------------");
					add.forEach(address -> System.out.println(address.getHouseNo()+"\t\t"+address.getHouseName()+"\t\t"+address.getPinCode()+"\t\t"+address.getCity()));

					System.out.println("------------------------------------------------------------------");});
				}
				else
					System.out.println("Record Not Found");
				
				flagStaffName=false;
			}
			else
				System.out.println("Enter Valid Staff Name .");
			
		}
	}



	@Override
	public void findByStaffDepartment() {
		Boolean flagStaffDept=true;
		while(flagStaffDept)
		{
			System.out.println("Enter Department :");
			String staffDepartment=scanner.next();
			if(Validation.checkValidFName(staffDepartment))
			{
				List<Staff> staff1=staffService.findByStaffDepartment(staffDepartment);
				if(staff1 != null)
				{
					staff1.forEach((staff->{
						System.out.println("Staff Id Is :"+staff.getStaffId());
						System.out.println("Staff Name Is :"+staff.getStaffName());
						System.out.println("Staff Joining Date Is :"+staff.getDoj());
						System.out.println("Staff Contact Number Is :"+staff.getStaffContact());
						System.out.println("Staff Salary is :"+staff.getStaffSalary());
						System.out.println("Staff Gender Is : "+staff.getStaffGender());
						System.out.println("Staff Email Id Is:"+staff.getStaffEmailId());
						System.out.println("Staff Department Is :"+staff.getStaffDepartment());				
				List<Address> add=staff.getStaffAddress();				
				System.out.println("--------------------"+"Address Of Staff :"+"---------------------");
				System.out.println("House No \t HouseName \t PinCode \t City");
				System.out.println("------------------------------------------------------------------");
				add.forEach(address -> System.out.println(address.getHouseNo()+"\t\t"+address.getHouseName()+"\t\t"+address.getPinCode()+"\t\t"+address.getCity()));

				System.out.println("------------------------------------------------------------------");}));
				}
				else
					System.out.println("Record Not Found");
				
				flagStaffDept=false;
			}
			else
				System.out.println("Enter Valid Staff Department .");
			
		}
		
	}



	@Override
	public void findByStaffContact() {
		
		Boolean flagStaffContact=true;
		while(flagStaffContact)
		{
			System.out.println("Enter Staff Contact :");
			String staffContact=scanner.next();
			if(Validation.checkMobileNumber(staffContact))
			{
				Staff staff=staffService.findByStaffContact(staffContact);
				if(staff != null)
				{
					System.out.println("Staff Id Is :"+staff.getStaffId()
					+"\n Staff Name Is :"+staff.getStaffName()
					+"\n Staff Joining Date Is :"+staff.getDoj()
					+"\n Staff Contact Number Is :"+staff.getStaffContact()
					+"\n Staff Salary is :"+staff.getStaffSalary()
					+"\n Staff Gender Is : "+staff.getStaffGender()
					+"\n Staff Email Id Is:"+staff.getStaffEmailId()
					+"\n Staff Department Is :"+staff.getStaffDepartment());
					List<Address> add=staff.getStaffAddress();
					System.out.println("Address ->");
					System.out.println("-----------------------------------------");
					System.out.println("House No \t HouseName \t PinCode \t City");
					System.out.println("------------------------------------------");
					add.forEach(address -> System.out.println(address.getHouseNo()+"\t"+address.getHouseName()+"\t"+address.getPinCode()+"\t"+address.getCity()));
					System.out.println("---------------------------------------------");
					System.out.println("------------------------------------------------------------------");
				}
				else
					System.out.println("Record Not Found");
				
				flagStaffContact=false;
			}
			else
				System.out.println("Enter Valid Staff Contact .");
			
		}
		
	}



	@Override
	public void findByStaffEmailId() {

		Boolean flagStaffMailId=true;
		while(flagStaffMailId)
		{
			System.out.println("Enter Staff MailId :");
			String staffEmailId=scanner.next();
			if(Validation.checkEmail(staffEmailId))
			{
				Staff staff=staffService.findByStaffEmailId(staffEmailId);
				if(staff != null)
				{
					System.out.println("Staff Id Is :"+staff.getStaffId()
					+"\n Staff Name Is :"+staff.getStaffName()
					+"\n Staff Joining Date Is :"+staff.getDoj()
					+"\n Staff Contact Number Is :"+staff.getStaffContact()
					+"\n Staff Salary is :"+staff.getStaffSalary()
					+"\n Staff Gender Is : "+staff.getStaffGender()
					+"\n Staff Email Id Is:"+staff.getStaffEmailId()
					+"\n Staff Department Is :"+staff.getStaffDepartment());
					List<Address> add=staff.getStaffAddress();
					System.out.println("Address ->");
					System.out.println("-----------------------------------------");
					System.out.println("House No \t HouseName \t PinCode \t City");
					System.out.println("------------------------------------------");
					add.forEach(address -> System.out.println(address.getHouseNo()+"\t"+address.getHouseName()+"\t"+address.getPinCode()+"\t"+address.getCity()));
					System.out.println("---------------------------------------------");
					System.out.println("------------------------------------------------------------------");
				}
				else
					System.out.println("Record Not Found");
				
				flagStaffMailId=false;
			}
			else
				System.out.println("Enter Valid Staff Department .");
			
		}
	}



	

}
