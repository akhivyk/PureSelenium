package com.solvd.carina.demo.gui.mobilworld.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    @FindBy(xpath = "//span[@class='wrap_remove_button']//span]")
    private ExtendedWebElement removeAllItemsButton;

    @FindBy(xpath = "//div[@class='text']//div[@class='title']")
    private ExtendedWebElement cartTitle;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void removeAllItemsFromCart() {
        removeAllItemsButton.click();
    }

    public String getTitleText() {
        return cartTitle.getText();
    }
}
