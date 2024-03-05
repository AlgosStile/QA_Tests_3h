package org.example.properties.clear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * Первый вариант поиска и перемещения элемента
 */
public class Clear {
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
            actions
                    .moveToElement(element1)//навести на курсор
                    .clickAndHold()//нажать и удерживать
                    .moveToElement(element2)//навести на курсор
                    .release()//отпустить
                    .build()//собрать
                    .perform();//запустить, выполнить

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            Thread.sleep(20000);
            driver.quit();
        }
    }
}
