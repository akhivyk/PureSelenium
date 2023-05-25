package com.solvd.carina.demo.gui.mobilworld.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IphonePage extends AbstractPage {
    @FindBy(xpath = "//div[@class='col-md-3 col-sm-4 col-xs-6']//div//div//a")
    private List<ExtendedWebElement> models;

    public IphonePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://mobilworld.by/catalog/iphone/");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public List<ExtendedWebElement> getModels() {
        return models;
    }

    public ExtendedWebElement findModel(String model) {
        return models.stream()
                .filter(e -> e.getText().equals(model))
                .findFirst()
                .orElse(null);
    }

    public SecondIphonePage clickModel(String model) {
        ExtendedWebElement element = findModel(model);
        if (element != null) {
            element.clickByJs();
            return new SecondIphonePage(driver);
        }
        return null;
    }
}
