import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.junit5.AllureJunit5;

import java.time.Duration;
import java.util.List;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AllureJunit5.class})
public class OnlineReplenishmentTest {
    private static WebDriver driver;
    WebDriverWait wait  =  new  WebDriverWait (driver, Duration.ofSeconds(10));
    String sum = "100.00";
    String phone = "297777777";

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); //создание экземпляраа
        driver.get("http://mts.by");
        String sum = "100.00";
        String phone = "297777777";
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cookie__buttons']/button[@id='cookie-agree']")));
        button.click();*/
    }

    @Test
    @DisplayName("Услуги связи: надписи в незаполненных полях формы")
    public void formPayConnection() {
        WebElement selectElement = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/.//p[contains(text(),'Услуги связи')]"));

        selectElement.click();
        selectElement2.click();

        List<WebElement> elementsConnection = driver.findElements(By.xpath("//form[@id='pay-connection']/.//input"));
        LinkedList<String> expectedLabel = new LinkedList<>();
        expectedLabel.add(0, "Номер телефона");
        expectedLabel.add(1, "Сумма");
        expectedLabel.add(2, "E-mail для отправки чека");
        LinkedList<String> actualLabel = new LinkedList<>();
        for (WebElement element : elementsConnection) {
            actualLabel.add(element.getAttribute("placeholder"));
        }
        assertEquals(expectedLabel, actualLabel, "Есть несоответствие");
        System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");
    }

    @Test
    @DisplayName("Домашний интернет: надписи в незаполненных полях формы")
    public void formPayInternet() {
        WebElement selectElement = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/.//p[contains(text(),'Домашний интернет')]"));

        selectElement.click();
        selectElement2.click();


        List<WebElement> elementsConnection = driver.findElements(By.xpath("//form[@id='pay-internet']/.//input"));
        LinkedList<String> expectedLabel = new LinkedList<>();
        expectedLabel.add(0, "Номер абонента");
        expectedLabel.add(1, "Сумма");
        expectedLabel.add(2, "E-mail для отправки чека");
        LinkedList<String> actualLabel = new LinkedList<>();
        for (WebElement element : elementsConnection) {
            actualLabel.add(element.getAttribute("placeholder"));
        }
        assertEquals(expectedLabel, actualLabel, "Есть несоответствие");
        System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");
    }

    @Test
    @DisplayName("Рассрочка: надписи в незаполненных полях формы")
    public void formPayInstalment() {
        WebElement selectElement = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/.//p[contains(text(),'Рассрочка')]"));

        selectElement.click();
        selectElement2.click();

        List<WebElement> elementsConnection = driver.findElements(By.xpath("//form[@id='pay-instalment']/.//input"));
        LinkedList<String> expectedLabel = new LinkedList<>();
        expectedLabel.add(0, "Номер счета на 44");
        expectedLabel.add(1, "Сумма");
        expectedLabel.add(2, "E-mail для отправки чека");
        LinkedList<String> actualLabel = new LinkedList<>();
        for (WebElement element : elementsConnection) {
            actualLabel.add(element.getAttribute("placeholder"));
        }
        assertEquals(expectedLabel, actualLabel, "Есть несоответствие");
        System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");
    }

    @Test
    @DisplayName("Задолженность: надписи в незаполненных полях формы")
    public void formPayArrears() {
        WebElement selectElement = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/.//p[contains(text(),'Задолженность')]"));

        selectElement.click();
        selectElement2.click();

        List<WebElement> elementsConnection = driver.findElements(By.xpath("//form[@id='pay-arrears']/.//input"));
        LinkedList<String> expectedLabel = new LinkedList<>();
        expectedLabel.add(0, "Номер счета на 2073");
        expectedLabel.add(1, "Сумма");
        expectedLabel.add(2, "E-mail для отправки чека");
        LinkedList<String> actualLabel = new LinkedList<>();
        for (WebElement element : elementsConnection) {
            actualLabel.add(element.getAttribute("placeholder"));
        }
        assertEquals(expectedLabel, actualLabel, "Есть несоответствие");
        System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");
    }

    @AfterAll
    public static void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}