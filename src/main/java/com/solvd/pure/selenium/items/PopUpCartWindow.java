package com.solvd.pure.selenium.items;

import com.solvd.pure.selenium.pages.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpCartWindow extends AbstractPage {
    protected WebDriver driver;

    @FindBy(xpath = "//td[@class='remove-cell']//a[@class='remove']")
    private WebElement removeAllItemsButton;

    @FindBy(xpath = "//div[@class='text']//div[@class='title']")
    private WebElement cartTitle;

    public PopUpCartWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void removeAllItemsFromCart() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", removeAllItemsButton);
    }

    public String getTitleText() {
        return cartTitle.getText();
    }
}
