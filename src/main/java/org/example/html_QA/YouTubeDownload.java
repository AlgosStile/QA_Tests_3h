package org.example.html_QA;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class YouTubeDownload {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:" +
                "\\Program Files\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("https://www.youtube.com/");
            Thread.sleep(6000);

            WebElement element = driver.findElement(By.id("a"));

            //? заменяем стили в devtools на нужные нам для отображения кнопки "выбрать файл"
            //? чтобы ее увидел selenium, после чего input в браузере будет видимым!
           js.executeScript("document.querySelector('#a').setAttribute('style', 'opacity:1')");
            //! Далее находим input по локатору по xpath) и далее методом sendKeys пишем путь к файлу

        } catch (InterruptedException e) {
            e.printStackTrace();


        } finally {
            driver.quit();
        }
    }
}
