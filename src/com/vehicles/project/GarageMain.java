package com.vehicles.project;

import java.util.Scanner;

public class GarageMain {

    public static void main(String[] args){

        try{
            Vehicle v = requestVehicleInformation();
            initializeVehicle(v);
            if(v instanceof Bike) System.out.println("Bike correctly initialized");
            else System.out.println("Car correctly initialized");
            System.out.println("Exiting now...");
        }
        catch (Exception e){
            System. out.println("Error initializing the vehicle. Incorrect data entry");
        }
    }

    public static Vehicle requestVehicleInformation() throws Exception {

        char option = requestAndVerifyVehicleOption();
        System.out.println("Enter the vehicle brand: ");
        String brand = requestStringFromCommandLine();
        System.out.println("Enter the vehicle color: ");
        String color = requestStringFromCommandLine();
        System.out.println("Enter the vehicle number plate: ");
        String plate = requestStringFromCommandLine();
        if (option == 'b') return new Bike(plate, brand, color);
        else return new Car(plate, brand, color);
    }

    public static char requestAndVerifyVehicleOption(){

        boolean acquired = false;
        String input="vehicle";
        while(!acquired) {
            System.out.println("Do yo want to create a car (c) or a motorbike (b)?");
            input = requestStringFromCommandLine();
            if((input.length() == 1)&&((input.charAt(0)=='c')||(input.charAt(0)=='b'))) acquired = true;
            else System.out.println("Your input does not correspond to any vehicle. Please select again");
        }
        return input.charAt(0);
    }

    public static String requestStringFromCommandLine(){

        Scanner sc= new Scanner(System.in);
        String s;
        s = sc.nextLine();
        return s;

    }

    private static void initializeVehicle(Vehicle v) throws Exception {

        int numOfWheels = 2;
        if(v instanceof Bike) numOfWheels =1;
        System.out.println("the vehicle needs front wheels...");
        Wheel[] frontWheels = requestWheelInfoAndInitialize(numOfWheels);
        System.out.println("the vehicle needs back wheels...");
        Wheel[] backWheels = requestWheelInfoAndInitialize(numOfWheels);
        if(v instanceof Bike) ((Bike) v).addWheels(frontWheels, backWheels);
        else ((Car) v).addWheels(frontWheels,backWheels);

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

    public static double requestDoubleFromCommandLine() {

        double dNumber = 0;
        String s;
        boolean acquired = false;

        while (!acquired) {
            try {
                s = requestStringFromCommandLine();
                dNumber = Double.valueOf(s);
                acquired = true;
            } catch (NumberFormatException e) {
                System.out.println("The entered value is not a valid number. Please, try again");
            }
        }
        return dNumber;

    }
}
