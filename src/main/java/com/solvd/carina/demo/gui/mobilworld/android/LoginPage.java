package com.solvd.carina.demo.gui.mobilworld.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "USER_LOGIN_POPUP")
    private ExtendedWebElement loginInput;

    @FindBy(id = "USER_PASSWORD_POPUP")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@name='Login']")
    private ExtendedWebElement loginButton;

    @FindBy(id = "pagetitle")
    private ExtendedWebElement pageTitle;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://mobilworld.by/auth/");
    }

    public boolean isLoginInputPresent() {
        return loginInput.isElementPresent();
    }

    public void inputLogin(String login) {
        loginInput.type(login);
    }

    public boolean isPasswordInputPresent() {
        return passwordInput.isElementPresent();
    }

    public void inputPassword(String password) {
        passwordInput.type(password);
    }

    public LoginPage login() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }
}
