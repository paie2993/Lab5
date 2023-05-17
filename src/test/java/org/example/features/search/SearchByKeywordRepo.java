package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import org.example.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SearchByKeywordRepo {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Test
    public void searching_for_pizza_takes_you_to_page_for_pizza() {
        anna.opens_the_home_page();
        anna.searches_and_enters("pizza");
        anna.should_see_title("Pizza");
    }

    @Test
    public void searching_three_spaces_wont_return_results() {
        anna.opens_the_home_page();
        anna.searches_and_enters(" ");
        anna.should_see_no_results();
    }

    @Test
    public void entering_small_amount_shows_error() {
        anna.opens_the_donation_page();
        anna.enters_donation_amount("4.54");
        anna.sees_error();
    }

    @Test
    public void entering_large_amount_shows_no_error() {
        anna.opens_the_donation_page();
        anna.enters_donation_amount("4.56");
        anna.sees_no_error();
    }
}