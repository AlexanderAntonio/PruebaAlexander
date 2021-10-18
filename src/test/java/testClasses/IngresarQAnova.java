package testClasses;

import org.openqa.selenium.WebDriver;
import page.FormularioQAnova;
import page.MatrizQAnova;
import page.QAnova;

import java.text.ParseException;

public class IngresarQAnova {



    public IngresarQAnova ( ){


    }

    public void iniciarSesion() {
        QAnova qaNova = new QAnova();
        qaNova.validarDespliegueLogin();
        qaNova.ingresarUsuario("nvivas");
        qaNova.ingresarContra("qanova");
        qaNova.clickBtnIngresar();
    }
    public void llenarFormulario() throws InterruptedException, ParseException {
        FormularioQAnova formularioQAnova = new FormularioQAnova();
        formularioQAnova.validarDespliegueFormulario();
        formularioQAnova.llenarCampoTexto("Alexander");
        formularioQAnova.llenarCampoMail("Prueba@gmail.com");
        formularioQAnova.llenarCampoArea("Esto es una prueba");
        //formularioQAnova.clickCalendario();
        //formularioQAnova.buscarFecha("15/Agosto/2023");//  (dd/mmmm/yyyy) ej: (23/Agosto/2022)
        formularioQAnova.seleccionarFecha("2023-05-16");
        formularioQAnova.llenarLista("valor 3");
        formularioQAnova.clickSeleccionMultiple("2;3");
        formularioQAnova.clickRadio(2);
        //formularioQAnova.clickBtnEnviar();

    }
    public void Filtrar(){
        MatrizQAnova matrizQAnova = new MatrizQAnova();
        matrizQAnova.validarDespliegueMatriz();
        matrizQAnova.llenarCampoFiltro("Alexander");
        matrizQAnova.clickBtnFiltrar();
    }


}
