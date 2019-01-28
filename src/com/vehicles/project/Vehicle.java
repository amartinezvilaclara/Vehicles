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
}

