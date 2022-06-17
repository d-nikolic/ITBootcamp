package pages.alerts.frames.windows;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

@Data
public class AlertsWindowsPage extends BasePage {
    public AlertsWindowsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


     private By modalDialogsLocator = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/" +
             "div/div/div[3]/div/ul/li[5]");  //fullxpath needed

    public void clickOnModalDialogs() {
        //links are not visible so scroll down is needed
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,400)");
        getDriverWait().until(ExpectedConditions.elementToBeClickable(modalDialogsLocator));
        getDriver().findElement(modalDialogsLocator).click();
        getDriverWait().until(ExpectedConditions.urlToBe("https://demoqa.com/modal-dialogs"));
    }
}
