package com.lendico.task.model;

public enum Constants {
	
	MONTHS(12),
	
	DAYSINMONTH(30),
	
	DAYSINYEAR(360),
	
	SCALE(2);
	
	private int value;
	
	Constants(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
