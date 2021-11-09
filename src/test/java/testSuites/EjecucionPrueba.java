package testSuites;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClasses.BusquedaAnimales;
import testClasses.IngresarQaNova;
import utils.Constants.Navegador;
import utils.DriverContext;
import utils.ReadProperties;
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
    public void iniciarQanova() throws ParseException {
        IngresarQaNova ingresarQAnova = new IngresarQaNova();
        String usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        ingresarQAnova.iniciarSesion(usuario,clave);

        ingresarQAnova.llenarFormulario();
        PdfQaNovaReports.closePDF();

    }

    @Test public void valdiarTextos(){
        IngresarQaNova ingresarQAnova = new IngresarQaNova();
        String usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        ingresarQAnova.iniciarSesion(usuario,clave);
        ingresarQAnova.validacionDeTextos();
        PdfQaNovaReports.closePDF();
    }
    @Test public void valdarMatriz() throws InterruptedException {
        IngresarQaNova ingresarQAnova = new IngresarQaNova();
        String usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        ingresarQAnova.iniciarSesion(usuario,clave);
        ingresarQAnova.filtrar();
        PdfQaNovaReports.closePDF();

    }

    @Test public void validarDescargaQaNova() throws InterruptedException {
        IngresarQaNova ingresarQAnova = new IngresarQaNova();
        String usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        String rutaDescarga = ReadProperties.readFromConfig("propiedades.properties").getProperty("rutaDescarga");
        ingresarQAnova.iniciarSesion(usuario,clave);
        ingresarQAnova.descarga(rutaDescarga);
        PdfQaNovaReports.closePDF();
    }

    @Test public void validarCargaQaNova() throws InterruptedException {
        IngresarQaNova ingresarQAnova = new IngresarQaNova();
        String usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        String rutaCarga = ReadProperties.readFromConfig("propiedades.properties").getProperty("rutaCarga");
        ingresarQAnova.iniciarSesion(usuario,clave);
        ingresarQAnova.carga(rutaCarga);
        PdfQaNovaReports.closePDF();

    }

}
