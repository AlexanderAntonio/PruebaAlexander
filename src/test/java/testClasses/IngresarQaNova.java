package testClasses;

import page.*;

import java.text.ParseException;

public class IngresarQaNova {

    public IngresarQaNova( ){

    }

    public void iniciarSesion(String usuario, String clave) {
        QAnova qaNova = new QAnova();
        qaNova.validarDespliegueLogin();
        qaNova.ingresarUsuario(usuario);
        qaNova.ingresarContra(clave);
        qaNova.clickBtnIngresar();
    }
    public void llenarFormulario() throws ParseException {
        FormularioQaNova formularioQAnova = new FormularioQaNova();
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
    public void validacionDeTextos(){
        FormularioQaNova formularioQAnova = new FormularioQaNova();
        formularioQAnova.validarDespliegueFormulario();
        formularioQAnova.validarTitulo("Carga de informaci\u00f3n");
        formularioQAnova.valdairDescrpcion("Se generan todas las posibilidades con el fin de poder automatizar la mayor parte del script en etapa de desarrollo");
        formularioQAnova.validarCincoPrimerosLbl("Campo Texto-campo mail-Campo Area de Texto-Campo Fecha-Campo Lista"); //Separar con "-"
        formularioQAnova.validarTextoSeleccionMultiple("Campo Selecci\u00f3n M\u00FAltiple- selecci\u00f3n 1- selecci\u00f3n 2- selecci\u00f3n 3"); //Separar con "-"
        formularioQAnova.validarTextoRadioButton("Combo Radio Button-cr 1-cr 2-cr 3"); //Separar con "-"
    }



    public void filtrar() throws InterruptedException {
        MatrizQaNova matrizQAnova = new MatrizQaNova();
        FormularioQaNova formularioQAnova = new FormularioQaNova();
        formularioQAnova.validarDespliegueFormulario();
        matrizQAnova.abrirMatriz();
        matrizQAnova.validarDespliegueMatriz();
        matrizQAnova.recuperarDatosConFiltro("Alexander");
        //matrizQAnova.recuperarDatos(4);//id=1 ,Campo_Texto=2, Campo_Mail=3, Campo_Area_de_Texto=4, Campo_Fecha=5, Campo_Lista=6, Campo_Seleccion_Multiple=7, Compo_Radio_Button=8

    }

    public void descarga(String rutaDescarga) throws InterruptedException {
        FormularioQaNova formularioQAnova = new FormularioQaNova();
        DescargaQaNova descargaQaNova = new DescargaQaNova();
        formularioQAnova.validarDespliegueFormulario();
        descargaQaNova.irADescarga();
        descargaQaNova.validarDespliegueDescarga();
        descargaQaNova.descargarArchivo("link",rutaDescarga); // boton-link-imagen
    }

    public void carga(String rutaCarga) throws InterruptedException {
        FormularioQaNova formularioQAnova = new FormularioQaNova();
        CargaQaNova cargaQaNova = new CargaQaNova();
        formularioQAnova.validarDespliegueFormulario();
        cargaQaNova.irACarga();
        cargaQaNova.validarDespliegueCarga();
        cargaQaNova.subirArchivo(rutaCarga,"descarga_link.pdf");
    }


}
