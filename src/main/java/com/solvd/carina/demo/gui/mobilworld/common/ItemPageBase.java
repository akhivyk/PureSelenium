package com.solvd.carina.demo.gui.mobilworld.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ItemPageBase extends AbstractPage {

    public ItemPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void addToCartButton();

    public abstract String getPrice();

    public abstract String getCurrency();

    public abstract void clickRemoveAllItemsButton();

    public abstract String getTitleText();

    public abstract boolean isRemoveItemsButtonPresent();
}
