package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MtsByTest {
    private static WebDriver driver;
    WebDriverWait  wait  =  new  WebDriverWait (driver, Duration.ofSeconds(10));


    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); //создание экземпляраа
        driver.get("http://mts.by");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cookie__buttons']/button[@id='cookie-agree']")));
        button.click();
    }

    @Test
    public void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath(" //h2[contains(text(),'Онлайн пополнение')]/.."));

        // Cоздаем строковую переменную и кладем в нее текст, полученный из blockTitle
        String actualText = blockTitle.getText();
        assertTrue(actualText.contains("Онлайн пополнение ") && actualText.contains("без комиссии"),
                "Название блока не содержит ожидаемых текстов.");
    }

    @Test
    public void testLogoPayPartners() {

        //Ищем список элементов, or действует так, что мы не останавливаемся на первом найденом элементе, а проверяем каждый
        List<WebElement> logos = driver.findElements(By.xpath("//h2[contains(text(),'Онлайн пополнение')]" +
                "/..//img[contains(@src, 'belkart') or contains (@src, 'visa') or contains (@src, 'mastercard')]"));

        System.out.println("Количество найденных логотипов: " + logos.size());
        assertFalse(logos.isEmpty(), "Не найдено ни одного логотипа платежной системы");
    }

    @Test
    public void testMoreDetailsAboutService() {
        WebElement moreDetailsLink = driver.findElement(By.xpath("//h2[contains(text(),'Онлайн пополнение')]" +
                "/..//a[text()='Подробнее о сервисе']"));
        assertTrue(moreDetailsLink.isEnabled(), "Не кликается");
    }

    @Test
    public void testPayForm() {
        WebElement phoneInput = driver.findElement(By.xpath(" //h2[contains(text(),'Онлайн пополнение')]/.." +
                "//input[@id='connection-phone']"));
        WebElement amountInput = driver.findElement(By.xpath(" //h2[contains(text(),'Онлайн пополнение')]/.." +
                "//input[@id='connection-sum']"));
        WebElement buttonContinue = driver.findElement(By.xpath(" //h2[contains(text(),'Онлайн пополнение')]/.." +
                "//button[text()='Продолжить']"));

        phoneInput.click();
        phoneInput.sendKeys("297777777");

        amountInput.click();
        amountInput.sendKeys("100");

        assertTrue(buttonContinue.isDisplayed(), "Кнопка 'Продолжить' не отображается.");
        assertTrue(buttonContinue.isEnabled(), "Кнопка 'Продолжить' не кликабельна.");

        buttonContinue.click();

        // Тут надо свитчнуться на iframe, так как всплывающий модуль находится не новой странице, а на той же, но в iframe
        // Используем WebDriveWait, так как iframe становится видимым в DOM не сразу
        WebElement iframeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class = 'bepaid-iframe']")));
        driver.switchTo().frame(iframeElement);

        // На всякий случай попробовала найти элемент в iframe и уже по нему сделать проверку
        WebElement container =  wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[@class='ya-pay-button ya-pay-button_black']")));

        assertTrue(container.isDisplayed(), "Модальное окно не отображается после нажатия кнопки 'Продолжить'.");
    }

    @AfterAll
    public static void tearDownClass() {
        if (driver != null) {
            driver.quit();  // Закрываем браузер после завершения всех тестов
        }
    }
}

