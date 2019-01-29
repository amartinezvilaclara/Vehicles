package com.vehicles.project;

import java.util.Scanner;

public class GarageMain {

    public static void main(String[] args){

        try{
            Vehicle v = requestVehicleInformation();
            if(v instanceof Car) {
                initializeCar((Car) v);
            }
            System.out.println("Car correctly initialized. Exiting now...");
        }
        catch (Exception e){
            System. out.println("Error initializing the vehicle. Incorrect data entry");
        }
    }

    public static Vehicle requestVehicleInformation() throws Exception {


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

    private static void initializeCar(Car v) throws Exception{
        System.out.println("the car needs front wheels...");
        Wheel[] frontWheels = requestWheelInfoAndInitialize(2);
        System.out.println("the car needs back wheels...");
        Wheel[] backWheels = requestWheelInfoAndInitialize(2);
        v.addWheels(frontWheels,backWheels);
    }

    private static Wheel[] requestWheelInfoAndInitialize(int numOfWheels) throws Exception {

        Wheel wheel = requestWheelInformation();
        Wheel[] wheels = new Wheel[numOfWheels];
        for(int i=0; i<numOfWheels; i++) {
            wheels[i] = new Wheel(wheel.getBrand(), wheel.getDiameter());
        }
        return wheels;
    }

    public static Wheel requestWheelInformation() throws Exception{

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
