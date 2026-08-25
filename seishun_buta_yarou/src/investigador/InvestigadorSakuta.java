package investigador;

import modelo.FenomenoAdolescencia;

public class InvestigadorSakuta
        implements InvestigadorFenomenos {

    private String diagnostico;

    @Override
    public void investigar(
            FenomenoAdolescencia fenomeno) {

        if (fenomeno.estaActivo()) {
            diagnostico =
                    "El fenómeno está actualmente activo.";
        } else {
            diagnostico =
                    "El fenómeno no está activo.";
        }
    }

    @Override
    public String obtenerDiagnostico() {
        return diagnostico;
    }
}