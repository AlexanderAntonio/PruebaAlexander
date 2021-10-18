package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;

public class QAnova {

    @FindBy (xpath = "(//input[@id= 'imUname'])")
    private WebElement inputUsuario;

    @FindBy (xpath = "(//input[@type= 'password'])")
    private WebElement inputContra;

    @FindBy (xpath = "(//input[@value= 'Ingresar a Demo'])")
    private WebElement btnIngresar;

    WebDriverWait webDriverWait;

    public QAnova( ) {
        PageFactory.initElements(DriverContext.getDriver(), this);
        webDriverWait = new WebDriverWait(DriverContext.getDriver(), 30);
    }

    public void validarDespliegueLogin(){
        webDriverWait.until(ExpectedConditions.visibilityOf(inputUsuario));
        webDriverWait.until(ExpectedConditions.visibilityOf(inputContra));
        PdfQaNovaReports.addWebReportImage("Despliegue Login","Pagina login desplegada correctamente", EstadoPrueba.PASSED,false);
    }

    public void ingresarUsuario(String usuario) {
        inputUsuario.sendKeys(usuario);
        System.out.println("El usuario es '" + usuario + "'");
    }
    public void ingresarContra(String contra) {

        inputContra.sendKeys(contra);
    }

    public void clickBtnIngresar(){
        webDriverWait.until(ExpectedConditions.visibilityOf(btnIngresar));
        PdfQaNovaReports.addWebReportImage("Datos Login","Campo usario y contraseña completados", EstadoPrueba.PASSED,false);
        btnIngresar.click();
    }

}
