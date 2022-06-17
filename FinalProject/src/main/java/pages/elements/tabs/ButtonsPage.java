package pages.elements.tabs;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

@Data
public class ButtonsPage extends BasePage {

    public ButtonsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By clickMeButtonLocator = By.xpath("//*[text()= 'Click Me']");
    private By clickMeButtonMsg = By.id("dynamicClickMessage");
    private By rightClickMeButtonLocator = By.xpath("//*[text()= 'Right Click Me']");

    private By rightClickMeMsg = By.id("rightClickMessage");

    private By doubleClickMeLocator = By.xpath("//*[text()= 'Double Click Me']");

    private By doubleClickMeMsg = By.id("doubleClickMessage");


    public void clickOnClickMe() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(clickMeButtonLocator));
        WebElement clickMeBtn = getDriver().findElement(clickMeButtonLocator);
        clickMeBtn.click();
    }

    public void clickOnRightClickMe() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(rightClickMeButtonLocator));
        WebElement rightClickMeBtn = getDriver().findElement(rightClickMeButtonLocator);
        Actions action = new Actions(getDriver());
        action.contextClick(rightClickMeBtn).perform();
    }

    public void doubleClickMe() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(doubleClickMeLocator));
        WebElement doubleClickMeBtn = getDriver().findElement(doubleClickMeLocator);
        Actions action = new Actions(getDriver());
        action.doubleClick(doubleClickMeBtn).perform();
    }
}
