package com.bootcamp.domaci;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
Otići na https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login.
Test 1: Logovanje kao Bank Manager
Test 2: Kreiranje Customera
Test 3: Kreiranje Accounta za tog Customera
Test 4: Logovanje kao Customer
Test 5: Uspešan Deposit za nekog Customera
Test 6: Uspešan Withdrawal za nekog Customera
Test 7: Logout za Bank Managera
Test 8: Logout za Customera
 */
public class BasePage {

    private WebDriver driver;
    private WebDriverWait driverWait;



    public BasePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }
}
