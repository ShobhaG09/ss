package com.shobha.basic.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shobha.basic.dao.OrderRepository;
import com.shobha.basic.model.Order1;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public String addOrder(Order1 order) {
		orderRepository.save(order);
		return "Order Added";
	}

	@Override
	public String updateOrder(Order1 order) {
		orderRepository.save(order);
		return "Order Updated";
	}

	@Override
	public String updateCustomerName(String customerName,Integer orderId) {
		orderRepository.updateByCustomerName(customerName, orderId);
		return "Customer Name Updated In Order Detail";
	}
	
	@Override
	public String deleteOrder(Integer orderId) {
		orderRepository.deleteById(orderId);
		return "OrderDeleted";
	}

	@Override
	public Order1 findOrderDetail(Integer orderId) {
		Optional<Order1> o=orderRepository.findById(orderId);
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
	public List<Order1> displayAllOrderDetails() {
		
		return orderRepository.findAll();
	}

	@Override
	public String updateStock(Double stock, Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	

//	@Override
//	public List<Order1> findByDate(Date date1, Date date2) {
//		
//		return orderRepository.findByDateOrder(date1, date2);
//	}


}
