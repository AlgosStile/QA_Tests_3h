package org.example.testNG.tests2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class FrTestNG {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:" +
                "\\Program Files\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("http://127.0.0.1:5507/index.html");
            Thread.sleep(6000);
            //? Произвольная проверка title c использованием TestNG
           String title = driver.getTitle();
           Assert.assertEquals(title ,"Test document");

            LoginPage ln = new LoginPage();
            ln.login("admin", "12345@");


        } catch (InterruptedException e) {
            e.printStackTrace();


        } finally {
            driver.quit();
        }
    }
}

