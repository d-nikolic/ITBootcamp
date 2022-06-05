package com.bootcamp.zadatak.za.nas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
LoginPage – dodati neophodne metode
 */
public class LoginPage extends BasePage {

    private By username = By.id("txt-username");
    private By password = By.id("txt-password");
    private By loginButton = By.id("btn-login");


    public void clearField(By locator) {
        getDriver().findElement(locator).clear();
    }

    public void enterUsername(String username) {
        clearField(this.username);
        getDriver().findElement(this.username).sendKeys(username);

    }

    public void enterPassword(String password) {
        clearField(this.password);
        getDriver().findElement(this.password).sendKeys(password);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        getDriver().findElement(loginButton).click();
    }


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
}
