package investigador;

import modelo.FenomenoAdolescencia;

public interface InvestigadorFenomenos {

    void investigar(
            FenomenoAdolescencia fenomeno
    );

    String obtenerDiagnostico();
}