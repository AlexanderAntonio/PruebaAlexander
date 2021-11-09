package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.CargaQaNova;
import page.MatrizQaNova;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Validaciones {

    public static void validarObjeto(WebElement webElement, String descripcionElemento){
        descripcionElemento = descripcionElemento.toLowerCase();
        WebDriverWait webDriverWait = new WebDriverWait(DriverContext.getDriver(), 30);
        String identificador;
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
            identificador = webElement.getAttribute("xpath");
            if (identificador == null){
                identificador = webElement.getAttribute("id");
            }
            System.out.println("El objeto "+ descripcionElemento+ " se ha desplegado correctamente, con el identificador: "+identificador);
            PdfQaNovaReports.addWebReportImage("Validaci\u00f3n objeto "+descripcionElemento, "El objeto "+ descripcionElemento+ " se ha desplegado correctamente", EstadoPrueba.PASSED, false);
        }catch (Exception e){
            System.out.println("El objeto "+ descripcionElemento+ " NO se ha desplegado");
            PdfQaNovaReports.addWebReportImage("Validaci\u00f3n objeto "+descripcionElemento, "El objeto "+ descripcionElemento+ " NO se ha desplegado", EstadoPrueba.FAILED, true);
        }

    }

    public static void validarTexto(WebElement  webElement, String texto) {
        String textoPagina = webElement.getText();
        if (textoPagina.equals(texto)) {
            PdfQaNovaReports.addWebReportImage("El texto esta correctamente escrito", "El texto es:'" + texto + "'", EstadoPrueba.PASSED, false);
        }else{
            String letraTextoPagina, letraTexto, comparacion = "";
            for (int i = 0; i < texto.length(); i++){
                letraTexto =  texto.substring(i, i+1);
                letraTextoPagina = textoPagina.substring(i, i+1);
                if(!letraTexto.equals(letraTextoPagina)){
                    System.out.println("El texto tiene diferencias en el caracter nro :'" + (i+1) + "' El texto web es:'"+textoPagina+"' Texto esperado:'"+texto+"'");
                    comparacion  = comparacion +"Diferencia en el caracter:'"+(i+1)+"' En el texto web es:'"+letraTextoPagina+"' Caracter esperado:'"+letraTexto+"'."+"\n";
                }
            }
            PdfQaNovaReports.addWebReportImage("Diferencia en los textos", "El texto web es:'" + textoPagina + "' texto esperado:'"+texto+"'\n"+comparacion, EstadoPrueba.FAILED, false);
        }
    }

    public static void validarFecha(WebElement webElement1, WebElement webElement2, String fecha){
        try {
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
                    webElement1.click();
                }
            }else {
                mes = (int) diferencia;
                for (int x = 0; x <= mes-1; x++){
                    webElement2.click();
                }
            }
            DriverContext.getDriver().findElement(By.xpath("//div[@id = 'imDPcal']//td[text() = '"+dia+"']")).click();
        }catch (Exception e){
            System.out.println("Fecha ingresada invalida: "+fecha);

        }
    }

    public static void valdiarDescargaPorBtn(WebElement webElement, String rutaDescarga) throws InterruptedException {

        String nombreArchivo = webElement.findElement(By.xpath("//*[@id=\"pluginAppObj_5_06\"]/a")).getAttribute("href");
        nombreArchivo = nombreArchivo.substring(nombreArchivo.lastIndexOf("/"));
        File archivo = new File(rutaDescarga+nombreArchivo);
        archivo.delete();
        webElement.click();
        Thread.sleep(3000);
        if (archivo.exists()){
            System.out.println("El archivo fue correctamente descargado");
            Thread.sleep(3000);
        }else {
            System.out.println("El archivo no existe NO fue correctamente descargado");
        }

    }
    public static void valdiarDescargaPorLink(WebElement webElement, String rutaDescarga) throws InterruptedException {

        String nombreArchivo = webElement.getAttribute("href");
        nombreArchivo = nombreArchivo.substring(nombreArchivo.lastIndexOf("/"));
        File archivo = new File(rutaDescarga+nombreArchivo);
        archivo.delete();
        webElement.click();
        Thread.sleep(3000);
        if (archivo.exists()){
            System.out.println("El archivo fue correctamente descargado");
            Thread.sleep(3000);

        }else {
            System.out.println("El archivo no existe NO fue correctamente descargado");
        }

    }
    public static void valdiarDescargaPorImg(WebElement webElement, String rutaDescarga) throws InterruptedException {

        String nombreArchivo = webElement.findElement(By.xpath("//*[@id=\"imCellStyle_4\"]/a")).getAttribute("href");
        nombreArchivo = nombreArchivo.substring(nombreArchivo.lastIndexOf("/"));
        File archivo = new File(rutaDescarga+nombreArchivo);
        archivo.delete();
        webElement.click();
        Thread.sleep(3000);
        if (archivo.exists()){
            System.out.println("El archivo fue correctamente descargado");
            Thread.sleep(3000);

        }else {
            System.out.println("El archivo no existe NO fue correctamente descargado");
        }

    }

    public static void validarMatrizPorFiltro (WebElement webElement, String filtro) throws InterruptedException {

        MatrizQaNova matrizQaNova = new MatrizQaNova();
        webElement.sendKeys(filtro);
        matrizQaNova.clickBtnFiltrar();

        int largoFila = DriverContext.getDriver().findElements(By.xpath("//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr")).size();

        List<WebElement> columna =DriverContext.getDriver().findElements(By.xpath("//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr[1]/td"));
        int largoColumna = columna.size()-2;

        List<String> fila = new ArrayList<String>();

        for (int i = 1; i <= largoFila; i++) {
            for (int j = 1; j <= largoColumna; j++) {
                String datos = DriverContext.getDriver().findElement(By.xpath("//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr[" + i + "]/td[" + j + "]")).getText() + " ";
                fila.add(datos);
                System.out.print(datos);
            }
            System.out.println("");
        }

    }

    public static void validarMatriz(int paginas) throws InterruptedException {

        MatrizQaNova matrizQaNova = new MatrizQaNova();
        int largoFila = DriverContext.getDriver().findElements(By.xpath("//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr")).size();
        List<WebElement>columna =DriverContext.getDriver().findElements(By.xpath("//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr[1]/td"));
        int largoColumna = columna.size()-2;

        List<String> fila = new ArrayList<String>();

        for (int x = 1; x <= paginas; x++) {
            int num = x-1;
            if (num != paginas) {
                int nunPag = num+1;
                System.out.println("--------------------------- Pagina: "+nunPag+" --------------------------- ");
                for (int i = 1; i <= largoFila; i++) {
                    for (int j = 1; j <= largoColumna; j++) {
                        String datos = DriverContext.getDriver().findElement(By.xpath("//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr[" + i + "]/td[" + j + "]")).getText() + " ";
                        fila.add(datos);
                        System.out.print(datos);
                    }
                    System.out.println(" ");
                }

                matrizQaNova.clickBtnAdelante();
            } else {
                break;
            }
        }
        System.out.println("-----------------------------------------------------------------");
    }

    public static void validarCargaArchivo(WebElement webElement, String ruta, String archivo){
        CargaQaNova cargaQaNova = new CargaQaNova();
        File rutaArchivo = new File(ruta+archivo);
        if (rutaArchivo.exists()){
            webElement.sendKeys(ruta+archivo);
            cargaQaNova.clickEnviarArchivo();
            System.out.println("Archivo cargado correctamente");
        }else {
            System.out.println("El archivo no se pudo cargar correctamente");
        }
    }
}
