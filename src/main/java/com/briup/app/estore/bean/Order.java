package com.briup.app.estore.bean;

import java.util.Date;
import java.util.List;

public class Order {
	private Integer id;

	private Double cost;

	private Date orderdate;

	private Customer customer;

	private List<Orderline> orderline;

	public Order() {
	}

	public Order(Double cost, Date orderdate, Customer customer, List<Orderline> orderline) {
		this.cost = cost;
		this.orderdate = orderdate;
		this.customer = customer;
		this.orderline = orderline;
	}

	public Order(Integer id, Double cost, Date orderdate, Customer customer, List<Orderline> orderline) {
		this.id = id;
		this.cost = cost;
		this.orderdate = orderdate;
		this.customer = customer;
		this.orderline = orderline;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Orderline> getOrderline() {
		return orderline;
	}

	public void setOrderline(List<Orderline> orderline) {
		this.orderline = orderline;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", cost=" + cost + ", orderdate=" + orderdate + ", customer=" + customer
				+ ", orderline=" + orderline + "]";
	}

}