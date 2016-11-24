package com.gmail.at.rospopa.pavlo.generics.vehicles;

import com.gmail.at.rospopa.pavlo.generics.passengers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class VehicleImpl<T extends Human> implements Vehicle<T>{
    private final Long id;
    private final int capacity;
    private String name;
    private List<T> passengers = new ArrayList<>();

    public VehicleImpl(Long id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }
    @Override
    public int getCapacity() {
        return capacity;
    }
    @Override
    public int getCount() {
        return passengers.size();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    @Override
    public void seatPassenger(T passenger) throws CrowdedVehicleException {
        if (getCount() == capacity)
            throw new CrowdedVehicleException();
        passengers.add(passenger);
    }

    @Override
    public void disembarkPassenger(T passenger) throws PassengerNotInVehicleException {
        if (!passengers.contains(passenger))
            throw new PassengerNotInVehicleException();
        passengers.remove(passenger);
    }

    @Override
    public String toString() {
        return "VehicleImpl{" +
                "id=" + id +
                ", vehicle name='" + name + '\'' +
                ", count of passengers=" + getCount() +
                ", capacity=" + capacity +
                ", passengers=" + passengers +
                '}';
    }
}
