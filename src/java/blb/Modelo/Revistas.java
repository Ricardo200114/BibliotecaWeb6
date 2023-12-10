package blb.Modelo;

public class Revistas {

    private int id, unidades;
    private String codRe, titulo, editorial, isbn, periodicidad, fecha, tamanio, idioma, ubicacion;

    public Revistas() {
    }

    public Revistas(int unidades, String codRe, String titulo, String editorial, String isbn, String periodicidad, String fecha, String tamanio, String idioma, String ubicacion) {
        this.unidades = unidades;
        this.codRe = codRe;
        this.titulo = titulo;
        this.editorial = editorial;
        this.isbn = isbn;
        this.periodicidad = periodicidad;
        this.fecha = fecha;
        this.tamanio = tamanio;
        this.idioma = idioma;
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getCodRe() {
        return codRe;
    }

    public void setCodRe(String codRe) {
        this.codRe = codRe;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Revistas{" + "id=" + id + ", unidades=" + unidades + ", codRe=" + codRe + ", titulo=" + titulo + ", editorial=" + editorial + ", isbn=" + isbn + ", periodicidad=" + periodicidad + ", fecha=" + fecha + ", tamanio=" + tamanio + ", idioma=" + idioma + ", ubicacion=" + ubicacion + '}';
    }

}
