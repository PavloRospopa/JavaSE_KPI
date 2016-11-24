package com.gmail.at.rospopa.pavlo.generics.vehicles;

import com.gmail.at.rospopa.pavlo.generics.passengers.Fireman;

public class Firetruck<T extends Fireman> extends Car<T> {
    public Firetruck(Long id, String name, int capacity) {
        super(id, name, capacity);
    }

    @Override
    public String toString() {
        return "Firetruck{" +
                "id=" + getId() +
                ", firetruck name='" + getName() + '\'' +
                ", count of passengers=" + getCount() +
                ", capacity=" + getCapacity() +
                ", passengers=" + getPassengers() +
                '}';
    }
}
