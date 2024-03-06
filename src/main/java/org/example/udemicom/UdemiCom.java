package org.example.udemicom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UdemiCom {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.udemy.com");

        //! ищем элемент input на странице с названием name='q'
        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
        new WebDriverWait(driver, Duration.ofSeconds(10));
        /** Вводим в input текст "Java" и нажимаем Enter
         * в строке ниже можно указать путь к файлу и
         * он автоматически будет загружен на сайт
         * например, element.sendKeys("..путь_к/файлу/файл.txt", Keys.ENTER);
         */
        element.sendKeys("Java", Keys.ENTER);


    }
}
