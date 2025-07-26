import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.HashMap;
import static java.lang.Thread.sleep;

public class ShoppingCardTest {
    @Test
    public void checkDiscountNull() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();// код для закрытия предупреждения от Chrome
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");

        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&last_name="+
                "test&email=test%40test.test&password1=12345678&password2=12345688");
        String email = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table"+
                "/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement((By.cssSelector("[value=Update"))).click();
        sleep(5000);

        String discountPercent = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent,"0","Процент скидки для количества < 20 должен быть 0");
        softAssert.assertEquals(discountDollar,"0.0","Сумма скидки для количества < 20 должна быть 0.0.");
        softAssert.assertEquals(total,"190.00","Ошибка в расчете итоговой суммы товаров");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountTwoPercent() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();// код для закрытия предупреждения от Chrome
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        //   Webdriver driver = new ChromeDriver(options);

        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&last_name="+
                "test&email=test%40test.test&password1=12345678&password2=12345688");
        String email = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table"+
                "/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("30");
        driver.findElement((By.cssSelector("[value=Update"))).click();
        sleep(5000);

        String discountPercent = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent,"2","Процент скидки для количества от 20 до 49 должен быть 2 ");
        softAssert.assertEquals(discountDollar,"6.0","Ошибка в расчете суммы скидки ");
        softAssert.assertEquals(total,"294.00","Ошибка в расчете итоговой суммы товаров ");

        driver.quit();
        softAssert.assertAll();

    }

    @Test
    public void checkDiscountFourPercent() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();// код для закрытия предупреждения от Chrome
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");

        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&last_name="+
                "test&email=test%40test.test&password1=12345678&password2=12345688");
        String email = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table"+
                "/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("110");
        driver.findElement((By.cssSelector("[value=Update"))).click();
        sleep(5000);

        String discountPercent = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent,"4","Процент скидки для количества от 100 до 499 должен быть 4");
        softAssert.assertEquals(discountDollar,"44.0","Ошибка в расчете суммы скидки ");
        softAssert.assertEquals(total,"1056.00","Ошибка в расчете итоговой суммы товаров ");

        driver.quit();
        softAssert.assertAll();
    }
}

