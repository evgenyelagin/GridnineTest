package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        System.out.println("flightList without filters: " + flightList);
        System.out.println();
      System.out.println("Filter - flights with departures up to the current time: " + Filters.DeparturedUntilNow(flightList));
        System.out.println();
        System.out.println("Filter -  flights with incorrect segments: " + Filters.DepartureAfterArrive(flightList));
        System.out.println();
       System.out.println("Filter -  flights with a time on the ground of more than 2 hours: " + Filters.MoreTwoHoursOnGround(flightList));
    }
}
