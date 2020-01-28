
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
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

    private static int FAVORIS_ITEM = 1;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least one item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).
                check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(allOf(withId(R.id.list_neighbours),isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(allOf(withId(R.id.list_neighbours),isDisplayed())).check(withItemCount(ITEMS_COUNT-1));
    }

    /**@Test
    public void myFavoriteListShouldBeEmpty(){
        onView(withContentDescription("Favorites")).perform(click());

        onView(allOf(withId(R.id.list_neighbours),isDisplayed())).check(withItemCount(0));
    }
    /**
     * This test will check if our new features work properly
     */
    @Test
    public void myNeighboursList_clickOnFavButton_shouldAddNeighbourToFavList(){

        //click on the first item
        onView(allOf(withId(R.id.list_neighbours),isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        //check if neighbour detail is displayed
        onView(allOf(withId(R.id.profilpage))).check(matches(isDisplayed()));
        // click on fav button to add the neighbour at position 0 to our favorite list
        onView(withId(R.id.AddToFavorit)).perform(click());
        // click on backMainActivityButton should close profil page activity and should resumed list neighbour activity
        onView(withId(R.id.BackMainActivityButton)).perform(click());
        //check if list neighbours activity has resumed
        //onView(allOf(withId(R.id.list_neighbours))).check(matches(isDisplayed()));
        //now we gonna check if our favorite list has been updated
        onView(withContentDescription("Favorites")).perform(click());
        //onView(allOf(withId(R.id.list_neighbours),isDisplayed())).check(withItemCount(FAVORIS_ITEM));
        onView(allOf(withId(R.id.list_neighbours),isDisplayed())).check(withItemCount(FAVORIS_ITEM));

    }

}