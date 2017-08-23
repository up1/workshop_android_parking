package lab.parking.parking.page01.view;

import android.content.Intent;
import android.support.test.espresso.core.deps.guava.base.Charsets;
import android.support.test.espresso.core.deps.guava.io.Resources;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import lab.parking.parking.R;
import lab.parking.parking.page01.network.LocationAPI;
import lab.parking.parking.page01.repository.LocationRepository;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

public class MainActivityWithAPITest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class, true, false);

    private MockWebServer mockWebServer;

    @Before
    public void startMockServer() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        LocationRepository.BASE_URL = mockWebServer.url("/").toString();
    }

    @Test
    public void success_with_size_2() throws Exception {
        String fileName = "location_success.json";
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(getDataFromFile(fileName)));

        Intent intent = new Intent();
        activityTestRule.launchActivity(intent);

        int maxSizeOfLocation = 2;
        onView(withId(R.id.parking_list_view)).
                check(matches(ListMatcher.withListSize(maxSizeOfLocation)));
    }

    @Test
    public void success_with_data() throws Exception {
        String fileName = "location_success.json";
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(getDataFromFile(fileName)));

        Intent intent = new Intent();
        activityTestRule.launchActivity(intent);

        int maxSizeOfLocation = 2;

        onData(anything())
                .inAdapterView(withId(R.id.parking_list_view))
                .atPosition(maxSizeOfLocation-1)
                .onChildView(withId(R.id.location_name))
                .check(matches(withText("ทดสอบที่ 1")));
    }

    private String getDataFromFile(String resource) throws IOException {
        return Resources.toString(Resources.getResource(resource),
                Charsets.UTF_8);
    }

    @After
    public void stopMockServer() throws IOException {
        mockWebServer.shutdown();
    }

}