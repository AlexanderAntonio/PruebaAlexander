package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;


public class Busqueda {

    @FindBy(xpath = "(//h3[@class= 'LC20lb DKV0Md'])")
    private WebElement enlace;

    @FindBy(xpath = "(//a[@href= 'https://es.wikipedia.org/wiki/Canis_familiaris'])")
    private WebElement urlBusqueda;


    @FindBy(xpath = "(//div[@class = 'yuRUbf'])[1]//h3")
    private WebElement titulo;

    @FindBy(xpath = "((//div[@class = 'yuRUbf'])[1]//a)[1]")
    private WebElement url;


    WebDriverWait webDriverWait;

    public Busqueda() {

        PageFactory.initElements(DriverContext.getDriver(), this);
        webDriverWait = new WebDriverWait(DriverContext.getDriver(), 30);
    }
    public void validarTituloUrl(){
        webDriverWait.until(ExpectedConditions.visibilityOf(titulo));
        webDriverWait.until(ExpectedConditions.visibilityOf(url));
        PdfQaNovaReports.addWebReportImage("Despliegue de la busqueda","Se realiza la busqueda", EstadoPrueba.PASSED,false);
    }

    public void extraerTexto(){
        System.out.println("El texto es '" + titulo.getText()+"'");
    }
    public void extraerUrl() {
        System.out.println("La URL es '" + url.getAttribute("href") +"'");
    }

}
