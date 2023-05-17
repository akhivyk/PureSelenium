package com.solvd.pure.selenium.components;

import com.solvd.pure.selenium.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenu extends AbstractPage {
    @FindBy(xpath = "//a[@href='/catalog/']")
    private WebElement devicesSection;

    @FindBy(xpath = "//a[@href='/services/']")
    private WebElement serviceSection;

    @FindBy(xpath = "//a[@href='/sale/']")
    private WebElement salesSection;

    @FindBy(xpath = "//a[@href='/blog/']")
    private WebElement blogSection;

    @FindBy(xpath = "//a[@href='/contacts/']")
    private WebElement contactsSection;

    public TopMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DevicesPage openDevicesPage() {
        devicesSection.click();
        return new DevicesPage(getDriver());
    }

    public ServicePage openServicePage() {
        serviceSection.click();
        return new ServicePage(getDriver());
    }

    public SalesPage openSalesPage() {
        salesSection.click();
        return new SalesPage(getDriver());
    }

    public BlogPage openBlogPage() {
        blogSection.click();
        return new BlogPage(getDriver());
    }

    public ContactsPage openContactsPage() {
        contactsSection.click();
        return new ContactsPage(getDriver());
    }
}
