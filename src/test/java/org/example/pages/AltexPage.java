package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.emag.ro/")
public class Emag extends PageObject {

    @FindBy(id = "searchboxTrigger")
    private WebElementFacade searchInput;

    public final void enter_keywords_and_search(final String keyword) {
        searchInput.typeAndEnter(keyword);
    }

    public final String getProducts() {
        final WebElementFacade products = findFirst(By.className("font-bold"));
        return products.getText();
    }
}