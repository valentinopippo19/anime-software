import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/*
 * Proyecto: The Shiunji Family Children
 * Interfaz gráfica: Java Swing
 *
 * IMPORTANTE:
 * Colocá una imagen llamada "shiunji_background.jpg" en la misma carpeta
 * que este archivo. La aplicación la usará como fondo.
 *
 * No se utiliza System.out.println(): toda la información se muestra
 * dentro de la interfaz gráfica.
 */
public class Main extends JFrame {

    private final JTextArea output = new JTextArea();
    private final BackgroundPanel backgroundPanel;
    private final JLabel status = new JLabel("Listo.");

    // =========================
    // MODELO DEL DIAGRAMA
    // =========================

    static abstract class Persona {
        protected String nombre;
        protected int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        public String presentarse() {
            return "Hola, soy " + nombre + ".";
        }
    }

    static class Hermano extends Persona {
        private String personalidad;

        public Hermano(String nombre, int edad, String personalidad) {
            super(nombre, edad);
            this.personalidad = personalidad;
        }

        public String interactuar() {
            return nombre + " interactúa con la familia.";
        }

        public String getPersonalidad() {
            return personalidad;
        }
    }

    static class Arata extends Hermano {
        public Arata() {
            super("Arata Shiunji", 17, "Responsable y protector");
        }

        public String cuidarHermanos() {
            return "Arata intenta mantener unida a la familia.";
        }
    }

    static class Banri extends Hermano {
        public Banri() {
            super("Banri Shiunji", 20, "Amable y maternal");
        }

        public String estudiar() {
            return "Banri continúa con sus estudios universitarios.";
        }
    }

    static class Seiha extends Hermano {
        public Seiha() {
            super("Seiha Shiunji", 16, "Inteligente y analítica");
        }

        public String analizar() {
            return "Seiha analiza cuidadosamente la situación.";
        }
    }

    static class Ouka extends Hermano {
        public Ouka() {
            super("Ouka Shiunji", 17, "Enérgica y atlética");
        }

        public String entrenar() {
            return "Ouka realiza actividad física.";
        }
    }

    static class Minami extends Hermano {
        public Minami() {
            super("Minami Shiunji", 16, "Deportista y alegre");
        }

        public String jugarTenis() {
            return "Minami practica tenis.";
        }
    }

    static class Shion extends Hermano {
        public Shion() {
            super("Shion Shiunji", 16, "Tranquilo y consejero");
        }

        public String aconsejar() {
            return "Shion le da un consejo a Arata.";
        }
    }

    static class Kotono extends Hermano {
        public Kotono() {
            super("Kotono Shiunji", 15, "Tímida y perceptiva");
        }

        public String observar() {
            return "Kotono observa las situaciones familiares con atención.";
        }
    }

    static class Padre extends Persona {
        public Padre() {
            super("Kaname Shiunji", 45);
        }

        public String revelarSecreto() {
            return "Kaname revela un secreto importante sobre los hermanos.";
        }
    }

    static class Casa {
        private String direccion;
        private int habitaciones;

        public Casa(String direccion, int habitaciones) {
            this.direccion = direccion;
            this.habitaciones = habitaciones;
        }

        public String recibirFamilia() {
            return "La casa recibe a todos los integrantes de la familia Shiunji.";
        }

        public String getDireccion() {
            return direccion;
        }

        public int getHabitaciones() {
            return habitaciones;
        }
    }

    static class FamiliaShiunji {
        private String apellido;
        private final Persona[] miembros;
        private final Casa casa;

        public FamiliaShiunji(Persona[] miembros, Casa casa) {
            this.apellido = "Shiunji";
            this.miembros = miembros;
            this.casa = casa;
        }

        public String comunicarse() {
            return "La familia Shiunji se comunica y comparte tiempo en casa.";
        }

        public String mostrarMiembros() {
            StringBuilder sb = new StringBuilder();
            for (Persona p : miembros) {
                sb.append("• ").append(p.getNombre())
                  .append(" — ").append(p.getEdad()).append(" años\n");
            }
            return sb.toString();
        }

        public Casa getCasa() {
            return casa;
        }
    }

    static class Evento {
        private String tipo;
        private String descripcion;

        public Evento(String tipo, String descripcion) {
            this.tipo = tipo;
            this.descripcion = descripcion;
        }

        public String ocurrir() {
            return tipo + ": " + descripcion;
        }
    }

    // =========================
    // CONSTRUCCIÓN DE LA APP
    // =========================

    public Main() {
        setTitle("The Shiunji Family Children - Diagrama UML");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 760);
        setLocationRelativeTo(null);

        backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);

        construirInterfaz();
    }

    private void construirInterfaz() {
        JLabel titulo = new JLabel(
                "<html><div style='text-align:center;'>THE SHIUNJI FAMILY CHILDREN<br>" +
                "<span style='font-size:16px;'>Diagrama de Clases y Diagrama de Secuencia</span></div></html>",
                SwingConstants.CENTER
        );
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        titulo.setBorder(new EmptyBorder(18, 10, 18, 10));

        backgroundPanel.add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new BorderLayout(12, 12));
        centro.setOpaque(false);
        centro.setBorder(new EmptyBorder(10, 20, 10, 20));

        JPanel menu = crearMenu();
        centro.add(menu, BorderLayout.WEST);

        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setFont(new Font("Monospaced", Font.PLAIN, 14));
        output.setForeground(Color.WHITE);
        output.setBackground(new Color(20, 20, 35, 220));
        output.setCaretColor(Color.WHITE);
        output.setBorder(new EmptyBorder(15, 15, 15, 15));

        JScrollPane scroll = new JScrollPane(output);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 100), 1));

        centro.add(scroll, BorderLayout.CENTER);
        backgroundPanel.add(centro, BorderLayout.CENTER);

        status.setForeground(Color.WHITE);
        status.setBorder(new EmptyBorder(8, 15, 8, 15));
        backgroundPanel.add(status, BorderLayout.SOUTH);

        mostrarInicio();
    }

    private JPanel crearMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(230, 0));

        JLabel menuTitulo = new JLabel("MENÚ");
        menuTitulo.setForeground(Color.WHITE);
        menuTitulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        menuTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(menuTitulo);
        panel.add(Box.createVerticalStrut(15));

        JButton btnClases = crearBoton("Diagrama de Clases");
        btnClases.addActionListener(this::mostrarClases);

        JButton btnSecuencia = crearBoton("Diagrama de Secuencia");
        btnSecuencia.addActionListener(this::mostrarSecuencia);

        JButton btnFamilia = crearBoton("Ver Familia");
        btnFamilia.addActionListener(e -> mostrarFamilia());

        JButton btnEventos = crearBoton("Ver Eventos");
        btnEventos.addActionListener(e -> mostrarEventos());

        JButton btnImagen = crearBoton("Cambiar fondo");
        btnImagen.addActionListener(e -> cambiarFondo());

        JButton btnLimpiar = crearBoton("Limpiar pantalla");
        btnLimpiar.addActionListener(e -> output.setText(""));

        panel.add(btnClases);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnSecuencia);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnFamilia);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnEventos);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnImagen);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnLimpiar);

        return panel;
    }

    private JButton crearBoton(String texto) {
        JButton b = new JButton(texto);
        b.setMaximumSize(new Dimension(220, 45));
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setFocusPainted(false);
        b.setFont(new Font("SansSerif", Font.BOLD, 13));
        b.setForeground(Color.WHITE);
        b.setBackground(new Color(70, 80, 150, 220));
        return b;
    }

    // =========================
    // DIAGRAMA DE CLASES
    // =========================

    private void mostrarClases(ActionEvent e) {
        StringBuilder sb = new StringBuilder();

        sb.append("══════════════════════════════════════════════════════\n");
        sb.append("                 DIAGRAMA DE CLASES\n");
        sb.append("══════════════════════════════════════════════════════\n\n");

        sb.append("<<abstract>> Persona\n");
        sb.append("  - nombre : String\n");
        sb.append("  - edad : int\n");
        sb.append("  + presentarse() : String\n\n");

        sb.append("Persona <|-- Hermano\n");
        sb.append("Hermano <|-- Arata\n");
        sb.append("Hermano <|-- Banri\n");
        sb.append("Hermano <|-- Seiha\n");
        sb.append("Hermano <|-- Ouka\n");
        sb.append("Hermano <|-- Minami\n");
        sb.append("Hermano <|-- Shion\n");
        sb.append("Hermano <|-- Kotono\n");
        sb.append("Persona <|-- Padre\n\n");

        sb.append("ARATA SHIUNJI\n");
        sb.append("  + cuidarHermanos() : String\n\n");

        sb.append("BANRI SHIUNJI\n");
        sb.append("  + estudiar() : String\n\n");

        sb.append("SEIHA SHIUNJI\n");
        sb.append("  + analizar() : String\n\n");

        sb.append("OUKA SHIUNJI\n");
        sb.append("  + entrenar() : String\n\n");

        sb.append("MINAMI SHIUNJI\n");
        sb.append("  + jugarTenis() : String\n\n");

        sb.append("SHION SHIUNJI\n");
        sb.append("  + aconsejar() : String\n\n");

        sb.append("KOTONO SHIUNJI\n");
        sb.append("  + observar() : String\n\n");

        sb.append("KANAME SHIUNJI\n");
        sb.append("  + revelarSecreto() : String\n\n");

        sb.append("FAMILIA SHIUNJI\n");
        sb.append("  - apellido : String\n");
        sb.append("  - miembros : Persona[]\n");
        sb.append("  - casa : Casa\n");
        sb.append("  + comunicarse() : String\n");
        sb.append("  + mostrarMiembros() : String\n\n");

        sb.append("CASA\n");
        sb.append("  - direccion : String\n");
        sb.append("  - habitaciones : int\n");
        sb.append("  + recibirFamilia() : String\n\n");

        sb.append("EVENTO\n");
        sb.append("  - tipo : String\n");
        sb.append("  - descripcion : String\n");
        sb.append("  + ocurrir() : String\n\n");

        sb.append("RELACIONES PRINCIPALES\n");
        sb.append("• FamiliaShiunji 1 ───── 1 Casa\n");
        sb.append("• FamiliaShiunji 1 ───── 7 Persona\n");
        sb.append("• Persona <|-- Hermano (herencia)\n");
        sb.append("• Hermano <|-- cada uno de los 7 hermanos\n");
        sb.append("• FamiliaShiunji ───── Evento\n");

        output.setText(sb.toString());
        status.setText("Mostrando el modelo de clases.");
    }

    // =========================
    // DIAGRAMA DE SECUENCIA
    // =========================

    private void mostrarSecuencia(ActionEvent e) {
        output.setText("");
        status.setText("Ejecutando simulación del diagrama de secuencia...");

        String[] pasos = {
                "1. Arata entra a la casa.",
                "2. Arata: «Hola, ¿ya están todos?»",
                "3. Banri: «Sí, estamos acá.»",
                "4. Arata pregunta cómo fue el día.",
                "5. Seiha analiza la situación y responde.",
                "6. Ouka comenta sobre sus actividades.",
                "7. Minami habla sobre tenis.",
                "8. Shion aconseja a Arata.",
                "9. Kotono observa la conversación.",
                "10. Kaname reúne a la familia.",
                "11. Todos conversan en la casa.",
                "12. Evento: Familia reunida.",
                "13. Fin de la interacción."
        };

        Timer timer = new Timer(700, null);
        final int[] i = {0};

        timer.addActionListener(ev -> {
            if (i[0] < pasos.length) {
                output.append(pasos[i[0]] + "\n");
                output.append("   ↓\n");
                i[0]++;
            } else {
                timer.stop();
                status.setText("Simulación finalizada.");
            }
        });

        timer.start();
    }

    // =========================
    // FAMILIA
    // =========================

    private void mostrarFamilia() {
        Arata arata = new Arata();
        Banri banri = new Banri();
        Seiha seiha = new Seiha();
        Ouka ouka = new Ouka();
        Minami minami = new Minami();
        Shion shion = new Shion();
        Kotono kotono = new Kotono();

        Casa casa = new Casa(
                "Mansión Shiunji, Setagaya, Tokio",
                8
        );

        Persona[] miembros = {
                arata, banri, seiha, ouka, minami, shion, kotono
        };

        FamiliaShiunji familia = new FamiliaShiunji(miembros, casa);

        output.setText(
                "══════════════════════════════════════════════════════\n" +
                "                    FAMILIA SHIUNJI\n" +
                "══════════════════════════════════════════════════════\n\n" +
                "Apellido: Shiunji\n" +
                "Casa: " + casa.getDireccion() + "\n" +
                "Habitaciones: " + casa.getHabitaciones() + "\n\n" +
                "MIEMBROS:\n" +
                familia.mostrarMiembros() +
                "\n" +
                familia.comunicarse() + "\n" +
                casa.recibirFamilia()
        );

        status.setText("Información de la familia cargada.");
    }

    // =========================
    // EVENTOS
    // =========================

    private void mostrarEventos() {
        Evento[] eventos = {
                new Evento("Interacción", "Los hermanos conversan en la casa."),
                new Evento("Familia", "Todos comparten un momento juntos."),
                new Evento("Revelación", "Kaname comunica información importante."),
                new Evento("Convivencia", "Los miembros mantienen sus vínculos familiares.")
        };

        StringBuilder sb = new StringBuilder();
        sb.append("══════════════════════════════════════════════════════\n");
        sb.append("                       EVENTOS\n");
        sb.append("══════════════════════════════════════════════════════\n\n");

        for (Evento evento : eventos) {
            sb.append("• ").append(evento.ocurrir()).append("\n");
        }

        output.setText(sb.toString());
        status.setText("Eventos cargados.");
    }

    // =========================
    // FONDO
    // =========================

    private void cambiarFondo() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Elegí una imagen de The Shiunji Family");

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            backgroundPanel.cargarImagen(archivo);
            backgroundPanel.repaint();
            status.setText("Fondo cambiado: " + archivo.getName());
        }
    }

    private void mostrarInicio() {
        output.setText(
                "Bienvenido al proyecto de The Shiunji Family Children.\n\n" +
                "Seleccioná una opción del menú:\n\n" +
                "• Diagrama de Clases\n" +
                "• Diagrama de Secuencia\n" +
                "• Ver Familia\n" +
                "• Ver Eventos\n" +
                "• Cambiar fondo\n\n" +
                "Toda la información se muestra dentro de esta interfaz."
        );
    }

    // =========================
    // PANEL CON IMAGEN DE FONDO
    // =========================

    static class BackgroundPanel extends JPanel {
        private BufferedImage imagen;

        public BackgroundPanel() {
            cargarImagen(new File("src/recurso/shiunji_background.jpg"));
        }

        public void cargarImagen(File archivo) {
            try {
                if (archivo.exists()) {
                    imagen = ImageIO.read(archivo);
                }
            } catch (Exception ignored) {
                imagen = null;
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();

            if (imagen != null) {
                int panelW = getWidth();
                int panelH = getHeight();

                double escala = Math.max(
                        (double) panelW / imagen.getWidth(),
                        (double) panelH / imagen.getHeight()
                );

                int ancho = (int) (imagen.getWidth() * escala);
                int alto = (int) (imagen.getHeight() * escala);

                int x = (panelW - ancho) / 2;
                int y = (panelH - alto) / 2;

                g2.drawImage(imagen, x, y, ancho, alto, null);

                // Oscurece la imagen para que el texto se pueda leer.
                g2.setColor(new Color(0, 0, 0, 115));
                g2.fillRect(0, 0, panelW, panelH);
            } else {
                GradientPaint gradiente = new GradientPaint(
                        0, 0, new Color(35, 35, 75),
                        getWidth(), getHeight(), new Color(110, 65, 125)
                );
                g2.setPaint(gradiente);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }

            g2.dispose();
        }
    }

    // =========================
    // MAIN
    // =========================

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName()
                );
            } catch (Exception ignored) {
            }

            Main ventana = new Main();
            ventana.setVisible(true);
        });
    }
}
