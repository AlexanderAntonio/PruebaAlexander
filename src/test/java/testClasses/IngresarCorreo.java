package testClasses;

import page.CargaQaNova;
import page.Correo;
import page.FormularioQaNova;

import java.awt.*;

public class IngresarCorreo {

    public IngresarCorreo(){

    }

    public void iniciarGmail(String correoGmail, String contraGmail) throws InterruptedException {
        Correo correo = new Correo();
        correo.validarDespliegueLogin();
        correo.ingresarUsuario(correoGmail);
        correo.validarDesplieguecontra();
        correo.ingresarContra(contraGmail);
    }

    public void adjuntarArchivoGmail() throws AWTException, InterruptedException {
        Correo correo = new Correo();
        correo.validarDespliegueGmail();
        correo.clickBtnRedactar();
        correo.redactarCorreo("validarFarmacia - Passed.pdf","testqanova314@gmail.com","Test");
        correo.validarCorreoEnviado();
    }
}
