package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;

public class Google {

    @FindBy(xpath = "(//input[@class= 'gLFyf gsfi'])")
    private WebElement inputBuscar;

    @FindBy(xpath = "(//input[@value= 'Buscar con Google'])[2]")
    private WebElement btnBuscar;

    WebDriverWait webDriverWait;

    public Google( ) {

        PageFactory.initElements(DriverContext.getDriver(), this);
        webDriverWait = new WebDriverWait(DriverContext.getDriver(), 30);
    }

    public void validarDespliegue(){
        webDriverWait.until(ExpectedConditions.visibilityOf(inputBuscar));
        PdfQaNovaReports.addWebReportImage("Despliegue de Google","Se comprueba que la pagina de despliegue correctamente", EstadoPrueba.PASSED,false);
    }

    public void ingresarBusqueda(String animal) {
        inputBuscar.sendKeys(animal);
        System.out.println("Buscamos un '" + animal + "'");
        PdfQaNovaReports.addWebReportImage("Campo de Busqueda","Se rellena el campo de busqueda", EstadoPrueba.PASSED,false);
    }

    public void clickBtnBuscar() {
        inputBuscar.sendKeys(Keys.ESCAPE);
        webDriverWait.until(ExpectedConditions.visibilityOf(btnBuscar));
        btnBuscar.click();
    }
}

