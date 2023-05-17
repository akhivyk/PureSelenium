package com.solvd.pure.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SecondIphonePage extends AbstractPage {
    @FindBy(xpath = "//a[contains(@href, '/catalog/iphone/iphone_14_pro_max')]")
    private List<WebElement> iphoneModels;

    public SecondIphonePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isIphoneModelsPresent() {
        return iphoneModels.isEmpty();
    }

    public List<WebElement> getIphoneModels() {
        return iphoneModels;
    }

    public WebElement findModel(String model) {
        return iphoneModels.stream()
                .filter(e -> e.getText().equals(model))
                .findFirst()
                .orElse(null);
    }

    public ItemPage clickItem(String model) {
        WebElement element = findModel(model);
        if (element != null) {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", element);
            return new ItemPage(getDriver());
        }
        return null;
    }
}
