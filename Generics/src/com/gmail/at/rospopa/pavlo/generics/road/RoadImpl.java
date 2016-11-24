package com.gmail.at.rospopa.pavlo.generics.road;

import com.gmail.at.rospopa.pavlo.generics.vehicles.Vehicle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoadImpl implements Road {
    private String roadName;

    private List<Vehicle> vehiclesInRoad = new ArrayList<>();

    public RoadImpl(String roadName) {
        this.roadName = roadName;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public List<Vehicle> getVehiclesInRoad() {
        return Collections.unmodifiableList(vehiclesInRoad);
    }

    @Override
    public int getCountOfHumans() {
        int count = 0;
        for (Vehicle v : vehiclesInRoad) {
            count += v.getCount();
        }
        return count;
    }

    @Override
    public void addVehicleToRoad(Vehicle vehicle) {

        vehiclesInRoad.add(vehicle);
    }
}
