import java.util.ArrayList;


public class Personaje {


    private String nombre;

    private String elemento;

    private String camino;


    private int nivel;

    private int vida;

    private int vidaMaxima;

    private int ataque;


    private ArrayList<Habilidad> habilidades;





    public Personaje(
    String nombre,
    String elemento,
    String camino){


        this.nombre = nombre;

        this.elemento = elemento;

        this.camino = camino;


        nivel = 1;

        vida = 100;

        vidaMaxima = 100;

        ataque = 30;


        habilidades = new ArrayList<>();

    }








    public Personaje(
    String nombre,
    String elemento,
    String camino,
    int nivel,
    int vida,
    int ataque){



        this.nombre = nombre;

        this.elemento = elemento;

        this.camino = camino;


        this.nivel = nivel;

        this.vida = vida;

        this.vidaMaxima = vida;

        this.ataque = ataque;



        habilidades = new ArrayList<>();

    }









    // ATAQUE BASICO

    public String atacar(Enemigo enemigo){



        String resultado = "";



        resultado +=
        "⚔ "
        + nombre
        + " atacó a "
        + enemigo.getNombre()
        + "\n";



        resultado +=
        enemigo.recibirDanio(ataque);



        return resultado;


    }









    public String usarHabilidad(
    int posicion,
    Enemigo enemigo){



        if(posicion < habilidades.size()){


            return habilidades
            .get(posicion)
            .ejecutar(this, enemigo);



        }



        return
        " Habilidad inexistente\n";


    }








    public void agregarHabilidad(
    Habilidad habilidad){


        habilidades.add(habilidad);


    }








    public ArrayList<Habilidad> getHabilidades(){


        return habilidades;


    }








    public void recibirDanio(int daño){



        vida -= daño;



        if(vida < 0){

            vida = 0;

        }


    }








    public boolean estaDerrotado(){


        return vida <= 0;


    }








    public String curarse(int cantidad){


        vida += cantidad;



        if(vida > vidaMaxima){

            vida = vidaMaxima;

        }



        return
        " "
        + nombre
        + " recuperó "
        + cantidad
        + " de vida\n"
        +
        " Vida actual: "
        + vida
        + "/"
        + vidaMaxima
        + "\n";


    }









    public String mostrarEstadisticas(){



        String mensaje = "";



        mensaje +=
        "===== "
        + nombre
        + " =====\n";



        mensaje +=
        " Nivel: "
        + nivel
        + "\n";



        mensaje +=
        " Vida: "
        + vida
        + "/"
        + vidaMaxima
        + "\n";



        mensaje +=
        "⚔ Ataque: "
        + ataque
        + "\n";



        mensaje +=
        "Elemento: "
        + elemento
        + "\n";



        mensaje +=
        "Camino: "
        + camino
        + "\n\n";



        return mensaje;


    }









    public int getNivel(){

        return nivel;

    }






    public String getNombre(){

        return nombre;

    }







    public String getElemento(){

        return elemento;

    }







    public String getCamino(){

        return camino;

    }







    public int getVida(){

        return vida;

    }







    public int getVidaMaxima(){

        return vidaMaxima;

    }







    public int getAtaque(){

        return ataque;

    }








    public void subirNivel(){



        nivel++;


        vidaMaxima += 200;


        vida = vidaMaxima;


        ataque += 50;


    }



}