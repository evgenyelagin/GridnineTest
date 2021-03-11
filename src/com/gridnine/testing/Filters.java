package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


class Filters {

    static List<Flight> DeparturedUntilNow(List<Flight> flights) {
        List<Flight> filtered = new ArrayList<>();
        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            if (flight.getSegments().get(0).getDepartureDate().isAfter(LocalDateTime.now())) {
                filtered.add(flight);
            }
        }
        return filtered;
    }

    static List<Flight> DepartureAfterArrive(List<Flight> flights) {
        List<Flight> filtered = new ArrayList<>();
        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            boolean flag = true;
            List<Segment> segs = flights.get(i).getSegments();
            for (int j = 0; j < segs.size(); j++) {
                Segment currentSeg = segs.get(j);
                if (currentSeg.getArrivalDate().isBefore(currentSeg.getDepartureDate())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                filtered.add(flight);
            }
        }
        return filtered;
    }

    static List<Flight> MoreTwoHoursOnGround(List<Flight> flights) {
        List<Flight> filtredCollection = new ArrayList<>();
        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            long minuteOnGround = 0;
            List<Segment> segs = flights.get(i).getSegments();
            for (int j = 0; j < segs.size() - 1; j++) {
                minuteOnGround += ChronoUnit.MINUTES.between(segs.get(j).getArrivalDate(), segs.get(j + 1).getDepartureDate());
            }
            if (minuteOnGround <= 120) {
                filtredCollection.add(flight);
            }
        }
        return filtredCollection;
    }
}