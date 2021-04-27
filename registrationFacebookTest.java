package Clase_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class registrationFacebookTest {

    @Test
    private WebDriver facebookLinksTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        return driver;
    }

//----------------------------------------------------------------------------------------------------------------

    @Test
    public void fullRegistrationTest() throws InterruptedException {

        WebDriver driver = facebookLinksTest();
        driver.findElement(By.linkText("Crear cuenta nueva")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("5555555");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");

        WebElement elementodias = driver.findElement(By.name("birthday_day"));
        Select dias = new Select(elementodias);
        dias.selectByVisibleText("26");

        WebElement elementoMeses = driver.findElement(By.name("birthday_month"));
        Select meses = new Select(elementoMeses);
        meses.selectByVisibleText("jun");

        WebElement elementoAños = driver.findElement(By.name("birthday_year"));
        Select años = new Select(elementoAños);
        años.selectByVisibleText("1980");

        List<WebElement> listaSexos = driver.findElements(By.name("sex"));
        WebElement maleElement = listaSexos.get(1);
        maleElement.click();

    }

}
