package dao;
import conexion.Conexion;
import excepciones.DbConexionExcepciones;
import gels.modelo.Articulos;
import gels.modelo.ClienteEstandar;
import gels.modelo.ClientePremium;
import gels.modelo.Clientes;
import gels.modelo.idao.IPedidoDao;
import gels.modelo.Pedidos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
}