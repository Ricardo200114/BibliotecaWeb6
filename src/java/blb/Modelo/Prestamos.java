package blb.Modelo;

public class Prestamos {

    private int id, idUser, idLib, idCds, idObr, idRev, idTsi;
    private String noCarnet, nombre, codMaterial, material;
    private java.sql.Date f_prestamo, f_devolucion;

    public Prestamos() {
    }

    public Prestamos(int idUser, int idLib, int idCds, int idObr, int idRev, int idTsi, String noCarnet, String nombre, String codMaterial, String material, java.sql.Date f_prestamo) {
        this.idUser = idUser;
        this.idLib = idLib;
        this.idCds = idCds;
        this.idObr = idObr;
        this.idRev = idRev;
        this.idTsi = idTsi;
        this.noCarnet = noCarnet;
        this.nombre = nombre;
        this.codMaterial = codMaterial;
        this.material = material;
        this.f_prestamo = f_prestamo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdLib() {
        return idLib;
    }

    public void setIdLib(int idLib) {
        this.idLib = idLib;
    }

    public int getIdCds() {
        return idCds;
    }

    public void setIdCds(int idCds) {
        this.idCds = idCds;
    }

    public int getIdObr() {
        return idObr;
    }

    public void setIdObr(int idObr) {
        this.idObr = idObr;
    }

    public int getIdRev() {
        return idRev;
    }

    public void setIdRev(int idRev) {
        this.idRev = idRev;
    }

    public int getIdTsi() {
        return idTsi;
    }

    public void setIdTsi(int idTsi) {
        this.idTsi = idTsi;
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

    public String getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(String codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public java.sql.Date getF_prestamo() {
        return f_prestamo;
    }

    public void setF_prestamo(java.sql.Date f_prestamo) {
        this.f_prestamo = f_prestamo;
    }

    public java.sql.Date getF_devolucion() {
        return f_devolucion;
    }

    public void setF_devolucion(java.sql.Date f_devolucion) {
        this.f_devolucion = f_devolucion;
    }

    @Override
    public String toString() {
        return "Prestamos{" + "id=" + id + ", idUser=" + idUser + ", idLib=" + idLib + ", idCds=" + idCds + ", idObr=" + idObr + ", idRev=" + idRev + ", idTsi=" + idTsi + ", noCarnet=" + noCarnet + ", nombre=" + nombre + ", codMaterial=" + codMaterial + ", material=" + material + ", f_prestamo=" + f_prestamo + ", f_devolucion=" + f_devolucion + '}';
    }

}
