package com.gmail.at.rospopa.pavlo.generics.vehicles;

import com.gmail.at.rospopa.pavlo.generics.passengers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AbstractVehicleTest {

    private static AbstractVehicle<Fireman> firetruck;
    private static List<Fireman> fmlist;

    @BeforeClass
    public static void preparation()throws Exception{
        firetruck = new Firetruck<>(1l, "Firetruck", 3);

        Fireman fm1 = new Fireman(1L, "Steve Rodgers", FiremanRank.CAPTAIN);
        Fireman fm2 = new Fireman(2L, "Bran Miller", FiremanRank.TECHNICIAN);
        Fireman fm3 = new Fireman(3L, "Mike Du", FiremanRank.ENGINEER);

        fmlist = new ArrayList<>();
        fmlist.add(fm1);
        fmlist.add(fm2);
        fmlist.add(fm3);

        firetruck.seatPassenger(fm1);
        firetruck.seatPassenger(fm2);
        firetruck.seatPassenger(fm3);
    }

    @Test
    public void testSeatPassenger() throws CrowdedVehicleException {
        for (Fireman fm : fmlist) {
            assertTrue(firetruck.getPassengers().contains(fm));
        }
    }

    @Test(expected = CrowdedVehicleException.class)
    public void testSeatPassengerMethodForException() throws CrowdedVehicleException {
        firetruck.seatPassenger(new Fireman(1212L, "Dean Lean", FiremanRank.CAPTAIN));
    }

    @Test
    public void testDisembarkPassenger() throws PassengerNotInVehicleException {
        firetruck.disembarkPassenger(fmlist.get(0));
        firetruck.disembarkPassenger(fmlist.get(1));
        firetruck.disembarkPassenger(fmlist.get(2));
        assertEquals(0, firetruck.getCount());
    }

    @Test(expected = PassengerNotInVehicleException.class)
    public void testDisembarkPassengerMethodForException() throws PassengerNotInVehicleException {
        Fireman illegalfm = new Fireman(21323L, "Jon Jonsy", FiremanRank.ENGINEER);
        firetruck.disembarkPassenger(illegalfm);
    }
}