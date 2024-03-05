package org.example.waiting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitExplicitAndNonExplicit {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Создаем явное ожидание в 10 секунд
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //НЕ явное ожидание в 10 секунд
        WebElement element = (new WebDriverWait( driver, Duration.ofSeconds(10))
                .until( ExpectedConditions.presenceOfElementLocated( By.id( "444555222" ) ) ) );

        driver.get("https://www.google.com/");
    }
}
