package testSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClasses.BusquedaAnimales;

public class EjecucionPrueba {

    private WebDriver webDriver;
    private String URL = "https://www.google.com/";


    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "driverNavegador/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(URL);
    }

    @Test
    public void BuscarPerroEnGoogle(){
        BusquedaAnimales busquedaAnimales = new BusquedaAnimales(webDriver);
        busquedaAnimales.buscarPerro(webDriver);
    }
}
