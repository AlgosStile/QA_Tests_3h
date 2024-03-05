package org.example.properties.clear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * Второй вариант поиска и перемещения элемента
 */
public class Clear2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://the-internet.herokuapp.com/drag_and_drop");
            Thread.sleep(2000);

            WebElement element1 = driver.findElement(By.id("column-a"));
            WebElement element2 = driver.findElement(By.id("column-b"));

            Actions actions = new Actions(driver);

            //! одна строка кода заменяет предыдущий вариант из класса Clear
            actions.dragAndDrop(element1, element2).perform();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            Thread.sleep(20000);
            driver.quit();
        }
    }
}
