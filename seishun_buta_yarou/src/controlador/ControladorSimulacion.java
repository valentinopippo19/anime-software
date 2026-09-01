package controlador;

import java.time.LocalDate;
import java.util.function.Consumer;

import investigador.InvestigadorFenomenos;
import investigador.InvestigadorSakuta;
import modelo.BucleTemporal;
import modelo.FenomenoAdolescencia;
import modelo.InvisibilidadSocial;
import modelo.MaiSakurajima;
import modelo.Relacion;
import modelo.SakutaAzusagawa;
import modelo.TipoRelacion;

public class ControladorSimulacion {

    private final Consumer<String> salida;

    public ControladorSimulacion(
            Consumer<String> salida) {

        this.salida = salida;
    }


    private void mostrar(String texto) {

        salida.accept(
                texto + System.lineSeparator()
        );
    }


    public void ejecutarSimulacion() {

        // =====================================================
        // CREACIÓN DE PERSONAJES
        // =====================================================

        SakutaAzusagawa sakuta =
                new SakutaAzusagawa(
                        1,
                        "Sakuta Azusagawa",
                        17,
                        "Segundo año",
                        "Minegahara High School"
                );


        MaiSakurajima mai =
                new MaiSakurajima(
                        2,
                        "Mai Sakurajima",
                        17,
                        "Segundo año",
                        "Minegahara High School",
                        "Actriz"
                );


        // =====================================================
        // ENCABEZADO
        // =====================================================

        mostrar("====================================");
        mostrar("       SEISHUN BUTA YAROU");
        mostrar("      SISTEMA DE INVESTIGACIÓN");
        mostrar("====================================");
        mostrar("");


        // =====================================================
        // PERSONAJES
        // =====================================================

        mostrar("PERSONAJES REGISTRADOS");

        mostrar(
                "Sakuta: "
                + sakuta.getNombre()
        );

        mostrar(
                "Mai: "
                + mai.getNombre()
        );

        mostrar("");


        // =====================================================
        // DETECCIÓN
        // =====================================================

        mostrar("DETECCIÓN DE FENÓMENO");

        mostrar(
                "Detectando anomalías..."
        );


        FenomenoAdolescencia fenomeno =
                new InvisibilidadSocial(20);


        mostrar(
                sakuta.getNombre()
                + " está observando un fenómeno."
        );


        mostrar(
                sakuta.getNombre()
                + " está investigando el fenómeno."
        );


        fenomeno.iniciar();


        mostrar(
                "Se inició el fenómeno de invisibilidad social."
        );


        // =====================================================
        // INVESTIGACIÓN
        // =====================================================

        mostrar("");

        mostrar("INVESTIGACIÓN");


        InvestigadorFenomenos investigador =
                new InvestigadorSakuta();


        mostrar(
                "Sakuta está investigando el fenómeno..."
        );


        investigador.investigar(
                fenomeno
        );


        mostrar("Diagnóstico:");


        mostrar(
                investigador.obtenerDiagnostico()
        );


        // =====================================================
        // RESOLUCIÓN
        // =====================================================

        mostrar("");

        mostrar("RESOLUCIÓN");


        mostrar(
                "Intentando resolver el fenómeno..."
        );


        fenomeno.resolver();


        mostrar(
                "El fenómeno de invisibilidad social "
                + "fue resuelto."
        );


        // =====================================================
        // BUCLE TEMPORAL
        // =====================================================

        mostrar("");

        mostrar("NUEVO FENÓMENO");


        FenomenoAdolescencia bucle =
                new BucleTemporal(
                        LocalDate.of(
                                2026,
                                8,
                                18
                        ),
                        LocalDate.of(
                                2026,
                                8,
                                19
                        )
                );


        bucle.iniciar();


        mostrar(
                "Se inició el fenómeno de bucle temporal."
        );


        mostrar(
                "Bucle activo: "
                + bucle.estaActivo()
        );


        bucle.resolver();


        mostrar(
                "El bucle temporal fue resuelto."
        );


        // =====================================================
        // RELACIÓN
        // =====================================================

        mostrar("");

        mostrar("ANÁLISIS DE RELACIÓN");


        Relacion relacion =
                new Relacion(
                        TipoRelacion.ROMANTICA,
                        10
                );


        mostrar(
                relacion.describir()
        );


        // =====================================================
        // FINAL
        // =====================================================

        mostrar("");

        mostrar("====================================");

        mostrar(
                "       SIMULACIÓN FINALIZADA"
        );

        mostrar("====================================");
    }
}