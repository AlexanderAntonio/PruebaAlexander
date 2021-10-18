package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;

public class MatrizQAnova {

    @FindBy(id = "pluginAppObj_4_01_filter_field")
    private WebElement inputFltrar;

    @FindBy(id = "pluginAppObj_4_01_filter_button")
    private WebElement btnFiltrar;


    WebDriverWait webDriverWait;

    public MatrizQAnova( ) {

        PageFactory.initElements(DriverContext.getDriver(), this);
        webDriverWait = new WebDriverWait(DriverContext.getDriver(), 30);
    }

    public void validarDespliegueMatriz(){
        webDriverWait.until(ExpectedConditions.visibilityOf(inputFltrar));
        webDriverWait.until(ExpectedConditions.visibilityOf(btnFiltrar));
    }
    public void llenarCampoFiltro(String filtro) {
        inputFltrar.sendKeys(filtro);
    }
    public void clickBtnFiltrar(){
        btnFiltrar.click();
    }
}
