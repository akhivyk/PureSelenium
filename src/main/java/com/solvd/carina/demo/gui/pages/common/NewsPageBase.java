package com.solvd.carina.demo.gui.pages.common;

import com.solvd.carina.demo.gui.components.NewsItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class NewsPageBase extends AbstractPage {

    public NewsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<NewsItem> searchNews(String searchInput);

}
