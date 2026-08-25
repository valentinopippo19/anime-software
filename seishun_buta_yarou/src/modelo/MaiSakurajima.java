package modelo;

public class MaiSakurajima extends Estudiante {

    private final String profesion;
    private boolean esVisible;

    public MaiSakurajima(
            int id,
            String nombre,
            int edad,
            String curso,
            String escuela,
            String profesion) {

        super(id, nombre, edad, curso, escuela);
        this.profesion = profesion;
        this.esVisible = true;
    }

    public String desaparecerSocialmente() {
        esVisible = false;

        return getNombre() +
                " ha desaparecido de la percepción social.";
    }

    public String serReconocida() {
        esVisible = true;

        return getNombre() +
                " vuelve a ser reconocida.";
    }

    public String getProfesion() {
        return profesion;
    }

    public boolean esVisible() {
        return esVisible;
    }
}