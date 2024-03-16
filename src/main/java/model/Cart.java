package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Items> items;
	public Cart() {
		items = new ArrayList<>();
	}
	public Cart(List<Items> items) {
		this.items = items;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public Items getItemById(int id) {
		for(Items i : items) {
			if(i.getFood().getId() == id)
				return i;
		}
		return null;
	}
	public int getQuantityById(int id) {
		return getItemById(id).getQuantity();
	}
	public void addItem(Items t) {
		if(getItemById(t.getFood().getId()) != null) {
			Items i = getItemById(t.getFood().getId());
			i.setQuantity(i.getQuantity() + t.getQuantity());
		}else {
			items.add(t);
		}
	}
	public void removeItem(int id) {
		if(getItemById(id) != null) {
			items.remove(getItemById(id));
		}
	}
	public int getTotalMoney() {
		int t = 0;
		for(Items i : items) {
			t += i.getQuantity() * i.getPrice();
		}
		return t;
	}
}
