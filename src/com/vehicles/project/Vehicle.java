package com.vehicles.project;


public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected Wheel[] wheels;

	public Vehicle(String plate, String brand, String color) throws Exception{
		if (!isPlateFormatCorrect(plate)) throw new Exception();
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}

	public abstract void addAllWheels(Wheel[] frontWheels, Wheel[] backWheels) throws Exception;

	protected void addWheel(Wheel[] wheels, int WheelPosition) throws Exception {
		if (wheels.length != 1) throw new Exception();
		this.wheels[WheelPosition]= wheels[0];
	}

	protected void addTwoWheels(Wheel[] wheels, int WheelPosition) throws Exception {
		if (wheels.length != 2) throw new Exception();
		if ((wheels[0] == wheels[1])||(wheels[0].getDiameter() != wheels[1].getDiameter())) throw new Exception();
		for(int i=0; i<2;i++){
			this.wheels[WheelPosition + i]= wheels[i];
		}
	}

	private boolean isPlateFormatCorrect(String plate){
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

	public abstract int getNumberOfWheelsPerAxle();
}

