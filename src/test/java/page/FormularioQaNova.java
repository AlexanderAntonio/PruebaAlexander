package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Validaciones;

import javax.sound.midi.SysexMessage;
import java.text.ParseException;


public class FormularioQaNova {

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
    @FindBy(xpath = "//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]")
    private WebElement btnMatriz;
    @FindBy(xpath = "//*[@id=\"imMnMnNode5\"]/a/span/span/span[2]")
    private WebElement btnDescarga;

    @FindBy(xpath = "//*[@id=\"imContent\"]")
    private WebElement textoCompleto;

    @FindBy(xpath = "//*[@id=\"imPgTitle\"]")
    private WebElement lblTitulo;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_1\"]")
    private WebElement lblDescripcion;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_2_label\"]/span")
    private WebElement lbl1;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_3_label\"]/span")
    private WebElement lbl2;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_4_label\"]/span")
    private WebElement lbl3;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_5_label\"]/span")
    private WebElement lbl4;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_6_label\"]/span")
    private WebElement lbl5;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_label\"]/span")
    private WebElement lblSeleccionMultiple;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_wrapper\"]/span[1]/span")
    private WebElement lblCheck1;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_wrapper\"]/span[3]/span")
    private WebElement lblCheck2;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_wrapper\"]/span[2]/span")
    private WebElement lblCheck3;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_label\"]/span")
    private WebElement lblTextoRadio;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_wrapper\"]/span[1]/span")
    private WebElement lblRadio1;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_wrapper\"]/span[3]/span")
    private WebElement lblRadio2;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_wrapper\"]/span[2]/span")
    private WebElement lblRadio3;



    WebDriverWait webDriverWait;

    public FormularioQaNova( ) {
        PageFactory.initElements(DriverContext.getDriver(), this);
        webDriverWait = new WebDriverWait(DriverContext.getDriver(), 30);
    }

    public void validarDespliegueFormulario(){
        Validaciones.validarObjeto(inputTexto, "Input Texto");
        Validaciones.validarObjeto(inputMail, "Input Mail");
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

    public void seleccionarFecha(String fecha) throws ParseException {
        calendario.click();
        Validaciones.validarFecha(btnAtrasCalendario,btnAdelanteCalendario,fecha);
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

    public void validarTitulo(String texto){
        Validaciones.validarTexto(lblTitulo,texto);

    }
    public void valdairDescrpcion(String texto){
        Validaciones.validarTexto(lblDescripcion,texto);
    }
    public void validarCincoPrimerosLbl(String lbls){
        String[] parts = lbls.split("-");
        String texto1 = parts[0]; //lbl1
        String texto2 = parts[1]; //lbl2
        String texto3 = parts[2]; //lbl3
        String texto4 = parts[3]; //lbl4
        String texto5 = parts[4]; //lbl5

        Validaciones.validarTexto(lbl1,texto1);
        Validaciones.validarTexto(lbl2,texto2);
        Validaciones.validarTexto(lbl3,texto3);
        Validaciones.validarTexto(lbl4,texto4);
        Validaciones.validarTexto(lbl5,texto5);

    }
    public void validarTextoSeleccionMultiple(String lblSeleccion){
        String[] parts = lblSeleccion.split("-");
        String texto1 = parts[0]; //lbl Seleccion multiple
        String texto2 = parts[1]; //lbl check 1
        String texto3 = parts[2]; //lbl check 2
        String texto4 = parts[3]; //lbl check 3

        Validaciones.validarTexto(lblSeleccionMultiple,texto1);
        Validaciones.validarTexto(lblCheck1,texto2);
        Validaciones.validarTexto(lblCheck2,texto3);
        Validaciones.validarTexto(lblCheck3,texto4);
    }

    public void validarTextoRadioButton(String lblRadio){
        String[] parts = lblRadio.split("-");
        String texto1 = parts[0]; //lbl radio button
        String texto2 = parts[1]; //lbl radio 1
        String texto3 = parts[2]; //lbl radio 2
        String texto4 = parts[3]; //lbl radio 3

        String[] parts1 = textoCompleto.getText().split(" ");
        for (int i=1; i==parts1.length; i++){
            String texto = parts1[0];
            System.out.println(texto);
        }
        Validaciones.validarTexto(lblTextoRadio,texto1);
        Validaciones.validarTexto(lblRadio1,texto2);
        Validaciones.validarTexto(lblRadio2,texto3);
        Validaciones.validarTexto(lblRadio3,texto4);




    }



    //--------------------------------------------------------------------------------------------------------//


    /*public void clickCalendario() throws InterruptedException {
        calendario.click();
        btnAtrasCalendario.click();
        Thread.sleep(2000);
    }*/

    /*public void buscarFecha(String fecha){
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
    }*/

}