package lab.parking.parking.page01.repository;

import java.util.ArrayList;
import java.util.List;

import lab.parking.parking.page01.model.Location;

public class LocationRepository {

    public List<Location> getAllLocation() {
        List<Location> locationList = new ArrayList<>();
        for(int i=1; i<=20; i++) {
            locationList.add(new Location(i, "Location " + i, i, 10));
        }

        return locationList;
    }

}
