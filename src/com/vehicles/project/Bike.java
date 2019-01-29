package com.vehicles.project;

public class Bike extends Vehicle {

	public static final int FRONT = 0;
	public static final int BACK = 1;

	public Bike(String plate, String brand, String color){
		super(plate, brand, color);
		wheels= new Wheel[2];
	}

	public void addWheels(Wheel[] frontWheels, Wheel[] backWheels) throws Exception {
		addWheel(frontWheels, Bike.FRONT);
		addWheel(backWheels, Bike.BACK);
	}

	public void addWheel(Wheel[] wheels, int WheelPosition) throws Exception {
		if (wheels.length != 1) throw new Exception();
		this.wheels[WheelPosition]= wheels[0];
	}
}
