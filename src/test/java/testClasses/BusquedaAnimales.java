package testClasses;

import org.openqa.selenium.WebDriver;
import page.Google;

public class BusquedaAnimales {

    WebDriver webDriver;

    public BusquedaAnimales(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void buscarPerro() {
        Google google = new Google(webDriver);
        google.ingresarBusqueda("Perro");
        google.clickBtnBuscar();
    }
}
