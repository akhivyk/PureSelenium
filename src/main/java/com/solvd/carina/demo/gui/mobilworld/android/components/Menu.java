package com.solvd.carina.demo.gui.mobilworld.android.components;

import com.solvd.carina.demo.gui.mobilworld.android.*;
import com.solvd.carina.demo.gui.mobilworld.common.*;
import com.solvd.carina.demo.gui.mobilworld.common.components.MenuBase;
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

    private static final String THIS_METHOD_IS_DEFINED_ONLY_IN_IOS = "This method is only for IOS";

    public Menu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void openMenu() {
        waitUntil(ExpectedConditions.elementToBeClickable(openMenuBtn.getBy()), 10);
        openMenuBtn.click();
    }

    public void clickDevicesPage() {
        devicesSection.clickByJs();
    }

    public DevicesPageBase openDevicesPage() {
        secondDevicesSection.clickByJs();
        return new DevicesPage(driver);
    }

    public ServicesPageBase openServicesPage() {
        serviceSection.clickByJs();
        return new ServicesPage(driver);
    }

    public SalesPageBase openSalesPage() {
        salesSection.clickByJs();
        return new SalesPage(driver);
    }

    public BlogPageBase openBlogPage() {
        blogSection.clickByJs();
        return new BlogPage(driver);
    }

    public ContactsPageBase openContactsPage() {
        contactsSection.clickByJs();
        return new ContactsPage(driver);
    }

    @Override
    public LoginPageBase openLoginPage() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_DEFINED_ONLY_IN_IOS);
    }
}
