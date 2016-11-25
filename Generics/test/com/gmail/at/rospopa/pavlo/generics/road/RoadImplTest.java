package com.gmail.at.rospopa.pavlo.generics.road;

import com.gmail.at.rospopa.pavlo.generics.passengers.Human;
import com.gmail.at.rospopa.pavlo.generics.passengers.PoliceRank;
import com.gmail.at.rospopa.pavlo.generics.passengers.Policeman;
import com.gmail.at.rospopa.pavlo.generics.vehicles.Bus;
import com.gmail.at.rospopa.pavlo.generics.vehicles.PoliceCar;
import com.gmail.at.rospopa.pavlo.generics.vehicles.Taxi;
import com.gmail.at.rospopa.pavlo.generics.vehicles.Vehicle;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoadImplTest {
    @Test
    public void testRoadMethods() throws Exception {
        Vehicle<Human> vehicle = new Taxi<>(121L, "Taxi", 5);
        vehicle.seatPassenger(new Human(1L, "Pavlo Rospopa")); //1st
        vehicle.seatPassenger(new Human(2L, "Mike Longer")); //2nd

        Bus<Human> bus = new Bus<>(100L, "Bus", 10);
        Human cop = new Policeman(3L, "Mr. Cop", PoliceRank.DEPUTY );
        bus.seatPassenger(cop); //3rd

        PoliceCar<Policeman> policeCar = new PoliceCar<>(144L, "Police car", 2);
        policeCar.seatPassenger(new Policeman(1232L, "Duan Rocky", PoliceRank.COMMANDER)); //4th
        policeCar.seatPassenger(new Policeman(12323L, "Rodger Ri", PoliceRank.SERGEANT));  //5th

        Road road = new RoadImpl("Street 21");
        road.addVehicleToRoad(vehicle);
        road.addVehicleToRoad(bus);
        road.addVehicleToRoad(policeCar);

        assertEquals(5, road.getCountOfHumans());
    }
}