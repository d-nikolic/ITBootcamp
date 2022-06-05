package com.bootcamp.zadatak.za.nas;

import com.bootcamp.FriendPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppointmentTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;

    private AppointmentPage appointmentPage;

    private SummaryPage summaryPage;

    @BeforeClass
    public void beforeAllTests() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Darko\\Ideaprojects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        loginPage = new LoginPage(driver, driverWait);
        appointmentPage = new AppointmentPage(driver, driverWait);
        summaryPage = new SummaryPage(driver, driverWait);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test(priority = 1)
    public void verifyThatUserSuccessfullyLoggedIn() {
        loginPage.clickMakeAppointmentButton();
        loginPage.login("John Doe", "ThisIsNotAPassword");
        Assert.assertTrue(appointmentPage.isFormPresented());
    }

    public void fillingOutTheForm(String facility, String healthcareProgram, String visitDate, String comment) {
        Select facilityOptions = new Select(driver.findElement(appointmentPage.getFacility()));
        facilityOptions.selectByValue(facility);
        driver.findElement(appointmentPage.getHospitalReadmission()).click();
        WebElement healthcareProgramElement = driver.findElement(appointmentPage.getHealthcareProgram(healthcareProgram));
        healthcareProgramElement.click();
        driver.findElement(appointmentPage.getVisitDate()).sendKeys(visitDate);
        driver.findElement(appointmentPage.getComment()).sendKeys(comment);
        driver.findElement(appointmentPage.getBookAppointment()).click();

    }

    @Test(priority = 2)
    public void verifyThatAppointmentDataIsEqualToSummaryData() {
        /*
         Popunite appointment formu
        I proverite da li se unosi sa appointment forme uklapaju sa podacima sa summary stranice
         */
        fillingOutTheForm("Hongkong CURA Healthcare Center", "Medicaid", "21/09/2020", "Random comment");
        Assert.assertEquals(driver.findElement(summaryPage.getFacilitySummary()).getText(), "Hongkong CURA Healthcare Center");
        Assert.assertEquals(driver.findElement(summaryPage.getHospitalReadmissionSummary()).getText(), "Yes");
        Assert.assertEquals(driver.findElement(summaryPage.getHealthCareProgramSummary()).getText(), "Medicaid");
        Assert.assertEquals(driver.findElement(summaryPage.getVisitDateSummary()).getText(), "21/09/2020");
        Assert.assertEquals(driver.findElement(summaryPage.getCommentSummary()).getText(), "Random comment");

    }

    @AfterClass
    public void afterAllMethods() {
         driver.close();
    }


}
