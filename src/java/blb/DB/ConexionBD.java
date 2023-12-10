package blb.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private String url, user, pwd, driver;

     public ConexionBD() {
        this.url = "jdbc:mysql://localhost:3306/blb_udb";
        this.user = "root";
        this.pwd = "";
        this.driver = "com.mysql.cj.jdbc.Driver";
    }
    public Connection conectarBaseDatos() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de la conexion: " + e);
        }
        return con;
    }

    public static void main(String[] args) {
        Connection con;
        ConexionBD conexion = new ConexionBD();
        con = conexion.conectarBaseDatos();
    }
    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }

    public String getDriver() {
        return driver;
    }

}
