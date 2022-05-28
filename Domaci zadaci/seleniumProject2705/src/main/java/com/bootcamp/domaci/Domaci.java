package com.bootcamp.domaci;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Otići na https://www.stealmylogin.com/demo.html, uneti bilo koje kredencijale za login, pritisnuti dugme.
Izvršiti proveru da je, nakon logina, URL promenjen na https://example.com/ kroz grananje. Ako jeste, štampati “Nice”.
Ako nije, štampati “Not nice.”
Sve elemente koji se koriste smestiti u intuitivno imenovane promenljive.
 */
public class Domaci {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Darko\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.stealmylogin.com/demo.html");

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("fasfhfashhgADSAGFshg23264!aa");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("password12313153fahnIGndsaFJaoniua!2@");

        WebElement login = driver.findElement(By.xpath("//input[@value='login']"));
        login.click();

        if(driver.getCurrentUrl().equals("https://example.com/")) {
            System.out.println("Nice!");
        } else {
            System.out.println("Not nice!");
        }
    }
}
