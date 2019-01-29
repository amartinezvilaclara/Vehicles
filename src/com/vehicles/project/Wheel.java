package com.vehicles.project;

public class Wheel {

	public static final double MINIMUM_DIAMETER = 0.4d;
	public static final double MAXIMUM_DIAMETER = 4d;

	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	public double getDiameter() {
		return diameter;
	}

	public String getBrand() {
		return brand;
	}

	public static boolean isAValidWheelDiameter(double d) {
		return (d >= Wheel.MINIMUM_DIAMETER)&&(d <= Wheel.MAXIMUM_DIAMETER);
	}
}
