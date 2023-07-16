package com.shobha.basic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shobha.basic.model.MenuCard;

@Repository
public interface MenuCardRepository extends JpaRepository<MenuCard, Integer>{

	public List<MenuCard> findByFoodNameLike(String foodName);
	public List<MenuCard> findByOrderByFoodPriceAsc();
	public List<MenuCard> findByFoodSpecifier(String foodSpecifier);
	
	@Transactional
	@Modifying
	@Query("update MenuCard m set m.foodName=:N where menuId=:I")
	 void updateByName(@Param("N")String foodName,@Param("I") Integer menuId);
	
	@Transactional
	@Modifying
	@Query("update MenuCard m set m.foodPrice=:P where menuId=:I")
	 void updateByPrice(@Param("P")Double foodPrice,@Param("I") Integer menuId);
	
	@Transactional
	@Modifying
	@Query("update MenuCard m set m.foodSpecifier=:S where menuId=:I")
	 void updateBySpecifier(@Param("S")String foodSpecifier,@Param("I") Integer menuId);
	
	
	
	
}
