package com.solvd.carina.demo.gui.mobilworld.ios;

import com.solvd.carina.demo.gui.mobilworld.common.IphonePageBase;
import com.solvd.carina.demo.gui.mobilworld.common.SecondIphonePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

public class IphonePage extends IphonePageBase {

    @FindBy(xpath = "//div[@class='col-md-3 col-sm-4 col-xs-6']//div//div//a")
    private List<ExtendedWebElement> models;

    public IphonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<ExtendedWebElement> getModels() {
        waitUntil(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='col-md-3 col-sm-4 col-xs-6']//div//div//a")), 10);
        return models;
    }

    @Override
    public boolean isModelsPresent() {
        return models.isEmpty();
    }

    @Override
    public ExtendedWebElement findModel(String model) {
        return models.stream()
                .filter(e -> e.getText().equals(model))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Model " + model + " not found"));
    }

    public SecondIphonePageBase openIphonePage(String model) {
        ExtendedWebElement element = findModel(model);
        element.clickByJs();
        return new SecondIphonePage(getDriver());
    }
}
