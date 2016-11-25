package com.gmail.at.rospopa.pavlo.generics;

import com.gmail.at.rospopa.pavlo.generics.passengers.*;
import com.gmail.at.rospopa.pavlo.generics.road.Road;
import com.gmail.at.rospopa.pavlo.generics.road.RoadImpl;
import com.gmail.at.rospopa.pavlo.generics.vehicles.*;

public class Main {

    public static void main(String[] args) {
        Vehicle<Human> vehicle1 = new Bus<>(1L, "Bus 1", 20);
        Vehicle<Policeman> vehicle2 = new Bus<>(2L, "Bus 2", 10);
        Vehicle<Fireman> vehicle3 = new Firetruck<>(3L, "Firetruck 1", 7);
        Car<Human> car = new Taxi<>(4L, "Taxi", 5);
        try {
            vehicle1.seatPassenger(new Human(1L, "Alan"));

        }
        catch (Exception e)
        {}

    }
}
