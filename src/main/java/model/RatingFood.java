package model;

public class RatingFood {
	private int id;
	private String content;
	private int userId;
	private int foodId;
	
	public RatingFood() {}
	public RatingFood(int id, String content, int userId, int foodId) {
		this.id = id;
		this.content = content; 
		this.userId = userId;
		this.foodId = foodId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	
}
