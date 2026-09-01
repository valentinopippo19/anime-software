import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        Jugador jugador = new Jugador("Valentino");


        Personaje kafka = new Personaje(
        "Kafka","Rayo","Nihilidad",
        80,5000,1200);


        Personaje acheron = new Personaje(
        "Acheron","Rayo","Nihilidad",
        80,5500,1500);


        Personaje jingliu = new Personaje(
        "Jingliu","Hielo","Destruccion",
        80,5200,1300);


        Personaje blade = new Personaje(
        "Blade","Viento","Destruccion",
        80,6000,1100);



        ArrayList<Personaje> disponibles = new ArrayList<>();

        disponibles.add(kafka);
        disponibles.add(acheron);
        disponibles.add(jingliu);
        disponibles.add(blade);



        String[] imagenes =
        {
            "kafka.jpg",
            "acheron.jpg",
            "aqua.jpg",
            "blade.jpg"
        };


        ArrayList<Personaje> equipoSeleccionado =
        new ArrayList<>();


        int[] turnoActual = {0};



        Enemigo enemigo =
        new Enemigo("Cocolia");



        JFrame ventana =
        new JFrame("Honkai Star Rail RPG");


        ventana.setSize(1200,750);

        ventana.setDefaultCloseOperation(
        JFrame.EXIT_ON_CLOSE);

        ventana.setLocationRelativeTo(null);



        JPanel fondo = new JPanel(){


            Image imagen =
            new ImageIcon("Sparkle.jpg").getImage();



            protected void paintComponent(Graphics g){

                super.paintComponent(g);


                g.drawImage(
                imagen,
                0,
                0,
                getWidth(),
                getHeight(),
                this);

            }

        };


        fondo.setLayout(
        new BorderLayout());



        JLabel titulo =
        new JLabel(
        "HONKAI STAR RAIL RPG",
        SwingConstants.CENTER);


        titulo.setForeground(Color.WHITE);

        titulo.setFont(
        new Font("Serif",
        Font.BOLD,40));


        fondo.add(
        titulo,
        BorderLayout.NORTH);



        JTextArea consola =
        new JTextArea();


        consola.setEditable(false);

        consola.setOpaque(false);

        consola.setForeground(Color.WHITE);

        consola.setFont(
        new Font("Consolas",
        Font.BOLD,16));


        consola.append(
        "Jugador: Valentino\n\n");

        consola.append(
        "Selecciona tus personajes\n");



        JScrollPane scroll =
        new JScrollPane(consola);


        scroll.setOpaque(false);

        scroll.getViewport()
        .setOpaque(false);


        fondo.add(
        scroll,
        BorderLayout.CENTER);



        JPanel panelPersonajes =
        new JPanel();


        panelPersonajes.setOpaque(false);

        panelPersonajes.setLayout(
        new GridLayout(4,1,10,10));




        for(int i=0;i<disponibles.size();i++){


            Personaje p =
            disponibles.get(i);



            JButton boton =
            new JButton();

            File carpeta = new File("imagenes");

            for(String archivo : carpeta.list()){
                System.out.println(archivo);
            }



            ImageIcon icono =
            new ImageIcon(
            System.getProperty("user.dir") + "/imagenes/" + imagenes[i]
            );

            System.out.println(
            System.getProperty("user.dir") + "/imagenes/" + imagenes[i]
            );
            System.out.println(icono.getIconWidth());



            Image img =
            icono.getImage()
            .getScaledInstance(
            130,
            130,
            Image.SCALE_SMOOTH);



            boton.setIcon(
            new ImageIcon(img));



            boton.setText(
            "<html><center>"
            +p.getNombre()
            +"<br>"
            +p.getElemento()
            +"<br>"
            +p.getCamino()
            +"</center></html>");



            boton.setHorizontalTextPosition(
            SwingConstants.CENTER);


            boton.setVerticalTextPosition(
            SwingConstants.BOTTOM);


            boton.setForeground(
            Color.WHITE);


            boton.setOpaque(false);

            boton.setContentAreaFilled(false);

            boton.setBorder(
            BorderFactory.createLineBorder(
            Color.WHITE));



            boton.addActionListener(e->{


                if(!equipoSeleccionado.contains(p)
                && equipoSeleccionado.size()<4){


                    equipoSeleccionado.add(p);


                    consola.append(
                    "\n "
                    +p.getNombre()
                    +" seleccionado");


                }


            });


            panelPersonajes.add(boton);


        }



        fondo.add(
        panelPersonajes,
        BorderLayout.WEST);




        JPanel comandos =
        new JPanel();


        comandos.setOpaque(false);



        JButton iniciar =
        new JButton("BATALLA");


        JButton atacar =
        new JButton(" ATAQUE");


        JButton mostrar =
        new JButton(" ESTADISTICAS");


        JButton limpiar =
        new JButton(" LIMPIAR");



        comandos.add(iniciar);
        comandos.add(atacar);
        comandos.add(mostrar);
        comandos.add(limpiar);



        fondo.add(
        comandos,
        BorderLayout.SOUTH);




        iniciar.addActionListener(e->{


            if(equipoSeleccionado.isEmpty()){

                consola.append(
                "\n No hay personajes");

                return;
            }



            Equipo equipo =
            new Equipo("Equipo Principal");


            for(Personaje p:
            equipoSeleccionado){

                equipo.agregarIntegrante(p);

            }


            jugador.seleccionarEquipo(equipo);



            consola.append(
            "\n\n HONKAI STAR RAIL RPG \n");


            consola.append(
            " Vida Cocolia: "
            +enemigo.getVida()
            +"\n");


        });




        atacar.addActionListener(e->{



            if(equipoSeleccionado.isEmpty()){

                consola.append(
                "\n No hay personajes");

                return;

            }



            Personaje actual =
            equipoSeleccionado.get(
            turnoActual[0]);



            consola.append(
            "\n====================\n");



            consola.append(
            actual.atacar(enemigo));



            consola.append(
            " Vida Cocolia: "
            +enemigo.getVida()
            +"\n");



            if(enemigo.estaDerrotado()){


                consola.append(
                "\n VICTORIA");

                return;

            }



            consola.append(
            enemigo.atacar(actual));


            consola.append(
            "\n "
            +actual.getNombre()
            +" Vida: "
            +actual.getVida()
            +"\n");



            turnoActual[0]++;


            if(turnoActual[0]>=equipoSeleccionado.size()){

                turnoActual[0]=0;

            }


        });




        mostrar.addActionListener(e->{


            consola.append(
            "\n===== EQUIPO =====\n");


            for(Personaje p:
            equipoSeleccionado){


                consola.append(
                p.mostrarEstadisticas());


            }


            consola.append(
            " Cocolia Vida: "
            +enemigo.getVida()
            +"\n");


        });




        limpiar.addActionListener(e->{


            consola.setText("");


        });




        ventana.add(fondo);

        ventana.setVisible(true);

    }

}