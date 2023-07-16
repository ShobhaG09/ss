package com.shobha.basic.service;

import com.shobha.basic.model.Admin;

public interface AdminService 
{
	Admin findByAdminEmailId(String emailId);
	String updateAdmin(Admin admin);
	

	

}
