package com.dsa.JavaBasics.POC.DesignPAtterns;

public class FactoryDesignPattern {

    public static void main(String[] args) {

        Vehicle v1 = VehicleFactory.getVehicle("Car");
        System.out.println(v1.Start());
        System.out.println(v1.Stop());

    }

}

/**
 *  
 */

class VehicleFactory {

    public static Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equals("Car")) {
            return new Car();
        } else if (vehicleType.equals("Truck")) {
            return new Truck();
        } else if (vehicleType.equals("Bike")) {
            return new Cycle();
        } else {
            throw new IllegalArgumentException("Unknown vehicle type");
        }

    }

}

interface Vehicle {

    String Stop();

    String Start();

}

class Car implements Vehicle {

    @Override
    public String Stop() {
        return "Stopping car";
    }

    @Override
    public String Start() {
        return "Starting car";
    }

}

class Truck implements Vehicle {

    @Override
    public String Stop() {
        return "Stopping Truck";
    }

    @Override
    public String Start() {
        return "Starting Truck";
    }

}

class Cycle implements Vehicle {

    @Override
    public String Stop() {
        return "Stopping Cycle";
    }

    @Override
    public String Start() {
        return "Starting Cycle";
    }

}
