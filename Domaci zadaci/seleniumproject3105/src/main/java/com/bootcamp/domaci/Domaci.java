package com.bootcamp.domaci;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

/*
Napisati dva smoke testa za https://www.telerik.com/support/demos

    Proveriti da klikom na Desktop odlazimo na tu sekciju
    Proveriti da klikom na Mobile odlazimo na tu sekciju
 */
public class Domaci {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Darko\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.telerik.com/support/demos/");
    }

    @Test
    public void validatingDesktopSection() {
        WebElement desktop = driver.findElement(By.cssSelector("a[href='#desktop']"));
        desktop.click();

        //bez Thread.sleepa assert ne radi - prebrzo zavrsi test(i pre nego sto se aktivira klasa is-active)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean actual = desktop.getAttribute("class").contains("is-active");
        System.out.println(desktop.getText() + " " + desktop.getAttribute("class"));
        boolean expected = true;
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void validatingMobileSection() {
        WebElement mobile = driver.findElement(By.cssSelector("a[href='#mobile']"));
        mobile.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean actual = mobile.getAttribute("class").contains("is-active");
        System.out.println(mobile.getText() + " " + mobile.getAttribute("class"));
        boolean expected = true;
        Assert.assertEquals(actual, expected);

    }

    @AfterClass
    public void closing() {
        driver.close();
    }


}
