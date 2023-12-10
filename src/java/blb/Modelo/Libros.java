package blb.Modelo;

public class Libros {

    private int id, noPaginas, unidades;
    private String codLib, titulo, autor, editorial, pais, isbn, anioPublicacion, idioma, ubicacion;

    public Libros() {
    }

    public Libros(int noPaginas, int unidades, String codLib, String titulo, String autor, String editorial, String pais, String isbn, String anioPublicacion, String idioma, String ubicacion) {
        this.noPaginas = noPaginas;
        this.unidades = unidades;
        this.codLib = codLib;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.pais = pais;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.idioma = idioma;
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public String getCodLib() {
        return codLib;
    }

    public void setCodLib(String codLib) {
        this.codLib = codLib;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoPaginas() {
        return noPaginas;
    }

    public void setNoPaginas(int noPaginas) {
        this.noPaginas = noPaginas;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
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
        return "Libros{" + "id=" + id + ", noPaginas=" + noPaginas + ", unidades=" + unidades + ", codLib=" + codLib + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", pais=" + pais + ", isbn=" + isbn + ", anioPublicacion=" + anioPublicacion + ", idioma=" + idioma + ", ubicacion=" + ubicacion + '}';
    }

}
