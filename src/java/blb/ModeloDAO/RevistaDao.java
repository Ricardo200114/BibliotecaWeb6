package blb.ModeloDAO;

import blb.DB.ConexionBD;
import blb.Modelo.Revistas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RevistaDao {
    
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void registrarRevista(Revistas rev) {

        String sql = "INSERT INTO revistas(Cod_Re,Titulo,Editorial,ISBN,Periodicidad,Fecha_Publicacion,Tamaño,Idioma,Ubicacion,Unidades) VALUES(?,?,?,?,?,?,?,?,?,?);";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, rev.getCodRe());
            pst.setString(2, rev.getTitulo());
            pst.setString(3, rev.getEditorial());
            pst.setString(4, rev.getIsbn());
            pst.setString(5, rev.getPeriodicidad());
            pst.setString(6, rev.getFecha());
            pst.setString(7, rev.getTamanio());
            pst.setString(8, rev.getIdioma());
            pst.setString(9, rev.getUbicacion());
            pst.setInt(10, rev.getUnidades());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }
    
    public List<Revistas> listarRevista() {

        String sql = "SELECT * FROM revistas";
        ArrayList<Revistas> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Revistas rev = new Revistas();
                rev.setId(rs.getInt("id"));
                rev.setCodRe(rs.getString("Cod_Re"));
                rev.setTitulo(rs.getString("Titulo"));
                rev.setEditorial(rs.getString("Editorial"));
                rev.setIsbn(rs.getString("ISBN"));
                rev.setPeriodicidad(rs.getString("Periodicidad"));
                rev.setFecha(rs.getString("Fecha_Publicacion"));
                rev.setTamanio(rs.getString("Tamaño"));
                rev.setIdioma(rs.getString("Idioma"));
                rev.setUbicacion(rs.getString("Ubicacion"));
                rev.setUnidades(rs.getInt("Unidades"));
                lista.add(rev);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return lista;
    }
    
    public List<Revistas> buscarRevista(String texto) {

        String sql = "SELECT * FROM revistas WHERE Cod_Re LIKE '%"+ texto + "%' OR Titulo LIKE '%"+ texto + "%' OR ISBN LIKE '%"+ texto + "%'";
        ArrayList<Revistas> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Revistas rev = new Revistas();
                rev.setId(rs.getInt("id"));
                rev.setCodRe(rs.getString("Cod_Re"));
                rev.setTitulo(rs.getString("Titulo"));
                rev.setEditorial(rs.getString("Editorial"));
                rev.setIsbn(rs.getString("ISBN"));
                rev.setPeriodicidad(rs.getString("Periodicidad"));
                rev.setFecha(rs.getString("Fecha_Publicacion"));
                rev.setTamanio(rs.getString("Tamaño"));
                rev.setIdioma(rs.getString("Idioma"));
                rev.setUbicacion(rs.getString("Ubicacion"));
                rev.setUnidades(rs.getInt("Unidades"));
                lista.add(rev);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return lista;
    }
    
    public Revistas consultarPorId(String codId) {

        Revistas rev = null;
        String sql = "SELECT * FROM revistas WHERE Cod_Re = ? LIMIT 1;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, codId);
            rs = pst.executeQuery();

            while (rs.next()) {
                rev = new Revistas();
                rev.setId(rs.getInt("id"));
                rev.setCodRe(rs.getString("Cod_Re"));
                rev.setTitulo(rs.getString("Titulo"));
                rev.setEditorial(rs.getString("Editorial"));
                rev.setIsbn(rs.getString("ISBN"));
                rev.setPeriodicidad(rs.getString("Periodicidad"));
                rev.setFecha(rs.getString("Fecha_Publicacion"));
                rev.setTamanio(rs.getString("Tamaño"));
                rev.setIdioma(rs.getString("Idioma"));
                rev.setUbicacion(rs.getString("Ubicacion"));
                rev.setUnidades(rs.getInt("Unidades"));
            }
            rs.close();
            pst.close();
            con.close();

//            log.info("Se ha hecho una consulta a la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo consultar a la tabla usuarios en la base de datos...");
            System.err.print(e.getCause());
        }
        return rev;
    }
    
    public void actualizarRevista(Revistas rev) {

        String sql = "UPDATE revistas SET Titulo=?,Editorial=?,ISBN=?,Periodicidad=?,Fecha_Publicacion=?,Tamaño=?,Idioma=?,Ubicacion=?,Unidades=? WHERE Cod_Re=?";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, rev.getTitulo());
            pst.setString(2, rev.getEditorial());
            pst.setString(3, rev.getIsbn());
            pst.setString(4, rev.getPeriodicidad());
            pst.setString(5, rev.getFecha());
            pst.setString(6, rev.getTamanio());
            pst.setString(7, rev.getIdioma());
            pst.setString(8, rev.getUbicacion());
            pst.setInt(9, rev.getUnidades());
            pst.setString(10, rev.getCodRe());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }

    }
    
    public void eliminarRevista(String codId) {

        String sql = "DELETE FROM revistas WHERE Cod_Re = ? LIMIT 1;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, codId);
            pst.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
        }
    }
    
    public boolean validarRepetido(String codId) {

        String sql = "SELECT COUNT(*) AS total FROM revistas WHERE Cod_Re = ?";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, codId);
            rs = pst.executeQuery();

            if (rs.next()) {
                int total = rs.getInt("total");

                if (total > 0) {
                    return false;
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
        }

        return true;

    }

}
