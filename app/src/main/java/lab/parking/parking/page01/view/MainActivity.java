package lab.parking.parking.page01.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import lab.parking.parking.R;
import lab.parking.parking.page01.model.Location;
import lab.parking.parking.page01.network.LocationAPI;
import lab.parking.parking.page01.repository.LocationRepository;

public class MainActivity extends AppCompatActivity implements LocationAPI.LocationAPIListener{

    private ListView mListView;
    private LocationAdapter locationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create Simple ListView
        mListView = (ListView) findViewById(R.id.parking_list_view);
//        final List<Location> locationList
//                = new LocationRepository().getAllLocation();
        new LocationRepository().getDataFromLocationAPI(this);

        locationAdapter
                = new LocationAdapter(this, new ArrayList<Location>());
        mListView.setAdapter(locationAdapter);

    }

    @Override
    public void onSuccess(List<Location> locationList) {
        locationAdapter.setDatasource(locationList);
        locationAdapter.notifyDataSetChanged();
    }
}
