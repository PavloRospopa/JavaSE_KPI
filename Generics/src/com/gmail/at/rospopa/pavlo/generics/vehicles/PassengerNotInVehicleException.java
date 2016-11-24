package com.gmail.at.rospopa.pavlo.generics.vehicles;

public class PassengerNotInVehicleException extends Exception {

    public PassengerNotInVehicleException() {
    }

    public PassengerNotInVehicleException(String message) {
        super(message);
    }
}
