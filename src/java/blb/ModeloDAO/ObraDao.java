package blb.ModeloDAO;

import blb.DB.ConexionBD;
import blb.Modelo.Obras;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObraDao {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void registrarObra(Obras obr) {

        String sql = "INSERT INTO obras(Cod_Ob,Titulo,Autor,No_Paginas,Editorial,Pais,ISBN,Año_Publicacion,Idioma,Genero,Ubicacion,Unidades) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, obr.getCodOb());
            pst.setString(2, obr.getTitulo());
            pst.setString(3, obr.getAutor());
            pst.setInt(4, obr.getNoPagina());
            pst.setString(5, obr.getEditorial());
            pst.setString(6, obr.getPais());
            pst.setString(7, obr.getIsbn());
            pst.setString(8, obr.getAnioPublicacion());
            pst.setString(9, obr.getIdioma());
            pst.setString(10, obr.getGenero());
            pst.setString(11, obr.getUbicacion());
            pst.setInt(12, obr.getUnidades());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }

    public List<Obras> listarObra() {

        String sql = "SELECT * FROM obras";
        ArrayList<Obras> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Obras obr = new Obras();
                obr.setId(rs.getInt("id"));
                obr.setCodOb(rs.getString("Cod_Ob"));
                obr.setTitulo(rs.getString("Titulo"));
                obr.setAutor(rs.getString("Autor"));
                obr.setNoPagina(rs.getInt("No_Paginas"));
                obr.setEditorial(rs.getString("Editorial"));
                obr.setPais(rs.getString("Pais"));
                obr.setIsbn(rs.getString("ISBN"));
                obr.setAnioPublicacion(rs.getString("Año_Publicacion"));
                obr.setIdioma(rs.getString("Idioma"));
                obr.setGenero(rs.getString("Genero"));
                obr.setUbicacion(rs.getString("Ubicacion"));
                obr.setUnidades(rs.getInt("Unidades"));
                lista.add(obr);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return lista;
    }

    public List<Obras> buscarObra(String texto) {

        String sql = "SELECT * FROM obras WHERE Cod_Ob LIKE '%" + texto + "%' OR Titulo LIKE '%" + texto + "%' OR Autor LIKE '%" + texto + "%'";
        ArrayList<Obras> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Obras obr = new Obras();
                obr.setId(rs.getInt("id"));
                obr.setCodOb(rs.getString("Cod_Ob"));
                obr.setTitulo(rs.getString("Titulo"));
                obr.setAutor(rs.getString("Autor"));
                obr.setNoPagina(rs.getInt("No_Paginas"));
                obr.setEditorial(rs.getString("Editorial"));
                obr.setPais(rs.getString("Pais"));
                obr.setIsbn(rs.getString("ISBN"));
                obr.setAnioPublicacion(rs.getString("Año_Publicacion"));
                obr.setIdioma(rs.getString("Idioma"));
                obr.setGenero(rs.getString("Genero"));
                obr.setUbicacion(rs.getString("Ubicacion"));
                obr.setUnidades(rs.getInt("Unidades"));
                lista.add(obr);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return lista;
    }

    public Obras consultarPorId(String codId) {

        Obras obr = null;
        String sql = "SELECT * FROM obras WHERE Cod_Ob = ? LIMIT 1;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, codId);
            rs = pst.executeQuery();

            while (rs.next()) {
                obr = new Obras();
                obr.setId(rs.getInt("id"));
                obr.setCodOb(rs.getString("Cod_Ob"));
                obr.setTitulo(rs.getString("Titulo"));
                obr.setAutor(rs.getString("Autor"));
                obr.setNoPagina(rs.getInt("No_Paginas"));
                obr.setEditorial(rs.getString("Editorial"));
                obr.setPais(rs.getString("Pais"));
                obr.setIsbn(rs.getString("ISBN"));
                obr.setAnioPublicacion(rs.getString("Año_Publicacion"));
                obr.setIdioma(rs.getString("Idioma"));
                obr.setGenero(rs.getString("Genero"));
                obr.setUbicacion(rs.getString("Ubicacion"));
                obr.setUnidades(rs.getInt("Unidades"));
            }
            rs.close();
            pst.close();
            con.close();

//            log.info("Se ha hecho una consulta a la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo consultar a la tabla usuarios en la base de datos...");
            System.err.print(e.getCause());
        }
        return obr;
    }

    public void actualizarObra(Obras obr) {

        String sql = "UPDATE obras SET Titulo=?,Autor=?,No_Paginas=?,Editorial=?,Pais=?,ISBN=?,Año_Publicacion=?,Idioma=?,Genero=?,Ubicacion=?,Unidades=? WHERE Cod_Ob=?";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, obr.getTitulo());
            pst.setString(2, obr.getAutor());
            pst.setInt(3, obr.getNoPagina());
            pst.setString(4, obr.getEditorial());
            pst.setString(5, obr.getPais());
            pst.setString(6, obr.getIsbn());
            pst.setString(7, obr.getAnioPublicacion());
            pst.setString(8, obr.getIdioma());
            pst.setString(9, obr.getGenero());
            pst.setString(10, obr.getUbicacion());
            pst.setInt(11, obr.getUnidades());
            pst.setString(12, obr.getCodOb());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }

    }

    public void eliminarObra(String codId) {

        String sql = "DELETE FROM obras WHERE Cod_Ob = ? LIMIT 1;";

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

        String sql = "SELECT COUNT(*) AS total FROM obras WHERE Cod_Ob = ?";

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
