package lab.parking.parking.page01.view;

import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.AdapterView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;

import lab.parking.parking.R;
import lab.parking.parking.page01.model.Location;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void should_display_correct_list_of_location() {
        int maxSizeOfLocation = 20;
        onData(instanceOf(Location.class))
                .inAdapterView(withId(R.id.parking_list_view))
                .atPosition(maxSizeOfLocation - 1)
                .check(matches(isDisplayed()));
    }

    @Test
    public void should_have_size_20() {
        int maxSizeOfLocation = 20;
        onView(withId(R.id.parking_list_view)).
                check(matches(ListMatcher.withListSize(maxSizeOfLocation)));
    }

    @Test
    public void check_data_in_first_position_in_list() {
        onData(anything())
                .inAdapterView(withId(R.id.parking_list_view))
                .atPosition(0)
                .onChildView(withId(R.id.location_name))
                .check(matches(withText("Location 1")));
    }

    @Test
    public void check_data_in_last_position_in_list() {
        onData(anything())
                .inAdapterView(withId(R.id.parking_list_view))
                .atPosition(20-1)
                .onChildView(withId(R.id.location_name))
                .check(matches(withText("Location 20")));
    }

}

class ListMatcher {
    public static Matcher<View> withListSize (final int size) {
        return new TypeSafeMatcher<View>() {
            int length;
            @Override public boolean matchesSafely (final View view) {
                length = ((AdapterView) view).getAdapter().getCount();

                return length == size;
            }

            @Override public void describeTo (final Description description) {
                description.appendText ("ListView should have " + size + " items, the actual size is " + length);
            }
        };
    }
}


