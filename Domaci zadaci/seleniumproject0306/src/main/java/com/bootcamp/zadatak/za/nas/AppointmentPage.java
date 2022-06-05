package com.bootcamp.zadatak.za.nas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
/*
    getter za facility select
o   getter za apply for hospital readmission
o   getter za radio dugme (trazeno po value atributu)
§ xpath-u - kao parametar se prima value za trazeno radio dugme
§ //*[@name='programs'][@value='"+ radioInputName +"']
o   getter za visit date input
o   getter za comment input
o   getter za book appointment button
o   metodu isFormPresented() koja vraca informaciju da li je ucitan element id="appointment",
(iskoriste logiku preko liste, ako je lista prazna element nije na stanici) - da li je element isDisplayed
Napomena: Datum se takodje postavlja preko metode sendKeys samo je potrebno datum uneti u formatu
 "dd/mm/yyyy" => npr: "21/09/2020"
 */


public class AppointmentPage extends BasePage {

    private By facility = By.id("combo_facility");
    private By hospitalReadmission = By.id("chk_hospotal_readmission");
    private By healthcareProgram = null;
    private By visitDate = By.id("txt_visit_date");
    private By comment = By.id("txt_comment");
    private By bookAppointment = By.id("btn-book-appointment");

    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFacility() {
        return facility;
    }

    public By getHospitalReadmission() {
        return hospitalReadmission;
    }

    public By getHealthcareProgram(String radioInputName) {
        return By.xpath("//*[@name='programs'][@value='" + radioInputName + "']");
    }

    public By getVisitDate() {
        return visitDate;
    }

    public By getComment() {
        return comment;
    }

    public By getBookAppointment() {
        return bookAppointment;
    }

    //isFormPresented() koja vraca informaciju da li je ucitan element id="appointment",
    // (iskoriste logiku preko liste, ako je lista prazna element nije na stanici)
    public boolean isFormPresented() {
        List<WebElement> listofAppointmentElements = getDriver().findElements(By.xpath("//*[@id=\"appointment\"]/div/div/form/div"));
        int size = listofAppointmentElements.size(); //6 elemenata forme
        return listofAppointmentElements.size() == 6;

    }

    public String hospitalReadmissionStatus() {
       WebElement checkbox = getDriver().findElement(getHospitalReadmission());
       return checkbox.isSelected() ? "Yes" : "No";
    }




}
