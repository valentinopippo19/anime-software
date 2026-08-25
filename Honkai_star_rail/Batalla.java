public class Batalla {


    private Equipo equipo;

    private Enemigo enemigo;



    public Batalla(Equipo equipo, Enemigo enemigo){

        this.equipo = equipo;
        this.enemigo = enemigo;

    }




    public String iniciar(){


        String resultado = "";



        resultado += " COMIENZA LA BATALLA ⚔\n\n";



        Personaje personaje =
        equipo.obtenerPersonaje();




        if(personaje != null){


            resultado +=
            " "
            + personaje.getNombre()
            + " ataca a "
            + enemigo.getNombre()
            + "\n";



            personaje.atacar(enemigo);



            resultado +=
            "Daño realizado al enemigo\n\n";


        }else{


            resultado +=
            " No hay personajes en el equipo\n";


        }






        if(enemigo.estaDerrotado()){


            resultado +=
            " VICTORIA\n";


        }else{


            resultado +=
            " El enemigo sigue vivo\n";


        }




        return resultado;

    }

}