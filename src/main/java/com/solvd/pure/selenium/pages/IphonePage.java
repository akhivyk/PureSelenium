package com.solvd.pure.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IphonePage extends AbstractPage {
    @FindAll({@FindBy(xpath = "//div[@class='col-md-3 col-sm-4 col-xs-6']")})
    private List<WebElement> models;

    public IphonePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getModels() {
        waitForElementToBeClickable(getDriver(), models.get(0), 20);
        return models;
    }

    public WebElement findModel(String model) {
        return models.stream()
                .filter(e -> e.getText().equals(model))
                .findFirst()
                .orElse(null);
    }

    public SecondIphonePage clickModel(String model) {
        WebElement element = findModel(model);
        if (element != null) {
            click(element);
            return new SecondIphonePage(getDriver());
        }
        return null;
    }
}
