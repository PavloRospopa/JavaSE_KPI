package com.gmail.at.rospopa.pavlo.generics.vehicles;

import com.gmail.at.rospopa.pavlo.generics.passengers.Human;

public class Bus<T extends Human> extends VehicleImpl<T> {

    public Bus(Long id, String name, int capacity) {
        super(id, name, capacity);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + getId() +
                ", bus name='" + getName() + '\'' +
                ", count of passengers=" + getCount() +
                ", capacity=" + getCapacity() +
                ", passengers=" + getPassengers() +
                '}';
    }
}
