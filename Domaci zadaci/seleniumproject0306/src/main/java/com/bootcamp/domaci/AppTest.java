package com.bootcamp.domaci;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private CustomerPage customerPage;
    private ManagerPage managerPage;
    private AccountPage accountPage;

    private String accountNumber;

    @BeforeClass
    public void beforeAllTests() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Darko\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        loginPage = new LoginPage(driver, driverWait);
        customerPage = new CustomerPage(driver, driverWait);
        managerPage = new ManagerPage(driver, driverWait);
        accountPage = new AccountPage(driver, driverWait);

        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test(priority = 1)
    public void verifyThatManagerSuccessfullyLoggedIn() {
        //Logovanje kao Bank Manager
        loginPage.loginAsManager();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(managerPage.getAddCustomer()));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
    }

    @Test(priority = 2)
    public void verifyThatCustomerIsCreated() {
        //Kreiranje Customera
        managerPage.createCustomer("Darko", "Nikolic", "21241");
        Assert.assertEquals(managerPage.customerSearch("Darko"), "Darko");

    }

    @Test(priority = 3)
    public void verifyThatCustomerHasCreatedANewAccount() {
        //Kreiranje Accounta za tog Customera
        accountNumber = managerPage.creatingAccountForExistingCustomer("Darko Nikolic", "Dollar");
        Assert.assertEquals(managerPage.accountSearch(accountNumber), "Darko");
    }

    @Test(priority = 4)
    public void verifyThatCustomerHasLoggedIn() {
        //Logovanje kao Customer
        loginPage.loginAsCustomer();
        customerPage.selectingCustomer("Harry Potter");
        Assert.assertEquals(accountPage.customerCredentials(), "Harry Potter");
    }

    @Test(priority = 5)
    public void verifyThatCustomerHasSuccessfullyDepositedMoney() {
        //Uspešan Deposit za nekog Customera
        /*
        //ako se pokrece samo ovaj test onda su potrebne i ove metode
        loginPage.loginAsCustomer();
        customerPage.selectingCustomer("Harry Potter");
         */
        Assert.assertTrue(accountPage.deposit(100).equals("Deposit Successful"));
    }

    @Test(priority = 6)
    public void verifyThatCustomerHasSuccessfullyWithdrawnMoney() {
        //Uspešan Withdrawal za nekog Customera
        Assert.assertTrue(accountPage.withdrawl(50).equals("Transaction successful"));

    }

    @Test(priority = 7)
    public void verifyThatBankManagerSuccessfullyLoggedOut() {
        managerPage.logoutManager();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer"));
    }

    @Test(priority = 8)
    public void verifyThatCustomerSuccessfullyLoggedOut() {
        accountPage.customerLogout();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer"));
    }

    @AfterClass
    public void afterAllMethods() {
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.close();
    }

}
