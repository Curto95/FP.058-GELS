package dao;
import conexion.Conexion;
import excepciones.DbConexionExcepciones;
import gels.modelo.ClienteEstandar;
import gels.modelo.Clientes;
import gels.modelo.Clientes.TipoCliente;
import gels.modelo.idao.IClienteDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author gels
 */
public class ClienteDao implements IClienteDao {
 private final java.lang.String SELECT_CLIENTE_DFT;
  
  public ClienteDao(java.lang.String SELECT_CLIENTE_DFT) {
     this.SELECT_CLIENTE_DFT = SELECT_CLIENTE_DFT;
  }
  
  private boolean registrarEstandar(gels.modelo.Clientes cliente, int id) throws java.sql.SQLException, excepciones.DbConexionExcepciones {
    return false;
  }
  
  private boolean registrarPremium(gels.modelo.Clientes cliente, int id) throws java.sql.SQLException, excepciones.DbConexionExcepciones {
    return false;
  }
  
  public boolean registrar(gels.modelo.Clientes cliente) throws excepciones.DbConexionExcepciones {
    String url = "jdbc:mysql://localhost:3306/Gels";
    String usuario = "root";
    String contrasena = "KarndePeix4";
    Connection conexion = null;
    PreparedStatement ps = null;

    try {
        conexion = DriverManager.getConnection(url, usuario, contrasena);
        String consulta = "INSERT INTO clientes (nif, nombre, domicilio, email, tipoCliente) VALUES (?, ?, ?, ?, ?)";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, cliente.getNif());
        ps.setString(2, cliente.getNombre());
        ps.setString(3, cliente.getDomicilio());
        ps.setString(4, cliente.getEmail());
        ps.setString(5, cliente.getTipoCliente());
        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0; // Se insertó al menos una fila
    } catch (SQLException e) {
        // Manejo de la excepción
        e.printStackTrace();
        return false;
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            // Manejo de la excepción
            e.printStackTrace();
        }
    }
  }   
}
