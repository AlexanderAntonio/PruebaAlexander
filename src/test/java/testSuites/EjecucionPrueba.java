package testSuites;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClasses.BusquedaAnimales;
import testClasses.BusquedaFarmacia;
import testClasses.IngresarCorreo;
import testClasses.IngresarQaNova;
import utils.Constants.Navegador;
import utils.DriverContext;
import utils.ReadProperties;
import utils.Reporte.PdfQaNovaReports;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public class EjecucionPrueba {


    private String URL = "https://www.google.com/";
    private String URL2 = "http://qanovagroup.com/piloto/";
    private String URL3 = "https://www.google.cl/maps";
    private String URL4 = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

    @BeforeTest
    public void setUp() {
        DriverContext.setUp(Navegador.Chrome, URL4);
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

    @Test public void validarFarmacia() throws IOException, InterruptedException {
        BusquedaFarmacia busquedaFarmacia = new BusquedaFarmacia();
        busquedaFarmacia.ValidarBusquedaMapa();
        PdfQaNovaReports.closePDF();
    }

    @Test public void enviarCorreo() throws InterruptedException, AWTException {
        IngresarCorreo ingresarCorreo = new IngresarCorreo();
        String correoGmail = ReadProperties.readFromConfig("propiedades.properties").getProperty("correoGmail");
        String contraGmail = ReadProperties.readFromConfig("propiedades.properties").getProperty("contraGmail");
        ingresarCorreo.iniciarGmail(correoGmail,contraGmail);
        ingresarCorreo.adjuntarArchivoGmail();
        PdfQaNovaReports.closePDF();
    }

}
