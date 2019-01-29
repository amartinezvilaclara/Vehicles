package com.vehicles.project;

import java.util.Scanner;

public class GarageMain {

    public static void main(String[] args){

        Vehicle v = requestVehicleInformation();
        initializeVehicle(v);

        if(v instanceof Car) System.out.println("Car correctly initialized");
        else System.out.println("Bike correctly initialized");
        System.out.println("Exiting now...");

    }

    public static Vehicle requestVehicleInformation(){

        char option = requestAndVerifyVehicleOption();
        System.out.println("Enter the vehicle brand: ");
        String brand = requestStringFromCommandLine();
        System.out.println("Enter the vehicle color: ");
        String color = requestStringFromCommandLine();
        String plate = requestAndVerifyPlate();
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

    private static String requestAndVerifyPlate() {
        String plate = "0000 AAA";
        boolean acquired = false;
        while(!acquired) {
            System.out.println("Enter the vehicle number plate: ");
            plate = requestStringFromCommandLine();
            if(isPlateFormatCorrect(plate)) acquired = true;
            else System.out.println("The format of the number plate is not correct. Please enter it again.");
        }
        return plate;
    }

    private static boolean isPlateFormatCorrect(String plate){
        plate.trim();
        boolean correctFormat = true;
        if(plate.length() < 7 || (plate.length() > 8)) correctFormat = false;
        for(int i =0; i<plate.length(); i++){
            if(i<4) correctFormat= correctFormat && Character.isDigit(plate.charAt(i));
            else{
                if(i == 4) correctFormat= correctFormat && Character.isSpaceChar(plate.charAt(i));
                else correctFormat= correctFormat && Character.isUpperCase(plate.charAt(i));
            }
        }
        return correctFormat;
    }

    private static void initializeVehicle(Vehicle v) {
        int numOfWheels = 2;
        if(v instanceof Bike) numOfWheels =1;
        System.out.println("the vehicle needs front wheels...");
        Wheel[] frontWheels = requestWheelInfoAndInitialize(numOfWheels);
        System.out.println("the vehicle needs back wheels...");
        Wheel[] backWheels = requestWheelInfoAndInitialize(numOfWheels);
        try{
            if(v instanceof Bike) ((Bike) v).addWheels(frontWheels, backWheels);
            else ((Car) v).addWheels(frontWheels,backWheels);
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
        double d = requestAndVerifyWheelDiameter();
        wheel = new Wheel(brand,d);
        return wheel;

    }

    private static double requestAndVerifyWheelDiameter() {
        boolean acquired = false;
        double d = 0;
        while (!acquired) {
            System.out.println("Enter the wheel diameter: ");
            d = requestDoubleFromCommandLine();
            if((d >= Wheel.MINIMUM_DIAMETER)&&(d <= Wheel.MAXIMUM_DIAMETER)) acquired = true;
            else System.out.println("The given diameter of the wheel is not valid. Please try again.");
        }
        return d;
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
