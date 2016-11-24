package com.gmail.at.rospopa.pavlo.generics.vehicles;

import com.gmail.at.rospopa.pavlo.generics.passengers.Human;

public abstract class VehicleFactory<T extends Human> {

    private static long nextId = 0;

    protected long getNextId() {
        return nextId++;
    }

    public abstract Vehicle<T> createVehicle(String name);
    public abstract Vehicle<T> createVehicle(String name, int capacity);
}
