package com.shobha.basic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shobha.basic.model.Address;
import com.shobha.basic.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>
{

	public List<Staff> findByStaffNameLike(String staffName);
	public List<Staff> findByStaffDepartment(String staffDepartment);
	public Staff findByStaffContact(String staffContact);
	public Staff findByStaffEmailId(String staffEmailId);
	
	@Transactional
	@Modifying
	@Query("update Staff s set s.staffName=:N where staff_id=:I")
	 void updateByStaffName(@Param("N")String staffName,@Param("I") Integer staffId);
	
	@Transactional
	@Modifying
	@Query("update Staff s set s.staffContact=:C where staff_id=:I")
	 void updateByStaffContact(@Param("C")String staffContact,@Param("I") Integer staffId);
	
	@Transactional
	@Modifying
	@Query("update Staff s set s.staffContact=:D where staff_id=:I")
	 void updateByStaffDepartment(@Param("D")String staffContact,@Param("I") Integer staffId);
	
	@Transactional
	@Modifying
	@Query("update Staff s set s.staffEmailId=:E where staff_id=:I")
	 void updateByStaffEmailId(@Param("E")String staffEmailId,@Param("I") Integer staffId);
	
	@Transactional
	@Modifying
	@Query("update Staff s set s.staffSalary=:S where staff_id=:I")
	 void updateByStaffSalary(@Param("S")Double staffSalary,@Param("I") Integer staffId);
	
	@Transactional
	@Modifying
	@Query("update Staff s set s.staffGender=:G where staff_id=:I")
	 void updateByStaffGender(@Param("G")String staffGender,@Param("I") Integer staffId);
	
	
}
