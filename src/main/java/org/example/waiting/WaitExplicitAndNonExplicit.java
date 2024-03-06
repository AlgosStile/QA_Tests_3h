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

        // Неявный таймаут
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");

        // Используем явное ожидание, чтобы убедиться, что поле "поиск" загружено
        WebElement searchBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("q"))); // Обычно поле поиска Google имеет имя "q"

        // Вводим текст для поиска и отправляем его (нажимаем Enter)
        searchBox.sendKeys("купить авто" + Keys.ENTER);

        // Явное ожидание для убеждения, что результаты поиска загружены
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3")));

        // Кликаем по первому элементу в результатах поиска
        firstResult.click();
        driver.quit();
    }
}
