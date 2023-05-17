package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.wikipedia.org/")
public class Wikipedia extends PageObject {

    @FindBy(id = "searchInput")
    private WebElementFacade searchInput;

    public final void enter_keywords_and_search(final String keyword) {
        searchInput.typeAndEnter(keyword);
    }

    public final String getTitle() {
        final WebElementFacade title = findFirst(By.className("mw-page-title-main")).get();
        return title.getText();
    }

    public final Boolean hasSearchResults() {
        return findFirst(By.className("mw-search-results-container")).isPresent();
    }
}