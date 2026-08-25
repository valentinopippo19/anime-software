public abstract class Usuario {

    protected int id;
    protected String nombre;
    protected String email;
    protected String password;
    protected Monedero monedero;

    public Usuario(int id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.monedero = new Monedero();
    }

    public boolean registrarse() {
        return true;
    }

    public boolean iniciarSesion(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Monedero getMonedero() {
        return monedero;
    }
}