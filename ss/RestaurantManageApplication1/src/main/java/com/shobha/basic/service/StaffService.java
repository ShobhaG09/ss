package com.shobha.basic.service;

import java.util.List;

import com.shobha.basic.model.Address;
import com.shobha.basic.model.Staff;

public interface StaffService 
{
	String addStaff(Staff staff);
	String updateStaff(Staff staff);
	String updateStaffByName(String staffName , Integer staffId);
	String updateStaffByContact(String staffContact, Integer staffId);
	String updateStaffDepartment(String staffDepartment, Integer staffId);
	String updateStaffEmailId(String staffEmailId, Integer staffId);
	String updateStaffGender(String staffGender, Integer staffId);
	String updateStaffSalary(Double staffSalary, Integer staffId);
	
	String deleteStaff(Integer staffId);
	Staff findStaffRecord(Integer staffId);
	List<Staff> findByStaffNameLike(String staffName);
	List<Staff> findByStaffDepartment(String staffDepartment);
	Staff findByStaffContact(String staffContact);
	Staff findByStaffEmailId(String staffEmailId);
	List<Staff> displayAllStaffRecord();
	

}
