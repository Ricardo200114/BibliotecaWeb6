package blb.Modelo;

public class Obras {

    private int id, noPagina, unidades;
    private String codOb, titulo, autor, editorial, pais, isbn, anioPublicacion, idioma, genero, ubicacion;

    public Obras() {
    }

    public Obras(int noPagina, int unidades, String codOb, String titulo, String autor, String editorial, String pais, String isbn, String anioPublicacion, String idioma, String genero, String ubicacion) {
        this.noPagina = noPagina;
        this.unidades = unidades;
        this.codOb = codOb;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.pais = pais;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.idioma = idioma;
        this.genero = genero;
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoPagina() {
        return noPagina;
    }

    public void setNoPagina(int noPagina) {
        this.noPagina = noPagina;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getCodOb() {
        return codOb;
    }

    public void setCodOb(String codOb) {
        this.codOb = codOb;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Obras{" + "id=" + id + ", noPagina=" + noPagina + ", unidades=" + unidades + ", codOb=" + codOb + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", pais=" + pais + ", isbn=" + isbn + ", anioPublicacion=" + anioPublicacion + ", idioma=" + idioma + ", genero=" + genero + ", ubicacion=" + ubicacion + '}';
    }

}
