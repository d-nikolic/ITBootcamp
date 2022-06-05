package com.bootcamp.domaci;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By customerLogin = By.xpath("//*[contains(text(), 'Customer Login')]");
    private By bankManagerLogin = By.xpath("//*[contains(text(), 'Bank Manager Login')]");

    private By home = By.xpath("/html/body/div/div/div[1]/button[1]");


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void loginAsManager() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(bankManagerLogin));
        getDriver().findElement(bankManagerLogin).click();

    }

    public void loginAsCustomer() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(home));
        if (getDriver().findElement(home).isDisplayed()) {
            getDriver().findElement(home).click();
        }

        getDriver().findElement(customerLogin).click();
    }
}
