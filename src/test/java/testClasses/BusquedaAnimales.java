package testClasses;

import org.openqa.selenium.WebDriver;
import page.Busqueda;
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

    public void recuperarDatosBusquedaPerro(){
        Google google = new Google(webDriver);
        google.validarDespliegue();
        google.ingresarBusqueda("Perro");
        google.clickBtnBuscar();
        Busqueda busqueda = new Busqueda(webDriver);
        busqueda.validarTituloUrl();
        busqueda.extraerTexto();
        busqueda.extraerUrl();
    }

}
