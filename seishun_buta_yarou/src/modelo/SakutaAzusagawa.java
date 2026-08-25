package modelo;

public class SakutaAzusagawa extends Estudiante {

    public SakutaAzusagawa(
            int id,
            String nombre,
            int edad,
            String curso,
            String escuela) {

        super(id, nombre, edad, curso, escuela);
    }

    public String observarFenomeno() {
        return getNombre() +
                " está observando un fenómeno.";
    }

    public String investigarFenomeno(
            FenomenoAdolescencia fenomeno) {

        fenomeno.iniciar();

        return getNombre() +
                " está investigando el fenómeno.";
    }

    public String ayudar(Personaje personaje) {
        return getNombre() +
                " está ayudando a " +
                personaje.getNombre() + ".";
    }
}