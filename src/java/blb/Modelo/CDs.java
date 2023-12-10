package blb.Modelo;

public class CDs {

    private int id, unidades;
    private String codCd, titulo, autor, pais, anioPublicacion, volumen, idioma, genero, ubicacion;

    public CDs() {
    }

    public CDs(int unidades, String codCd, String titulo, String autor, String pais, String anioPublicacion, String volumen, String idioma, String genero, String ubicacion) {
        this.unidades = unidades;
        this.codCd = codCd;
        this.titulo = titulo;
        this.autor = autor;
        this.pais = pais;
        this.anioPublicacion = anioPublicacion;
        this.volumen = volumen;
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

    public String getCodCd() {
        return codCd;
    }

    public void setCodCd(String codCd) {
        this.codCd = codCd;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
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
        return "CDs{" + "id=" + id + ", unidades=" + unidades + ", codCd=" + codCd + ", titulo=" + titulo + ", autor=" + autor + ", pais=" + pais + ", anioPublicacion=" + anioPublicacion + ", volumen=" + volumen + ", idioma=" + idioma + ", genero=" + genero + ", ubicacion=" + ubicacion + '}';
    }

}
