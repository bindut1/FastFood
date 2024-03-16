package model;

public class Items {
	private Food food;
	private int quantity;
	private int price;
	
	public Items() {
		
	}
	public Items(Food food, int quantity, int price) {
		this.food = food;
		this.quantity = quantity;
		this.price = price;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
