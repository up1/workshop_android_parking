package lab.parking.parking.page01.repository;

import java.util.ArrayList;
import java.util.List;

import lab.parking.parking.page01.model.Location;

public class LocationRepository {

    public List<Location> getAllLocation() {
        List<Location> locationList = new ArrayList<>();
        locationList.add(new Location(1, "Location 1", 1, 10));
        locationList.add(new Location(2, "Location 2", 2, 10));
        locationList.add(new Location(3, "Location 3", 3, 10));
        locationList.add(new Location(4, "Location 4", 4, 10));
        locationList.add(new Location(5, "Location 5", 5, 10));

        return locationList;
    }

}
