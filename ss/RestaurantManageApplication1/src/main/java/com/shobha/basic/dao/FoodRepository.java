package com.shobha.basic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shobha.basic.model.Food;

@Repository
public interface FoodRepository  extends JpaRepository<Food, Integer>{
	
	@Transactional
	@Modifying
	@Query("update Food  m set m.stock=:C where menuId=:I")
	 void updateByStock(@Param("C")Double stock,@Param("I") Integer menuId);
}
