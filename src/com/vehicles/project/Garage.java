package com.vehicles.project;

import java.util.Scanner;

public class Garage {

    public static void main(String[] args){

        Vehicle v;
        Wheel wheel;

        v = requestVehicleInformation();

        if(v instanceof Car) {
            System.out.println("the car needs front wheels...");
            wheel = requestWheelInformation();
            Wheel[] frontWheels = new Wheel[2];
            frontWheels[0]= new Wheel(wheel.getBrand(),wheel.getDiameter());
            frontWheels[1]= new Wheel(wheel.getBrand(),wheel.getDiameter());
            System.out.println("the car needs back wheels...");
            wheel = requestWheelInformation();
            Wheel[] backWheels = new Wheel[2];
            backWheels[0]= new Wheel(wheel.getBrand(),wheel.getDiameter());
            backWheels[1]= new Wheel(wheel.getBrand(),wheel.getDiameter());
           try{
               ((Car) v).addWheels(frontWheels,backWheels);
           }
           catch (Exception e) {
               System.out.println("There has been an error with the wheels.");
           }
        }

    }

    public static Vehicle requestVehicleInformation(){

        String brand, color, plate;
        Vehicle v;

        System.out.println("Enter the vehicle brand: ");
        brand = requestStringFromCommandLine();
        System.out.println("Enter the vehicle color: ");
        color = requestStringFromCommandLine();
        System.out.println("Enter the vehicle number plate: ");
        plate = requestStringFromCommandLine();


        v = new Car(plate,brand,color);
        return v;
    }

    public static String requestStringFromCommandLine(){

        Scanner sc= new Scanner(System.in);
        String s;
        s = sc.nextLine();
        return s;

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

    public static Wheel requestWheelInformation(){

        Wheel wheel;
        System.out.println("Enter the wheel brand: ");
        String brand = requestStringFromCommandLine();
        System.out.println("Enter the wheel diameter: ");
        double d = requestDoubleFromCommandLine();
        wheel = new Wheel(brand,d);
        return wheel;

    }
}
