package com.shobha.basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shobha.basic.dao.MenuCardRepository;
import com.shobha.basic.model.MenuCard;

@Service
public class MenuCardServiceImpl implements MenuCardService{
@Autowired
	private MenuCardRepository menuRepository;
	
	@Override
	public String addMenu(MenuCard menu) {
		menuRepository.save(menu);
		return "Menu Added Successfully.";
	}

	@Override
	public String updateMenu(MenuCard menu) {
		menuRepository.save(menu);
		return "Menu Updated Successfully.";
	}

	@Override
	public String updateMenuName(String foodName,Integer menuId) {
		menuRepository.updateByName(foodName, menuId);
		return "Menu Card Food Name Updated";
	}

	@Override
	public String updateMenuPrice(Double foodPrice,Integer menuId) {
		menuRepository.updateByPrice(foodPrice, menuId);
		return "Menu Card Food Price Updated";
	}

	@Override
	public String updateMenuSpecifier(String FoodSpecifier,Integer menuId) {
		menuRepository.updateBySpecifier(FoodSpecifier, menuId);
		return "Menu Card Food SPecifier Updated";
	}
	
	
	@Override
	public String deleteMenu(Integer menuId) {
		menuRepository.deleteById(menuId);
		return "Menu Deleted Successfully.";
	}

	@Override
	public MenuCard findMenuDetails(Integer menuId) {
		Optional<MenuCard> o=menuRepository.findById(menuId);
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
	public List<MenuCard> displayAllMenu() {
		
		return menuRepository.findAll();
	}

	@Override
	public List<MenuCard> findByFoodNameLike(String foodName) {
		
		return menuRepository.findByFoodNameLike("%"+foodName+"%");
	}

	@Override
	public List<MenuCard> findByOrderByFoodPriceAsc() {
		List<MenuCard> list=menuRepository.findByOrderByFoodPriceAsc();
		return list;
	}

	@Override
	public List<MenuCard> findByFoodSpecifier(String foodSpecifier) {
		List<MenuCard> list=menuRepository.findByFoodSpecifier(foodSpecifier);
		return list;
	}

	

	


}
