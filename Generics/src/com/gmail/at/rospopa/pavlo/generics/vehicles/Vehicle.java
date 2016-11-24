package com.gmail.at.rospopa.pavlo.generics.vehicles;

import com.gmail.at.rospopa.pavlo.generics.passengers.Human;

public interface Vehicle<T extends Human> {
    int getCapacity();
    int getCount();
    void seatPassenger(T passenger) throws CrowdedVehicleException;
    void disembarkPassenger(T passenger) throws PassengerNotInVehicleException;
}
