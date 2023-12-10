package blb.ModeloDAO;

import blb.DB.ConexionBD;
import blb.Modelo.Tesis;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesisDao {
    
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void registrarTesis(Tesis tes) {

        String sql = "INSERT INTO tesis(Cod_Ts,Titulo,Autor,Pais,Ciudad,Universidad,No_Paginas,Fecha_Publicacion,Idioma,Ubicacion,Unidades) VALUES(?,?,?,?,?,?,?,?,?,?,?);";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, tes.getCodTs());
            pst.setString(2, tes.getTitulo());
            pst.setString(3, tes.getAutor());
            pst.setString(4, tes.getPais());
            pst.setString(5, tes.getCiudad());
            pst.setString(6, tes.getUniversidad());
            pst.setInt(7, tes.getNoPagina());
            pst.setString(8, tes.getFecha());
            pst.setString(9, tes.getIdioma());
            pst.setString(10, tes.getUbicacion());
            pst.setInt(11, tes.getUnidades());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }
    
    public List<Tesis> listarTesis() {

        String sql = "SELECT * FROM tesis";
        ArrayList<Tesis> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Tesis tes = new Tesis();
                tes.setId(rs.getInt("id"));
                tes.setCodTs(rs.getString("Cod_Ts"));
                tes.setTitulo(rs.getString("Titulo"));
                tes.setAutor(rs.getString("Autor"));
                tes.setPais(rs.getString("Pais"));
                tes.setCiudad(rs.getString("Ciudad"));
                tes.setUniversidad(rs.getString("Universidad"));
                tes.setNoPagina(rs.getInt("No_Paginas"));
                tes.setFecha(rs.getString("Fecha_Publicacion"));
                tes.setIdioma(rs.getString("Idioma"));
                tes.setUbicacion(rs.getString("Ubicacion"));
                tes.setUnidades(rs.getInt("Unidades"));
                lista.add(tes);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return lista;
    }
    
    public List<Tesis> buscarTesis(String texto) {

        String sql = "SELECT * FROM tesis WHERE Cod_Ts LIKE '%"+ texto + "%' OR Titulo LIKE '%"+ texto + "%' OR Autor LIKE '%"+ texto + "%'";
        ArrayList<Tesis> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Tesis tes = new Tesis();
                tes.setId(rs.getInt("id"));
                tes.setCodTs(rs.getString("Cod_Ts"));
                tes.setTitulo(rs.getString("Titulo"));
                tes.setAutor(rs.getString("Autor"));
                tes.setPais(rs.getString("Pais"));
                tes.setCiudad(rs.getString("Ciudad"));
                tes.setUniversidad(rs.getString("Universidad"));
                tes.setNoPagina(rs.getInt("No_Paginas"));
                tes.setFecha(rs.getString("Fecha_Publicacion"));
                tes.setIdioma(rs.getString("Idioma"));
                tes.setUbicacion(rs.getString("Ubicacion"));
                tes.setUnidades(rs.getInt("Unidades"));
                lista.add(tes);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return lista;
    }
    
    public Tesis consultarPorId(String codId) {

        Tesis tes = null;
        String sql = "SELECT * FROM tesis WHERE Cod_Ts = ? LIMIT 1;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, codId);
            rs = pst.executeQuery();

            while (rs.next()) {
                tes = new Tesis();
                tes.setId(rs.getInt("id"));
                tes.setCodTs(rs.getString("Cod_Ts"));
                tes.setTitulo(rs.getString("Titulo"));
                tes.setAutor(rs.getString("Autor"));
                tes.setPais(rs.getString("Pais"));
                tes.setCiudad(rs.getString("Ciudad"));
                tes.setUniversidad(rs.getString("Universidad"));
                tes.setNoPagina(rs.getInt("No_Paginas"));
                tes.setFecha(rs.getString("Fecha_Publicacion"));
                tes.setIdioma(rs.getString("Idioma"));
                tes.setUbicacion(rs.getString("Ubicacion"));
                tes.setUnidades(rs.getInt("Unidades"));
            }
            rs.close();
            pst.close();
            con.close();

//            log.info("Se ha hecho una consulta a la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo consultar a la tabla usuarios en la base de datos...");
            System.err.print(e.getCause());
        }
        return tes;
    }
    
    public void actualizarTesis(Tesis tes) {

        String sql = "UPDATE tesis SET Titulo=?,Autor=?,Pais=?,Ciudad=?,Universidad=?,No_Paginas=?,Fecha_Publicacion=?,Idioma=?,Ubicacion=?,Unidades=? WHERE Cod_Ts=?";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, tes.getTitulo());
            pst.setString(2, tes.getAutor());
            pst.setString(3, tes.getPais());
            pst.setString(4, tes.getCiudad());
            pst.setString(5, tes.getUniversidad());
            pst.setInt(6, tes.getNoPagina());
            pst.setString(7, tes.getFecha());
            pst.setString(8, tes.getIdioma());
            pst.setString(9, tes.getUbicacion());
            pst.setInt(10, tes.getUnidades());
            pst.setString(11, tes.getCodTs());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }

    }
    
    public void eliminarTesis(String codId) {

        String sql = "DELETE FROM tesis WHERE Cod_Ts = ? LIMIT 1;";

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

        String sql = "SELECT COUNT(*) AS total FROM tesis WHERE Cod_Ts = ?";

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
