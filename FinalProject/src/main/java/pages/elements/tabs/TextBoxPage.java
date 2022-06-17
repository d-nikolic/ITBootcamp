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

@Data
public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By usernameLocator = By.id("userName");
    private By emailLocator = By.id("userEmail");
    private By currentAddressLocator = By.id("currentAddress");
    private By permanentAddressLocator = By.id("permanentAddress");

    private By submitLocator = By.id("submit");

    public String inputtedDataView(String username, String email, String currentAddress, String permanentAddress) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(submitLocator)));
        getDriver().findElement(usernameLocator).sendKeys(username);
        getDriver().findElement(emailLocator).sendKeys(email);
        getDriver().findElement(currentAddressLocator).sendKeys(currentAddress);
        getDriver().findElement(permanentAddressLocator).sendKeys(permanentAddress);
        WebElement submitBtn = getDriver().findElement(submitLocator);

        Actions a = new Actions(getDriver());
        //scroll down a page
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        Actions moveToSubmit = new Actions(getDriver());
        //without 2 clicks it isn't working
        moveToSubmit.moveToElement(submitBtn).click().build().perform();
        moveToSubmit.moveToElement(submitBtn).click().build().perform();

        return "Name:" + username + "Email:" + email + "Current Address :" + currentAddress +
                "Permananet Address :" + permanentAddress;

    }

    public String displayActualInfo() {
        WebElement name = getDriver().findElement(By.cssSelector("p#name"));
        WebElement email = getDriver().findElement(By.cssSelector("p#email"));
        WebElement currAddress = getDriver().findElement(By.cssSelector("p#currentAddress"));
        WebElement permAddress = getDriver().findElement(By.cssSelector("p#permanentAddress"));

        return name.getText() + email.getText() + currAddress.getText() + permAddress.getText();
    }

}
