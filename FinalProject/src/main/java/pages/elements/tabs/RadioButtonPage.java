package pages.elements.tabs;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

@Data
public class RadioButtonPage extends BasePage {

    public RadioButtonPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By impressiveButtonLocator = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]");

    private By yesButtonLocator = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]");
    private By displayedMsgLocator = By.xpath("//*[contains(@class, 'text-success')]");


    public void clickOnImpressiveBtn() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(impressiveButtonLocator));
        WebElement impressiveBtn = getDriver().findElement(impressiveButtonLocator);
        Actions moveToSubmit = new Actions(getDriver());
        moveToSubmit.moveToElement(impressiveBtn).click().build().perform();
        valueOfImpressiveButton();

    }

    public boolean isYesBtnSelected() {
        WebElement yesBtn = getDriver().findElement(yesButtonLocator);
        return yesBtn.isSelected();
    }

    public boolean isImpressiveBtnSelected() {
        WebElement impressiveBtn = getDriver().findElement(impressiveButtonLocator);
        return impressiveBtn.isSelected();
    }

    public String valueOfImpressiveButton() {
        WebElement impressiveBtn = getDriver().findElement(impressiveButtonLocator);
        System.out.println(impressiveBtn.getText());
        return impressiveBtn.getText();
    }

    public String valueOfYesButton() {
        WebElement yesBtn = getDriver().findElement(yesButtonLocator);
        System.out.println(yesBtn.getText());
        return yesBtn.getText();
    }

    public String valueOfDisplayedMsg() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(displayedMsgLocator));
        WebElement msg = getDriver().findElement(displayedMsgLocator);
        return msg.getText();
    }


    public void clickOnYesBtn() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(yesButtonLocator));
        WebElement yesBtn = getDriver().findElement(yesButtonLocator);
        Actions moveToSubmit = new Actions(getDriver());
        moveToSubmit.moveToElement(yesBtn).click().build().perform();
        valueOfYesButton();
    }
}
