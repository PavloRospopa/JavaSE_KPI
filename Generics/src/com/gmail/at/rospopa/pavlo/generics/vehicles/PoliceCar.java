package com.gmail.at.rospopa.pavlo.generics.vehicles;

import com.gmail.at.rospopa.pavlo.generics.passengers.Policeman;

public class PoliceCar<T extends Policeman> extends Car<T> {
    public PoliceCar(Long id, String name, int capacity) {
        super(id, name, capacity);
    }

    @Override
    public String toString() {
        return "Police car{" +
                "id=" + getId() +
                ", police car name='" + getName() + '\'' +
                ", count of passengers=" + getCount() +
                ", capacity=" + getCapacity() +
                ", passengers=" + getPassengers() +
                '}';
    }
}
