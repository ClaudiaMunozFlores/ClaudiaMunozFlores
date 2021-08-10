package Practica_Exámen;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class prueba_mailchimp {

    public WebDriver driver;
    private int parametro = 0;

    public prueba_mailchimp() {
        this.parametro = 0;
    }
    public prueba_mailchimp (int param){
        this.parametro = param;
    }

    @BeforeMethod
    public void getMailchimp(){
        System.setProperty("webdriver.chrome.driver" , "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.id("onetrust-pc-btn-handler")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[contains(text(), 'Confirm My Choices')]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }


//Caso de prueba 1: ----------------------------------------------------------------------------------------------------
    @Test (dependsOnMethods = {"iniciarSesionPageTest"})
    public void validarTituloTest(){
        String ActualTittle = driver.getTitle();
        String ExpectedTittle = "Log In";
        Assert.assertEquals(ActualTittle, ExpectedTittle);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.quit();
    }


//Caso de prueba 2: ----------------------------------------------------------------------------------------------------
    @Test (dependsOnMethods = {"loginErrorTest"})
    public void iniciarSesionPageTest(){
        List<WebElement> list01 = driver.findElements(By.xpath("//*[contains(text(),'Iniciar sesión')]"));
        Assert.assertTrue(list01.size() > 0, "El texto no se encuentra en el website");

        List<WebElement> list02 = driver.findElements(By.xpath("//*[contains(text(),'Need a Mailchimp account?')]"));
        Assert.assertTrue(list02.size() > 0, "El texto no se encuentra en el website");

        driver.close();
    }


//Caso de prueba 3: ----------------------------------------------------------------------------------------------------
    @Test (dependsOnMethods = {"fakeEmailTest"})
    public void loginErrorTest(){
        driver.findElement(By.id("username")).sendKeys("XXXXX@gmail.com");
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Looks like you forgot your password there')]"));
        Assert.assertTrue(list.size() > 0, "El texto no se encuentra en el website");

        Assert.assertTrue(driver.findElement(By.id("stay-signed-in")).isSelected(), "el elemento no está seleccionado");

        driver.close();
    }


//Caso de prueba 4: ----------------------------------------------------------------------------------------------------
    @Test (dependsOnMethods = {"dataProviderEmailTest"})
    public void fakeEmailTest(){
        driver.navigate().to("https://login.mailchimp.com/signup/");

        List<WebElement> lista = driver.findElements(By.xpath("//*[contains(text(),'Customize Settings')]"));
        if (lista.size() > 0){
            driver.findElement(By.id("onetrust-pc-btn-handler")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }

        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        System.out.println(email);
        driver.findElement(By.id("email")).sendKeys(email);

        driver.close();
    }


//Caso de prueba 5: ----------------------------------------------------------------------------------------------------
    @DataProvider(name = "emails")
    public Object[][] emailsToTest(){
        return new Object[][]{
            {"test@test.com"},
            {"prueba2@test.com"},
            {"10agsoto2021@gmail.com"},
    };
}


    @Test (dataProvider = "emails")
    public void dataProviderEmailTest(String anEmail){
        driver.findElement(By.id("username")).sendKeys(anEmail);
        driver.findElement(By.id("password")).sendKeys("holamundo");
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Can we help you recover your username?')]"));
        Assert.assertTrue(list.size() > 0, "El texto no se encuentra en el website");

        driver.close();
    }


}
