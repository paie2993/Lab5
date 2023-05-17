package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.Wikipedia;
import org.example.pages.WikipediaDonationPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EndUserSteps {

    Wikipedia wikipedia;
    WikipediaDonationPage wikipediaDonationPage;

    @Step
    public void searches_and_enters(String keyword) {
        wikipedia.enter_keywords_and_search(keyword);
    }

    @Step
    public void should_see_title(final String title) {
        assertThat(wikipedia.getTitle(), is(title));
    }

    @Step
    public void should_see_no_results() {
        assertThat(wikipedia.hasSearchResults(), is(false));
    }

    @Step
    public void opens_the_home_page() {
        wikipedia.open();
    }

    @Step
    public void opens_the_donation_page() {
        wikipediaDonationPage.open();
    }

    @Step
    public void enters_donation_amount(String amount) {
        wikipediaDonationPage.enter_amount(amount);
    }

    @Step
    public void sees_error() {
        assertThat(wikipediaDonationPage.hasSmallAmountErrorText(), is(true));
    }

    @Step
    public void sees_no_error() {
        assertThat(wikipediaDonationPage.hasSmallAmountErrorText(), is(false));
    }
}