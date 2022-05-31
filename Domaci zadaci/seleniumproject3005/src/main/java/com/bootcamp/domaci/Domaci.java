package com.bootcamp.domaci;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
Otići na http://www.strela.co.rs/, kliknuti na dugme Prodavnica u headeru,
izabrati opciju Lukovi - Bows iz leve navigacije, potom kliknuti na luk koji se zove Samick Sage,
i onda proveriti da ime tog luka na njegovoj stranici zaista sadrži reč Samick.
 */
public class Domaci {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Darko\\Ideaprojects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.strela.co.rs/");
        WebElement prodavnica = driver.findElement(By.xpath("//*[@id='ctl00_RadMenu1']/ul/li[2]"));
        prodavnica.click();

        WebElement lukoviBows = driver.findElement(By.xpath
                ("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
        lukoviBows.click();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //dok se ne ucita poslednji proizvod iz grupe lukovi - bows By.id("ctl00_MainContent_ListView1_ctrl193_Panel1")
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id
                ("ctl00_MainContent_ListView1_ctrl193_Panel1")));

        WebElement samickSageProdavnica = driver.findElement(By.xpath
                ("//*[@id='ctl00_MainContent_ListView1_ctrl35_Panel1']/figure"));


        samickSageProdavnica.click();

        WebElement samickSageStranica = driver.findElement(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel"));


        if (samickSageStranica.getText().contains("Samick")) {
            System.out.println("Ime luka sadrži reč Samick!");
        } else {
            System.out.println("Ime luka ne sadrži reč Samick!");
        }

        driver.close();


    }
}
