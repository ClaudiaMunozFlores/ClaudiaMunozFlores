package Clase_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.lang.ref.SoftReference;

public class ejercicioGit {

    WebDriver driver;

    @BeforeMethod
    public void getSalesforce(){
        System.setProperty("webdriver.chrome.driver" , "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/?locale=eu");
    }


    @Test (priority = 3)
    public void LoginFailureTest() throws InterruptedException {
        WebElement logo = driver.findElement(By.xpath("//*[@id='logo']"));
        boolean logoPresent = logo.isDisplayed();
        Assert.assertTrue(logoPresent , "La imagen no se encuentra disponible");

        driver.findElement(By.id("username")).sendKeys("test@test.com");
        driver.findElement(By.id("password")).sendKeys("123466");
        driver.findElement(By.id("Login")).click();

        Thread.sleep(2000);
        WebElement messageError = driver.findElement(By.id("error"));
        System.out.println("Error: " +messageError.getText());
    }

    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


}
