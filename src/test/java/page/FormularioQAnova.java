package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class FormularioQAnova {

    @FindBy(name = "Campo_Texto")
    private WebElement inputTexto;
    @FindBy(name = "Campo_Mail")
    private WebElement inputMail;
    @FindBy(name = "Campo_Area_de_Texto")
    private WebElement textAreatextp;
    @FindBy(name = "Campo_Fecha")
    private WebElement inputFecha;
    @FindBy(id = "imObjectForm_1_5_icon")
    private WebElement calendario;
    @FindBy(xpath = "//*[@id=\"imDPleft\"]")
    private WebElement btnAtrasCalendario;
    @FindBy(xpath = "//*[@id=\"imDPright\"]")
    private WebElement btnAdelanteCalendario;
    @FindBy(name = "Campo_Lista")
    private WebElement campoLista;
    @FindBy(id = "imObjectForm_1_7_0")
    private WebElement check1;
    @FindBy(id = "imObjectForm_1_7_1")
    private WebElement check2;
    @FindBy(id = "imObjectForm_1_7_2")
    private WebElement check3;
    @FindBy(xpath = "(//input[@value = 'cr 1'])")
    private WebElement radio1;
    @FindBy(xpath = "(//input[@value = 'cr 2'])")
    private WebElement radio2;
    @FindBy(xpath = "(//input[@value = 'cr 3'])")
    private WebElement radio3;
    @FindBy(id = "imObjectForm_1_submit")
    private WebElement btnEnviar;


    WebDriverWait webDriverWait;

    public FormularioQAnova( ) {
        PageFactory.initElements(DriverContext.getDriver(), this);
        webDriverWait = new WebDriverWait(DriverContext.getDriver(), 30);
    }

    public void validarDespliegueFormulario(){
        webDriverWait.until(ExpectedConditions.visibilityOf(inputTexto));
        webDriverWait.until(ExpectedConditions.visibilityOf(inputMail));
        PdfQaNovaReports.addWebReportImage("Despliegue Formulario","Pagina Formulario desplegada correctamente", EstadoPrueba.PASSED,false);
    }

    public void llenarCampoTexto(String cTexto) {
        inputTexto.sendKeys(cTexto);
    }
    public void llenarCampoMail(String cMail) {
        inputMail.sendKeys(cMail);
    }
    public void llenarCampoArea(String cArea) {
        textAreatextp.sendKeys(cArea);
    }
    public void clickCalendario() throws InterruptedException {
        calendario.click();
        btnAtrasCalendario.click();
        Thread.sleep(2000);
    }

    public void seleccionarFecha(String fecha) throws ParseException {
        calendario.click();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String hoy = simpleDateFormat.format(new Date());
        Date dateHoy = simpleDateFormat.parse(hoy);
        Date dateFecha =  simpleDateFormat.parse(fecha);
        long diferencia = ChronoUnit.MONTHS.between(LocalDate.parse(hoy).withDayOfMonth(1), LocalDate.parse(fecha).withDayOfMonth(1));
        int dia = Integer.parseInt(fecha.substring(fecha.length()-2));
        int mes;
        if(dateHoy.after(dateFecha)){
            mes = (int) (diferencia * -1);
            for (int x = 0; x <= mes-1; x++){
                btnAtrasCalendario.click();
            }
        }else {
            mes = (int) diferencia;
            for (int x = 0; x <= mes-1; x++){
                btnAdelanteCalendario.click();
            }
        }
        DriverContext.getDriver().findElement(By.xpath("//div[@id = 'imDPcal']//td[text() = '"+dia+"']")).click();
    }

    public void buscarFecha(String fecha){
        String[] partes = fecha.split("/");
        String dia = partes[0]; //Dia
        String mes = partes[1]; //Mes
        String ano = partes[2]; //Año
        int diaInt = Integer.parseInt(dia);
        int anoInt = Integer.parseInt(ano);
        int mesInt = 0;
        switch (mes){
            case "Enero": mesInt = 1;break;
            case "Febrero": mesInt = 2;break;
            case "Marzo": mesInt = 3;break;
            case "Abril": mesInt = 4;break;
            case "Mayo": mesInt = 5;break;
            case "Junio": mesInt = 6;break;
            case "Julio": mesInt = 7;break;
            case "Agosto": mesInt = 8;break;
            case "Septiembre": mesInt = 9;break;
            case "Octubre": mesInt = 10;break;
            case "Noviembre": mesInt = 11;break;
            case "Diciembre": mesInt = 12;break;
            default: break;
        }
        while (true){
            String mesAnoCalendario = DriverContext.getDriver().findElement(By.xpath("//*[@id=\"imDPMonth\"]")).getText();
            String[] parts = mesAnoCalendario.split(" ");
            String mesCalendario = parts[0]; //Mes
            String anoCalendario = parts[1]; //Año
            int anoCalendarioInt = Integer.parseInt(anoCalendario);
            int mesCalendarioInt = 0;
            switch (mesCalendario){
                case "Enero": mesCalendarioInt = 1;break;
                case "Febrero": mesCalendarioInt = 2;break;
                case "Marzo": mesCalendarioInt = 3;break;
                case "Abril": mesCalendarioInt = 4;break;
                case "Mayo": mesCalendarioInt = 5;break;
                case "Junio": mesCalendarioInt = 6;break;
                case "Julio": mesCalendarioInt = 7;break;
                case "Agosto": mesCalendarioInt = 8;break;
                case "Septiembre": mesCalendarioInt = 9;break;
                case "Octubre": mesCalendarioInt = 10;break;
                case "Noviembre": mesCalendarioInt = 11;break;
                case "Diciembre": mesCalendarioInt = 12;break;
                default: break;
            }
            if (mesCalendarioInt==1 && anoCalendarioInt==anoInt){
                break;
            }else if (anoCalendarioInt<anoInt){
                DriverContext.getDriver().findElement(By.xpath("//*[@id=\"imDPright\"]")).click();
            }else{
                DriverContext.getDriver().findElement(By.xpath("//*[@id=\"imDPleft\"]")).click();
            }
        }
        while (true){
            String mesAnoCalendario = DriverContext.getDriver().findElement(By.xpath("//*[@id=\"imDPMonth\"]")).getText();
            String[] parts = mesAnoCalendario.split(" ");
            String mesCalendario = parts[0]; //Mes
            int mesCalendarioInt = 0;
            switch (mesCalendario){
                case "Enero": mesCalendarioInt = 1;break;
                case "Febrero": mesCalendarioInt = 2;break;
                case "Marzo": mesCalendarioInt = 3;break;
                case "Abril": mesCalendarioInt = 4;break;
                case "Mayo": mesCalendarioInt = 5;break;
                case "Junio": mesCalendarioInt = 6;break;
                case "Julio": mesCalendarioInt = 7;break;
                case "Agosto": mesCalendarioInt = 8;break;
                case "Septiembre": mesCalendarioInt = 9;break;
                case "Octubre": mesCalendarioInt = 10;break;
                case "Noviembre": mesCalendarioInt = 11;break;
                case "Diciembre": mesCalendarioInt = 12;break;
                default: break;
            }
            if (mesCalendarioInt==mesInt){
                break;
            }else if (mesInt>mesCalendarioInt){
                DriverContext.getDriver().findElement(By.xpath("//*[@id=\"imDPright\"]")).click();
            }
        }
        if (diaInt > 28 && mes.equals("Febrero"))
        {
            System.out.println("Fecha incorrecta :"+dia+"/"+mes+"/"+ano);
        }else{
            DriverContext.getDriver().findElement(By.xpath("//tbody/tr/td[contains(text(),"+dia+")]")).click();
        }
    }

    public void llenarLista(String option){
        Select select = new Select(campoLista);
        select.selectByVisibleText(option);
    }

    public void clickSeleccionMultiple(String selecciones) {
        String[] indicadores = selecciones.split(";");
        for (String nro:indicadores) {
            int seleccion = Integer.parseInt(nro);
            switch (seleccion){
                case 1:
                    check1.click();
                    break;
                case 2:
                    check2.click();
                    break;
                case 3:
                    check3.click();
                    break;
                default:
                    System.out.println("Dato entregado no procesable");
            }
        }

    }
    public void clickRadio(int seleccionRadio) {

        switch (seleccionRadio){
            case 1:
                radio1.click();
                break;
            case 2:
                radio2.click();
                break;
            case 3:
                radio3.click();
                break;
            default:
                System.out.println("Dato entregado no procesable");
        }
        PdfQaNovaReports.addWebReportImage("Datos Formulario","Todos los campos del formulario completados", EstadoPrueba.PASSED,false);
    }
    public void clickBtnEnviar(){
        btnEnviar.click();
    }

}