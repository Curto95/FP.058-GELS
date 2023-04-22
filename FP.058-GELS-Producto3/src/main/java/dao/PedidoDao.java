package dao;
import gels.modelo.idao.IPedidoDao;
import gels.modelo.Pedidos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
/**
 *
 * @author Gels
 */
public class PedidoDao implements IPedidoDao {
  
  private final java.lang.String SELECT_DFT = "SELECT id_pedido, id_articulo, id_cliente, cantidad_articulo, fecha_pedido, pedido_enviado, precio FROM PEDIDO ";
  
  public PedidoDao() {
  }
  
  @Override
  public int registrar(Pedidos pedido) throws excepciones.DbConexionExcepciones {
   String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    String usuario = "tu_usuario";
    String contrasena = "tu_contrasena";
    Connection conexion = null;
    PreparedStatement ps = null;

    try {
        conexion = DriverManager.getConnection(url, usuario, contrasena);
        String consulta = "INSERT INTO pedidos (idPedido, cli, articulo, cantidadArticulo, fechaPedido, pedidoEnviado, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";
        ps = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, pedido.getIdPedido());
        ps.setString(2, pedido.getcli().getEmail());
        ps.setInt(3, pedido.getArticulo().getidArticulos());
        ps.setInt(4, pedido.getCantidadArticulo());
        ps.setDate(5, new Date(pedido.getFechaPedido().getTime()));
        ps.setDouble(6, pedido.getTotal());
        ps.setDouble(7, pedido.getTotal());
        int filasAfectadas = ps.executeUpdate();
        if (filasAfectadas == 0) {
            throw new SQLException("Error al insertar el pedido");
        }
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        } else {
            throw new SQLException("Error al obtener el ID generado del pedido");
        }
    } catch (SQLException e) {
        System.out.println("Error al registrar el pedido: " + e.getMessage());
        return -1;
    } finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar el PreparedStatement: " + e.getMessage());
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
  }
  
  @Override
  public  java.util.List<Pedidos> obtener() throws excepciones.DbConexionExcepciones {
    return null;
  }
  
  public gels.modelo.Pedidos obtenerPorId(int id_pedido) throws excepciones.DbConexionExcepciones {
    return null;
  }
  
  public  java.util.List<Pedidos> obtenerPorFecha(java.lang.String fecha) throws excepciones.DbConexionExcepciones {
    return null;
  }
  
  public boolean actualizar(Pedidos pedido) throws excepciones.DbConexionExcepciones {
    return false;
  }
  
  public boolean eliminar(Pedidos pedido) throws excepciones.DbConexionExcepciones {
    return false;
  }
}