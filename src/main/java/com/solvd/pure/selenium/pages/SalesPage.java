package com.solvd.pure.selenium.pages;

import com.solvd.pure.selenium.components.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesPage extends AbstractPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='header-wrapper topmenu-LIGHT']")
    private TopMenu topMenu;

    public SalesPage(WebDriver driver) {
        topMenu = new TopMenu(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
