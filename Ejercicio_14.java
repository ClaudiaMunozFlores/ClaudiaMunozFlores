package Clase_9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio_14 {

    @Test
    public void navegarEnNetflix(){

        System.setProperty("webdriver.chrome.driver" , "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://netflix.com");

        List<WebElement> ListaH1s = driver.findElements(By.tagName("h1"));
        System.out.println("Elementos h1: ");
        for (WebElement h1: ListaH1s){
            System.out.println("--> H1: " +h1.getText());
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------- ");

        List<WebElement> ListaH2s = driver.findElements(By.tagName("h2"));
        System.out.println("Elementos h2: ");
        for (WebElement h2: ListaH2s){
            System.out.println("--> H2: " +h2.getText());
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------- ");

        driver.navigate().refresh();
        System.out.println("***El sitio fue refrescado***");

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------- ");

        List<WebElement> listaButton = driver.findElements(By.tagName("div"));
        for (WebElement button : listaButton){
            System.out.println("-Button Nª" +listaButton.indexOf(button) +": " + button.getText());
        }

        List<WebElement> listaDiv = driver.findElements(By.tagName("div"));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------- ");
        System.out.println("La cantidad de elementos de tipo div es: " +listaDiv.size());

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------- ");

        System.out.println("Título: " +driver.getTitle());

        List<WebElement> listaLink = driver.findElements(By.tagName("a"));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------- ");
        System.out.println("La cantidad de elementos de tipo link es: " +listaLink.size());

    }

}
