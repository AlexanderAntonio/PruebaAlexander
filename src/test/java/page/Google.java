package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {

    @FindBy(xpath = "(//input[@class= 'gLFyf gsfi'])")
    private WebElement inputBuscar;

    @FindBy(xpath = "(//input[@value= 'Buscar con Google'])[2]")
    private WebElement btnBuscar;

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    public Google(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait = new WebDriverWait(webDriver, 30);
    }

    public void validarDespliegue(){
        webDriverWait.until(ExpectedConditions.visibilityOf(inputBuscar));
    }

    public void ingresarBusqueda(String animal) {
        inputBuscar.sendKeys(animal);
        System.out.println("Buscamos un '" + animal + "'");
    }

    public void clickBtnBuscar() {
        inputBuscar.sendKeys(Keys.ESCAPE);
        webDriverWait.until(ExpectedConditions.visibilityOf(btnBuscar));
        btnBuscar.click();
    }
}

