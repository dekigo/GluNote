package com.example.glunote;

public class CarbsDBEntry {
	private int id;
	private double carbs;
	private String meal;
	
	public int GetId() {
		return id;
	}
	
	public void SetId(int id) {
		this.id=id;
	}
	
	public String GetMeal() {
		return meal;
	}
	
	public void SetMeal(String meal) {
		this.meal=meal;
	}
	
}
