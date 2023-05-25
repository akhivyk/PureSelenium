package com.solvd.carina.demo.gui.mobilworld.android;

import com.solvd.carina.demo.gui.mobilworld.common.ItemPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ItemPageBase.class)
public class ItemPage extends ItemPageBase {

    @FindBy(xpath = "//span[contains(text(), 'В корзину')]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[@class='opener']//div[contains(@class, 'basket_count clicked')]")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//span[@class='values_wrapper']/span[@class='price_value']")
    private ExtendedWebElement price;

    @FindBy(xpath = "//span[@class='values_wrapper']/span[@class='price_currency']")
    private ExtendedWebElement currency;

    @FindBy(xpath = "//span[contains(@class, 'remove_all_basket') and contains(@class, 'AnDelCanBuy') and contains(@class, 'cur') and @data-type='basket']")
    private ExtendedWebElement removeAllItemsButton;

    @FindBy(xpath = "//div[@class='title']")
    private ExtendedWebElement cartTitle;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void addToCartButton() {
        addToCartButton.clickByJs();
    }

    public boolean isAddedToCart() {
        return addToCartButton.getAttribute("style").contains("display: none;");
    }

    public String getPrice() {
        return price.getAttribute("innerText");
    }

    public String getCurrency() {
        return currency.getAttribute("innerText");
    }

    public void clickRemoveAllItemsButton() {
        pause(5);
        removeAllItemsButton.click();
    }

    public String getTitleText() {
        pause(5);
        return cartTitle.getText();
    }

    public boolean isRemoveItemsButtonPresent() {
        return removeAllItemsButton.isElementPresent(5);
    }
}
