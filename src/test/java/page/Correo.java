package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Validaciones;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class Correo {

    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    private WebElement inputCorreo;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement inputContra;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    private WebElement btnSiguiente;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/span")
    private WebElement btnIngresar;

    @FindBy(className = "z0")
    private WebElement btnRedactar;

    @FindBy(className = "vO")
    private WebElement inputDestino;

    @FindBy(name = "subjectbox")
    private WebElement inputAsunto;

    @FindBy(xpath = "/html/body/div[23]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[4]/div/div[1]/div/div/div")
    private WebElement btnAdjuntar;

    @FindBy(className = "dC")
    private WebElement btnEnviar;

    @FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div/div[1]/div[1]/div/div[4]/div/div/div[2]/span/a")
    private WebElement btnEnviados;

    @FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[4]/div[2]/div/table/tbody/tr[1]")
    private WebElement correoEnviado;

    public Correo(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void validarDespliegueLogin(){
        Validaciones.validarObjeto(inputCorreo, "Input usuario");
    }
    public void validarDesplieguecontra(){
        Validaciones.validarObjeto(inputContra, "Input clave");
    }
    public void validarDespliegueGmail(){
        Validaciones.validarObjeto(btnRedactar, "Gmail");
    }


    public void ingresarUsuario(String correoGmail) throws InterruptedException {

        inputCorreo.sendKeys(correoGmail);
        clickSigUsuario();
        Thread.sleep(3000);
    }

    public void ingresarContra(String contraGmail) {
        inputContra.sendKeys(contraGmail);
        clicklIngresar();
    }

    public void clickSigUsuario(){
        btnSiguiente.click();
    }

    public void clicklIngresar(){
        btnIngresar.click();
    }

    public void clickBtnRedactar() throws InterruptedException {
        Thread.sleep(4000);
        btnRedactar.click();
    }
    public void clickBtnEnviar() throws InterruptedException {
        Thread.sleep(4000);
        btnEnviar.click();
    }


    public void redactarCorreo(String archivo,String correoDestino, String asuntoCorre) throws AWTException, InterruptedException {
        Thread.sleep(3000);
        inputDestino.sendKeys(correoDestino);
        inputAsunto.sendKeys(asuntoCorre);
        Thread.sleep(3000);
        btnAdjuntar.click();
        File file = new File("D:\\Git\\PruebaAlexander\\tmp\\"+archivo);
        StringSelection ss = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        PdfQaNovaReports.addWebReportImage("Validacion correo", "El correo fue redactado correctamente", EstadoPrueba.PASSED, false);
        clickBtnEnviar();
    }

    public void validarCorreoEnviado() throws InterruptedException {
        btnEnviados.click();
        Thread.sleep(2000);
        correoEnviado.click();
        Thread.sleep(2000);
        PdfQaNovaReports.addWebReportImage("Validacion correo enviado", "El correo fue correctamente enviado", EstadoPrueba.PASSED, false);
    }
}
