package com.bootcamp.domaci;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void zatvaranjePopUpa(WebDriver driver) {
        //ako se popup pojavi, zatvori ga
        WebElement popUp = driver.findElement(By.className("welcome-holder"));
        if (popUp.isDisplayed()) {
            WebElement closeBtn = driver.findElement(By.className("kpBoxCloseButton"));
            closeBtn.click();

        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Darko\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //https:"www.google.rs/
        driver.get("http://kupujemprodajem.com/");
        driver.manage().window().maximize();

        zatvaranjePopUpa(driver);

        WebElement searchBar = driver.findElement(By.id("searchKeywordsInput"));
        searchBar.sendKeys("iphone 13");
        /*
          WebElement trazi = driver.findElement(By.xpath("//*[@id=\"searchFormHolder\"]/div/div/div[2]/div[2]/div[2]/div[1]/input"));
          trazi.submit();
        */

        searchBar.sendKeys(Keys.ENTER);

        WebElement prviOglasLink = driver.findElement(By.xpath("//*[@id='adListContainer']//div[3]//div//a"));
        prviOglasLink.sendKeys(Keys.ENTER);
        WebElement oglas = driver.findElement(By.xpath("//h1[@class='oglas-title']"));
        System.out.println(
                (oglas.getText().equals("iPhone 13, iPhone 12, iPhone 11 - NOVO!"))
                        ? "Naslov oglasa je isti kao onaj koji smo uočili tokom manuelnog izvođenja kejsa."
                        : "Naslov oglasa nije isti!");


    }
}
