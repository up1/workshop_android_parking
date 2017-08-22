package lab.parking.parking.page01.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

    public List<Location> filterOutEmpty(List<Location> locationList) {
        List<Location> notEmptyLocation = new ArrayList<>();
        for (Location location: locationList) {
            if(location.getAvailable() != 0) {
                notEmptyLocation.add(location);
            }
        }
        return notEmptyLocation;
    }

    public void sortByDistanceAsc(List<Location> locationList) {
        Collections.sort(locationList, new LocationDistanceComparator());
    }
}

class LocationDistanceComparator implements Comparator<Location> {
    @Override
    public int compare(Location a, Location b) {
        return a.getDistance() < b.getDistance()? -1: 0;
    }
}
