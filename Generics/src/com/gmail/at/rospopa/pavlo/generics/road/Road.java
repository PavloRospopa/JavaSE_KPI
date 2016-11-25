package com.gmail.at.rospopa.pavlo.generics.road;

import com.gmail.at.rospopa.pavlo.generics.passengers.Human;
import com.gmail.at.rospopa.pavlo.generics.vehicles.Vehicle;

public interface Road {
    int getCountOfHumans();
    void addVehicleToRoad(Vehicle<? extends Human> vehicle);
}
