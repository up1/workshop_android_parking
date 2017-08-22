package lab.parking.parking.page01.repository;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import lab.parking.parking.page01.model.Location;

import static org.junit.Assert.*;

public class LocationRepositoryTest {
    @Test public void
    กรองข้อมูลของที่จอดรถที่ไม่ว่างออกไป(){
        List<Location> locationList = new ArrayList<>();
        locationList.add(new Location(1, "Location 1", 1, 10));
        locationList.add(new Location(2, "Location 2", 1, 0));

        LocationRepository locationRepository = new LocationRepository();
        List<Location> actualLocationList = locationRepository.filterOutEmpty(locationList);
        assertEquals(1, actualLocationList.size());
        assertEquals(1, actualLocationList.get(0).getId());
        assertEquals("Location 1", actualLocationList.get(0).getName());
        assertEquals(10, actualLocationList.get(0).getAvailable());
    }

    @Test public void
    เรียงลำดับข้อมูลจากระยะทางใกล้ไปไกล() {
        List<Location> locationList = new ArrayList<>();
        locationList.add(new Location(1, "Location 1", 3, 10));
        locationList.add(new Location(2, "Location 2", 2, 10));
        locationList.add(new Location(3, "Location 3", 1, 10));

        LocationRepository locationRepository = new LocationRepository();
        locationRepository.sortByDistanceAsc(locationList);

        assertEquals(3, locationList.size());
        assertEquals(3, locationList.get(0).getId());
        assertEquals("Location 3", locationList.get(0).getName());
        assertEquals(1, locationList.get(0).getDistance());
    }

}