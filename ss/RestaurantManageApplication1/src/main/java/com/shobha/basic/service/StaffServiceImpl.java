package com.shobha.basic.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shobha.basic.dao.StaffRepository;
import com.shobha.basic.model.Address;
import com.shobha.basic.model.Staff;

@Service
public class StaffServiceImpl implements StaffService
{
	@Autowired
	private StaffRepository staffRepository;
	
	@Override
	public String addStaff(Staff staff) {
		staffRepository.save(staff);
		return "Staff Record Added Successfull.";
	}

	@Override
	public String updateStaff(Staff staff) {
		staffRepository.save(staff);
		return "Staff Record Updated Successfull.";
	}
	@Override
	public String updateStaffByName(String staffName, Integer staffId) {
		staffRepository.updateByStaffName(staffName, staffId);
		return "\n Staff Name Updated Successfully";
	}

	@Override
	public String updateStaffByContact(String staffContact, Integer staffId) {
		staffRepository.updateByStaffContact(staffContact, staffId);
		return "\n Staff Contact Number Updated Successfully";
	}

	@Override
	public String updateStaffDepartment(String staffDepartment, Integer staffId) {
		staffRepository.updateByStaffDepartment(staffDepartment, staffId);
		return "\n Staff Departmeny Updated SuccessFully.";
	}

	@Override
	public String updateStaffEmailId(String staffEmailId, Integer staffId) {
		staffRepository.updateByStaffEmailId(staffEmailId, staffId);
		return "\n Staff EmailId Updated Successfully";
	}

	@Override
	public String updateStaffGender(String staffGender, Integer staffId) {
		staffRepository.updateByStaffGender(staffGender, staffId);
		return "\n Staff gender Updated Successfully";
	}

	@Override
	public String updateStaffSalary(Double staffSalary, Integer staffId) {
		staffRepository.updateByStaffSalary(staffSalary, staffId);
		return "\n Staff Salary Updated Successfully";
	}

	@Override
	public String deleteStaff(Integer staffId) {
		staffRepository.deleteById(staffId);
		return "Staff Record Deleted Successfully.";
	}

	@Override
	public Staff findStaffRecord(Integer staffId) {
		Optional<Staff> o=staffRepository.findById(staffId);
		if(o.isPresent())
		{
			return o.get();
		}
		else
		{
			return null;
		}
		
	}

	
	@Override
	public List<Staff> displayAllStaffRecord() {
		
		return staffRepository.findAll();
	}

	@Override
	public List<Staff> findByStaffNameLike(String staffName) {
		return staffRepository.findByStaffNameLike("%"+staffName+"%");
	}

	@Override
	public List<Staff> findByStaffDepartment(String staffDepartment) {
		
		return staffRepository.findByStaffDepartment(staffDepartment);
	}

	@Override
	public Staff findByStaffContact(String staffContact) {
		
		return staffRepository.findByStaffContact(staffContact);
	}

	@Override
	public Staff findByStaffEmailId(String staffEmailId) {
		
		return staffRepository.findByStaffEmailId(staffEmailId);
	}

	

	
}
