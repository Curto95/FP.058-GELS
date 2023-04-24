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
    String usuario = "root";
    String contrasena = "KarndePeix4";
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
  
 /* @Override
  public List<Pedidos> obtener() throws DbConexionExcepciones {
        List<Pedidos> pedidos = new ArrayList<>();

        // Instanciar la clase Conexion y conectar a la base de datos
        Conexion conexion = new Conexion();
        Connection cx = null;
        try {
            cx = conexion.conectar();

            // Crear la consulta SQL
            String sql = "SELECT * FROM pedidos";

            // Ejecutar la consulta y obtener los resultados
            try (PreparedStatement statement = cx.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Mapear los resultados a objetos Pedido
                    int idPedido = resultSet.getInt("id_pedido");
                    String cli = resultSet.getString("cliente");
                    if (cli.equals("PREMIUM")) {
                    cliente = new ClientePremium(nombre, domicilio, nif, email, tipoCliente);
                    } else {
                    cliente = new ClienteEstandar(nombre, domicilio, nif, email, tipoCliente);
                    }
                    int idArticulo = resultSet.getInt("id_articulo");
                    int cantidadArticulo = resultSet.getInt("cantidad_articulo");
                    Date fechaPedido = resultSet.getDate("fecha_pedido");
                    boolean pedidoEnviado = resultSet.getBoolean("pedido_enviado");
                    Articulos articulo = obtenerArticuloPorId(idArticulo);
                    Pedidos pedido = new Pedidos(idPedido, Clientes.valueOf(cli), articulo, cantidadArticulo, fechaPedido, pedidoEnviado);
                    pedidos.add(pedido);
                }
            } catch (SQLException e) {
                throw new SQLException("Error al obtener los pedidos de la base de datos", e);
            }
        } catch (SQLException e) {
            try {
                throw new SQLException("Error al conectarse a la base de datos", e);
            } catch (SQLException ex) {
                Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            // Cerrar la conexión
            conexion.desconectar();
        }

        return pedidos;
    }


public List<Pedidos> obtenerPorDescripcion(String descripcion) throws DbConexionExcepciones {
    List<Pedidos> pedidos = new ArrayList<>();
    
    // Instanciar la clase Conexion y conectar a la base de datos
    Conexion conexion = new Conexion();
    try {
        Connection cx = conexion.conectar();

        // Crear la consulta SQL
        String sql = "SELECT * FROM pedidos WHERE articulo = ?";

        // Ejecutar la consulta y obtener los resultados
        try (PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setString(1, descripcion);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Mapear los resultados a un objeto Pedido
                    int idPedido = resultSet.getInt("idPedido");
                    String cli = resultSet.getString("cli");
                    String articulo = resultSet.getString("articulo");
                    int cantidadArticulo = resultSet.getInt("cantidadArticulo");
                    Date fechaPedido = resultSet.getDate("fechaPedido");
                    boolean pedidoEnviado = resultSet.getBoolean("pedidoEnviado");
                    Pedidos pedido = new Pedidos(idPedido, cli, articulo, cantidadArticulo, fechaPedido, pedidoEnviado);
                    pedidos.add(pedido);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener los pedidos de la base de datos", e);
        } finally {
            // Cerrar la conexión
            conexion.desconectar();
        }
    } catch (SQLException e) {
         try {
             throw new SQLException("Error al conectarse a la base de datos", e);
         } catch (SQLException ex) {
             Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    return pedidos;
}


public Pedidos obtenerPorId(int idPedido) throws DbConexionExcepciones {
    Pedidos pedido = null;
    // Instanciar la clase Conexion y conectar a la base de datos
    Conexion conexion = new Conexion();
    try {
        Connection cx = conexion.conectar();

        // Crear la consulta SQL
        String sql = "SELECT * FROM pedidos WHERE idPedido = ?";

        // Ejecutar la consulta y obtener los resultados
        try (PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setInt(1, idPedido);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Mapear los resultados a un objeto Pedido
                    int id_pedido = resultSet.getInt("idPedido");
                    Clientes cliente = new Clientes(resultSet.getString("nombreCliente"), resultSet.getString("direccionCliente"), resultSet.getString("telefonoCliente")) {};
                    Articulo articulo = new Articulo(resultSet.getString("nombreArticulo"), resultSet.getString("descripcionArticulo"), resultSet.getFloat("precioArticulo"), resultSet.getFloat("precioEnvioArticulo"), resultSet.getInt("tiempoPreparacionEnvioArticulo"));
                    int cantidadArticulo = resultSet.getInt("cantidadArticulo");
                    LocalDate fechaPedido = resultSet.getDate("fechaPedido").toLocalDate();
                    boolean pedidoEnviado = resultSet.getBoolean("pedidoEnviado");
                    pedido = new Pedido(id_pedido, cliente, articulo, cantidadArticulo, fechaPedido, pedidoEnviado);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener el pedido de la base de datos", e);
        } finally {
            // Cerrar la conexión
            conexion.desconectar();
        }
    } catch (SQLException e) {
        try {
            throw new SQLException("Error al conectarse a la base de datos", e);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return pedido;
}



public boolean actualizarPedido(Pedidos pedido) throws DbConexionExcepciones {
    boolean actualizado = false;
    
    // Instanciar la clase Conexion y conectar a la base de datos
    Conexion conexion = new Conexion();
    try {
        Connection cx = conexion.conectar();
        
        // Crear la consulta SQL
        String sql = "UPDATE pedidos SET cli=?, articulo=?, cantidadArticulo=?, fechaPedido=?, pedidoEnviado=? WHERE idPedido=?";
        
        // Ejecutar la consulta
        try (PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setString(1, pedido.getCliente());
            statement.setString(2, pedido.getArticulo());
            statement.setInt(3, pedido.getCantidad());
            statement.setDate(4, new java.sql.Date(pedido.getFecha().getTime()));
            statement.setBoolean(5, pedido.isEnviado());
            statement.setInt(6, pedido.getIdPedido());
            
            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                actualizado = true;
            }
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar el pedido en la base de datos", e);
        }
    } catch (SQLException e) {
        try {
            throw new SQLException("Error al conectarse a la base de datos", e);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    } finally {
        // Cerrar la conexión
        conexion.desconectar();
    }
    
    return actualizado;
}


public boolean eliminar(int idPedido) throws DbConexionExcepciones {
    // Instanciar la clase Conexion y conectar a la base de datos
    Conexion conexion = new Conexion();
    try {
        Connection cx = conexion.conectar();

        // Crear la consulta SQL
        String sql = "DELETE FROM pedidos WHERE idPedido = ?";

        // Ejecutar la consulta
        try (PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setInt(1, idPedido);
            int rowCount = statement.executeUpdate();
            if (rowCount > 0) {
                // Si se eliminó al menos una fila, se considera que la operación fue exitosa
                return true;
            }
        } catch (SQLException e) {
            throw new SQLException("Error al eliminar el pedido de la base de datos", e);
        } finally {
            // Cerrar la conexión
            conexion.desconectar();
        }
    } catch (SQLException e) {
        try {
            throw new SQLException("Error al conectarse a la base de datos", e);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return false;
}

    @Override
    public boolean actualizar(Pedidos arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Pedidos arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pedidos> obtenerPorFecha(String arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/

    @Override
    public List<Pedidos> obtener() throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Pedidos arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Pedidos arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pedidos> obtenerPorFecha(String arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pedidos obtenerPorId(int arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}