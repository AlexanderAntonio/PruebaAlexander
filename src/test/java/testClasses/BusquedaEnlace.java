package testClasses;

import org.openqa.selenium.WebDriver;
import page.Busqueda;

public class BusquedaEnlace {

    WebDriver webDriver;
    public BusquedaEnlace(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void TextoEnlace(){
        Busqueda busqueda = new Busqueda(webDriver);
        busqueda.extraerTexto();
    }

    public void EntrarEnlace(){
        Busqueda busqueda = new Busqueda(webDriver);
        busqueda.clickEnlace();
    }
}
