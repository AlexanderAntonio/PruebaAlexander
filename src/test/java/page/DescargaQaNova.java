package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;
import utils.Validaciones;

import java.io.File;

public class DescargaQaNova {

    @FindBy(xpath = "//*[@id=\"imMnMnNode5\"]/a/span/span/span[2]")
    private WebElement btnIrADescarga;

    @FindBy(xpath = "//div[@id='pluginAppObj_5_06']")
    private WebElement descargaBoton;

    @FindBy(xpath = "//*[@id=\"imTextObject_5_05_tab0\"]/div/div[2]/a")
    private WebElement descargaLink;

    @FindBy(xpath = "//*[@id=\"imCellStyle_4\"]")
    private WebElement descargaImagen;

    WebDriverWait webDriverWait;

    public DescargaQaNova( ) {
        PageFactory.initElements(DriverContext.getDriver(), this);
        webDriverWait = new WebDriverWait(DriverContext.getDriver(), 30);
    }

    public void validarDespliegueDescarga(){
        Validaciones.validarObjeto(descargaBoton, "Descargar por boton");
    }
    public void irADescarga(){
        btnIrADescarga.click();
    }

    public void descargaPorBoton(String rutaDescarga) throws InterruptedException {
        Validaciones.valdiarDescargaPorBtn(descargaBoton,rutaDescarga);
    }

    public void descargaPorLink(String rutaDescarga) throws InterruptedException {
        Validaciones.valdiarDescargaPorLink(descargaLink,rutaDescarga);
    }

    public void descargaPorImagen(String rutaDescarga) throws InterruptedException {
        Validaciones.valdiarDescargaPorImg(descargaImagen,rutaDescarga);
    }

   public void descargarArchivo(String metodo, String rutaDescarga) throws InterruptedException {

        if (metodo.equals("boton")){
            descargaPorBoton(rutaDescarga);
        }if (metodo.equals("link")){
            descargaPorLink(rutaDescarga);
        }if (metodo.equals("imagen")){
            descargaPorImagen(rutaDescarga);
        }
    }
}
