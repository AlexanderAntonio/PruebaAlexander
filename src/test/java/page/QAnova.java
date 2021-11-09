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
import utils.Validaciones;

public class QAnova {

    @FindBy (xpath = "(//input[@id= 'imUname'])")
    private WebElement inputUsuario;

    @FindBy (xpath = "(//input[@type= 'password'])")
    private WebElement inputContra;

    @FindBy (xpath = "(//input[@value= 'Ingresar a Demo'])")
    private WebElement btnIngresar;

    public QAnova( ) {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void validarDespliegueLogin(){
    Validaciones.validarObjeto(inputUsuario, "Input usuario");
    Validaciones.validarObjeto(inputContra, "Input clave");
    }

    public void ingresarUsuario(String usuario) {
        inputUsuario.sendKeys(usuario);
        System.out.println("El usuario es '" + usuario + "'");
    }
    public void ingresarContra(String contra) {

        inputContra.sendKeys(contra);
    }

    public void clickBtnIngresar(){
        Validaciones.validarObjeto(btnIngresar, "Boton Ingresar");
        btnIngresar.click();
    }

}
