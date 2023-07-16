package com.shobha.basic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shobha.basic.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
	public Admin findByEmailId(String emailId);	
	
}
