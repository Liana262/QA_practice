package org.example;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class LoginTest {
    /**
     * осуществление первоначальной настройки
     */
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        //System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");

        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);}
    @Test
    public void test_0_1_1and2and3and4() throws InterruptedException {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        driver.findElement(By.xpath("//*[contains(@class, 'sc-pNWxx sc-jrsJCI dryRrI emsrNO')]")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'Button2 Button2_size_l Button2_view_action Button2_width_max Button2_type_submit')]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("passp-field-passwd")).sendKeys(ConfProperties.getProperty("password"));
        driver.findElement(By.xpath("//button[contains(@class, 'Button2 Button2_size_l Button2_view_action Button2_width_max Button2_type_submit')]")).click();

        Assert.assertEquals(ConfProperties.getProperty("name"),
                driver.findElement(By.xpath("//span[contains(@class, 'user-account__name')]")).getText());
        Assert.assertEquals(ConfProperties.getProperty("personal-info__first"),
                driver.findElement(By.xpath("//div[contains(@class, 'personal-info__first')]")).getText());
        Assert.assertEquals(ConfProperties.getProperty("personal-info__last"),
                driver.findElement(By.xpath("//div[contains(@class, 'personal-info__last')]")).getText());
        String user = profilePage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("name"), user);

    } @After
    public void tearDown() {
        profilePage.entryMenu();
        profilePage.userLogout();
        driver.quit();

    }}
