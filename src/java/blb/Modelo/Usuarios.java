package blb.Modelo;

public class Usuarios {

    private int id;
    private String noCarnet, nombre, apellido, oficio, username, password;
    private double recargoMora;

    public Usuarios() {
    }

    public Usuarios(String noCarnet, String nombre, String apellido, String oficio, String username, String password, double recargoMora) {
        this.noCarnet = noCarnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.oficio = oficio;
        this.username = username;
        this.password = password;
        this.recargoMora = recargoMora;
    }

    public Usuarios(int id, String noCarnet, String nombre, String apellido, String oficio, String username, String password, double recargoMora) {
        this.id = id;
        this.noCarnet = noCarnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.oficio = oficio;
        this.username = username;
        this.password = password;
        this.recargoMora = recargoMora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoCarnet() {
        return noCarnet;
    }

    public void setNoCarnet(String noCarnet) {
        this.noCarnet = noCarnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRecargoMora() {
        return recargoMora;
    }

    public void setRecargoMora(double recargoMora) {
        this.recargoMora = recargoMora;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", noCarnet=" + noCarnet + ", nombre=" + nombre + ", apellido=" + apellido + ", oficio=" + oficio + ", username=" + username + ", password=" + password + ", recargoMora=" + recargoMora + '}';
    }

}
