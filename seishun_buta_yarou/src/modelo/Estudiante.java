package modelo;

public class Estudiante extends Personaje {

    private final String curso;
    private final String escuela;

    public Estudiante(
            int id,
            String nombre,
            int edad,
            String curso,
            String escuela) {

        super(id, nombre, edad);
        this.curso = curso;
        this.escuela = escuela;
    }

    public String estudiar() {
        return getNombre() + " está estudiando.";
    }

    public String asistirAClase() {
        return getNombre() + " está asistiendo a clase.";
    }

    public String getCurso() {
        return curso;
    }

    public String getEscuela() {
        return escuela;
    }
}