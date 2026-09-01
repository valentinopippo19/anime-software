package interfaz;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.net.URL;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controlador.ControladorSimulacion;

public class VentanaPrincipal extends JFrame {

    private JTextArea consola;

    private final Color BLANCO =
            new Color(255, 255, 255);

    private final Color GRIS_CLARO =
            new Color(235, 235, 240);

    private final Color ROSA =
            new Color(235, 105, 155);

    private final Color ROSA_CLARO =
            new Color(255, 170, 200);


    public VentanaPrincipal() {

        setTitle(
                "Seishun Buta Yarou - Sistema"
        );

        setSize(
                1100,
                750
        );

        setMinimumSize(
                new Dimension(
                        900,
                        600
                )
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        crearInterfaz();
    }


    // =========================================================
    // CREAR INTERFAZ
    // =========================================================

    private void crearInterfaz() {

        JPanel panelPrincipal =
                new JPanel() {

                    private Image imagenFondo;

                    {
                        cargarImagen();
                    }


                    private void cargarImagen() {

                        /*
                         * Busca la imagen dentro de resources.
                         *
                         * Si resources está dentro de src:
                         *
                         * src/
                         * ├── resources/
                         * │   └── mai.jpg
                         *
                         * se utiliza:
                         *
                         * /resources/mai.jpg
                         */

                        try {

                            URL url =
                                    VentanaPrincipal.class
                                            .getClassLoader()
                                            .getResource(
                                                    "resources/mai.jpg"
                                            );

                            if (url != null) {

                                imagenFondo =
                                        new ImageIcon(
                                                url
                                        ).getImage();

                                return;
                            }

                        } catch (Exception e) {

                            // Se intenta la ruta externa.
                        }


                        /*
                         * Segunda opción:
                         * buscar resources/mai.jpg
                         * desde la carpeta del proyecto.
                         */

                        ImageIcon icono =
                                new ImageIcon(
                                        "resources/mai.jpg"
                                );


                        if (icono.getIconWidth() > 0) {

                            imagenFondo =
                                    icono.getImage();

                        } else {

                            System.err.println(
                                    "ERROR: No se encontró "
                                    + "resources/mai.jpg"
                            );
                        }
                    }


                    @Override
                    protected void paintComponent(
                            Graphics g) {

                        super.paintComponent(g);

                        Graphics2D g2 =
                                (Graphics2D) g.create();


                        g2.setRenderingHint(
                                RenderingHints.KEY_INTERPOLATION,
                                RenderingHints.VALUE_INTERPOLATION_BILINEAR
                        );

                        g2.setRenderingHint(
                                RenderingHints.KEY_RENDERING,
                                RenderingHints.VALUE_RENDER_QUALITY
                        );


                        /*
                         * =================================================
                         * IMAGEN DE FONDO
                         * =================================================
                         */

                        if (imagenFondo != null) {

                            g2.drawImage(
                                    imagenFondo,
                                    0,
                                    0,
                                    getWidth(),
                                    getHeight(),
                                    this
                            );
                        }


                        /*
                         * Capa oscura transparente.
                         */

                        g2.setComposite(
                                AlphaComposite.getInstance(
                                        AlphaComposite.SRC_OVER,
                                        0.18f
                                )
                        );

                        g2.setColor(
                                new Color(
                                        10,
                                        10,
                                        20
                                )
                        );

                        g2.fillRect(
                                0,
                                0,
                                getWidth(),
                                getHeight()
                        );


                        g2.dispose();
                    }
                };


        panelPrincipal.setLayout(
                new BorderLayout()
        );

        panelPrincipal.setOpaque(false);


        // =========================================================
        // ENCABEZADO
        // =========================================================

        JPanel encabezado =
                new JPanel();

        encabezado.setOpaque(false);

        encabezado.setLayout(
                new BoxLayout(
                        encabezado,
                        BoxLayout.Y_AXIS
                )
        );

        encabezado.setBorder(
                new EmptyBorder(
                        25,
                        40,
                        15,
                        40
                )
        );


        JLabel titulo =
                new JLabel(
                        "SEISHUN BUTA YAROU"
                );

        titulo.setAlignmentX(
                JLabel.CENTER_ALIGNMENT
        );

        titulo.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        32
                )
        );

        titulo.setForeground(
                BLANCO
        );


        JLabel subtitulo =
                new JLabel(
                        "Sistema de análisis del Síndrome de la Adolescencia"
                );

        subtitulo.setAlignmentX(
                JLabel.CENTER_ALIGNMENT
        );

        subtitulo.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        15
                )
        );

        subtitulo.setForeground(
                GRIS_CLARO
        );


        encabezado.add(
                titulo
        );

        encabezado.add(
                Box.createVerticalStrut(5)
        );

        encabezado.add(
                subtitulo
        );


        panelPrincipal.add(
                encabezado,
                BorderLayout.NORTH
        );


        // =========================================================
        // PANEL CENTRAL
        // =========================================================

        JPanel centro =
                new JPanel(
                        new BorderLayout()
                );

        centro.setOpaque(false);

        centro.setBorder(
                new EmptyBorder(
                        15,
                        50,
                        15,
                        50
                )
        );


        // =========================================================
        // PANEL DE CONSOLA
        // =========================================================

        JPanel panelConsola =
                new JPanel(
                        new BorderLayout()
                ) {

                    @Override
                    protected void paintComponent(
                            Graphics g) {

                        Graphics2D g2 =
                                (Graphics2D) g.create();


                        g2.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON
                        );


                        /*
                         * Fondo semitransparente.
                         */

                        g2.setColor(
                                new Color(
                                        10,
                                        10,
                                        20,
                                        90
                                )
                        );


                        g2.fillRoundRect(
                                0,
                                0,
                                getWidth() - 1,
                                getHeight() - 1,
                                25,
                                25
                        );


                        /*
                         * Borde.
                         */

                        g2.setColor(
                                new Color(
                                        255,
                                        255,
                                        255,
                                        100
                                )
                        );


                        g2.drawRoundRect(
                                0,
                                0,
                                getWidth() - 1,
                                getHeight() - 1,
                                25,
                                25
                        );


                        g2.dispose();
                    }
                };


        panelConsola.setOpaque(false);

        panelConsola.setBorder(
                BorderFactory.createEmptyBorder(
                        18,
                        22,
                        18,
                        22
                )
        );


        // =========================================================
        // TITULO DE LA CONSOLA
        // =========================================================

        JLabel tituloConsola =
                new JLabel(
                        "REGISTRO DEL SISTEMA"
                );

        tituloConsola.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        tituloConsola.setForeground(
                ROSA_CLARO
        );

        tituloConsola.setBorder(
                new EmptyBorder(
                        0,
                        0,
                        10,
                        0
                )
        );


        panelConsola.add(
                tituloConsola,
                BorderLayout.NORTH
        );


        // =========================================================
        // AREA DE TEXTO
        // =========================================================

        consola =
                new JTextArea();

        consola.setEditable(false);

        consola.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        16
                )
        );

        consola.setForeground(
                Color.WHITE
        );

        consola.setOpaque(false);

        consola.setLineWrap(true);

        consola.setWrapStyleWord(true);

        consola.setMargin(
                new java.awt.Insets(
                        10,
                        12,
                        10,
                        12
                )
        );


        // =========================================================
        // SCROLL
        // =========================================================

        JScrollPane scroll =
                new JScrollPane(
                        consola
                );

        scroll.setOpaque(false);

        scroll.getViewport()
                .setOpaque(false);

        scroll.setBackground(
                new Color(
                        0,
                        0,
                        0,
                        0
                )
        );

        scroll.setBorder(
                BorderFactory.createEmptyBorder()
        );


        panelConsola.add(
                scroll,
                BorderLayout.CENTER
        );


        centro.add(
                panelConsola,
                BorderLayout.CENTER
        );


        panelPrincipal.add(
                centro,
                BorderLayout.CENTER
        );


        // =========================================================
        // BOTONES
        // =========================================================

        JPanel panelBotones =
                new JPanel();

        panelBotones.setOpaque(false);

        panelBotones.setBorder(
                new EmptyBorder(
                        10,
                        0,
                        25,
                        0
                )
        );


        JButton ejecutar =
                crearBoton(
                        "Ejecutar simulación",
                        ROSA
                );


        ejecutar.setPreferredSize(
                new Dimension(
                        220,
                        48
                )
        );


        ejecutar.addActionListener(
                e -> ejecutarPrograma()
        );


        JButton limpiar =
                crearBoton(
                        "Limpiar",
                        new Color(
                                90,
                                90,
                                105
                        )
                );


        limpiar.setPreferredSize(
                new Dimension(
                        140,
                        48
                )
        );


        limpiar.addActionListener(
                e -> consola.setText("")
        );


        panelBotones.add(
                ejecutar
        );


        panelBotones.add(
                Box.createHorizontalStrut(
                        15
                )
        );


        panelBotones.add(
                limpiar
        );


        panelPrincipal.add(
                panelBotones,
                BorderLayout.SOUTH
        );


        add(
                panelPrincipal
        );
    }


    // =========================================================
    // CREAR BOTON
    // =========================================================

    private JButton crearBoton(
            String texto,
            Color color) {

        JButton boton =
                new JButton(
                        texto
                );


        boton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );


        boton.setForeground(
                Color.WHITE
        );


        boton.setBackground(
                color
        );


        boton.setFocusPainted(
                false
        );


        boton.setBorderPainted(
                false
        );


        boton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );


        boton.setBorder(
                new EmptyBorder(
                        10,
                        20,
                        10,
                        20
                )
        );


        return boton;
    }


    // =========================================================
    // EJECUTAR SIMULACION
    // =========================================================

    private void ejecutarPrograma() {

        /*
         * Limpiar la pantalla antes de comenzar.
         */

        consola.setText("");


        /*
         * El controlador manda cada mensaje
         * directamente a este método.
         */

        Consumer<String> mostrarEnPantalla =
                texto -> {

                    SwingUtilities.invokeLater(
                            () -> {

                                consola.append(
                                        texto
                                );


                                consola.setCaretPosition(
                                        consola.getDocument()
                                                .getLength()
                                );
                            }
                    );
                };


        /*
         * Ejecutar en otro hilo para que
         * la interfaz no se congele.
         */

        Thread hilo =
                new Thread(
                        () -> {

                            ControladorSimulacion controlador =
                                    new ControladorSimulacion(
                                            mostrarEnPantalla
                                    );


                            controlador.ejecutarSimulacion();
                        }
                );


        hilo.start();
    }
}