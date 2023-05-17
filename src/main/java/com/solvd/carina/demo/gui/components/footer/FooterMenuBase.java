package com.solvd.carina.demo.gui.components.footer;

import com.solvd.carina.demo.gui.pages.common.HomePageBase;
import com.solvd.carina.demo.gui.pages.common.NewsPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FooterMenuBase extends AbstractUIObject {

    public FooterMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract NewsPageBase openNewsPage();

    public abstract HomePageBase openHomePage();
}
