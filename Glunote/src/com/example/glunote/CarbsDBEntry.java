package com.example.glunote;

public class CarbsDBEntry {
	private int id;
	private double carbs;
	private String meal;
	private String time;
	
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
	
	public double GetCarbs() {
		return carbs;
	}
	
	public void setCarbs(double carbs) {
		this.carbs=carbs;
	}
	
	public String GetTime() {
		return time;
	}
	
	public void SetTime(String time) {
		this.time=time;
	}
	
}
