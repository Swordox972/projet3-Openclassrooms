package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.DetailNeighbourActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.neighbour_list.AtPosition.atPosition;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;


/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule<>(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(atPosition(0, ViewMatchers.withId(R.id.list_neighbours)))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(atPosition(0, ViewMatchers.withId(R.id.list_neighbours))).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(atPosition(0, ViewMatchers.withId(R.id.list_neighbours)))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(atPosition(0, ViewMatchers.withId(R.id.list_neighbours))).check(withItemCount(ITEMS_COUNT - 1));
    }


    @Test
    public void myNeighbourList_TestIntent_ToDetailActivity() {

        Intents.init();
        // Click on a neighbour in the list
        onView(atPosition(0, withId(R.id.list_neighbours)))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));

        intended(hasComponent(DetailNeighbourActivity.class.getName()));

        //Check if TextView is displayed
        onView(withId(R.id.nom_voisin)).check(matches(allOf(withText("Vincent"), isDisplayed())));
        onView(withId(R.id.card_view_nom)).check(matches(allOf(withText("Vincent"), isDisplayed())));

        //Add neighbour to favorite
        onView(withId(R.id.fab_avatar_favorite)).perform(click());

        //click on back button
        onView(withContentDescription("Navigate up")).perform(click());

        // Click on favorite tab
        onView(withText("Favorites")).perform(click());


        // Check if neighbour is on favorite
        onView(withRecyclerView(R.id.list_neighbours).atPosition(2))
                .check(matches(hasDescendant(withText("Vincent"))));


    }

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }
}