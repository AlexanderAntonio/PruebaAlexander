package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;
import utils.Validaciones;

import java.io.File;

public class CargaQaNova {

    @FindBy(xpath = "//*[@id=\"imMnMnNode6\"]/a/span/span/span[2]")
    private WebElement btnIrACarga;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_2\"]")
    private WebElement btnSeleccionarArchivo;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_submit\"]")
    private WebElement btnEnviar;



    WebDriverWait webDriverWait;

    public CargaQaNova( ) {
        PageFactory.initElements(DriverContext.getDriver(), this);
        webDriverWait = new WebDriverWait(DriverContext.getDriver(), 30);
    }

    public void validarDespliegueCarga(){
        Validaciones.validarObjeto(btnSeleccionarArchivo, "Boton seleccionar archivo");
    }
    public void irACarga(){
        btnIrACarga.click();
    }
    public void clickEnviarArchivo(){
        btnEnviar.click();
    }
    public void subirArchivo(String ruta,String archivo){
        Validaciones.validarCargaArchivo(btnSeleccionarArchivo,ruta,archivo);
    }
}
