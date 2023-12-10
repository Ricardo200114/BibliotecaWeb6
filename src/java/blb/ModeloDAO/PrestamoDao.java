package blb.ModeloDAO;

import blb.DB.ConexionBD;
import blb.Modelo.CDs;
import blb.Modelo.Libros;
import blb.Modelo.Obras;
import blb.Modelo.Prestamos;
import blb.Modelo.Revistas;
import blb.Modelo.Tesis;
import blb.Modelo.Usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDao {
    
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    //----ESTOS METODOS SIRVEN PARA REGISTRAR EL PRESTAMO EN LA TABLA PRESTAMOS----
    public void registrarPrestamoLibro(Prestamos pre) {

        String sql = "INSERT INTO prestamos(id_user,id_lib,No_Carnet,Nombre,Cod_Material,Material,f_prestamo) VALUES(?,?,?,?,?,?,?);";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setInt(1, pre.getIdUser());
            pst.setInt(2, pre.getIdLib());
            pst.setString(3, pre.getNoCarnet());
            pst.setString(4, pre.getNombre());
            pst.setString(5, pre.getCodMaterial());
            pst.setString(6, pre.getMaterial());
            pst.setDate(7, pre.getF_prestamo());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("No se pudo hacer la insercion" + e.getMessage());
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }
    
    public void registrarPrestamoObra(Prestamos pre) {

        String sql = "INSERT INTO prestamos(id_user,id_obr,No_Carnet,Nombre,Cod_Material,Material,f_prestamo) VALUES(?,?,?,?,?,?,?);";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setInt(1, pre.getIdUser());
            pst.setInt(2, pre.getIdObr());
            pst.setString(3, pre.getNoCarnet());
            pst.setString(4, pre.getNombre());
            pst.setString(5, pre.getCodMaterial());
            pst.setString(6, pre.getMaterial());
            pst.setDate(7, pre.getF_prestamo());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("No se pudo hacer la insercion" + e.getMessage());
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }
    
    public void registrarPrestamoRevista(Prestamos pre) {

        String sql = "INSERT INTO prestamos(id_user,id_rev,No_Carnet,Nombre,Cod_Material,Material,f_prestamo) VALUES(?,?,?,?,?,?,?);";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setInt(1, pre.getIdUser());
            pst.setInt(2, pre.getIdRev());
            pst.setString(3, pre.getNoCarnet());
            pst.setString(4, pre.getNombre());
            pst.setString(5, pre.getCodMaterial());
            pst.setString(6, pre.getMaterial());
            pst.setDate(7, pre.getF_prestamo());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("No se pudo hacer la insercion" + e.getMessage());
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }
    
    public void registrarPrestamoCd(Prestamos pre) {

        String sql = "INSERT INTO prestamos(id_user,id_cds,No_Carnet,Nombre,Cod_Material,Material,f_prestamo) VALUES(?,?,?,?,?,?,?);";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setInt(1, pre.getIdUser());
            pst.setInt(2, pre.getIdCds());
            pst.setString(3, pre.getNoCarnet());
            pst.setString(4, pre.getNombre());
            pst.setString(5, pre.getCodMaterial());
            pst.setString(6, pre.getMaterial());
            pst.setDate(7, pre.getF_prestamo());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("No se pudo hacer la insercion" + e.getMessage());
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }
    
    public void registrarPrestamoTesis(Prestamos pre) {

        String sql = "INSERT INTO prestamos(id_user,id_tsi,No_Carnet,Nombre,Cod_Material,Material,f_prestamo) VALUES(?,?,?,?,?,?,?);";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setInt(1, pre.getIdUser());
            pst.setInt(2, pre.getIdTsi());
            pst.setString(3, pre.getNoCarnet());
            pst.setString(4, pre.getNombre());
            pst.setString(5, pre.getCodMaterial());
            pst.setString(6, pre.getMaterial());
            pst.setDate(7, pre.getF_prestamo());
            pst.executeUpdate();

            pst.close();
            con.close();

//            log.info("Se ha registrado un nuevo usuario en la tabla usuarios en la base de datos...");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("No se pudo hacer la insercion" + e.getMessage());
//            log.error("No se pudo registrar usuario a la tabla usuarios en la base de datos..." + e.getCause());

        }
    }
    
    
    
    //----ESTOS METODOS SIRVEN PARA ENCONTRAR EL PRESTAMO ACTUAL DONDE LA COLUMNA FECHA DEVOLUCION SE NULL----
    public Prestamos prestamoActualObra(Usuarios user, Obras obr) {

        Prestamos prestamo = null;
        String sql = "SELECT * FROM prestamos WHERE No_Carnet=? AND Cod_Material=? AND f_devolucion IS NULL ORDER BY id DESC LIMIT 1";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNoCarnet());
            pst.setString(2, obr.getCodOb());

            rs = pst.executeQuery();

            while (rs.next()) {
                prestamo = new Prestamos();
                prestamo.setId(rs.getInt("id"));
                prestamo.setIdUser(rs.getInt("id_user"));
                prestamo.setIdObr(rs.getInt("id_obr"));
                prestamo.setNoCarnet(rs.getString("No_Carnet"));
                prestamo.setNombre(rs.getString("Nombre"));
                prestamo.setCodMaterial(rs.getString("Cod_Material"));
                prestamo.setMaterial(rs.getString("Material"));
                prestamo.setF_prestamo(rs.getDate("f_prestamo"));
                prestamo.setF_devolucion(rs.getDate("f_devolucion"));
            }

            pst.close();
            rs.close();
            con.close();

//            log.info("Se ha hecho una consulta a la tabla prestamos en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo consultar la tabla prestamos en la base de datos..." + e.getCause());

        }
        return prestamo;
    }
    
    public Prestamos prestamoActualLibro(Usuarios user, Libros lib) {

        Prestamos prestamo = null;
        String sql = "SELECT * FROM prestamos WHERE No_Carnet=? AND Cod_Material=? AND f_devolucion IS NULL ORDER BY id DESC LIMIT 1";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNoCarnet());
            pst.setString(2, lib.getCodLib());

            rs = pst.executeQuery();

            while (rs.next()) {
                prestamo = new Prestamos();
                prestamo.setId(rs.getInt("id"));
                prestamo.setIdUser(rs.getInt("id_user"));
                prestamo.setIdLib(rs.getInt("id_lib"));
                prestamo.setNoCarnet(rs.getString("No_Carnet"));
                prestamo.setNombre(rs.getString("Nombre"));
                prestamo.setCodMaterial(rs.getString("Cod_Material"));
                prestamo.setMaterial(rs.getString("Material"));
                prestamo.setF_prestamo(rs.getDate("f_prestamo"));
                prestamo.setF_devolucion(rs.getDate("f_devolucion"));
            }

            pst.close();
            rs.close();
            con.close();

//            log.info("Se ha hecho una consulta a la tabla prestamos en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo consultar la tabla prestamos en la base de datos..." + e.getCause());

        }
        return prestamo;
    }
    
    public Prestamos prestamoActualRevista(Usuarios user, Revistas rev) {

        Prestamos prestamo = null;
        String sql = "SELECT * FROM prestamos WHERE No_Carnet=? AND Cod_Material=? AND f_devolucion IS NULL ORDER BY id DESC LIMIT 1";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNoCarnet());
            pst.setString(2, rev.getCodRe());

            rs = pst.executeQuery();

            while (rs.next()) {
                prestamo = new Prestamos();
                prestamo.setId(rs.getInt("id"));
                prestamo.setIdUser(rs.getInt("id_user"));
                prestamo.setIdLib(rs.getInt("id_rev"));
                prestamo.setNoCarnet(rs.getString("No_Carnet"));
                prestamo.setNombre(rs.getString("Nombre"));
                prestamo.setCodMaterial(rs.getString("Cod_Material"));
                prestamo.setMaterial(rs.getString("Material"));
                prestamo.setF_prestamo(rs.getDate("f_prestamo"));
                prestamo.setF_devolucion(rs.getDate("f_devolucion"));
            }

            pst.close();
            rs.close();
            con.close();

//            log.info("Se ha hecho una consulta a la tabla prestamos en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo consultar la tabla prestamos en la base de datos..." + e.getCause());

        }
        return prestamo;
    }
    
    public Prestamos prestamoActualCd(Usuarios user, CDs cds) {

        Prestamos prestamo = null;
        String sql = "SELECT * FROM prestamos WHERE No_Carnet=? AND Cod_Material=? AND f_devolucion IS NULL ORDER BY id DESC LIMIT 1";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNoCarnet());
            pst.setString(2, cds.getCodCd());

            rs = pst.executeQuery();

            while (rs.next()) {
                prestamo = new Prestamos();
                prestamo.setId(rs.getInt("id"));
                prestamo.setIdUser(rs.getInt("id_user"));
                prestamo.setIdLib(rs.getInt("id_cds"));
                prestamo.setNoCarnet(rs.getString("No_Carnet"));
                prestamo.setNombre(rs.getString("Nombre"));
                prestamo.setCodMaterial(rs.getString("Cod_Material"));
                prestamo.setMaterial(rs.getString("Material"));
                prestamo.setF_prestamo(rs.getDate("f_prestamo"));
                prestamo.setF_devolucion(rs.getDate("f_devolucion"));
            }

            pst.close();
            rs.close();
            con.close();

//            log.info("Se ha hecho una consulta a la tabla prestamos en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo consultar la tabla prestamos en la base de datos..." + e.getCause());

        }
        return prestamo;
    }
    
    public Prestamos prestamoActualTesis(Usuarios user, Tesis tsi) {

        Prestamos prestamo = null;
        String sql = "SELECT * FROM prestamos WHERE No_Carnet=? AND Cod_Material=? AND f_devolucion IS NULL ORDER BY id DESC LIMIT 1";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNoCarnet());
            pst.setString(2, tsi.getCodTs());

            rs = pst.executeQuery();

            while (rs.next()) {
                prestamo = new Prestamos();
                prestamo.setId(rs.getInt("id"));
                prestamo.setIdUser(rs.getInt("id_user"));
                prestamo.setIdLib(rs.getInt("id_tsi"));
                prestamo.setNoCarnet(rs.getString("No_Carnet"));
                prestamo.setNombre(rs.getString("Nombre"));
                prestamo.setCodMaterial(rs.getString("Cod_Material"));
                prestamo.setMaterial(rs.getString("Material"));
                prestamo.setF_prestamo(rs.getDate("f_prestamo"));
                prestamo.setF_devolucion(rs.getDate("f_devolucion"));
            }

            pst.close();
            rs.close();
            con.close();

//            log.info("Se ha hecho una consulta a la tabla prestamos en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo consultar la tabla prestamos en la base de datos..." + e.getCause());

        }
        return prestamo;
    }
    
    
    //----METODO PARA CONTAR LA CANTIDAD DE PRESTAMOS DE UN USUARIO EN LA TABLA PRESTAMOS---
    public int cantidadPrestamos(Usuarios user) {

        int cantidadRegistros = 0;
        String sql = "SELECT COUNT(*) FROM prestamos WHERE No_Carnet=? AND f_devolucion IS NULL;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNoCarnet());
            rs = pst.executeQuery();
            if (rs.next()) {
                cantidadRegistros = Integer.parseInt(rs.getString(1));
            }
            rs.close();
            pst.close();
            con.close();

//            log.info("Se ha hecho un conteo en la tabla prestamos en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo realizar el conteo a la tabla prestamos en la base de datos...");

        }
        return cantidadRegistros;
    }
    
    //---METODO PARA LISTAR TODOS LOS PRESTAMOS DE LA TABLA PRESTAMOS---
    public List<Prestamos> listarPrestamo() {

        String sql = "SELECT * FROM prestamos";
        ArrayList<Prestamos> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Prestamos pre = new Prestamos();
                pre.setId(rs.getInt("id"));
                pre.setNoCarnet(rs.getString("No_Carnet"));
                pre.setNombre(rs.getString("Nombre"));
                pre.setCodMaterial(rs.getString("Cod_Material"));
                pre.setMaterial(rs.getString("Material"));
                pre.setF_prestamo(rs.getDate("f_prestamo"));
                pre.setF_devolucion(rs.getDate("f_devolucion"));
                lista.add(pre);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return lista;
    }
    
    public List<Prestamos> listarPrestamoPorId(String noCarnet) {

        String sql = "SELECT * FROM prestamos WHERE No_Carnet='" + noCarnet + "'";
        ArrayList<Prestamos> lista = new ArrayList<>();

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Prestamos pre = new Prestamos();
                pre.setId(rs.getInt("id"));
                pre.setNoCarnet(rs.getString("No_Carnet"));
                pre.setNombre(rs.getString("Nombre"));
                pre.setCodMaterial(rs.getString("Cod_Material"));
                pre.setMaterial(rs.getString("Material"));
                pre.setF_prestamo(rs.getDate("f_prestamo"));
                pre.setF_devolucion(rs.getDate("f_devolucion"));
                lista.add(pre);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return lista;
    }
    
    
    
 
  //----ESTOS METODOS SIRVEN PARA MODIFICAR LA TABLA DE PRESTAMOS EN LA COLUMNA DE FECHA DEVOLUCION----  
    public void modificarDevolucionLibro(Prestamos pre) {

        String sql = "UPDATE prestamos SET id_user=?, id_lib=?, No_Carnet=?, Nombre=?, Cod_Material=?, Material=?, f_prestamo=?, f_devolucion=? WHERE id=?;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setInt(1, pre.getIdUser());
            pst.setInt(2, pre.getIdLib());
            pst.setString(3, pre.getNoCarnet());
            pst.setString(4, pre.getNombre());
            pst.setString(5, pre.getCodMaterial());
            pst.setString(6, pre.getMaterial());
            pst.setDate(7, pre.getF_prestamo());
            pst.setDate(8, pre.getF_devolucion());
            pst.setInt(9, pre.getId());
            pst.executeUpdate();
            pst.close();

            pst.close();
            con.close();

//            log.info("Se ha actualizado la tabla prestamos en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo actualizar la tabla prestamos en la base de datos..." + e.getCause());

        }
    }
    
    public void modificarDevolucionObra(Prestamos pre) {

        String sql = "UPDATE prestamos SET id_user=?, id_obr=?, No_Carnet=?, Nombre=?, Cod_Material=?, Material=?, f_prestamo=?, f_devolucion=? WHERE id=?;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setInt(1, pre.getIdUser());
            pst.setInt(2, pre.getIdObr());
            pst.setString(3, pre.getNoCarnet());
            pst.setString(4, pre.getNombre());
            pst.setString(5, pre.getCodMaterial());
            pst.setString(6, pre.getMaterial());
            pst.setDate(7, pre.getF_prestamo());
            pst.setDate(8, pre.getF_devolucion());
            pst.setInt(9, pre.getId());
            pst.executeUpdate();
            pst.close();

            pst.close();
            con.close();

//            log.info("Se ha actualizado la tabla prestamos en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo actualizar la tabla prestamos en la base de datos..." + e.getCause());

        }
    }
    
    public void modificarDevolucionCd(Prestamos pre) {

        String sql = "UPDATE prestamos SET id_user=?, id_cds=?, No_Carnet=?, Nombre=?, Cod_Material=?, Material=?, f_prestamo=?, f_devolucion=? WHERE id=?;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setInt(1, pre.getIdUser());
            pst.setInt(2, pre.getIdCds());
            pst.setString(3, pre.getNoCarnet());
            pst.setString(4, pre.getNombre());
            pst.setString(5, pre.getCodMaterial());
            pst.setString(6, pre.getMaterial());
            pst.setDate(7, pre.getF_prestamo());
            pst.setDate(8, pre.getF_devolucion());
            pst.setInt(9, pre.getId());
            pst.executeUpdate();
            pst.close();

            pst.close();
            con.close();

//            log.info("Se ha actualizado la tabla prestamos en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo actualizar la tabla prestamos en la base de datos..." + e.getCause());

        }
    }
    
    public void modificarDevolucionRevista(Prestamos pre) {

        String sql = "UPDATE prestamos SET id_user=?, id_rev=?, No_Carnet=?, Nombre=?, Cod_Material=?, Material=?, f_prestamo=?, f_devolucion=? WHERE id=?;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setInt(1, pre.getIdUser());
            pst.setInt(2, pre.getIdRev());
            pst.setString(3, pre.getNoCarnet());
            pst.setString(4, pre.getNombre());
            pst.setString(5, pre.getCodMaterial());
            pst.setString(6, pre.getMaterial());
            pst.setDate(7, pre.getF_prestamo());
            pst.setDate(8, pre.getF_devolucion());
            pst.setInt(9, pre.getId());
            pst.executeUpdate();
            pst.close();

            pst.close();
            con.close();

//            log.info("Se ha actualizado la tabla prestamos en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo actualizar la tabla prestamos en la base de datos..." + e.getCause());

        }
    }
    
    public void modificarDevolucionTesis(Prestamos pre) {

        String sql = "UPDATE prestamos SET id_user=?, id_tsi=?, No_Carnet=?, Nombre=?, Cod_Material=?, Material=?, f_prestamo=?, f_devolucion=? WHERE id=?;";

        try {

            Class.forName(cn.getDriver());
            con = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPwd());

            pst = con.prepareStatement(sql);
            pst.setInt(1, pre.getIdUser());
            pst.setInt(2, pre.getIdTsi());
            pst.setString(3, pre.getNoCarnet());
            pst.setString(4, pre.getNombre());
            pst.setString(5, pre.getCodMaterial());
            pst.setString(6, pre.getMaterial());
            pst.setDate(7, pre.getF_prestamo());
            pst.setDate(8, pre.getF_devolucion());
            pst.setInt(9, pre.getId());
            pst.executeUpdate();
            pst.close();

            pst.close();
            con.close();

//            log.info("Se ha actualizado la tabla prestamos en la base de datos...");

        } catch (SQLException | ClassNotFoundException e) {
//            log.error("No se pudo actualizar la tabla prestamos en la base de datos..." + e.getCause());

        }
    }

}
