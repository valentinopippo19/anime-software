public class Enemigo {

    private String nombre;
    private int vida;
    private int ataque;


    public Enemigo(String nombre){

        this.nombre = nombre;
        vida = 20000;
        ataque = 800;
    }



    public String recibirDanio(int daño){

        vida -= daño;


        if(vida < 0){

            vida = 0;

        }


        return 
        " " + nombre +
        " recibió " + daño +
        " de daño\n" +
        " Vida de " + nombre +
        ": " + vida + "\n";

    }




    public String atacar(Personaje personaje){


        personaje.recibirDanio(ataque);



        return
        " " + nombre +
        " atacó a " +
        personaje.getNombre() +
        "\n Daño recibido: " +
        ataque +
        "\n Vida de " +
        personaje.getNombre() +
        ": " +
        personaje.getVida() +
        "\n";


    }




    public String getNombre(){

        return nombre;

    }



    public int getVida(){

        return vida;

    }



    public boolean estaDerrotado(){

        return vida <= 0;

    }


}