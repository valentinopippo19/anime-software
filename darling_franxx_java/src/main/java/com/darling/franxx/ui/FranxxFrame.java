package com.darling.franxx.ui;

import com.darling.franxx.model.Franxx;
import com.darling.franxx.model.Klaxosaurio;
import com.darling.franxx.service.FranxxService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FranxxFrame extends JFrame {

    private final FranxxService service = new FranxxService();

    private final DefaultListModel<Franxx> listModel =
            new DefaultListModel<>();

    private final JList<Franxx> franxxList =
            new JList<>(listModel);

    private final JTextArea details =
            new JTextArea();

    private final JComboBox<String> strategyBox =
            new JComboBox<>(
                    new String[]{
                            "Ataque",
                            "Defensa",
                            "Patrulla",
                            "Retirada"
                    }
            );

    private final JComboBox<String> factoryBox =
            new JComboBox<>(
                    new String[]{
                            "STRELIZIA",
                            "DELPHINIUM",
                            "ARGENTEA",
                            "GENISTA",
                            "CHLOROPHYTUM"
                    }
            );

    private final JLabel status =
            new JLabel("Sistema listo.");

    public FranxxFrame() {

        setTitle("APE — Sistema de Gestión de FRANXX");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1100, 700);

        setLocationRelativeTo(null);


        // =====================================================
        // FONDO PRINCIPAL
        // =====================================================

        BackgroundPanel root = new BackgroundPanel();

        root.setLayout(new BorderLayout(10, 10));

        root.setBorder(
                new EmptyBorder(15, 15, 15, 15)
        );

        root.setOpaque(false);


        // =====================================================
        // TÍTULO
        // =====================================================

        JLabel title = new JLabel(
                "SISTEMA DE GESTIÓN DE FRANXX",
                SwingConstants.CENTER
        );

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        28
                )
        );

        title.setForeground(Color.WHITE);

        title.setOpaque(false);

        root.add(
                title,
                BorderLayout.NORTH
        );


        // =====================================================
        // LISTA DE FRANXX
        // =====================================================

        for (Franxx f : service.getFranxxList()) {
            listModel.addElement(f);
        }

        franxxList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        franxxList.addListSelectionListener(
                e -> mostrarSeleccionado()
        );

        franxxList.setOpaque(false);

        franxxList.setForeground(Color.WHITE);

        franxxList.setBackground(
                new Color(0, 0, 0, 0)
        );

        franxxList.setSelectionBackground(
                new Color(255, 255, 255, 70)
        );

        franxxList.setSelectionForeground(
                Color.WHITE
        );


        // =====================================================
        // SCROLL DE LA LISTA
        // =====================================================

        JScrollPane left =
                new JScrollPane(franxxList);

        left.setPreferredSize(
                new Dimension(280, 0)
        );

        left.setOpaque(false);

        left.getViewport().setOpaque(false);

        left.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255, 255, 255, 90),
                        1
                )
        );


        // =====================================================
        // DETALLES
        // =====================================================

        details.setEditable(false);

        details.setFont(
                new Font(
                        Font.MONOSPACED,
                        Font.PLAIN,
                        14
                )
        );

        details.setForeground(Color.WHITE);

        details.setCaretColor(Color.WHITE);

        details.setOpaque(false);

        details.setLineWrap(false);


        // =====================================================
        // SCROLL DE DETALLES
        // =====================================================

        JScrollPane center =
                new JScrollPane(details);

        center.setOpaque(false);

        center.getViewport().setOpaque(false);

        center.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255, 255, 255, 90),
                        1
                )
        );


        // =====================================================
        // PANEL DE CONTROLES
        // =====================================================

        JPanel controls =
                new JPanel(
                        new GridLayout(
                                0,
                                1,
                                6,
                                6
                        )
                );

        controls.setOpaque(false);


        // =====================================================
        // BOTONES
        // =====================================================

        JButton create =
                crearBoton(
                        "Crear FRANXX (Factory)"
                );

        JButton strategy =
                crearBoton(
                        "Cambiar estrategia (Strategy)"
                );

        JButton mission =
                crearBoton(
                        "Iniciar misión (State)"
                );

        JButton attack =
                crearBoton(
                        "Atacar Klaxosaurio"
                );

        JButton damage =
                crearBoton(
                        "Simular daño"
                );

        JButton repair =
                crearBoton(
                        "Reparar"
                );

        JButton events =
                crearBoton(
                        "Ver eventos (Observer)"
                );


        // =====================================================
        // EVENTOS
        // =====================================================

        create.addActionListener(
                e -> crearFranxx()
        );

        strategy.addActionListener(
                e -> cambiarEstrategia()
        );

        mission.addActionListener(
                e -> iniciarMision()
        );

        attack.addActionListener(
                e -> atacar()
        );

        damage.addActionListener(
                e -> daniar()
        );

        repair.addActionListener(
                e -> reparar()
        );

        events.addActionListener(
                e -> mostrarEventos()
        );


        // =====================================================
        // ETIQUETAS
        // =====================================================

        JLabel crearLabel =
                crearEtiqueta("CREAR MODELO");

        JLabel estrategiaLabel =
                crearEtiqueta("ESTRATEGIA");

        controls.add(crearLabel);

        controls.add(factoryBox);

        controls.add(create);

        controls.add(estrategiaLabel);

        controls.add(strategyBox);

        controls.add(strategy);

        controls.add(mission);

        controls.add(attack);

        controls.add(damage);

        controls.add(repair);

        controls.add(events);


        // =====================================================
        // COMBOBOX TRANSPARENTES
        // =====================================================

        factoryBox.setOpaque(false);

        strategyBox.setOpaque(false);

        factoryBox.setForeground(Color.WHITE);

        strategyBox.setForeground(Color.WHITE);


        // =====================================================
        // PANEL DERECHO
        // =====================================================

        JPanel right =
                new JPanel(
                        new BorderLayout(
                                5,
                                5
                        )
                );

        right.setOpaque(false);

        right.setPreferredSize(
                new Dimension(260, 0)
        );


        JLabel operations =
                crearEtiqueta(
                        "OPERACIONES"
                );

        operations.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        right.add(
                operations,
                BorderLayout.NORTH
        );

        right.add(
                controls,
                BorderLayout.CENTER
        );


        // =====================================================
        // SPLIT PRINCIPAL
        // =====================================================

        JSplitPane split =
                new JSplitPane(
                        JSplitPane.HORIZONTAL_SPLIT,
                        left,
                        center
                );

        split.setResizeWeight(0.30);

        split.setOpaque(false);

        split.setDividerSize(8);

        split.setBorder(null);


        // =====================================================
        // PANEL INFERIOR
        // =====================================================

        JPanel bottom =
                new JPanel(
                        new BorderLayout()
                );

        bottom.setOpaque(false);


        status.setForeground(Color.WHITE);

        status.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );


        JLabel patterns =
                crearEtiqueta(
                        "POO + Factory + Strategy + State + Observer"
                );

        patterns.setHorizontalAlignment(
                SwingConstants.RIGHT
        );


        bottom.add(
                status,
                BorderLayout.WEST
        );

        bottom.add(
                patterns,
                BorderLayout.EAST
        );


        // =====================================================
        // ARMAR INTERFAZ
        // =====================================================

        root.add(
                split,
                BorderLayout.CENTER
        );

        root.add(
                right,
                BorderLayout.EAST
        );

        root.add(
                bottom,
                BorderLayout.SOUTH
        );


        setContentPane(root);


        // =====================================================
        // SELECCIÓN INICIAL
        // =====================================================

        if (!listModel.isEmpty()) {

            franxxList.setSelectedIndex(0);

        }
    }


    // =========================================================
    // CREAR BOTÓN
    // =========================================================

    private JButton crearBoton(String texto) {

        JButton boton =
                new JButton(texto);

        boton.setOpaque(false);

        boton.setContentAreaFilled(false);

        boton.setForeground(Color.WHITE);

        boton.setFocusPainted(false);

        boton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(255, 255, 255, 100)
                        ),
                        BorderFactory.createEmptyBorder(
                                8,
                                5,
                                8,
                                5
                        )
                )
        );

        return boton;
    }


    // =========================================================
    // CREAR ETIQUETA
    // =========================================================

    private JLabel crearEtiqueta(String texto) {

        JLabel label =
                new JLabel(texto);

        label.setForeground(Color.WHITE);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        label.setOpaque(false);

        return label;
    }


    // =========================================================
    // FRANXX SELECCIONADO
    // =========================================================

    private Franxx seleccionado() {

        Franxx f =
                franxxList.getSelectedValue();

        if (f == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un FRANXX."
            );
        }

        return f;
    }


    // =========================================================
    // ACTUALIZAR LISTA
    // =========================================================

    private void actualizarLista() {

        Franxx selected =
                franxxList.getSelectedValue();

        listModel.clear();

        for (Franxx f :
                service.getFranxxList()) {

            listModel.addElement(f);
        }

        if (selected != null) {

            franxxList.setSelectedValue(
                    selected,
                    true
            );
        }

        mostrarSeleccionado();
    }


    // =========================================================
    // MOSTRAR INFORMACIÓN
    // =========================================================

    private void mostrarSeleccionado() {

        Franxx f =
                franxxList.getSelectedValue();

        if (f == null) return;

        StringBuilder sb =
                new StringBuilder();

        sb.append(
                "MODELO: "
        ).append(
                f.getModelo()
        ).append("\n");

        sb.append(
                "ID: "
        ).append(
                f.getId()
        ).append("\n");

        sb.append(
                "NOMBRE: "
        ).append(
                f.getNombre()
        ).append("\n");

        sb.append(
                "ENERGÍA: "
        ).append(
                f.getNivelEnergia()
        ).append("\n");

        sb.append(
                "ESTADO: "
        ).append(
                f.getEstado().getNombre()
        ).append("\n");

        sb.append(
                "ESTRATEGIA: "
        ).append(
                f.getEstrategia().getNombre()
        ).append("\n");

        sb.append(
                "HABILIDAD: "
        ).append(
                f.getHabilidadEspecial()
        ).append("\n");

        sb.append(
                "ARMA: "
        ).append(
                f.getArmaPrincipal()
        ).append("\n");

        sb.append(
                "\nPILOTOS:\n"
        );

        if (f.getPilotos().isEmpty()) {

            sb.append(
                    "- Sin pilotos asignados\n"
            );

        } else {

            f.getPilotos().forEach(
                    p -> sb.append("- ")
                            .append(p)
                            .append("\n")
            );
        }

        details.setText(
                sb.toString()
        );
    }


    // =========================================================
    // FACTORY
    // =========================================================

    private void crearFranxx() {

        try {

            Franxx f =
                    service.crearFranxx(
                            (String)
                                    factoryBox
                                            .getSelectedItem()
                    );

            actualizarLista();

            franxxList.setSelectedValue(
                    f,
                    true
            );

            status.setText(
                    "Creado: "
                            + f.getModelo()
                            + " mediante Factory."
            );

        } catch (Exception ex) {

            error(ex);
        }
    }


    // =========================================================
    // STRATEGY
    // =========================================================

    private void cambiarEstrategia() {

        Franxx f =
                seleccionado();

        if (f == null) return;

        try {

            service.cambiarEstrategia(
                    f,
                    (String)
                            strategyBox
                                    .getSelectedItem()
            );

            actualizarLista();

            status.setText(
                    "Strategy cambiada a "
                            + f.getEstrategia()
                            .getNombre()
            );

        } catch (Exception ex) {

            error(ex);
        }
    }


    // =========================================================
    // STATE - MISIÓN
    // =========================================================

    private void iniciarMision() {

        Franxx f =
                seleccionado();

        if (f == null) return;

        try {

            service.iniciarMision(
                    f,
                    "Klaxosaurio objetivo"
            );

            actualizarLista();

            status.setText(
                    "Misión iniciada."
            );

        } catch (Exception ex) {

            error(ex);
        }
    }


    // =========================================================
    // ATAQUE
    // =========================================================

    private void atacar() {

        Franxx f =
                seleccionado();

        if (f == null) return;

        try {

            Klaxosaurio k =
                    new Klaxosaurio(
                            1,
                            "Conrad",
                            8,
                            35
                    );

            service.atacar(
                    f,
                    k
            );

            actualizarLista();

            JOptionPane.showMessageDialog(
                    this,
                    "Resultado del ataque:\n"
                            + k,
                    "Combate",
                    JOptionPane.INFORMATION_MESSAGE
            );

            status.setText(
                    "Ataque ejecutado."
            );

        } catch (Exception ex) {

            error(ex);
        }
    }


    // =========================================================
    // DAÑO
    // =========================================================

    private void daniar() {

        Franxx f =
                seleccionado();

        if (f == null) return;

        try {

            service.daniar(
                    f,
                    85
            );

            actualizarLista();

            status.setText(
                    "Daño aplicado. Observer notificado."
            );

        } catch (Exception ex) {

            error(ex);
        }
    }


    // =========================================================
    // REPARAR
    // =========================================================

    private void reparar() {

        Franxx f =
                seleccionado();

        if (f == null) return;

        try {

            service.reparar(
                    f
            );

            actualizarLista();

            status.setText(
                    "Proceso de reparación ejecutado."
            );

        } catch (Exception ex) {

            error(ex);
        }
    }


    // =========================================================
    // OBSERVER
    // =========================================================

    private void mostrarEventos() {

        JTextArea area =
                new JTextArea(
                        service.getEventos(),
                        20,
                        70
                );

        area.setEditable(false);

        area.setLineWrap(true);

        area.setWrapStyleWord(true);

        area.setForeground(Color.WHITE);

        area.setBackground(
                new Color(10, 10, 20, 220)
        );

        JOptionPane.showMessageDialog(
                this,
                new JScrollPane(area),
                "Eventos Observer",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // =========================================================
    // ERROR
    // =========================================================

    private void error(Exception ex) {

        JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Operación no permitida",
                JOptionPane.WARNING_MESSAGE
        );

        status.setText(
                "Operación no permitida."
        );
    }
}