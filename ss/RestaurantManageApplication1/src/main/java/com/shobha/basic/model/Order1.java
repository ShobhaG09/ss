package com.shobha.basic.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;



@Entity
public class Order1
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	@Autowired
	@Temporal(TemporalType.DATE)
	private Date orderdate;
	private Double totalBill;
	private String customerName;

	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="orderId")
	private List<Food> foodId;
	
	public List<Food> getFood() {
		return foodId;
	}
	public void setFood(List<Food> food) {
		this.foodId = food;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Food> getFoodId() {
		return foodId;
	}
	public void setFoodId(List<Food> foodId) {
		this.foodId = foodId;
	}
	

}
