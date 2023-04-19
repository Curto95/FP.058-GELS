package gels.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    String bd ="fp58_gels_producto3_bd";
    String url = "jdbc:mysql://localhost:3306/";
    String user="root";
    String password = "berrus2010";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    
    public Conexion(){
        
    }
    
    public Connection conectar() throws SQLException{
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd, user, password);
            System.out.println("Se conecto a la BD " + bd);
        } catch (ClassNotFoundException |SQLException ex) {
            System.out.println("No se conecto a la BD " + bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return cx;
        
    }
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main (String[] args) throws SQLException{
        Conexion conexion = new Conexion();
        conexion.conectar();
    }
}
