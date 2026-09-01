import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Main extends JFrame {

    private Viajero viajero;
    private Guia guia;
    private Expedicion expedicion;

    private JLabel lblSaldo;
    private JTextArea areaInformacion;

    private JTextField txtOrigen;
    private JTextField txtDestino;
    private JTextField txtRecarga;

    private JPanel panelPrincipal;

    public Main() {

        crearDatos();

        configurarVentana();

        crearInterfaz();
    }

    // ==========================================
    // CREACIÓN DE DATOS
    // ==========================================

    private void crearDatos() {

        viajero = new Viajero(
                1,
                "Aether",
                "aether@teyvat.com",
                "1234"
        );

        Vehiculo vehiculo = new Vehiculo(
                "TEY-001",
                "15/08/2027",
                "Electro",
                "Raiden Shogun"
        );

        guia = new Guia(
                2,
                "Zhongli",
                "zhongli@teyvat.com",
                "1234",
                "LIC-001",
                vehiculo
        );

        // Mora inicial
        viajero.getMonedero().recargar(5000);
    }

    // ==========================================
    // CONFIGURACIÓN DE VENTANA
    // ==========================================

    private void configurarVentana() {

        setTitle("Teyvat Travel - Genshin Impact");

        setSize(1100, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
    }

    // ==========================================
    // INTERFAZ
    // ==========================================

    private void crearInterfaz() {

        panelPrincipal = new BackgroundPanel();

        panelPrincipal.setLayout(new BorderLayout());

        // --------------------------------------
        // TÍTULO
        // --------------------------------------

        JLabel titulo = new JLabel(
                "✦ TEYVAT TRAVEL ✦",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font("Serif", Font.BOLD, 38)
        );

        titulo.setForeground(Color.WHITE);

        titulo.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        10,
                        20,
                        10
                )
        );

        panelPrincipal.add(
                titulo,
                BorderLayout.NORTH
        );

        // --------------------------------------
        // PANEL CENTRAL
        // --------------------------------------

        JPanel panelCentral = new JPanel();

        panelCentral.setOpaque(false);

        panelCentral.setLayout(
                new GridLayout(1, 2, 20, 0)
        );

        // ======================================
        // INFORMACIÓN DEL USUARIO
        // ======================================

        JPanel panelUsuario = crearPanelTransparente();

        panelUsuario.setLayout(
                new BoxLayout(
                        panelUsuario,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel usuarioTitulo = new JLabel(
                "✦ VIAJERO ✦"
        );

        usuarioTitulo.setFont(
                new Font("Serif", Font.BOLD, 25)
        );

        usuarioTitulo.setForeground(Color.WHITE);

        usuarioTitulo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panelUsuario.add(usuarioTitulo);

        panelUsuario.add(
                Box.createVerticalStrut(20)
        );

        JLabel nombre = new JLabel(
                "Nombre: " + viajero.getNombre()
        );

        nombre.setForeground(Color.WHITE);

        nombre.setFont(
                new Font("Arial", Font.BOLD, 17)
        );

        nombre.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panelUsuario.add(nombre);

        panelUsuario.add(
                Box.createVerticalStrut(10)
        );

        JLabel email = new JLabel(
                "Email: " + viajero.getEmail()
        );

        email.setForeground(Color.WHITE);

        email.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panelUsuario.add(email);

        panelUsuario.add(
                Box.createVerticalStrut(20)
        );

        lblSaldo = new JLabel(
                "Mora: " +
                        String.format(
                                "%.2f",
                                viajero
                                        .getMonedero()
                                        .consultarSaldo()
                        )
        );

        lblSaldo.setForeground(Color.YELLOW);

        lblSaldo.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        lblSaldo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panelUsuario.add(lblSaldo);

        panelUsuario.add(
                Box.createVerticalStrut(20)
        );

        // Recarga

        JLabel recargaLabel = new JLabel(
                "Cantidad de Mora:"
        );

        recargaLabel.setForeground(Color.WHITE);

        recargaLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panelUsuario.add(recargaLabel);

        txtRecarga = new JTextField();

        txtRecarga.setMaximumSize(
                new Dimension(250, 35)
        );

        panelUsuario.add(txtRecarga);

        panelUsuario.add(
                Box.createVerticalStrut(10)
        );

        JButton btnRecargar = crearBoton(
                "RECARGAR MORA"
        );

        btnRecargar.addActionListener(
                e -> recargarMora()
        );

        panelUsuario.add(btnRecargar);

        panelCentral.add(panelUsuario);

        // ======================================
        // SOLICITUD DE EXPEDICIÓN
        // ======================================

        JPanel panelExpedicion =
                crearPanelTransparente();

        panelExpedicion.setLayout(
                new BoxLayout(
                        panelExpedicion,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel expTitulo = new JLabel(
                "✦ SOLICITAR EXPEDICIÓN ✦"
        );

        expTitulo.setFont(
                new Font("Serif", Font.BOLD, 25)
        );

        expTitulo.setForeground(Color.WHITE);

        expTitulo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panelExpedicion.add(expTitulo);

        panelExpedicion.add(
                Box.createVerticalStrut(20)
        );

        JLabel origenLabel =
                new JLabel("Origen:");

        origenLabel.setForeground(Color.WHITE);

        origenLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panelExpedicion.add(origenLabel);

        txtOrigen = new JTextField();

        txtOrigen.setMaximumSize(
                new Dimension(300, 35)
        );

        panelExpedicion.add(txtOrigen);

        panelExpedicion.add(
                Box.createVerticalStrut(10)
        );

        JLabel destinoLabel =
                new JLabel("Destino:");

        destinoLabel.setForeground(Color.WHITE);

        destinoLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panelExpedicion.add(destinoLabel);

        txtDestino = new JTextField();

        txtDestino.setMaximumSize(
                new Dimension(300, 35)
        );

        panelExpedicion.add(txtDestino);

        panelExpedicion.add(
                Box.createVerticalStrut(15)
        );

        JButton btnSolicitar =
                crearBoton(
                        "SOLICITAR EXPEDICIÓN"
                );

        btnSolicitar.addActionListener(
                e -> solicitarExpedicion()
        );

        panelExpedicion.add(btnSolicitar);

        panelExpedicion.add(
                Box.createVerticalStrut(10)
        );

        JButton btnAceptar =
                crearBoton(
                        "ACEPTAR POR EL GUÍA"
                );

        btnAceptar.addActionListener(
                e -> aceptarExpedicion()
        );

        panelExpedicion.add(btnAceptar);

        panelExpedicion.add(
                Box.createVerticalStrut(10)
        );

        JButton btnPagar =
                crearBoton(
                        "PAGAR EXPEDICIÓN"
                );

        btnPagar.addActionListener(
                e -> pagarExpedicion()
        );

        panelExpedicion.add(btnPagar);

        panelExpedicion.add(
                Box.createVerticalStrut(10)
        );

        JButton btnFinalizar =
                crearBoton(
                        "FINALIZAR EXPEDICIÓN"
                );

        btnFinalizar.addActionListener(
                e -> finalizarExpedicion()
        );

        panelExpedicion.add(btnFinalizar);

        panelCentral.add(panelExpedicion);

        panelPrincipal.add(
                panelCentral,
                BorderLayout.CENTER
        );

        // ======================================
        // INFORMACIÓN INFERIOR
        // ======================================

        areaInformacion = new JTextArea();

        areaInformacion.setEditable(false);

        areaInformacion.setFont(
                new Font("Monospaced", Font.PLAIN, 14)
        );

        areaInformacion.setForeground(Color.WHITE);

        areaInformacion.setBackground(
                new Color(0, 0, 0, 170)
        );

        areaInformacion.setText(
                "=== TEYVAT TRAVEL ===\n\n" +
                "Guía disponible: " +
                guia.getNombre() + "\n" +
                "Vehículo: " +
                guia.getVehiculo() + "\n\n" +
                "Esperando una expedición..."
        );

        JScrollPane scroll =
                new JScrollPane(areaInformacion);

        scroll.setPreferredSize(
                new Dimension(1000, 150)
        );

        panelPrincipal.add(
                scroll,
                BorderLayout.SOUTH
        );

        setContentPane(panelPrincipal);
    }

    // ==========================================
    // RECARGAR MORA
    // ==========================================

    private void recargarMora() {

        try {

            double cantidad = Double.parseDouble(
                    txtRecarga.getText()
            );

            if (cantidad <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "La cantidad debe ser mayor que 0."
                );

                return;
            }

            // Seleccionar método de pago
            String[] opciones = {
                    "PayPal",
                    "Tarjeta de Crédito"
            };

            String metodo = (String) JOptionPane.showInputDialog(
                    this,
                    "Seleccione el método de pago:",
                    "Recargar Mora",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            // Si el usuario cancela
            if (metodo == null) {
                return;
            }

            // Variable de tipo Pago.
            // Puede almacenar PayPal o TarjetaCredito.
            Pago pago;

            if (metodo.equals("PayPal")) {

                pago = new PayPal(
                        1,
                        cantidad,
                        viajero.getEmail()
                );

            } else {

                pago = new TarjetaCredito(
                        2,
                        cantidad,
                        "4509-1234-5678-9012",
                        viajero.getNombre(),
                        "12/30"
                );
            }

            // Procesar el pago
            if (pago.procesarPago()) {

                // Agregar Mora al monedero
                viajero
                        .getMonedero()
                        .recargar(cantidad);

                actualizarSaldo();

                // Mostrar información
                areaInformacion.setText(
                        "=== RECARGA EXITOSA ===\n\n" +
                        "Método: " + metodo + "\n" +
                        "Cantidad: " +
                        String.format(
                                "%.2f",
                                cantidad
                        ) +
                        " Mora\n\n" +
                        "Nuevo saldo: " +
                        String.format(
                                "%.2f",
                                viajero
                                        .getMonedero()
                                        .consultarSaldo()
                        )
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese un número válido."
            );
        }
    }


    // ==========================================
    // SOLICITAR EXPEDICIÓN
    // ==========================================

    private void solicitarExpedicion() {

        String origen =
                txtOrigen.getText().trim();

        String destino =
                txtDestino.getText().trim();

        if (origen.isEmpty() ||
                destino.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese origen y destino."
            );

            return;
        }

        expedicion =
                viajero.solicitarExpedicion(
                        origen,
                        destino
                );

        expedicion.setViajero(viajero);

        areaInformacion.setText(
                "=== NUEVA EXPEDICIÓN ===\n\n" +
                "ID: " +
                expedicion.getId() + "\n" +
                "Viajero: " +
                viajero.getNombre() + "\n" +
                "Origen: " +
                expedicion.getOrigen() + "\n" +
                "Destino: " +
                expedicion.getDestino() + "\n" +
                "Distancia: " +
                String.format(
                        "%.2f km",
                        expedicion.getDistancia()
                ) +
                "\n" +
                "Precio: " +
                String.format(
                        "%.2f Mora",
                        expedicion.getPrecio()
                ) +
                "\n" +
                "Estado: " +
                expedicion.getEstado() +
                "\n\n" +
                "Esperando respuesta de " +
                guia.getNombre() + "..."
        );
    }

    // ==========================================
    // ACEPTAR EXPEDICIÓN
    // ==========================================

    private void aceptarExpedicion() {

        if (expedicion == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Primero debe solicitar una expedición."
            );

            return;
        }

        if (guia.aceptarExpedicion(expedicion)) {

            areaInformacion.append(
                    "\n\n=== EXPEDICIÓN ACEPTADA ===\n" +
                    "Guía: " +
                    guia.getNombre() +
                    "\nVehículo: " +
                    guia.getVehiculo() +
                    "\nEstado: " +
                    expedicion.getEstado()
            );

        } else {

            areaInformacion.append(
                    "\n\nEl guía no está disponible."
            );
        }
    }

    // ==========================================
    // PAGAR
    // ==========================================

    private void pagarExpedicion() {

        if (expedicion == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "No hay ninguna expedición."
            );

            return;
        }

        if (!expedicion
                .getEstado()
                .equals("ACEPTADA")) {

            JOptionPane.showMessageDialog(
                    this,
                    "La expedición debe ser aceptada primero."
            );

            return;
        }

        double precio =
                expedicion.getPrecio();

        if (viajero.realizarPago(expedicion)) {

            double comision =
                    precio * 0.15;

            double pagoGuia =
                    precio - comision;

            guia.getMonedero()
                    .depositar(pagoGuia);

            actualizarSaldo();

            areaInformacion.append(
                    "\n\n=== PAGO REALIZADO ===\n" +
                    "Precio: " +
                    String.format(
                            "%.2f Mora",
                            precio
                    ) +
                    "\nComisión plataforma: " +
                    String.format(
                            "%.2f Mora",
                            comision
                    ) +
                    "\nPago al guía: " +
                    String.format(
                            "%.2f Mora",
                            pagoGuia
                    ) +
                    "\n\nEstado: " +
                    expedicion.getEstado()
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "No tienes suficiente Mora."
            );
        }
    }

    // ==========================================
    // FINALIZAR
    // ==========================================

    private void finalizarExpedicion() {

        if (expedicion == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "No hay una expedición activa."
            );

            return;
        }

        guia.finalizarExpedicion(
                expedicion
        );

        areaInformacion.append(
                "\n\n=== EXPEDICIÓN FINALIZADA ===\n" +
                "Gracias por viajar por Teyvat.\n" +
                "Estado: " +
                expedicion.getEstado()
        );
    }

    // ==========================================
    // ACTUALIZAR SALDO
    // ==========================================

    private void actualizarSaldo() {

        lblSaldo.setText(
                "Mora: " +
                String.format(
                        "%.2f",
                        viajero
                                .getMonedero()
                                .consultarSaldo()
                )
        );
    }

    // ==========================================
    // CREAR BOTONES
    // ==========================================

    private JButton crearBoton(String texto) {

        JButton boton =
                new JButton(texto);

        boton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        boton.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        15
                )
        );

        boton.setFocusPainted(false);

        boton.setMaximumSize(
                new Dimension(300, 40)
        );

        return boton;
    }

    // ==========================================
    // PANEL TRANSPARENTE
    // ==========================================

    private JPanel crearPanelTransparente() {

        JPanel panel =
                new JPanel();

        panel.setBackground(
                new Color(0, 0, 0, 130)
        );

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        20,
                        20,
                        20
                )
        );

        return panel;
    }

    // ==========================================
    // PANEL CON FONDO
    // ==========================================

    class BackgroundPanel extends JPanel {

        private BufferedImage imagen;

        public BackgroundPanel() {

            try {

                File archivo =
                        new File(
                                "recursos/genshin.jpg"
                        );

                if (archivo.exists()) {

                    imagen =
                            ImageIO.read(archivo);
                }

            } catch (Exception e) {

                System.out.println(
                        "No se pudo cargar el fondo."
                );
            }
        }

        @Override
        protected void paintComponent(
                Graphics g) {

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

            } else {

                // Fondo alternativo si no existe
                // la imagen.

                Graphics2D g2 =
                        (Graphics2D) g;

                GradientPaint gradiente =
                        new GradientPaint(
                                0,
                                0,
                                new Color(35, 80, 120),
                                0,
                                getHeight(),
                                new Color(80, 45, 100)
                        );

                g2.setPaint(gradiente);

                g2.fillRect(
                        0,
                        0,
                        getWidth(),
                        getHeight()
                );
            }
        }
    }

    // ==========================================
    // MAIN
    // ==========================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            Main ventana =
                    new Main();

            ventana.setVisible(true);
        });
    }
}