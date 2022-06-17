package tests;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.alerts.frames.windows.AlertsWindowsPage;
import pages.alerts.frames.windows.tabs.ModalDialogsPage;
import pages.elements.ElementsPage;
import pages.HomePage;
import pages.elements.tabs.*;

import java.time.Duration;


@Getter
public class BaseTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private HomePage homePage;
    private ElementsPage elementsPage;
    private TextBoxPage textBoxPage;
    private RadioButtonPage radioButtonPage;

    private WebTablesPage webTablesPage;
    private ButtonsPage buttonsPage;

    private LinksPage linksPage;
    private AlertsWindowsPage alertsWindowsPage;

    private ModalDialogsPage modalDialogsPage;


    @BeforeClass
    public void beforeAllMethods() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Darko\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.navigate().to("https://demoqa.com");
        driver.manage().window().maximize();
        homePage = new HomePage(driver, driverWait);
        elementsPage = new ElementsPage(driver, driverWait);
        textBoxPage = new TextBoxPage(driver, driverWait);
        radioButtonPage = new RadioButtonPage(driver, driverWait);
        webTablesPage = new WebTablesPage(driver, driverWait);
        buttonsPage = new ButtonsPage(driver, driverWait);
        linksPage = new LinksPage(driver, driverWait);
        alertsWindowsPage = new AlertsWindowsPage(driver, driverWait);
        modalDialogsPage = new ModalDialogsPage(driver, driverWait);
    }

//    @AfterClass
//    public void closing() {
//        getDriver().close();
//    }

}
