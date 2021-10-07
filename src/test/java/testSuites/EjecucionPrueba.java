package testSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClasses.BusquedaAnimales;
import testClasses.BusquedaEnlace;

public class EjecucionPrueba {

    private WebDriver webDriver;
    private String URL = "https://www.google.com/";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driverNavegador/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(URL);
    }

    @AfterTest
    void TearDown() {
        //webDriver.quit();
    }

    @AfterTest
    public void RecuperarTexto(){
        BusquedaEnlace busquedaEnlace = new BusquedaEnlace(webDriver);
        //busquedaEnlace.TextoEnlace();

    }
    @AfterTest
    public void ClickEnlace(){
        BusquedaEnlace busquedaEnlace = new BusquedaEnlace(webDriver);
        //busquedaEnlace.EntrarEnlace();
    }

    @Test
    public void BuscarPerroEnGoogle() {
        BusquedaAnimales busquedaAnimales = new BusquedaAnimales(webDriver);
        BusquedaEnlace busquedaEnlace = new BusquedaEnlace(webDriver);
        busquedaAnimales.buscarPerro();
        busquedaEnlace.TextoEnlace();
        busquedaEnlace.EntrarEnlace();
    }

}
