package com.netology.tabbedapplication;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MyTestApp {
    private ViewInteraction tabOne = onView(
            allOf(withText("TAB 1")));
    private ViewInteraction tabTwo = onView(
            allOf(withText("TAB 2")));
    private ViewInteraction textOnPage = onView(
            allOf(withId(R.id.section_label), isDisplayed()));

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        // Видимость вкладок
        tabOne.check(matches(isDisplayed()));
        tabTwo.check(matches(isDisplayed()));

        //Соответствие текста на странице 1
        textOnPage.check(matches(withText("Page: 1")));

        //Переход на вторую вкладку и проверка текста
        tabTwo.perform(click());
        textOnPage.check(matches(withText("Page: 2")));
    }
}
