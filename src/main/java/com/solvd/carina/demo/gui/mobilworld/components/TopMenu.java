package com.solvd.carina.demo.gui.mobilworld.components;

import com.solvd.carina.demo.gui.mobilworld.page.*;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends AbstractUIObject {
    @FindBy(xpath = "//a[@href='/catalog/']")
    private ExtendedWebElement devicesSection;

    @FindBy(xpath = "//a[@href='/services/']")
    private ExtendedWebElement serviceSection;

    @FindBy(xpath = "//a[@href='/sale/']")
    private ExtendedWebElement salesSection;

    @FindBy(xpath = "//a[@href='/blog/']")
    private ExtendedWebElement blogSection;

    @FindBy(xpath = "//a[@href='/contacts/']")
    private ExtendedWebElement contactsSection;

    public TopMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public DevicesPage openDevicesPage() {
        devicesSection.click();
        return new DevicesPage(driver);
    }

    public ServicePage openServicePage() {
        serviceSection.click();
        return new ServicePage(driver);
    }

    public SalesPage openSalesPage() {
        salesSection.click();
        return new SalesPage(driver);
    }

    public BlogPage openBlogPage() {
        blogSection.click();
        return new BlogPage(driver);
    }

    public ContactsPage openContactsPage() {
        contactsSection.click();
        return new ContactsPage(driver);
    }
}
