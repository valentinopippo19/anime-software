public class Habilidad {


    private String nombre;

    private String tipo;

    private int daño;

    private int costoEnergia;




    public Habilidad(
    String nombre,
    String tipo,
    int daño,
    int costoEnergia){


        this.nombre = nombre;

        this.tipo = tipo;

        this.daño = daño;

        this.costoEnergia = costoEnergia;

    }







    public String ejecutar(
    Personaje personaje,
    Enemigo enemigo){



        String mensaje = "";



        mensaje +=
        " "
        + personaje.getNombre()
        + " usa "
        + nombre
        + "\n";



        mensaje +=
        "Tipo: "
        + tipo
        + "\n";



        mensaje +=
        " Energía utilizada: "
        + costoEnergia
        + "\n";




        mensaje +=
        enemigo.recibirDanio(daño);



        return mensaje;

    }







    public String getNombre(){

        return nombre;

    }





    public String getTipo(){

        return tipo;

    }





    public int getDaño(){

        return daño;

    }





    public int getCostoEnergia(){

        return costoEnergia;

    }

}