package com.vehicles.project;

import java.util.Scanner;

public class GarageMain {

    public static void main(String[] args){

        Vehicle v = requestVehicleInformation();

        if(v instanceof Car) {
            InitializeCar((Car) v);
        }
        System.out.println("Car correctly initialized. Exiting now...");

    }

    public static Vehicle requestVehicleInformation(){

        System.out.println("Enter the vehicle brand: ");
        String brand = requestStringFromCommandLine();
        System.out.println("Enter the vehicle color: ");
        String color = requestStringFromCommandLine();
        System.out.println("Enter the vehicle number plate: ");
        String plate = requestStringFromCommandLine();

        return new Car(plate, brand, color);
    }

    public static String requestStringFromCommandLine(){

        Scanner sc= new Scanner(System.in);
        String s;
        s = sc.nextLine();
        return s;

    }

    private static void InitializeCar(Car v) {
        System.out.println("the car needs front wheels...");
        Wheel[] frontWheels = requestWheelInfoAndInitialize(2);
        System.out.println("the car needs back wheels...");
        Wheel[] backWheels = requestWheelInfoAndInitialize(2);
        try{
            v.addWheels(frontWheels,backWheels);
        }
        catch (Exception e) {
            System.out.println("There has been an error with the wheels.");
        }
    }

    private static Wheel[] requestWheelInfoAndInitialize(int numOfWheels) {

        Wheel wheel = requestWheelInformation();
        Wheel[] wheels = new Wheel[numOfWheels];
        for(int i=0; i<numOfWheels; i++) {
            wheels[i] = new Wheel(wheel.getBrand(), wheel.getDiameter());
        }
        return wheels;
    }

    public static Wheel requestWheelInformation(){

        Wheel wheel;
        System.out.println("Enter the wheel brand: ");
        String brand = requestStringFromCommandLine();
        System.out.println("Enter the wheel diameter: ");
        double d = requestDoubleFromCommandLine();
        wheel = new Wheel(brand,d);
        return wheel;

    }

    public static double requestDoubleFromCommandLine(){

        double dNumber = 0;
        String s;
        boolean acquired = false;

        while (!acquired){
            try{
                s = requestStringFromCommandLine();
                dNumber = Double.valueOf(s);
                acquired = true;
            }
            catch (NumberFormatException e){
                System.out.println("The entered value is not a valid number. Please, try again");
            }
        }
        return dNumber;

    }
}