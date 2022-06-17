package pages.alerts.frames.windows.tabs;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

@Data
public class ModalDialogsPage extends BasePage {
    public ModalDialogsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By smallModalLocator = By.id("showSmallModal");

    private By smallModalTitleLocator = By.id("example-modal-sizes-title-sm");
    private By smallModalTextLocator = By.xpath("/html/body/div[4]/div/div/div[2]");
    private By smallModalCloseBtnLocator = By.id("closeSmallModal");

    private By largeModalLocator = By.id("showLargeModal");

    private By largeModalTitleLocator = By.id("example-modal-sizes-title-lg");
    private By largeModalTextLocator = By.xpath("/html/body/div[4]/div/div/div[2]/p");
    private By largeModalCloseBtnLocator = By.id("closeLargeModal");

    private By modalContentLocator = By.xpath("/html/body/div[4]/div/div");



    public void clickOnLargeModal() {
        WebElement largeModal = waitingForElement(largeModalLocator);
        largeModal.click();
    }

    public WebElement waitingForElement(By locator) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = getDriver().findElement(locator);
        return element;
    }

    public void clickOnSmallModal() {
        WebElement smallModal = waitingForElement(smallModalLocator);
        smallModal.click();
    }

    public boolean isModalWindowDisplayed() {
        WebElement modalContent = waitingForElement(modalContentLocator);
        return modalContent.isDisplayed();
    }

    public void clickOnLargeModalCloseBtn() {
        WebElement closeBtn = waitingForElement(largeModalCloseBtnLocator);
        closeBtn.click();
    }

    public void clickOnSmallModalCloseBtn() {
        WebElement closeBtn = waitingForElement(smallModalCloseBtnLocator);
        closeBtn.click();
    }
    public String getSmallModalTitle() {
        WebElement smallModal = waitingForElement(smallModalTitleLocator);
        return smallModal.getText();
    }

    public String getLargeModalTitle() {
        WebElement largeModal = waitingForElement(largeModalTitleLocator);
        return largeModal.getText();
    }

    public String getSmallModalText() {
        WebElement smallModal = waitingForElement(smallModalTextLocator);
        return smallModal.getText();
    }

    public String getLargeModalText() {
        WebElement largeModal = waitingForElement(largeModalTextLocator);
        return largeModal.getText();
    }

}
