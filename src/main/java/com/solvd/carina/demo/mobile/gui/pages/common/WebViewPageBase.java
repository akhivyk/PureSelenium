package com.solvd.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebViewPageBase extends AbstractPage implements IMobileUtils {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ContactUsPageBase goToContactUsPage();

}
