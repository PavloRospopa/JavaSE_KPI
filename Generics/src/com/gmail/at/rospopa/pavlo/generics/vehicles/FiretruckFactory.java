package com.gmail.at.rospopa.pavlo.generics.vehicles;

import com.gmail.at.rospopa.pavlo.generics.passengers.Fireman;
import com.gmail.at.rospopa.pavlo.generics.passengers.Human;

public class FiretruckFactory<T extends Fireman> extends VehicleFactory<T> {
    private final int CAPACITY = 7;

    @Override
    public Vehicle<T> createVehicle(String name, int capacity) {
        return new Firetruck<T>(getNextId(), name, capacity);
    }

    @Override
    public Vehicle<T> createVehicle(String name) {
        return new Firetruck<T>(getNextId(), name, CAPACITY);
    }
}
