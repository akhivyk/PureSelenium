package com.solvd.pure.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IphonePage {
    private WebDriver driver;

    @FindAll({@FindBy(xpath = "//div[@class='col-md-3 col-sm-4 col-xs-6']")})
    private List<WebElement> models;

    public IphonePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isModelsPresent () {
        return models.isEmpty();
    }

    public List<WebElement> getModels () {
        return models;
    }
}
