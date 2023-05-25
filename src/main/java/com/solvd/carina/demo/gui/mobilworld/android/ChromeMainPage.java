package com.solvd.carina.demo.gui.mobilworld.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ChromeMainPage extends AbstractPage {

    @FindBy(id = "com.android.chrome:id/search_box_text")
    private ExtendedWebElement searchLine;

    public ChromeMainPage(WebDriver driver) {
        super(driver);
    }

    public void inputSearch(String search) {
        searchLine.type(search);
    }

    public boolean isSearchLinePresent() {
        return searchLine.isElementPresent();
    }

    public void clickSearch() {
        searchLine.sendKeys(Keys.ENTER);
    }
}
