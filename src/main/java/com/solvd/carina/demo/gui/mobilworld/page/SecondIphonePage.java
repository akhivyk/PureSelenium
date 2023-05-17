package com.solvd.carina.demo.gui.mobilworld.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SecondIphonePage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@href, '/catalog/iphone/iphone_14_pro_max')]")
    private List<ExtendedWebElement> iphoneModels;

    public SecondIphonePage(WebDriver driver) {
        super(driver);
    }

    public boolean isIphoneModelsPresent() {
        return iphoneModels.isEmpty();
    }

    public List<ExtendedWebElement> getIphoneModels() {
        return iphoneModels;
    }

    public ExtendedWebElement findModel(String model) {
        return iphoneModels.stream()
                .filter(e -> e.getText().equals(model))
                .findFirst()
                .orElse(null);
    }

    public ItemPage clickItem(String model) {
        ExtendedWebElement element = findModel(model);
        if (element != null) {
            element.clickByJs();
            return new ItemPage(getDriver());
        }
        return null;
    }

}
