package page;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Validaciones;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.List;

public class GoogleMap {

    @FindBy(xpath = "(//*[@id=\"searchboxinput\"])")
    private WebElement inputMapa;

    @FindBy(xpath = "(//*[@id=\"searchbox-searchbutton\"])")
    private WebElement btnBuscar;


    private static HttpURLConnection connection;
    WebDriverWait webDriverWait;

    public GoogleMap( ){
        PageFactory.initElements(DriverContext.getDriver(), this);
        webDriverWait = new WebDriverWait(DriverContext.getDriver(), 30);
    }

    public void buscarEnMapa() throws IOException {
        Validaciones.validarFarmacia(inputMapa);
    }

    public void clickBtnBuscarMapa() throws InterruptedException {
        btnBuscar.click();
        Thread.sleep(3000);
    }
}





