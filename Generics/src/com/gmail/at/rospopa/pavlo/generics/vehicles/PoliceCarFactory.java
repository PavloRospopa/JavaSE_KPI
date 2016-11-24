package com.gmail.at.rospopa.pavlo.generics.vehicles;

import com.gmail.at.rospopa.pavlo.generics.passengers.Policeman;

public class PoliceCarFactory<T extends Policeman> extends VehicleFactory<T> {
    private final int CAPACITY = 2;

    @Override
    public Vehicle<T> createVehicle(String name) {
        return new PoliceCar<T>(getNextId(), name, CAPACITY);
    }

    @Override
    public Vehicle<T> createVehicle(String name, int capacity) {
        return new PoliceCar<T>(getNextId(), name, capacity);
    }
}
