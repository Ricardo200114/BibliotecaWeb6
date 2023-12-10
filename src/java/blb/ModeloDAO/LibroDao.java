package blb.ModeloDAO;

import blb.DB.ConexionBD;
import blb.Modelo.Libros;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDao {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public List<Libros> listarLibro() {

        String sql = "SELECT * FROM libros";
        ArrayList<Libros> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Libros lib = new Libros();
                lib.setId(rs.getInt("id"));
                lib.setCodLib(rs.getString("Cod_Lib"));
                lib.setTitulo(rs.getString("Titulo"));
                lib.setAutor(rs.getString("Autor"));
                lib.setNoPaginas(rs.getInt("No_Paginas"));
                lib.setEditorial(rs.getString("Editorial"));
                lib.setPais(rs.getString("Pais"));
                lib.setIsbn(rs.getString("ISBN"));
                lib.setAnioPublicacion(rs.getString("Año_Publicacion"));
                lib.setIdioma(rs.getString("Idioma"));
                lib.setUbicacion(rs.getString("Ubicacion"));
                lib.setUnidades(rs.getInt("Unidades"));
                lista.add(lib);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
        }

        return lista;
    }

    public List<Libros> buscarLibro(String texto) {

        String sql = "SELECT * FROM libros WHERE Cod_Lib LIKE '%" + texto + "%' OR Titulo LIKE '%" + texto + "%' OR Autor LIKE '%" + texto + "%'";
        ArrayList<Libros> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Libros lib = new Libros();
                lib.setId(rs.getInt("id"));
                lib.setCodLib(rs.getString("Cod_Lib"));
                lib.setTitulo(rs.getString("Titulo"));
                lib.setAutor(rs.getString("Autor"));
                lib.setNoPaginas(rs.getInt("No_Paginas"));
                lib.setEditorial(rs.getString("Editorial"));
                lib.setPais(rs.getString("Pais"));
                lib.setIsbn(rs.getString("ISBN"));
                lib.setAnioPublicacion(rs.getString("Año_Publicacion"));
                lib.setIdioma(rs.getString("Idioma"));
                lib.setUbicacion(rs.getString("Ubicacion"));
                lib.setUnidades(rs.getInt("Unidades"));
                lista.add(lib);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return lista;
    }

    public void registrarLibro(Libros lib) {

        String sql = "INSERT INTO libros(Cod_Lib,Titulo,Autor,No_Paginas,Editorial,Pais,ISBN,Año_Publicacion,Idioma,Ubicacion,Unidades) VALUES(?,?,?,?,?,?,?,?,?,?,?);";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, lib.getCodLib());
            pst.setString(2, lib.getTitulo());
            pst.setString(3, lib.getAutor());
            pst.setInt(4, lib.getNoPaginas());
            pst.setString(5, lib.getEditorial());
            pst.setString(6, lib.getPais());
            pst.setString(7, lib.getIsbn());
            pst.setString(8, lib.getAnioPublicacion());
            pst.setString(9, lib.getIdioma());
            pst.setString(10, lib.getUbicacion());
            pst.setInt(11, lib.getUnidades());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }

    public Libros consultarPorId(String codId) {

        Libros lib = null;
        String sql = "SELECT * FROM libros WHERE Cod_Lib = ? LIMIT 1;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, codId);
            rs = pst.executeQuery();

            while (rs.next()) {
                lib = new Libros();
                lib.setId(rs.getInt("id"));
                lib.setCodLib(rs.getString("Cod_Lib"));
                lib.setTitulo(rs.getString("Titulo"));
                lib.setAutor(rs.getString("Autor"));
                lib.setNoPaginas(rs.getInt("No_Paginas"));
                lib.setEditorial(rs.getString("Editorial"));
                lib.setPais(rs.getString("Pais"));
                lib.setIsbn(rs.getString("ISBN"));
                lib.setAnioPublicacion(rs.getString("Año_Publicacion"));
                lib.setIdioma(rs.getString("Idioma"));
                lib.setUbicacion(rs.getString("Ubicacion"));
                lib.setUnidades(rs.getInt("Unidades"));
            }
            rs.close();
            pst.close();
            con.close();

//            log.info("Se ha hecho una consulta a la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo consultar a la tabla usuarios en la base de datos...");
            System.err.print(e.getCause());
        }
        return lib;
    }

    public void actualizarLibro(Libros lib) {

        String sql = "UPDATE libros SET Titulo=?,Autor=?,No_Paginas=?,Editorial=?,Pais=?,ISBN=?,Año_Publicacion=?,Idioma=?,Ubicacion=?,Unidades=? WHERE Cod_Lib=?";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, lib.getTitulo());
            pst.setString(2, lib.getAutor());
            pst.setInt(3, lib.getNoPaginas());
            pst.setString(4, lib.getEditorial());
            pst.setString(5, lib.getPais());
            pst.setString(6, lib.getIsbn());
            pst.setString(7, lib.getAnioPublicacion());
            pst.setString(8, lib.getIdioma());
            pst.setString(9, lib.getUbicacion());
            pst.setInt(10, lib.getUnidades());
            pst.setString(11, lib.getCodLib());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }

    }

    public void eliminarLibro(String codId) {

        String sql = "DELETE FROM libros WHERE Cod_Lib = ? LIMIT 1;";

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

        String sql = "SELECT COUNT(*) AS total FROM libros WHERE Cod_Lib = ?";

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
