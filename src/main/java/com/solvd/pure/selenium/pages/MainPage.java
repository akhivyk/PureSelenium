package com.solvd.pure.selenium.pages;

import com.solvd.pure.selenium.components.TopMenu;
import com.solvd.pure.selenium.items.PopUpLoginWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    @FindBy(css = "a.dropdown-toggle[href='/catalog/'] > div")
    private WebElement devicesSection;

    @FindBy(xpath = "//span[@class='wrap']/span[@class='name']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='/personal/' and contains(@class, 'personal-link')]")
    private WebElement accountButton;

    @FindBy(xpath = "//div[@class='wrapper_inner']")
    private TopMenu topMenu;

    public MainPage(WebDriver driver) {
        super(driver);
        topMenu = new TopMenu(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isDevicesSectionPresent() {
        return isElementDisplayed(devicesSection);
    }

    public DevicesPage clickDevicesSection() {
        click(devicesSection);
        return new DevicesPage(getDriver());
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public PopUpLoginWindow openLoginWindow() {
        clickLoginButton();
        return new PopUpLoginWindow(getDriver());
    }

    public AccountPage openAccountPage() {
        clickLoginButton();
        return new AccountPage(getDriver());
    }

    public String getLoginButtonText() {
        return loginButton.getText();
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
