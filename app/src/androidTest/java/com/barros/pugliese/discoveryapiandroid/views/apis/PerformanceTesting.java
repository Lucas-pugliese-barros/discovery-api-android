package com.barros.pugliese.discoveryapiandroid.views.apis;

import android.os.SystemClock;
import android.view.View;

import com.barros.pugliese.discoveryapiandroid.R;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class PerformanceTesting {

    private static final Integer MAX_OF_ITEMS = 4;

    @Before
    public void launchActivity() {
        ActivityScenario.launch(ApiListActivity.class);
    }

    @Test
    public void mainTest() {
        SystemClock.sleep(2000);

        for (int position = 0; position < MAX_OF_ITEMS; position++) {
            onView(withId(R.id.list)).perform(
                    RecyclerViewActions.actionOnItemAtPosition(position, clickChildAction(R.id.is_favorite)));

            SystemClock.sleep(500);
        }

        onView(withId(R.id.action_favorite)).perform(click());
    }

    private ViewAction clickChildAction(final int id) {
        return new ViewAction() {

            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with id = " + String.valueOf(id);
            }

            @Override
            public void perform(UiController uiController, View view) {
                View checkBox = view.findViewById(id);
                checkBox.performClick();
            }
        };
    }

}
