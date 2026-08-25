import java.util.ArrayList;


public class Jugador {


    private String nombre;

    private String idJugador;

    private int nivelCuenta;


    private ArrayList<Personaje> personajes;

    private Equipo equipoActual;






    public Jugador(String nombre){


        this.nombre = nombre;

        this.idJugador = "001";

        this.nivelCuenta = 1;


        personajes = new ArrayList<>();

    }








    public void agregarPersonaje(Personaje personaje){


        personajes.add(personaje);


    }








    public void seleccionarEquipo(Equipo equipo){


        equipoActual = equipo;


    }









    public String mostrarPerfil(){



        String mensaje = "";



        mensaje +=
        "===== PERFIL DEL JUGADOR =====\n";



        mensaje +=
        " Nombre: "
        + nombre
        + "\n";



        mensaje +=
        "ID: "
        + idJugador
        + "\n";



        mensaje +=
        " Nivel de cuenta: "
        + nivelCuenta
        + "\n";



        return mensaje;


    }










    public String getNombre(){


        return nombre;


    }






    public String getIdJugador(){


        return idJugador;


    }







    public int getNivelCuenta(){


        return nivelCuenta;


    }







    public Equipo getEquipoActual(){


        return equipoActual;


    }









    public String mostrarEquipoActual(){



        if(equipoActual != null){



            return equipoActual.mostrarEquipo();


        }else{


            return
            " No hay equipo seleccionado\n";


        }


    }


}