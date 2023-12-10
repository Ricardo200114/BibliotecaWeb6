package blb.ModeloDAO;

import blb.DB.ConexionBD;
import blb.Modelo.Usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public Usuarios iniciarSesion(String use, String pass) {

        Usuarios user = null;
        String sql = "SELECT * FROM usuarios WHERE Username=? AND Password =?";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, use);
            pst.setString(2, pass);
            rs = pst.executeQuery();

            while (rs.next()) {
                user = new Usuarios();
                user.setId(rs.getInt("id"));
                user.setNoCarnet(rs.getString("No_Carnet"));
                user.setNombre(rs.getString("Nombre"));
                user.setApellido(rs.getString("Apellido"));
                user.setOficio(rs.getString("Oficio"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setRecargoMora(rs.getDouble("Recargo_Mora"));
            }
            rs.close();
            pst.close();
            con.close();

//            log.info("Se ha hecho una consulta a la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo consultar a la tabla usuarios en la base de datos...");
            System.err.print(e.getCause());
        }
        return user;
    }
    
    public Usuarios verificarUsuario(String u, String noCarnet) {

        Usuarios user = null;
        String sql = "SELECT * FROM usuarios WHERE Username=? AND No_Carnet =?";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, u);
            pst.setString(2, noCarnet);
            rs = pst.executeQuery();

            while (rs.next()) {
                user = new Usuarios();
                user.setId(rs.getInt("id"));
                user.setNoCarnet(rs.getString("No_Carnet"));
                user.setNombre(rs.getString("Nombre"));
                user.setApellido(rs.getString("Apellido"));
                user.setOficio(rs.getString("Oficio"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setRecargoMora(rs.getDouble("Recargo_Mora"));
            }
            rs.close();
            pst.close();
            con.close();

//            log.info("Se ha hecho una consulta a la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo consultar a la tabla usuarios en la base de datos...");
            System.err.print(e.getCause());
        }
        return user;
    }
    
    public void restablecerContraseña(Usuarios user) {

        String sql = "UPDATE usuarios SET Password = ? WHERE No_Carnet = ?";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, user.getPassword());
            pst.setString(2, user.getNoCarnet());
            pst.executeUpdate();
            pst.close();
            con.close();

//            log.info("Se ha actualizado el campo password a la tabla usuarios en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo actualizar el campo password a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }

    public List<Usuarios> listarUsuario() {

        String sql = "SELECT * FROM usuarios";
        ArrayList<Usuarios> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Usuarios user = new Usuarios();
                user.setId(rs.getInt("id"));
                user.setNoCarnet(rs.getString("No_Carnet"));
                user.setNombre(rs.getString("Nombre"));
                user.setApellido(rs.getString("Apellido"));
                user.setOficio(rs.getString("Oficio"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setRecargoMora(rs.getDouble("Recargo_Mora"));
                lista.add(user);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return lista;
    }
    
    public List<Usuarios> listarUsuariosConMora() {

        String sql = "SELECT * FROM usuarios WHERE oficio = 'ESTUDIANTE' OR oficio = 'PROFESOR' ORDER BY No_Carnet;";
        ArrayList<Usuarios> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Usuarios user = new Usuarios();
                user.setId(rs.getInt("id"));
                user.setNoCarnet(rs.getString("No_Carnet"));
                user.setNombre(rs.getString("Nombre"));
                user.setApellido(rs.getString("Apellido"));
                user.setOficio(rs.getString("Oficio"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setRecargoMora(rs.getDouble("Recargo_Mora"));
                lista.add(user);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return lista;
    }

    public void registrarUsuario(Usuarios user) {

        String sql = "INSERT INTO usuarios(No_Carnet,Nombre,Apellido,Oficio,Username,Password,Recargo_Mora) VALUES(?,?,?,?,?,?,?);";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNoCarnet());
            pst.setString(2, user.getNombre());
            pst.setString(3, user.getApellido());
            pst.setString(4, user.getOficio());
            pst.setString(5, user.getUsername());
            pst.setString(6, user.getPassword());
            pst.setDouble(7, user.getRecargoMora());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }

    public Usuarios consultarPorId(String noCarnet) {

        Usuarios user = null;
        String sql = "SELECT * FROM usuarios WHERE No_Carnet = ? LIMIT 1;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, noCarnet);
            rs = pst.executeQuery();

            while (rs.next()) {
                user = new Usuarios();
                user.setId(rs.getInt("id"));
                user.setNoCarnet(rs.getString("No_Carnet"));
                user.setNombre(rs.getString("Nombre"));
                user.setApellido(rs.getString("Apellido"));
                user.setOficio(rs.getString("Oficio"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setRecargoMora(rs.getDouble("Recargo_Mora"));
            }
            rs.close();
            pst.close();
            con.close();

//            log.info("Se ha hecho una consulta a la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo consultar a la tabla usuarios en la base de datos...");
            System.err.print(e.getCause());
        }
        return user;
    }

    public void actualizarUsuario(Usuarios user) {

        String sql = "UPDATE usuarios SET Nombre=?, Apellido=?, Oficio=?, Username=? ,Password=?, Recargo_Mora=? WHERE No_Carnet=?";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNombre());
            pst.setString(2, user.getApellido());
            pst.setString(3, user.getOficio());
            pst.setString(4, user.getUsername());
            pst.setString(5, user.getPassword());
            pst.setDouble(6, user.getRecargoMora());
            pst.setString(7, user.getNoCarnet());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }

    }

    public void eliminarUsuario(String noCarnet) {

        String sql = "DELETE FROM usuarios WHERE No_Carnet = ? LIMIT 1;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, noCarnet);
            pst.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
        }
    }

    public boolean validarRepetido(String noCarnet) {

        String sql = "SELECT COUNT(*) AS total FROM usuarios WHERE No_Carnet = ?";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, noCarnet);
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
    
    public void sancionar(Usuarios user) {

        String sql = "UPDATE usuarios SET Recargo_Mora = ? WHERE No_Carnet = ?";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setDouble(1, user.getRecargoMora());
            pst.setString(2, user.getNoCarnet());
            pst.executeUpdate();
            pst.close();
            con.close();

//            log.info("Se ha actualizado el campo recargo_mora a la tabla usuarios en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
//            log.info("No se pudo actualizar el campo recargo_mora a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }
    
    public void pagarRecargo(Usuarios user) {

        String sql = "UPDATE usuarios SET Recargo_Mora = ? WHERE No_Carnet = ?";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setDouble(1, user.getRecargoMora());
            pst.setString(2, user.getNoCarnet());
            pst.executeUpdate();
            pst.close();
            con.close();

//            log.info("Se ha actualizado el campo recargo_mora a la tabla usuarios en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
////            log.error("No se pudo actualizar el campo recargo_mora a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }

}
