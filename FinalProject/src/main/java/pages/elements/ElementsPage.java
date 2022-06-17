package pages.elements;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

@Data
public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By textBoxLocator = By.id("item-0");

    private By radioButtonLocator = By.id("item-2");

    private By webTablesLocator = By.id("item-3");
    private By buttonsLocator = By.id("item-4");

    private By linksLocator = By.id("item-5");

    public void clickOnTextBox() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(textBoxLocator));
        getDriver().findElement(textBoxLocator).click();
        getDriverWait().until(ExpectedConditions.urlToBe("https://demoqa.com/text-box"));
    }

    public void clickOnRadioButton() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(radioButtonLocator));
        getDriver().findElement(radioButtonLocator).click();
        getDriverWait().until(ExpectedConditions.urlToBe("https://demoqa.com/radio-button"));
    }

    public void clickOnWebTables() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(webTablesLocator));
        getDriver().findElement(webTablesLocator).click();
        getDriverWait().until(ExpectedConditions.urlToBe("https://demoqa.com/webtables"));
    }

    public void clickOnButtons() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,400)");
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(buttonsLocator));
        getDriver().findElement(buttonsLocator).click();
        getDriverWait().until(ExpectedConditions.urlToBe("https://demoqa.com/buttons"));
    }

    public void clickOnLinks() {
        //links are not visible so scroll down is needed
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,500)");
        getDriverWait().until(ExpectedConditions.elementToBeClickable(linksLocator));
        getDriver().findElement(linksLocator).click();
        getDriverWait().until(ExpectedConditions.urlToBe("https://demoqa.com/links"));
    }
}
