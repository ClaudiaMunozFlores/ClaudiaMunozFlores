package Clase_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SpotifyWithCssSelectorTest {

    private WebDriver getSpotify(){
        System.setProperty("webdriver.chrome.driver" , "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/signup/");
        return driver;
    }


    @Test
    public void spotifyByPlaceHolderTest() throws InterruptedException {

        WebDriver driver = getSpotify();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("claumunoz0839@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("claumunoz0839@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("ContraseñaPrueba");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("ClaudiaMuñoz");
        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys("02");

        WebElement monthElement = driver.findElement(By.cssSelector("select[id='month']"));
        Select monthSelect = new Select(monthElement);
        monthSelect.selectByValue("11");

        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("1994");

        driver.findElement(By.cssSelector("#__next > main > div:nth-of-type(2) > div > form > fieldset > div > div:nth-of-type(2) > label > span:first-of-type")).click();
        
    }


}
