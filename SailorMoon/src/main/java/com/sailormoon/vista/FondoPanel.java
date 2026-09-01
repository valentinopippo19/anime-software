package com.sailormoon.vista;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class FondoPanel extends JPanel {

    private Image imagen;

    public FondoPanel(String ruta) {

        URL location = getClass().getResource(ruta);

        if (location == null) {
            throw new RuntimeException(
                "NO SE ENCONTRÓ LA IMAGEN: " + ruta
            );
        }

        imagen = new ImageIcon(location).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (imagen != null) {

            g.drawImage(
                imagen,
                0,
                0,
                getWidth(),
                getHeight(),
                this
            );
        }
    }
}