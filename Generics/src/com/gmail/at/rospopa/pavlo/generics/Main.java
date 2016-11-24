package com.gmail.at.rospopa.pavlo.generics;

import com.gmail.at.rospopa.pavlo.generics.passengers.*;
import com.gmail.at.rospopa.pavlo.generics.road.Road;
import com.gmail.at.rospopa.pavlo.generics.road.RoadImpl;
import com.gmail.at.rospopa.pavlo.generics.vehicles.*;

public class Main {

    public static void main(String[] args) {
        VehicleFactory<Human> factory = new BusFactory<>();
        Vehicle<Human> vehicle = factory.createVehicle("Bus1");

        Vehicle<Human> vehicle1 = factory.createVehicle("Bus2");

        System.out.println(vehicle);


    }
}
