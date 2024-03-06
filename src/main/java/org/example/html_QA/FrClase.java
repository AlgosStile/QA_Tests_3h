package org.example.html_QA;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

/**
 * Перед запуском теста, index.html нужно запустить в VC Code c установленным плагином live server
 * Далее запускаем тест!
 */
public class FrClase {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:" +
                "\\Program Files\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("http://127.0.0.1:5507/index.html");
            Thread.sleep(6000);

            WebElement element1 = driver.findElement(By.id("a"));
            WebElement element2 = driver.findElement(By.id("b"));
            WebElement element3 = driver.findElement(By.id("c"));

            element1.click();

            Alert alert = wait.until(alertIsPresent());
            Thread.sleep(1500);
            alert.accept();

            element2.click();
            Alert prompt = wait.until(alertIsPresent());

            prompt.sendKeys("Super!");
            prompt.accept();

            Alert alert2 = wait.until(alertIsPresent());
            Thread.sleep(2500);
            alert2.accept();

            element3.click();
            Alert alert3 = wait.until(alertIsPresent());
            Thread.sleep(2700);
            alert3.dismiss();

        } catch (InterruptedException e) {
            e.printStackTrace();


        } finally {
            driver.quit();
        }
    }
}