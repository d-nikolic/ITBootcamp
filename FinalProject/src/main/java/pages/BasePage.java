package pages;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
@NoArgsConstructor
public abstract class BasePage {

    private WebDriver driver;
    private WebDriverWait driverWait;
    public BasePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }
}
