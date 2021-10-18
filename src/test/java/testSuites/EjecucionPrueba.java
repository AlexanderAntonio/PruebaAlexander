package testSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClasses.BusquedaAnimales;
import testClasses.IngresarQAnova;
import utils.Constants.Navegador;
import utils.DriverContext;
import utils.Reporte.PdfQaNovaReports;

import java.text.ParseException;

public class EjecucionPrueba {


    private String URL = "https://www.google.com/";
    private String URL2 = "http://qanovagroup.com/piloto/";

    @BeforeTest
    public void setUp() {
        DriverContext.setUp(Navegador.Chrome, URL2);
        PdfQaNovaReports.createPDF();
    }

    @AfterTest
    void TearDown() {
        DriverContext.closeDriver();
    }


    @Test
    public void BuscarPerroEnGoogle() {
        BusquedaAnimales busquedaAnimales = new BusquedaAnimales();
        busquedaAnimales.buscarPerro();
    }

    @Test
    public void busquedaPerro(){
        BusquedaAnimales busquedaAnimales = new BusquedaAnimales();
        busquedaAnimales.recuperarDatosBusquedaPerro();
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void iniciarQanova() throws InterruptedException, ParseException {
        IngresarQAnova ingresarQAnova = new IngresarQAnova();
        ingresarQAnova.iniciarSesion();
        ingresarQAnova.llenarFormulario();
        PdfQaNovaReports.closePDF();
        //ingresarQAnova.Filtrar();

    }

}
