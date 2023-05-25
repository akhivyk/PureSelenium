package com.solvd.carina.demo.gui.mobilworld.android.components;

import com.solvd.carina.demo.gui.mobilworld.android.*;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Menu extends AbstractUIObject {

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


    public Menu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void openMenu() {
        openMenuBtn.click();
    }

    public void clickDevicesPage() {
        devicesSection.clickByJs();
    }

    public DevicesPage openDevicesPage() {
        secondDevicesSection.clickByJs();
        return new DevicesPage(driver);
    }

    public ServicesPage openServicesPage() {
        serviceSection.clickByJs();
        return new ServicesPage(driver);
    }

    public SalesPage openSalesPage() {
        salesSection.clickByJs();
        return new SalesPage(driver);
    }

    public BlogPage openBlogPage() {
        blogSection.clickByJs();
        return new BlogPage(driver);
    }

    public ContactsPage openContactsPage() {
        contactsSection.clickByJs();
        return new ContactsPage(driver);
    }
}
