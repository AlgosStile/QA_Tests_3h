package org.example.udemicom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UdemiCom {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.udemy.com");
        //! ищем элемент инпут на странице с названием name='q'
        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
        /** вводим в инпут текст "Selenium" и нажимаем Enter
         * в строке ниже можно указать путь к файлу и
         * он автоматически будет загружен на сайт
         * например, element.sendKeys("..путь_к/файлу/файл.txt", Keys.ENTER);
         */
        element.sendKeys("Java", Keys.ENTER);

    }
}
