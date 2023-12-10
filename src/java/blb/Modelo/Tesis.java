package blb.Modelo;

public class Tesis {

    private int id, noPagina, unidades;
    private String codTs, titulo, autor, pais, ciudad, universidad, fecha, idioma, ubicacion;

    public Tesis() {
    }

    public Tesis(int noPagina, int unidades, String codTs, String titulo, String autor, String pais, String ciudad, String universidad, String fecha, String idioma, String ubicacion) {
        this.noPagina = noPagina;
        this.unidades = unidades;
        this.codTs = codTs;
        this.titulo = titulo;
        this.autor = autor;
        this.pais = pais;
        this.ciudad = ciudad;
        this.universidad = universidad;
        this.fecha = fecha;
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

    public String getCodTs() {
        return codTs;
    }

    public void setCodTs(String codTs) {
        this.codTs = codTs;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public int getNoPagina() {
        return noPagina;
    }

    public void setNoPagina(int noPagina) {
        this.noPagina = noPagina;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        return "Tesis{" + "id=" + id + ", unidades=" + unidades + ", codTs=" + codTs + ", titulo=" + titulo + ", autor=" + autor + ", pais=" + pais + ", ciudad=" + ciudad + ", universidad=" + universidad + ", noPagina=" + noPagina + ", fecha=" + fecha + ", idioma=" + idioma + ", ubicacion=" + ubicacion + '}';
    }

}
