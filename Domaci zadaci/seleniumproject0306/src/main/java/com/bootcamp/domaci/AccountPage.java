package com.bootcamp.domaci;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage extends BasePage {

    private By transactions = By.xpath("//*[contains(text(), 'Transactions')]");
    private By deposit = By.xpath("//*[contains(text(), 'Deposit')]");
    private By withdrawl = By.xpath("//*[contains(text(), 'Withdrawl')]");
    private By depositSubmit = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");

    private By withdrawlSubmit = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");

    private By customerLogout = By.xpath("/html/body/div/div/div[1]/button[2]");

    private By customerCredentials = By.xpath("/html/body/div/div/div[2]/div/div[1]/strong/span");

    private LoginPage loginPage;


    public AccountPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public String deposit(int amount) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(deposit));
        getDriver().findElement(deposit).click();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")));
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("" + amount);
        getDriver().findElement(depositSubmit).click();
        By depositSuccessful = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(depositSuccessful));
        return getDriver().findElement(depositSuccessful).getText();
    }

    public String withdrawl(int amount) {
        getDriver().navigate().refresh(); //nista bez refresha
        getDriverWait().until(ExpectedConditions.elementToBeClickable(withdrawl));
        getDriver().findElement(withdrawl).click();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")));
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("" + amount);
        getDriver().findElement(withdrawlSubmit).click();
        By transactionSuccessful = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(transactionSuccessful));
        return getDriver().findElement(transactionSuccessful).getText();

    }

    public void customerLogout() {
        //first we log in - we are already logged in
        //then we log out
        getDriver().navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account");
        getDriver().findElement(customerLogout).click();
    }

    public By getCustomerCredentials() {
        return customerCredentials;
    }

    public String customerCredentials() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(customerCredentials));
        System.out.println(getDriver().findElement(customerCredentials).getText());
        return getDriver().findElement(customerCredentials).getText();
    }

}
