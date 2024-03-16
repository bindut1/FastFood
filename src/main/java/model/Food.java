package model;

public class Food {
	private int id;
	private String title;
	private String description;
	private int price;
	private int cateId;
	
	public Food() {}
	public Food(int id, String title, String description, int price, int cateId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.cateId = cateId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	
}
