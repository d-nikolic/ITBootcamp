package com.bootcamp.domaci;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerPage extends BasePage {


    private By addCustomer = By.xpath("//*[contains(text(), 'Add Customer')]");
    private By openAccount = By.xpath("//*[contains(text(), 'Open Account')]");
    private By customers = By.xpath("//*[contains(text(), 'Customers')]");
    private By home = By.xpath("//*[contains(text(), 'Home')]");
    private By firstName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postCode = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private By addCustomerSubmit = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    private By openAccountCustomer = By.xpath("//*[@id=\"userSelect\"]");

    private By logoutSubmit = By.xpath("/html/body/div/div/div[1]/button[2]");


    public ManagerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void createCustomer(String firstN, String lastN, String postalCode) {
        getDriver().findElement(addCustomer).click();
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(firstName));
        getDriver().findElement(firstName).sendKeys(firstN);
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(lastName));
        getDriver().findElement(lastName).sendKeys(lastN);
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(postCode));
        getDriver().findElement(postCode).sendKeys(postalCode);
        getDriver().findElement(addCustomerSubmit).click();
        getDriver().switchTo().alert().accept();

    }

    public String creatingAccountForExistingCustomer(String fullName, String mediumOfExchange) {
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).click();
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.id("userSelect")));

        /*
        Select facilityOptions = new Select(driver.findElement(appointmentPage.getFacility()));
        facilityOptions.selectByValue(facility);
         */
        Select customers = new Select(getDriver().findElement(openAccountCustomer));
        //   getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), '" + fullName + "')]")));
        customers.selectByVisibleText(fullName);
        Select currencies = new Select(getDriver().findElement(By.id("currency")));
        currencies.selectByValue(mediumOfExchange);
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
        String text = getDriver().switchTo().alert().getText();
        String[] splittingText = text.split(":");
        getDriver().switchTo().alert().accept();
        String accountNumber = splittingText[1];
        return accountNumber;
    }

    public By getAddCustomer() {
        return addCustomer;
    }

    public By getOpenAccount() {
        return openAccount;
    }

    public By getCustomers() {
        return customers;
    }

    public By getHome() {
        return home;
    }

    public String customerSearch(String firstN) {
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).click();
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input")));
        WebElement searchBar = getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input"));
        searchBar.sendKeys(firstN);
        WebElement searchResult = getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[1]"));
        return searchResult.getText();
    }

    public String accountSearch(String accountN) {
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).click();
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input")));
        WebElement searchBar = getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input"));
        searchBar.sendKeys(accountN);
        WebElement searchResult = getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[1]"));
        return searchResult.getText();
    }


    public void logoutManager() {
        getDriver().navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("document.querySelector('.ng-hide').setAttribute('class', 'btn logout')");
        getDriver().findElement(logoutSubmit).click();
    }
}
