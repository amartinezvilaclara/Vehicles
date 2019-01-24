package com.vehicles.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected Map<Wheel,WheelPosition> wheels = new HashMap<>();

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}

	public void addWheel(Wheel wheel, WheelPosition position){

		this.wheels.put(wheel,position);
	}
}

