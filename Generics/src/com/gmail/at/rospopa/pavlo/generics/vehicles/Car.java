package com.gmail.at.rospopa.pavlo.generics.vehicles;

import com.gmail.at.rospopa.pavlo.generics.passengers.Human;

public abstract class Car<T extends Human> extends AbstractVehicle<T> {
    public Car(Long id, String name, int capacity) {
        super(id, name, capacity);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + getId() +
                ", car name='" + getName() + '\'' +
                ", count of passengers=" + getCount() +
                ", capacity=" + getCapacity() +
                ", passengers=" + getPassengers() +
                '}';
    }
}
