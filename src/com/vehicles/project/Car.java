package com.vehicles.project;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	public void addWheels(Wheel[] frontWheels, Wheel[] backWheels) throws Exception {
		addTwoWheels(frontWheels, WheelPosition.FRONT);
		addTwoWheels(backWheels, WheelPosition.REAR);
	}

	public void addTwoWheels(Wheel[] wheels, WheelPosition position) throws Exception {
		if (wheels.length != 2) throw new Exception();

		if (!wheels[0].equals(wheels[1])) throw new Exception();

		if(position == WheelPosition.FRONT) {
			super.addWheel(wheels[0],WheelPosition.FRONT_LEFT );
			super.addWheel(wheels[1],WheelPosition.FRONT_RIGHT);
		}
		else{
			super.addWheel(wheels[0],WheelPosition.REAR_LEFT );
			super.addWheel(wheels[1],WheelPosition.REAR_RIGHT);
		}
	}

}
