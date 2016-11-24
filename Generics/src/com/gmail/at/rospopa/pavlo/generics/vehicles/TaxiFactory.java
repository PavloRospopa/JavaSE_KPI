package com.gmail.at.rospopa.pavlo.generics.vehicles;

import com.gmail.at.rospopa.pavlo.generics.passengers.Human;

public class TaxiFactory<T extends Human> extends VehicleFactory<T> {
    private final int CAPACITY = 5;

    @Override
    public Vehicle<T> createVehicle(String name) {
        return new Taxi<T>(getNextId(), name, CAPACITY);
    }

    @Override
    public Vehicle<T> createVehicle(String name, int capacity) {
        return new Taxi<T>(getNextId(), name, capacity);
    }
}
