import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ZipCodeTest {

    @Test
    public void test() {
     WebDriver browser= new ChromeDriver();// создание экземляр класса ChromeDriver
     browser.get("https://www.sharelane.com/cgi-bin/register.py");
     browser.findElement(By.name("zip_code")).sendKeys("1234");
     browser.findElement(By.cssSelector("[value=Continue]")).click();
     WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
     WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error_message")));
     String errorMessage = errorElement.getText();
     Assert.assertEquals(errorMessage,"Oops, error on page. ZIP code should have 5 digits");
     browser.quit();
    }

    @Test
    public void test1() {
        WebDriver browser= new ChromeDriver();// создание экземляр класса ChromeDriver
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("12345");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement registerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Register']")));
        Assert.assertTrue(registerButton.isDisplayed(), "Кнопка 'Register' не отображается на странице");
        browser.quit();
    }
}
