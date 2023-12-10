package blb.Modelo;

public class Administracion {

    private int id, diaEstudiante, materialEstudiante, diaProfesor, materialProfesor;
    private double moraEstudiante, moraProfesor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiaEstudiante() {
        return diaEstudiante;
    }

    public void setDiaEstudiante(int diaEstudiante) {
        this.diaEstudiante = diaEstudiante;
    }

    public int getMaterialEstudiante() {
        return materialEstudiante;
    }

    public void setMaterialEstudiante(int materialEstudiante) {
        this.materialEstudiante = materialEstudiante;
    }

    public int getDiaProfesor() {
        return diaProfesor;
    }

    public void setDiaProfesor(int diaProfesor) {
        this.diaProfesor = diaProfesor;
    }

    public int getMaterialProfesor() {
        return materialProfesor;
    }

    public void setMaterialProfesor(int materialProfesor) {
        this.materialProfesor = materialProfesor;
    }

    public double getMoraEstudiante() {
        return moraEstudiante;
    }

    public void setMoraEstudiante(double moraEstudiante) {
        this.moraEstudiante = moraEstudiante;
    }

    public double getMoraProfesor() {
        return moraProfesor;
    }

    public void setMoraProfesor(double moraProfesor) {
        this.moraProfesor = moraProfesor;
    }

    @Override
    public String toString() {
        return "Administracion{" + "id=" + id + ", diaEstudiante=" + diaEstudiante + ", materialEstudiante=" + materialEstudiante + ", diaProfesor=" + diaProfesor + ", materialProfesor=" + materialProfesor + ", moraEstudiante=" + moraEstudiante + ", moraProfesor=" + moraProfesor + '}';
    }

}
