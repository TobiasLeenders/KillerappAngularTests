package tests;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegisterTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Tobias\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");

        baseUrl = "http://localhost:4200";
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testRegistrationKillerApp() throws Exception {
        driver.findElement(By.id("mat-tab-label-0-1")).click();
        driver.findElement(By.id("mat-input-2")).click();
        driver.findElement(By.id("mat-input-2")).clear();
        driver.findElement(By.id("mat-input-2")).sendKeys("registrationTest");
        driver.findElement(By.id("mat-input-3")).click();
        driver.findElement(By.id("mat-input-3")).clear();
        driver.findElement(By.id("mat-input-3")).sendKeys("password");
        driver.findElement(By.id("mat-input-4")).click();
        driver.findElement(By.id("mat-input-4")).clear();
        driver.findElement(By.id("mat-input-4")).sendKeys("test@email.com");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email'])[1]/following::button[1]")).click();
        //TODO Assert can't register because user already exists or else Assert registration complete
    }

    @Test
    public void loginTest() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("mat-input-0")).click();
        driver.findElement(By.id("mat-input-0")).clear();
        driver.findElement(By.id("mat-input-0")).sendKeys("1");
        driver.findElement(By.id("mat-input-1")).click();
        driver.findElement(By.id("mat-input-1")).clear();
        driver.findElement(By.id("mat-input-1")).sendKeys("2");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::button[1]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertEquals("1", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Logout'])[1]/following::span[1]")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}