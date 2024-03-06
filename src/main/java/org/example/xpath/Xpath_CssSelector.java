package org.example.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_CssSelector {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/"); // Переходим по этому URL
        //1 вараинт поиск xpath элемента
        WebElement input = driver.findElement(By.xpath("//textarea[@aria-label='Найти']"));
        input.click();
        //2 вариант поиск cssSelector
        WebElement input2 = driver.findElement(By.cssSelector("input"));
        input2.sendKeys("input");
        driver.quit();
    }
}