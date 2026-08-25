package fabrica;

import java.time.LocalDate;

import modelo.BucleTemporal;
import modelo.FenomenoAdolescencia;
import modelo.InvisibilidadSocial;

public class FabricaFenomenos {

    public FenomenoAdolescencia crearInvisibilidadSocial(
            double nivelVisibilidad) {

        return new InvisibilidadSocial(
                nivelVisibilidad
        );
    }


    public FenomenoAdolescencia crearBucleTemporal(
            LocalDate fechaInicio,
            LocalDate fechaFin) {

        return new BucleTemporal(
                fechaInicio,
                fechaFin
        );
    }
}