package com.solvd.pure.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends AbstractPage {
    @FindBy(xpath = "//h1[@id='pagetitle']")
    private WebElement titleText;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitleText() {
        return titleText.getText();
    }
}
