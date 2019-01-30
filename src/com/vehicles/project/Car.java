package com.vehicles.project;

public class Car extends Vehicle {

	public static final int FRONT = 0;
	public static final int BACK = 2;

	public Car(String plate, String brand, String color) throws Exception {
		super(plate, brand, color);
		wheels= new Wheel[4];
	}

	@Override
	public void addAllWheels(Wheel[] frontWheels, Wheel[] backWheels) throws Exception {
		addTwoWheels(frontWheels, Car.FRONT);
		addTwoWheels(backWheels, Car.BACK);
	}

	@Override
	public int getNumberOfWheelsPerAxle() {
		return 2;
	}


}
