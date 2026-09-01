package com.darling.franxx.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class BackgroundPanel extends JPanel {

    private BufferedImage imagen;

    public BackgroundPanel() {

        try {

            InputStream input =
                    getClass().getResourceAsStream(
                            "/images/fondo-franxx.jpg"
                    );

            if (input == null) {

                throw new IOException(
                        "No se encontró la imagen de fondo."
                );
            }

            imagen = ImageIO.read(input);

        } catch (IOException e) {

            System.err.println(
                    "Error cargando fondo: "
                            + e.getMessage()
            );
        }

        setOpaque(false);

        setLayout(
                new BorderLayout()
        );
    }


    @Override
    protected void paintComponent(
            Graphics g
    ) {

        super.paintComponent(g);

        Graphics2D g2 =
                (Graphics2D) g.create();

        if (imagen != null) {

            int ancho =
                    getWidth();

            int alto =
                    getHeight();

            double escala =
                    Math.max(
                            (double) ancho
                                    / imagen.getWidth(),

                            (double) alto
                                    / imagen.getHeight()
                    );

            int nuevoAncho =
                    (int)
                            (imagen.getWidth()
                                    * escala);

            int nuevoAlto =
                    (int)
                            (imagen.getHeight()
                                    * escala);

            int x =
                    (ancho - nuevoAncho)
                            / 2;

            int y =
                    (alto - nuevoAlto)
                            / 2;


            // =================================================
            // IMAGEN
            // =================================================

            g2.drawImage(
                    imagen,
                    x,
                    y,
                    nuevoAncho,
                    nuevoAlto,
                    this
            );


            // =================================================
            // CAPA OSCURA TRANSPARENTE
            // =================================================

            g2.setColor(
                    new Color(
                            0,
                            0,
                            0,
                            85
                    )
            );

            g2.fillRect(
                    0,
                    0,
                    ancho,
                    alto
            );


            // =================================================
            // EFECTO AZULADO MUY SUTIL
            // =================================================

            g2.setColor(
                    new Color(
                            20,
                            30,
                            60,
                            35
                    )
            );

            g2.fillRect(
                    0,
                    0,
                    ancho,
                    alto
            );
        }

        g2.dispose();
    }
}