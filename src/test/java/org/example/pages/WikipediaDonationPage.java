package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://donate.wikimedia.org/")
public class WikipediaDonationPage extends PageObject {
    @FindBy(id = "input_amount_other_box")
    private WebElementFacade donationInput;

    public final void enter_amount(final String amount) {
        donationInput.type(amount);
    }

    public final Boolean hasSmallAmountErrorText() {
        WebElementFacade errorText = findFirst(By.className("lp-error-smallamount")).get();


        return errorText.isDisplayed();
    }
}
