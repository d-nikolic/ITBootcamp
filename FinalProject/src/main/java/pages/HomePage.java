package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By elementsLocator = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    private By alertsFramesWindowsLocator = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]");

    public void clickOnElements() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(elementsLocator));
        getDriver().findElement(elementsLocator).click();
        getDriverWait().until(ExpectedConditions.urlToBe("https://demoqa.com/elements"));
    }

    public void clickOnAlertsFramesWindows() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(alertsFramesWindowsLocator));
        getDriver().findElement(alertsFramesWindowsLocator).click();
        getDriverWait().until(ExpectedConditions.urlToBe("https://demoqa.com/alertsWindows"));
    }







}
