package com.solvd.carina.demo.gui.mobilworld.ios;

import com.solvd.carina.demo.gui.mobilworld.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

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
    }

    @Override
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

    @Override
    public LoginPageBase login() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }
}
