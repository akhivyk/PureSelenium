package com.solvd.carina.demo.gui.mobilworld.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {
    @FindBy(xpath = "//h1[@id='pagetitle']")
    private ExtendedWebElement titleText;

    public AccountPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://mobilworld.by/personal/");
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setUiLoadedMarker(titleText);
    }

    public String getTitleText() {
        return titleText.getText();
    }
}
