package com.dsa.SystemDesign.ParkingLotSystem;

public interface ParkingFeeStrategy {

    double calculateFee(String vehicleType, int duation, DurationType durationType);

}