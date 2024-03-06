package org.example.properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

        // Пауза 3 секунды
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Проскролливаем страницу до кнопок пагинации
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@data-marker='pagination-button']")));

        // Дополнительное ожидание для убеждения, что страница и элементы полностью загружены
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '4')]//ancestor::a")));

        // Нажимаем на кнопку 4-й страницы
        WebElement page4Button = driver.findElement(By.xpath("//textarea[@aria-label='Страница 4']"));
        page4Button.click();

        // Дополнительная пауза перед закрытием браузера (если необходимо)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрываем браузер
        driver.quit();
    }
}
