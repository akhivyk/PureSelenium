package com.solvd.carina.demo.gui.mobilworld.ios.components;

import com.solvd.carina.demo.gui.mobilworld.common.*;
import com.solvd.carina.demo.gui.mobilworld.common.components.MenuBase;
import com.solvd.carina.demo.gui.mobilworld.ios.*;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Menu extends MenuBase {

    @FindBy(xpath = "//div[@class='burger pull-left']")
    private ExtendedWebElement openMenuBtn;

    @FindBy(xpath = "//a[@href='/catalog/']")
    private ExtendedWebElement devicesSection;

    @FindBy(xpath = "//li[@class='menu_title']")
    private ExtendedWebElement secondDevicesSection;

    @FindBy(xpath = "//a[@href='/services/']")
    private ExtendedWebElement serviceSection;

    @FindBy(xpath = "//a[@href='/sale/']")
    private ExtendedWebElement salesSection;

    @FindBy(xpath = "//a[@href='/blog/']")
    private ExtendedWebElement blogSection;

    @FindBy(xpath = "//a[@href='/contacts/']")
    private ExtendedWebElement contactsSection;

    @FindBy(xpath = "//a[@href='/personal/']")
    private ExtendedWebElement loginSection;

    public Menu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void openMenu() {
        waitUntil(ExpectedConditions.elementToBeClickable(openMenuBtn.getBy()), 10);
        openMenuBtn.click();
    }

    @Override
    public void clickDevicesPage() {
        devicesSection.click();
    }

    @Override
    public DevicesPageBase openDevicesPage() {
        secondDevicesSection.click();
        return new DevicesPage(driver);
    }

    @Override
    public ServicesPageBase openServicesPage() {
        serviceSection.click();
        return new ServicesPage(driver);
    }

    @Override
    public SalesPageBase openSalesPage() {
        salesSection.click();
        return new SalesPage(driver);
    }

    @Override
    public BlogPageBase openBlogPage() {
        blogSection.click();
        return new BlogPage(driver);
    }

    @Override
    public ContactsPageBase openContactsPage() {
        contactsSection.click();
        return new ContactsPage(driver);
    }

    public LoginPageBase openLoginPage() {
        loginSection.click();
        return new LoginPage(driver);
    }
}
