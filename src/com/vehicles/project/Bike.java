package com.vehicles.project;

public class Bike extends Vehicle {

	public static final int FRONT = 0;
	public static final int BACK = 1;

	public Bike(String plate, String brand, String color) throws Exception{
		super(plate, brand, color);
		wheels= new Wheel[2];
	}

	@Override
	public void addAllWheels(Wheel[] frontWheels, Wheel[] backWheels) throws Exception {
		addWheel(frontWheels, Bike.FRONT);
		addWheel(backWheels, Bike.BACK);
	}

	@Override
	public int getNumberOfWheelsPerAxle() {
		return 1;
	}


}
