package com.shobha.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shobha.basic.dao.AdminRepository;
import com.shobha.basic.model.Admin;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin findByAdminEmailId(String  emailId) {
		
		return adminRepository.findByEmailId(emailId);
	}

	@Override
	public String updateAdmin(Admin admin) {
		adminRepository.save(admin);
		return "PassWord Updated";
	}

	

}
