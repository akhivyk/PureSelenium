package com.solvd.carina.demo.gui.mobilworld.components;

import com.solvd.carina.demo.gui.mobilworld.page.MainPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PopUpLoginWindow extends AbstractPage {
    @FindBy(xpath = "//input[@id='USER_LOGIN_POPUP']")
    private ExtendedWebElement loginInput;

    @FindBy(xpath = "//input[@id='USER_PASSWORD_POPUP']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit' and @value='Войти']")
    private ExtendedWebElement loginButton;

    public PopUpLoginWindow(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginInput);
    }

    public boolean isLoginInputPresent() {
        return loginInput.isElementPresent(1);
    }

    public boolean isPasswordInputPresent() {
        return passwordInput.isElementPresent(1);
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent(1);
    }

    public void inputLogin(String login) {
        loginInput.type(login);
    }

    public void inputPassword(String password) {
        passwordInput.type(password);
    }

    public MainPage login() {
        loginButton.click();
        return new MainPage(driver);
    }
}
