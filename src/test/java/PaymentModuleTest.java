import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
/*Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы,
    нажать кнопку «Продолжить» и в появившемся окне проверить корректность отображения суммы (в том числе на кнопке),
    номера телефона, а также надписей в незаполненных полях для ввода реквизитов карты, наличие иконок платёжных систем.*/
public class PaymentModuleTest {
    private static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    static String sum = "100.00";
    static String phone = "297777777";

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); //создание экземпляраа
        driver.get("http://mts.by");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement phoneInput = driver.findElement(By.xpath(" //input[@id='connection-phone']"));
        WebElement amountInput = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        WebElement buttonContinue = driver.findElement(By.xpath("//button[text()='Продолжить']"));

        // Заполняем поля
        phoneInput.sendKeys(phone);
        amountInput.sendKeys(sum);
        buttonContinue.click();

        // Ждем появления модуля оплаты, чтобы свитчнуться на него
        WebElement iframeElement = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class = 'bepaid-iframe']")));
        driver.switchTo().frame(iframeElement);

    }

    @Test
    @DisplayName("Тест на отображение надписи суммы в модуле оплаты (сверху и на кнопке)")
    public void textOfCost() {

        //Ждем появления надписи суммы
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'pay-description__cost']/descendant::span[1]")));

        //Сумма сверху
        // Создаем динамический XPath для надписи сверху и на кнопке
        String xpathExpressionSpan = String.format("//app-payment-container/.//span[contains(text(), '%s')]", sum);
        WebElement labelSum = driver.findElement(By.xpath(xpathExpressionSpan));
        String actualLabelSum = labelSum.getText();
        assertEquals(sum + " BYN", actualLabelSum, "Надпись не соответсвует фактической сумме");

        // Сумма на кнопке
        WebElement labelSumOnButton = driver.findElement(By.xpath("//app-payment-container/.//button[@class = 'colored disabled']"));
        String actualLabelSumOnButton = labelSumOnButton.getText();
        assertEquals("Оплатить " + sum + " BYN", actualLabelSumOnButton, "Надпись не соответсвует фактической сумме");

    }

    @Test
    @DisplayName("Тест на отображение надписи номера телефона в модуле оплаты")
    public void textOfPhone() {

        //Ждем появления надписи суммы
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'pay-description__text']/descendant::span[1]")));

        // Номер телефона
        String xpathExpressionPhone = String.format("//div[@class = 'pay-description__text']/span[contains(text(), '%s')]", phone);
        WebElement phoneNumber = driver.findElement(By.xpath(xpathExpressionPhone));
        String actualLabelPhone = phoneNumber.getText();
        assertEquals("Оплата: Услуги связи Номер:375" + phone, actualLabelPhone, "Надпись не соответсвует фактическому номеру");
    }
    @Test
    @DisplayName("Тест на отображение надписей незаполненных полей формы банковской карты")
    public void formBankCard() {
        //Ждем появления полей
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-card-input")));

        // Поля
        List<WebElement> formElements = driver.findElements(By.xpath("//app-card-input/descendant::label[position() < last()]"));
        LinkedList<String> expectedLabel = new LinkedList<>();
        System.out.println("Количество найденных элементов: " + formElements.size());
        expectedLabel.add(0, "Номер карты");
        expectedLabel.add(1, "Срок действия");
        expectedLabel.add(2, "CVC");
        expectedLabel.add(3, "Имя держателя (как на карте)");
        LinkedList<String> actualLabel = new LinkedList<>();
        for (WebElement element : formElements) {
            actualLabel.add(element.getText());
        }
        assertEquals(expectedLabel, actualLabel, "Есть несоответствие");
        System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");

    }
    @Test
    @DisplayName("Тест на отображение иконок платежных систем")
    public void iconsPaySystem() {
        //Ждем появления полей
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-card-input")));
        List<WebElement> images = driver.findElements(By.xpath("//app-card-input/.//img"));
        for (int i = 0; i < images.size(); i++) {
            String url = images.get(i).getAttribute("src");
            assertTrue(url != null,"URL картинок пусты");
            double height = images.get(i).getSize().height;
            double width = images.get(i).getSize().width;
            assertTrue(height > 0);
            System.out.println("Высота картинки " + url + " = " + height);
            assertTrue(width > 0);
            System.out.println("Ширина картинки " + url + " = " + width);
        }
    }
        @AfterAll
        public static void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}

