package com.bootcamp.domaci;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerPage extends BasePage {


    private By yourName = By.id("userSelect");

    private By home = By.xpath("/html/body/div/div/div[1]/button[1]");


    public void selectingCustomer(String name) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(yourName));
        Select customer = new Select(getDriver().findElement(yourName));
        customer.selectByVisibleText(name);
        getDriver().findElement(By.xpath("//*[contains(text(), 'Login')]")).click();
    }


    public CustomerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void returningToLoginPage() {
        getDriver().findElement(home).click();
    }
}
