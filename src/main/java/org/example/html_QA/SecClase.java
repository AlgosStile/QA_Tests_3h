package org.example.html_QA;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class SecClase {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:" +
                "\\Program Files\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("http://127.0.0.1:5507/index.html");
            Thread.sleep(6000);

            String window1 = driver.getWindowHandle();

            //открываем новое окно с помощью Js
            js.executeScript("window.open()");

            Set<String> currentWindows = driver.getWindowHandles();

            String window2 = null;

            for (String window : currentWindows) {
                if (!window.equals(window1)) {
                    window2 = window;
                    break;
                }
            }

            driver.switchTo().window(window2);
            driver.get("http://127.0.0.1:5507/index.html");
            driver.close();
            driver.switchTo().window(window1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();


        }
    }
}
