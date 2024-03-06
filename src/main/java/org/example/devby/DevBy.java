package org.example.devby;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Этот автотест выполняет следующие действия:
 * Открывает страницу входа на DevBy.io и измеряет продолжительность перехода элемента "Вход"
 * при наведении на него курсора. Кликает по элементу "Вход", затем нажимает на кнопку
 * "Войти с помощью Google" и закрывает браузер через 5 секунд.
 */
public class DevBy {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://id.devby.io/@/hello");

        // Проверяем продолжительность перехода "transition-duration" для элемента Вход
        WebElement loginElement = driver.findElement(By.xpath("//a[text()='Вход']"));
        String transitionDuration = loginElement.getCssValue("transition-duration");
        System.out.println("Transition duration for Вход: " + transitionDuration);
        loginElement.click();

        // Добавим небольшую задержку для наглядности
        try {
            Thread.sleep(2000); // Задержка в 2 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Найти и кликнуть на кнопку "Войти с помощью Google"
        WebElement googleLoginButton = driver.findElement(By.xpath("//span[contains(text(), 'Войти с помощью Google')]"));
        googleLoginButton.click();

        // Закрыть браузер после небольшой задержки
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
