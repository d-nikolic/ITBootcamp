package pages.elements.tabs;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

@Data
public class LinksPage extends BasePage {

    public LinksPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By homeLinkLocator = By.id("simpleLink");

    //handle of https://demoqa.com/links
    private String originalHandle = getDriver().getWindowHandle();


    public String getHomeLinkURL() {
        WebElement homeLink = waitingForHomeLinkElement();
        return homeLink.getAttribute("href");
    }

    public void clickOnHomeLink() {
        WebElement homeLink = waitingForHomeLinkElement();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(homeLinkLocator));
        homeLink.click();
    }
    public WebElement waitingForHomeLinkElement() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(homeLinkLocator));
        WebElement homeLink = getDriver().findElement(homeLinkLocator);
        return homeLink;
    }

    public String getCurrentHandle() {
        clickOnHomeLink();
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!originalHandle.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return getDriver().getWindowHandle();
    }
}
