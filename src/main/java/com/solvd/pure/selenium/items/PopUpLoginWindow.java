package com.solvd.pure.selenium.items;

import com.solvd.pure.selenium.pages.AbstractPage;
import com.solvd.pure.selenium.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpLoginWindow extends AbstractPage {
    protected WebDriver driver;

    @FindBy(xpath = "//input[@id='USER_LOGIN_POPUP']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='USER_PASSWORD_POPUP']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit' and @value='Войти']")
    private WebElement loginButton;

    public PopUpLoginWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoginInputPresent() {
        return isElementDisplayed(loginInput);
    }

    public boolean isPasswordInputPresent() {
        return isElementDisplayed(passwordInput);
    }

    public boolean isLoginButtonPresent() {
        return isElementDisplayed(loginButton);
    }

    public void inputLogin(String login) {
        setInputField(loginInput, login);
    }

    public void inputPassword(String password) {
        setInputField(passwordInput, password);
    }

    public MainPage login() {
        click(loginButton);
        return new MainPage(driver);
    }
}
