package com.shobha.basic.service;

import java.util.Date;
import java.util.List;

import com.shobha.basic.model.Order1;

public interface OrderService 
{

	String addOrder(Order1 order);
	String updateOrder(Order1 order);
	String updateCustomerName(String customerName,Integer orderId);
	String updateStock(Double stock,Integer orderId );
	String deleteOrder(Integer orderId);
	Order1 findOrderDetail(Integer orderId);
	List<Order1> displayAllOrderDetails();
	
	
}
