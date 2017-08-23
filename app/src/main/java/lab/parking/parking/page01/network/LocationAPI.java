package lab.parking.parking.page01.network;

import java.util.List;

import lab.parking.parking.page01.model.Location;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LocationAPI {

    interface LocationAPIListener {
        void onSuccess(List<Location> locationList);
    }

    @GET("location/{latitude}/{longitude}")
    Call<List<Location>> getAll(
            @Path("latitude") float latitude,
            @Path("longitude") float longitude);

}

