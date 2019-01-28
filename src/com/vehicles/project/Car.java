package com.vehicles.project;

public class Car extends Vehicle {

	public static final int FRONT = 0;
	public static final int BACK = 2;
	public static final int RIGHT = 0;
	public static final int LEFT = 1;

	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
		wheels= new Wheel[4];
	}

	public void addWheels(Wheel[] frontWheels, Wheel[] backWheels) throws Exception {
		addTwoWheels(frontWheels, Car.FRONT);
		addTwoWheels(backWheels, Car.BACK);
	}

	public void addTwoWheels(Wheel[] wheels, int WheelPosition) throws Exception {
		if (wheels.length != 2) throw new Exception();
		if ((wheels[0] == wheels[1])||(wheels[0].getDiameter() != wheels[1].getDiameter())) throw new Exception();
		for(int i=0; i<2;i++){
			this.wheels[WheelPosition + i]= wheels[i];
		}
	}
}
