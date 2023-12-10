package blb.ModeloDAO;

import blb.DB.ConexionBD;
import blb.Modelo.Administracion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministracionDao {
    
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public Administracion consultarAdmin() {

        int id = 1;
        Administracion admin = null;
        String sql = "SELECT * FROM administracion WHERE id = '" + id + "'";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {

                admin = new Administracion();
                admin.setId(rs.getInt("id"));
                admin.setDiaEstudiante(rs.getInt("dia_estudiante"));
                admin.setMoraEstudiante(rs.getDouble("mora_estudiante"));
                admin.setMaterialEstudiante(rs.getInt("material_estudiante"));
                admin.setDiaProfesor(rs.getInt("dia_profesor"));
                admin.setMoraProfesor(rs.getDouble("mora_profesor"));
                admin.setMaterialProfesor(rs.getInt("material_profesor"));

            }
            pst.close();
            rs.close();
            con.close();

//            log.info("Se ha hecho una consulta a la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {

//            log.error("No se ha podido consultar a la base de datos..." + e.getCause());

        }
        return admin;
    }
    
    public void actualizarAdministracionEstudiante(Administracion admin) {

        int id = 1;
        String sql = "UPDATE administracion SET dia_estudiante=?, mora_estudiante=?, material_estudiante=? WHERE id = '" + id + "'";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setInt(1, admin.getDiaEstudiante());
            pst.setDouble(2, admin.getMoraEstudiante());
            pst.setInt(3, admin.getMaterialEstudiante());
            pst.executeUpdate();
            pst.close();

            con.close();

//            log.info("Se han modificado los campos dia_estudiante, mora_estudiante, material_estudiante de la tabla administración en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {

//            log.error("No se ha podido modificar la tabla administración en la base de datos..." + e.getCause());

        }
    }
    
    public void actualizarAdministracionProfesor(Administracion admin) {

        int id = 1;
        String sql = "UPDATE administracion SET dia_profesor=?, mora_profesor=?, material_profesor=? WHERE id = '" + id + "'";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setInt(1, admin.getDiaProfesor());
            pst.setDouble(2, admin.getMoraProfesor());
            pst.setInt(3, admin.getMaterialProfesor());
            pst.executeUpdate();
            pst.close();

            pst.close();
            con.close();

//            log.info("Se ha actualizado los campos dia_profesor, mora_profesor, material_profesor de la tabla administración en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {

//            log.error("No se ha podido modificar la tabla administración en la base de datos..." + e.getCause());
        
        }
    }

}
