package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;
import utils.Validaciones;
import java.util.ArrayList;
import java.util.List;

public class MatrizQaNova {

    @FindBy(xpath = "//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]")
    private WebElement btnMatriz;
    @FindBy(id = "pluginAppObj_4_01_filter_field")
    private WebElement inputFltrar;
    @FindBy(id = "pluginAppObj_4_01_filter_button")
    private WebElement btnFiltrar;
    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr[1]")
    private WebElement primeraFila;
    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table")
    private WebElement tabla;
    @FindBy(className = "jtable-page-number-next")
    private WebElement btnAdelante;
    //@FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_jtable\"]/div/div[4]/div[1]/span[2]/select")
    //private WebElement numeroPagina;


    WebDriverWait webDriverWait;

    public MatrizQaNova( ) {

        PageFactory.initElements(DriverContext.getDriver(), this);
        webDriverWait = new WebDriverWait(DriverContext.getDriver(), 30);
    }

    public void abrirMatriz(){
        btnMatriz.click();
    }

    public void validarDespliegueMatriz(){
        Validaciones.validarObjeto(inputFltrar, "Input Filtrar");
        Validaciones.validarObjeto(tabla, "Matriz");
    }

    public void recuperarDatosConFiltro(String filtro) throws InterruptedException {

        Validaciones.validarMatrizPorFiltro(inputFltrar,filtro);
    }


    public void recuperarDatos(int paginas) throws InterruptedException{

        Validaciones.validarMatriz(paginas);
    }

    public void clickBtnAdelante() throws InterruptedException {
        btnAdelante.click();
        Thread.sleep(2000);
    }

    public void clickBtnFiltrar() throws InterruptedException {
        btnFiltrar.click();
        Thread.sleep(2000);
    }

}
