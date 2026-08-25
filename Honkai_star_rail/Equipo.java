import java.util.ArrayList;


public class Equipo {


    private String nombreEquipo;

    private ArrayList<Personaje> integrantes;




    public Equipo(String nombre){


        nombreEquipo = nombre;

        integrantes = new ArrayList<>();

    }





    public void agregarIntegrante(Personaje personaje){


        integrantes.add(personaje);

    }






    public ArrayList<Personaje> getIntegrantes(){


        return integrantes;

    }







    public Personaje obtenerPersonaje(){


        if(integrantes.size() > 0){

            return integrantes.get(0);

        }


        return null;

    }








    public String mostrarEquipo(){


        String mensaje = "";



        mensaje +=
        "===== "
        + nombreEquipo
        + " =====\n";




        for(Personaje personaje : integrantes){



            mensaje +=
            " "
            + personaje.getNombre()
            + "\n";


            mensaje +=
            "Nivel: "
            + personaje.getNivel()
            + "\n";


            mensaje +=
            "Elemento: "
            + personaje.getElemento()
            + "\n";


            mensaje +=
            "Camino: "
            + personaje.getCamino()
            + "\n\n";


        }




        return mensaje;

    }




    public String getNombreEquipo(){


        return nombreEquipo;

    }

}