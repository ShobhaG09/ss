package com.shobha.basic.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shobha.basic.model.Order1;

@Repository
public interface OrderRepository extends JpaRepository<Order1, Integer>{

	@Transactional
	@Modifying
	@Query("update Order1 o set o.customerName=:C where orderId=:I")
	 void updateByCustomerName(@Param("C")String customerName,@Param("I") Integer orderId);
}
