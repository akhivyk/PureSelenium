package com.solvd.carina.demo.gui.mobilworld.desktop;

import com.solvd.carina.demo.gui.mobilworld.components.PopUpLoginWindow;
import com.solvd.carina.demo.gui.mobilworld.components.TopMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    @FindBy(css = "a.dropdown-toggle[href='/catalog/'] > div")
    private ExtendedWebElement devicesSection;

    @FindBy(xpath = "//span[@class='wrap']/span[@class='name']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//a[@href='/personal/' and contains(@class, 'personal-link')]")
    private ExtendedWebElement accountButton;

    @FindBy(xpath = "//div[@class='col-md-8 menu-row']")
    private TopMenu topMenu;

    public MainPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://mobilworld.by/");
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setUiLoadedMarker(devicesSection);
    }

    public boolean isDeviceSectionPresent() {
        return devicesSection.isElementPresent(1);
    }

    public DevicesPage openDevicesSection() {
        devicesSection.click();
        return new DevicesPage(driver);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public PopUpLoginWindow openLoginWindow() {
        clickLoginButton();
        return new PopUpLoginWindow(driver);
    }

    public AccountPage openAccountPage() {
        clickLoginButton();
        return new AccountPage(driver);
    }

    public String getLoginButtonText() {
        return loginButton.getText();
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
