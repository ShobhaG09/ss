package com.shobha.basic.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Staff 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer staffId;
	private String staffName;
	@Temporal(TemporalType.DATE)
	private Date Doj;
	private String staffContact;
	private String staffDepartment;
	private Double staffSalary;
	private String staffGender;
	private String staffEmailId;
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="staffId")
	private List<Address> staffAddress;
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public Date getDoj() {
		return Doj;
	}
	public void setDoj(Date doj) {
		Doj = doj;
	}
	public String getStaffContact() {
		return staffContact;
	}
	public void setStaffContact(String staffContact) {
		this.staffContact = staffContact;
	}
	public String getStaffDepartment() {
		return staffDepartment;
	}
	public void setStaffDepartment(String staffDepartment) {
		this.staffDepartment = staffDepartment;
	}
	public Double getStaffSalary() {
		return staffSalary;
	}
	public void setStaffSalary(Double staffSalary) {
		this.staffSalary = staffSalary;
	}
	public String getStaffGender() {
		return staffGender;
	}
	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}
	public String getStaffEmailId() {
		return staffEmailId;
	}
	public void setStaffEmailId(String staffEmailId) {
		this.staffEmailId = staffEmailId;
	}
	public List<Address> getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(List<Address> staffAddress) {
		this.staffAddress = staffAddress;
	}
	
	
	
	

}
