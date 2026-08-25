package com.sailormoon.vista;

import com.sailormoon.modelo.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;

public class VentanaPrincipal extends JFrame {

    private JTextArea areaTexto;

    public VentanaPrincipal() {

        setTitle("Sailor Moon - Sistema de Misiones");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        FondoPanel fondo =
                new FondoPanel("/images/sailor-moon-fondo.jpg");

        fondo.setLayout(new BorderLayout(20, 20));

        // =====================================================
        // ENCABEZADO
        // =====================================================

        JPanel encabezado = new JPanel();
        encabezado.setOpaque(false);
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("SAILOR MOON");
        titulo.setFont(new Font("Serif", Font.BOLD, 38));
        titulo.setForeground(Color.WHITE);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel(
                "Sistema de gestión de Sailor Scouts y Misiones"
        );
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        encabezado.add(titulo);
        encabezado.add(Box.createVerticalStrut(5));
        encabezado.add(subtitulo);

        fondo.add(encabezado, BorderLayout.NORTH);

        // =====================================================
        // AREA DE INFORMACION
        // =====================================================

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setOpaque(false);
        areaTexto.setForeground(Color.WHITE);
        areaTexto.setFont(new Font("Consolas", Font.PLAIN, 16));
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);

        areaTexto.setBorder(
                new EmptyBorder(20, 30, 20, 30)
        );

        JScrollPane scroll =
                new JScrollPane(areaTexto);

        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255, 255, 255, 120),
                        1
                )
        );

        fondo.add(scroll, BorderLayout.CENTER);

        // =====================================================
        // BOTON
        // =====================================================

        JButton boton =
                new JButton("✦ MOSTRAR INFORMACIÓN ✦");

        boton.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        boton.setForeground(Color.WHITE);
        boton.setBackground(
                new Color(100, 50, 150)
        );

        boton.setFocusPainted(false);
        boton.setBorder(
                BorderFactory.createEmptyBorder(
                        12, 30, 12, 30
                )
        );

        boton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        boton.addActionListener(e ->
                cargarDatos()
        );

        JPanel panelBoton = new JPanel();
        panelBoton.setOpaque(false);
        panelBoton.add(boton);

        fondo.add(panelBoton, BorderLayout.SOUTH);

        setContentPane(fondo);
    }

    private void cargarDatos() {

        // =====================================================
        // DATOS
        // =====================================================

        Planeta tierra =
                new Planeta(
                        1,
                        "Tierra"
                );

        Rango eternal =
                new Rango(
                        1,
                        "Eternal Guardian"
                );

        Equipo inner =
                new Equipo(
                        1,
                        "Inner Scouts",
                        "Guardianes del Sistema Solar Interior"
                );

        Ataque moonTiara =
                new Ataque(
                        1,
                        "Moon Tiara Action",
                        "Ataque de energía lunar",
                        80
                );

        Enemigo enemigo =
                new Enemigo(
                        1,
                        "Queen Beryl",
                        "Reina Oscura",
                        10
                );

        SailorScout sailorMoon =
                new SailorScout(
                        1,
                        "Usagi Tsukino",
                        "Sailor Moon",
                        "sailor-moon.png",
                        tierra,
                        inner,
                        eternal
                );

        sailorMoon.aprenderAtaque(
                moonTiara
        );

        Mision mision =
                new Mision(
                        1,
                        "Batalla contra el Reino Oscuro",
                        "Derrotar a las fuerzas del Reino Oscuro.",
                        LocalDate.now()
                );

        mision.agregarEnemigo(
                enemigo
        );

        sailorMoon.participarEnMision(
                mision
        );

        mision.finalizar(
                sailorMoon
        );

        // =====================================================
        // CONSTRUCCION DEL TEXTO
        // =====================================================

        StringBuilder texto =
                new StringBuilder();

        texto.append(
                "\n"
        );

        texto.append(
                "╔══════════════════════════════════════════════════╗\n"
        );

        texto.append(
                "║              SAILOR SCOUT                       ║\n"
        );

        texto.append(
                "╚══════════════════════════════════════════════════╝\n\n"
        );

        texto.append(
                "  Nombre civil : "
        );
        texto.append(
                sailorMoon.getNombreCivil()
        );
        texto.append("\n");

        texto.append(
                "  Nickname     : "
        );
        texto.append(
                sailorMoon.getNickname()
        );
        texto.append("\n");

        texto.append(
                "  Planeta      : "
        );
        texto.append(
                sailorMoon.getPlaneta()
        );
        texto.append("\n");

        texto.append(
                "  Equipo       : "
        );
        texto.append(
                sailorMoon.getEquipoActual()
        );
        texto.append("\n");

        texto.append(
                "  Rango        : "
        );
        texto.append(
                sailorMoon.getRangoActual()
        );
        texto.append("\n");

        texto.append(
                "  Estado       : "
        );

        texto.append(
                sailorMoon.isActiva()
                        ? "ACTIVA"
                        : "INACTIVA"
        );

        texto.append("\n\n");

        // =====================================================
        // ATAQUES
        // =====================================================

        texto.append(
                "╔══════════════════════════════════════════════════╗\n"
        );

        texto.append(
                "║                  ATAQUES                         ║\n"
        );

        texto.append(
                "╚══════════════════════════════════════════════════╝\n\n"
        );

        for (Ataque ataque :
                sailorMoon.getAtaques()) {

            texto.append(
                    "  ★ "
            );

            texto.append(
                    ataque.getNombre()
            );

            texto.append(
                    "\n     Poder: "
            );

            texto.append(
                    ataque.getNivelPoder()
            );

            texto.append(
                    "\n     Descripción: "
            );

            texto.append(
                    ataque.getDescripcion()
            );

            texto.append(
                    "\n\n"
            );
        }

        // =====================================================
        // MISION
        // =====================================================

        texto.append(
                "╔══════════════════════════════════════════════════╗\n"
        );

        texto.append(
                "║                  MISIÓN                          ║\n"
        );

        texto.append(
                "╚══════════════════════════════════════════════════╝\n\n"
        );

        texto.append(
                "  Nombre : "
        );

        texto.append(
                mision.getNombre()
        );

        texto.append("\n");

        texto.append(
                "  Estado : "
        );

        texto.append(
                mision.getEstado()
        );

        texto.append("\n\n");

        texto.append(
                "  Enemigos:\n\n"
        );

        for (Enemigo e :
                mision.getEnemigos()) {

            texto.append(
                    "    ☠ "
            );

            texto.append(
                    e.getNombre()
            );

            texto.append(
                    "\n       Tipo: "
            );

            texto.append(
                    e.getTipo()
            );

            texto.append(
                    "\n       Nivel de peligrosidad: "
            );

            texto.append(
                    e.getNivelPeligrosidad()
            );

            texto.append("\n\n");
        }

        texto.append(
                "  Derrotado por: "
        );

        if (mision.getSailorQueDerroto() != null) {

            texto.append(
                    mision
                            .getSailorQueDerroto()
                            .getNickname()
            );
        }

        texto.append("\n");

        texto.append(
                "\n══════════════════════════════════════════════════\n"
        );

        texto.append(
                "        SISTEMA SAILOR MOON - ACTIVO\n"
        );

        texto.append(
                "══════════════════════════════════════════════════\n"
        );

        areaTexto.setText(
                texto.toString()
        );

        // Volver automáticamente al principio
        areaTexto.setCaretPosition(0);
    }
}