package com.solvd.carina.demo.gui.mobilworld.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLoginInputPresent();

    public abstract boolean isPasswordInputPresent();

    public abstract void inputLogin(String login);

    public abstract void inputPassword(String password);

    public abstract LoginPageBase login();

    public abstract String getPageTitle();
}
