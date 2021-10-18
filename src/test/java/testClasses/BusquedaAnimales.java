package testClasses;

import org.openqa.selenium.WebDriver;
import page.Busqueda;
import page.Google;

public class BusquedaAnimales {



    public BusquedaAnimales( ) {

    }

    public void buscarPerro() {
        Google google = new Google();
        google.ingresarBusqueda("Perro");
        google.clickBtnBuscar();
    }

    public void recuperarDatosBusquedaPerro(){
        Google google = new Google();
        google.validarDespliegue();
        google.ingresarBusqueda("Perro");
        google.clickBtnBuscar();
        Busqueda busqueda = new Busqueda();
        busqueda.validarTituloUrl();
        busqueda.extraerTexto();
        busqueda.extraerUrl();
    }

}
