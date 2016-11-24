package com.gmail.at.rospopa.pavlo.generics.vehicles;

import com.gmail.at.rospopa.pavlo.generics.passengers.Human;

public class Taxi<T extends Human> extends Car<T> {
    public Taxi(Long id, String name, int capacity) {
        super(id, name, capacity);
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "id=" + getId() +
                ", taxi name='" + getName() + '\'' +
                ", count of passengers=" + getCount() +
                ", capacity=" + getCapacity() +
                ", passengers=" + getPassengers() +
                '}';
    }
}
