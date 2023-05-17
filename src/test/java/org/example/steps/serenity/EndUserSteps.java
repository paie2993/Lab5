package org.example.steps.serenity;

import org.example.pages.AltexPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EndUserSteps {

    AltexPage altexPage;

    @Step
    public void searches_and_enters(String keyword) {
        altexPage.enter_keywords_and_search(keyword);
    }

    @Step
    public void should_see_repository(final String repoNo) {
        assertThat(altexPage.getReposNo(), is(repoNo));
    }

    @Step
    public void is_the_home_page() {
        altexPage.open();
    }
}