package com.gmail.at.rospopa.pavlo.generics.vehicles;

import com.gmail.at.rospopa.pavlo.generics.passengers.Human;

public class BusFactory<T extends Human> extends VehicleFactory<T> {
    private final int CAPACITY = 20;

    @Override
    public Vehicle<T> createVehicle(String name, int capacity) {
        return new Bus<T>(getNextId(), name, capacity);
    }

    @Override
    public Vehicle<T> createVehicle(String name) {
        return new Bus<T>(getNextId(), name, CAPACITY);
    }
}
