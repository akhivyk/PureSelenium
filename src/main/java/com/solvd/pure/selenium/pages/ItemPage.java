package com.solvd.pure.selenium.pages;

import com.solvd.pure.selenium.items.PopUpCartWindow;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends AbstractPage {
    protected WebDriver driver;

    @FindBy(xpath = "//span[@class='btn-lg w_icons to-cart btn btn-default transition_bg animate-load']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='opener']//div[contains(@class, 'basket_count clicked')]")
    private WebElement cartButton;

    @FindBy(xpath = "//span[@class='values_wrapper']/span[@class='price_value']")
    private WebElement price;

    @FindBy(xpath = "//span[@class='values_wrapper']/span[@class='price_currency']")
    private WebElement currency;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartButton() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", addToCartButton);
    }

    public boolean isAddedToCart() {
        return addToCartButton.getAttribute("style").contains("display: none;");
    }

    public PopUpCartWindow clickCartButton() {
        click(cartButton);
        return new PopUpCartWindow(driver);
    }

    public String getPrice() {
        return price.getAttribute("innerText");
    }

    public String getCurrency() {
        return currency.getAttribute("innerText");
    }
}
