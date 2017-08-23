package lab.parking.parking.page01.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lab.parking.parking.page01.model.Location;
import lab.parking.parking.page01.network.LocationAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LocationRepository {

    public static String BASE_URL = "http://xxx.com/";

    public void getDataFromLocationAPI(
            final LocationAPI.LocationAPIListener listener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LocationAPI locationAPI = retrofit.create(LocationAPI.class);
        final Call<List<Location>> call = locationAPI.getAll(0, 0);

        call.enqueue(new Callback<List<Location>>() {
            @Override
            public void onResponse(Call<List<Location>> call,
                                   Response<List<Location>> response) {
                if(response.isSuccessful()) {
                    listener.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Location>> call, Throwable t) {
                listener.onSuccess(new ArrayList<Location>());
            }
        });
    }

    public List<Location> getAllLocation() {
        // Try to use Data test !!
        List<Location> locationList = new ArrayList<>();
        for(int i=1; i<=20; i++) {
            locationList.add(new Location(i, "Location " + i, i, 10));
        }

        // Try to Filter and ordering data

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
