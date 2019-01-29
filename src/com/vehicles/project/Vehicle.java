package com.vehicles.project;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected Wheel[] wheels;

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}

	public static boolean isPlateFormatCorrect(String plate){
		plate.trim();
		boolean correctFormat = true;
		if(plate.length() < 7 || (plate.length() > 8)) correctFormat = false;
		for(int i =0; i<plate.length(); i++){
			if(i<4) correctFormat= correctFormat && Character.isDigit(plate.charAt(i));
			else{
				if(i == 4) correctFormat= correctFormat && Character.isSpaceChar(plate.charAt(i));
				else correctFormat= correctFormat && Character.isUpperCase(plate.charAt(i));
			}
		}
		return correctFormat;
	}
}

