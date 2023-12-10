package blb.ModeloDAO;

import blb.DB.ConexionBD;
import blb.Modelo.CDs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CdDao {
    
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void registrarCds(CDs cd) {

        String sql = "INSERT INTO cds(Cod_Cd,Titulo,Autor,Pais,Año_Publicacion,Volumen,Idioma,Genero,Ubicacion,Unidades) VALUES(?,?,?,?,?,?,?,?,?,?);";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, cd.getCodCd());
            pst.setString(2, cd.getTitulo());
            pst.setString(3, cd.getAutor());
            pst.setString(4, cd.getPais());
            pst.setString(5, cd.getAnioPublicacion());
            pst.setString(6, cd.getVolumen());
            pst.setString(7, cd.getIdioma());
            pst.setString(8, cd.getGenero());
            pst.setString(9, cd.getUbicacion());
            pst.setInt(10, cd.getUnidades());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }
    
    public List<CDs> listarCds() {

        String sql = "SELECT * FROM cds";
        ArrayList<CDs> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                CDs cd = new CDs();
                cd.setId(rs.getInt("id"));
                cd.setCodCd(rs.getString("Cod_Cd"));
                cd.setTitulo(rs.getString("Titulo"));
                cd.setAutor(rs.getString("Autor"));
                cd.setPais(rs.getString("Pais"));
                cd.setAnioPublicacion(rs.getString("Año_Publicacion"));
                cd.setVolumen(rs.getString("Volumen"));
                cd.setIdioma(rs.getString("Idioma"));
                cd.setGenero(rs.getString("Genero"));
                cd.setUbicacion(rs.getString("Ubicacion"));
                cd.setUnidades(rs.getInt("Unidades"));
                lista.add(cd);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return lista;
    }
    
    public List<CDs> buscarCds(String texto) {

        String sql = "SELECT * FROM cds WHERE Cod_Cd LIKE '%"+ texto + "%' OR Titulo LIKE '%"+ texto + "%' OR Autor LIKE '%"+ texto + "%'";
        ArrayList<CDs> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                CDs cd = new CDs();
                cd.setId(rs.getInt("id"));
                cd.setCodCd(rs.getString("Cod_Cd"));
                cd.setTitulo(rs.getString("Titulo"));
                cd.setAutor(rs.getString("Autor"));
                cd.setPais(rs.getString("Pais"));
                cd.setAnioPublicacion(rs.getString("Año_Publicacion"));
                cd.setVolumen(rs.getString("Volumen"));
                cd.setIdioma(rs.getString("Idioma"));
                cd.setGenero(rs.getString("Genero"));
                cd.setUbicacion(rs.getString("Ubicacion"));
                cd.setUnidades(rs.getInt("Unidades"));
                lista.add(cd);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return lista;
    }
    
    public CDs consultarPorId(String codId) {

        CDs cd = null;
        String sql = "SELECT * FROM cds WHERE Cod_Cd = ? LIMIT 1;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, codId);
            rs = pst.executeQuery();

            while (rs.next()) {
                cd = new CDs();
                cd.setId(rs.getInt("id"));
                cd.setCodCd(rs.getString("Cod_Cd"));
                cd.setTitulo(rs.getString("Titulo"));
                cd.setAutor(rs.getString("Autor"));
                cd.setPais(rs.getString("Pais"));
                cd.setAnioPublicacion(rs.getString("Año_Publicacion"));
                cd.setVolumen(rs.getString("Volumen"));
                cd.setIdioma(rs.getString("Idioma"));
                cd.setGenero(rs.getString("Genero"));
                cd.setUbicacion(rs.getString("Ubicacion"));
                cd.setUnidades(rs.getInt("Unidades"));
            }
            rs.close();
            pst.close();
            con.close();

//            log.info("Se ha hecho una consulta a la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo consultar a la tabla usuarios en la base de datos...");
            System.err.print(e.getCause());
        }
        return cd;
    }
    
    public void actualizarCd(CDs cd) {

        String sql = "UPDATE cds SET Titulo=?,Autor=?,Pais=?,Año_Publicacion=?,Volumen=?,Idioma=?,Genero=?,Ubicacion=?,Unidades=? WHERE Cod_Cd=?";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, cd.getTitulo());
            pst.setString(2, cd.getAutor());
            pst.setString(3, cd.getPais());
            pst.setString(4, cd.getAnioPublicacion());
            pst.setString(5, cd.getVolumen());
            pst.setString(6, cd.getIdioma());
            pst.setString(7, cd.getGenero());
            pst.setString(8, cd.getUbicacion());
            pst.setInt(9, cd.getUnidades());
            pst.setString(10, cd.getCodCd());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }

    }
    
    public void eliminarCd(String codId) {

        String sql = "DELETE FROM cds WHERE Cod_Cd = ? LIMIT 1;";

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

        String sql = "SELECT COUNT(*) AS total FROM cds WHERE Cod_Cd = ?";

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
