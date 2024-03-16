package model;

import java.util.Date;

public class Orders {
	private int id;
	private String createdDate;
	private int totalMoney;
	private String orderStatus;
	private String note;
	private int userId;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	public Orders(int id, String createdDate, int totalMoney, String orderStatus, String note, int userId) {
		this.id = id;
		this.createdDate = createdDate;
		this.orderStatus = orderStatus;
		this.note = note;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
