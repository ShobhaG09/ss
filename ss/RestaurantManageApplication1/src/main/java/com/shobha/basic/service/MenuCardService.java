package com.shobha.basic.service;

import java.util.List;

import com.shobha.basic.model.MenuCard;

public interface MenuCardService {

	String addMenu(MenuCard menu);
	String updateMenu(MenuCard menu);
	String updateMenuName(String foodName,Integer menuId);
	String updateMenuPrice(Double foodPrice,Integer menuId);
	String updateMenuSpecifier(String FoodSpecifier,Integer menuId);
	
	String deleteMenu(Integer menuId);
	MenuCard findMenuDetails(Integer menuId);
	List<MenuCard> displayAllMenu();
	List<MenuCard> findByFoodNameLike(String foodName);
	List<MenuCard> findByFoodSpecifier(String foodSpecifier);
	List<MenuCard> findByOrderByFoodPriceAsc();
	
}
