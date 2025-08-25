import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/*
1.Перейти на страницу регистрации
2.Ввести ZipCode
3.Заполнить основные поля
4.Кликнуть кнопку Pегистрация
5.Проверкак создания пользователя по всплывающему сообщению
 */

public class SignUpTest {

    @Test
    public void checkSignUpValidUserData(){
        WebDriver browser= new ChromeDriver();// создание экземляра класса ChromeDriver
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//неявное ожидание
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("12345");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        browser.findElement(By.name("first_name")).sendKeys("test");
        browser.findElement(By.name("last_name")).sendKeys("test");
        browser.findElement(By.name("email")).sendKeys("test@mail.ru");
        browser.findElement(By.name("password1")).sendKeys("Qwerty!F");
        browser.findElement(By.name("password2")).sendKeys("Qwerty!F");
        browser.findElement(By.cssSelector("input[value='Register']")).click();
        String message = new WebDriverWait(browser,Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("confirmation_message"))).getText();
       // String message = browser.findElement(By.className("confirmation_message")).getText(); код без явного ожидания
        Assert.assertEquals(message,"Account is created!");
        browser.quit();
    }






}

