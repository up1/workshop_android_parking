package lab.parking.parking.page01.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import lab.parking.parking.R;
import lab.parking.parking.page01.model.Location;
import lab.parking.parking.page01.repository.LocationRepository;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create Simple ListView
        mListView = (ListView) findViewById(R.id.parking_list_view);
        final List<Location> locationList
                = new LocationRepository().getAllLocation();
        LocationAdapter locationAdapter
                = new LocationAdapter(this, locationList);
        mListView.setAdapter(locationAdapter);

    }
}
