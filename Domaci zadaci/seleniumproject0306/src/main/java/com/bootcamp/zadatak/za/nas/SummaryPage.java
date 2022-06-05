package com.bootcamp.zadatak.za.nas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

// ima gettere za sve elemente sa summary stranice koji nose informacije appointment-a

public class SummaryPage extends BasePage {

    private By facilitySummary = By.id("facility");
    private By hospitalReadmissionSummary = By.id("hospital_readmission");
    private By healthCareProgramSummary = By.id("program");
    private By visitDateSummary = By.id("visit_date");
    private By commentSummary = By.id("comment");


    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFacilitySummary() {
        return facilitySummary;
    }

    public By getHospitalReadmissionSummary() {
        return hospitalReadmissionSummary;
    }

    public By getHealthCareProgramSummary() {
        return healthCareProgramSummary;
    }

    public By getVisitDateSummary() {
        return visitDateSummary;
    }

    public By getCommentSummary() {
        return commentSummary;
    }


}
