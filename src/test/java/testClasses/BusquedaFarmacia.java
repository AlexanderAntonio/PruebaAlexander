package testClasses;


import org.json.simple.parser.ParseException;
import page.GoogleMap;

import java.io.IOException;

public class BusquedaFarmacia {

    public BusquedaFarmacia( ){

    }

    public void ValidarBusquedaMapa() throws IOException, InterruptedException {
        GoogleMap googleMap = new GoogleMap();
        googleMap.buscarEnMapa();

    }
}
