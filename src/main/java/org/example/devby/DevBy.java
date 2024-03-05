package org.example.devby;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DevBy {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://id.devby.io/@/hello");
       //Проверяем продолжительность перехода "transition-duration"
        WebElement element = driver.findElement(By.xpath("//a[text()='Вход']"));
        String par = element.getCssValue("transition-duration");
        System.out.println(par);
        element.click();

    }
}