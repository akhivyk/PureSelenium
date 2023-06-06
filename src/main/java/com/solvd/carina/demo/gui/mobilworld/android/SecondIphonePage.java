package com.solvd.carina.demo.gui.mobilworld.android;

import com.solvd.carina.demo.gui.mobilworld.common.SecondIphonePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SecondIphonePageBase.class)
public class SecondIphonePage extends SecondIphonePageBase {

    @FindBy(xpath = "//a[contains(@href, '/catalog/iphone/iphone_14_pro_max')]//span")
    private List<ExtendedWebElement> iphoneModels;

    public SecondIphonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isIphoneModelsPresent() {
        waitUntil(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(@href, '/catalog/iphone')]")), 10);
        return iphoneModels.isEmpty();
    }

    @Override
    public ExtendedWebElement findModel(String model) {
        return iphoneModels.stream()
                .filter(e -> e.getText().equals(model))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Model " + model + " not found"));
    }

    public ItemPage openItemPage(String model) {
        ExtendedWebElement element = findModel(model);
        element.clickByJs();
        return new ItemPage(driver);
    }

    public List<ExtendedWebElement> getIphoneModels() {
        return iphoneModels;
    }
}
