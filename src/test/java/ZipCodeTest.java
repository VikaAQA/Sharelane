import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeTest {

    /*
    1.Открыть браузер Chrome
    2.В браузере открыть страницу
    3.
     */

 @Test
    public void test() {
     System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");//устанавливаем Path переменную
     WebDriver browser= new ChromeDriver();// создание экземляр класса ChromeDriver
     browser.get("https://www.sharelane.com/cgi-bin/register.py");
     browser.findElement(By.name("zip_code")).sendKeys("1234");
     browser.findElement(By.cssSelector("[value=Continue]")).click();
     String errorMessage= browser.findElement(By.className("error_message")).getText();
     Assert.assertEquals(errorMessage,"Oops, error on page. ZIP code should have 5 digits");
     browser.quit();
    }
}
