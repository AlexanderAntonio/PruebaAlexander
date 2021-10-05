package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google {

    @FindBy(xpath = "(//input[@class= 'gLFyf gsfi'])")
    private WebElement inputBuscar;

    @FindBy(xpath = "(//input[@value= 'Buscar con Google'])[2]")
    private WebElement btnBuscar;
    
    WebDriver webDriver;
    
    public Google(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void ingresarBusqueda(String perro) {

    }

    public void clickBtnBuscar() {
    }
}

