package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Busqueda {

    @FindBy(xpath = "(//h3[@class= 'LC20lb DKV0Md'])")
    private WebElement enlace;

    @FindBy(xpath = "(//a[@href= 'https://es.wikipedia.org/wiki/Canis_familiaris'])")
    private WebElement urlBusqueda;

    WebDriver webDriver;

    public Busqueda(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void extraerTexto(){
        System.out.println("El texto es '" + enlace.getText()+"'");
    }
    public void clickEnlace() {
        enlace.click();
        System.out.println("La URL es '" + webDriver.getCurrentUrl()+"'");
    }

}
