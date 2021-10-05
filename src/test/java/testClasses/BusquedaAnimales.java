package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.Google;

import java.nio.file.WatchEvent;

public class BusquedaAnimales {

    WebDriver webDriver;
    public BusquedaAnimales(WebDriver webDriver){

    }

    public void buscarPerro(WebDriver webDriver){
        String ingresaBusqueda = "Perro";
        WebElement txtBuscardor = webDriver.findElement(By.name("q"));
        txtBuscardor.sendKeys(ingresaBusqueda);
        txtBuscardor.submit();

    }
}
