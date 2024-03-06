package org.example.properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PropertiesOfTheElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.avito.ru/all/avtomobili");

        // Находим поле ввода поиска
        WebElement searchInput = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));

        // Вводим слово "ВАЗ"
        searchInput.sendKeys("ВАЗ");

        // Находим и нажимаем кнопку "Найти"
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-marker='search-form/submit-button']"));
        searchButton.click();

        // Добавляем явное ожидание (страница точно загрузилась)
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), 'ВАЗ')]")));

        // Прокручиваем страницу вниз
        WebElement body = driver.findElement(By.cssSelector("body"));
        for (int i = 0; i < 30; i++) {
            body.sendKeys(Keys.PAGE_DOWN);
            try {
                Thread.sleep(50); //пауза между прокрутками
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Обновленный XPath для кнопки 4-й страницы с использованием data-marker
        WebElement page4Button = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-marker='pagination-button/page(4)']")));
        page4Button.click();

        // Дополнительная пауза перед закрытием браузера
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
