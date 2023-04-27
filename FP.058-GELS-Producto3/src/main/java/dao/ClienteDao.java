package dao;
import conexion.Conexion;
import excepciones.DbConexionExcepciones;
import gels.modelo.ClienteEstandar;
import gels.modelo.Clientes;
import gels.modelo.Clientes.TipoCliente;
import gels.modelo.idao.IClienteDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
  
  
  
  private boolean registrarEstandar(gels.modelo.ClienteEstandar clienteEstandar, int id) throws java.sql.SQLException, excepciones.DbConexionExcepciones {
   return false;
  
  }
  
  private boolean registrarPremium(gels.modelo.Clientes cliente, int id) throws java.sql.SQLException, excepciones.DbConexionExcepciones {
    return false;
  }
 
 public boolean registrar(gels.modelo.Clientes cliente) throws excepciones.DbConexionExcepciones {
    Conexion conexionBD = new Conexion();
    Connection conexion = null;
    PreparedStatement ps = null;
    

    try {
        conexion = conexionBD.conectar();
        String consulta = "INSERT INTO cliente (id_eMail, Nombre, Domicilio, Nif, tipoCliente) VALUES (?, ?, ?, ?, ?)";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, cliente.getEmail());
        ps.setString(2, cliente.getNombre());
        ps.setString(3, cliente.getDomicilio());
        ps.setString(4, cliente.getNif());
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
  
 /* public List<Clientes> obtener() throws DbConexionExcepciones {
        List<Clientes> clientes = new ArrayList<>();
        
        // Instanciar la clase Conexion y conectar a la base de datos
        Conexion conexion = new Conexion();
        Connection cx = null;
        try {
            cx = conexion.conectar();
            
    // Resto del código
            } catch (SQLException e) {
            try {
                throw new SQLException("Error al conectarse a la base de datos", e);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        
        // Crear la consulta SQL
        String sql = "SELECT * FROM clientes";
        
        // Ejecutar la consulta y obtener los resultados
        try (PreparedStatement statement = cx.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                // Mapear los resultados a objetos Cliente
                String nombre = resultSet.getString("nombre");
                String domicilio = resultSet.getString("domicilio");
                String nif = resultSet.getString("nif");
                String email = resultSet.getString("email");
                String tipoCliente = resultSet.getString("tipo_cliente");
                Clientes cliente = new Clientes(nombre, domicilio, nif, email, TipoCliente.valueOf(tipoCliente)) {
                    @Override
                    public String tipoCliente() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public float calcAnual() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public float descuentoEnv() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                };
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            try {
                throw new SQLException("Error al obtener los clientes de la base de datos", e);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            // Cerrar la conexión
            conexion.desconectar();
        }
        
        return clientes;
    }



public List<Clientes> obtenerPorNombre(String nombrecli) throws DbConexionExcepciones {
    List<Clientes> clientes = new ArrayList<>();
    // Instanciar la clase Conexion y conectar a la base de datos
    Conexion conexion = new Conexion();
    try {
        Connection cx = conexion.conectar();

        // Crear la consulta SQL
        String sql = "SELECT * FROM clientes WHERE nombre = ?";

        // Ejecutar la consulta y obtener los resultados
        try (PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setString(1, nombrecli);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Mapear los resultados a objetos Cliente
                String nombre = resultSet.getString("nombre");
                String domicilio = resultSet.getString("domicilio");
                String nif = resultSet.getString("nif");
                String email = resultSet.getString("email");
                String tipoCliente = resultSet.getString("tipo_cliente");
                    Clientes cliente = new Clientes(nombre, domicilio, nif, email, TipoCliente.valueOf(tipoCliente)) {
                        @Override
                        public String tipoCliente() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }

                        @Override
                        public float calcAnual() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }

                        @Override
                        public float descuentoEnv() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }
                    };
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener el cliente de la base de datos", e);
        } finally {
            // Cerrar la conexión
            conexion.desconectar();
        }
    } catch (SQLException e) {
        try {
            throw new SQLException("Error al conectarse a la base de datos", e);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return clientes;
}


public Clientes obtenerPorId(String nifcliente) throws DbConexionExcepciones {
    Clientes cliente = null;
    // Instanciar la clase Conexion y conectar a la base de datos
    Conexion conexion = new Conexion();
    try {
        Connection cx = conexion.conectar();

        // Crear la consulta SQL
        String sql = "SELECT * FROM clientes WHERE nif = ?";

        // Ejecutar la consulta y obtener los resultados
        try (PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setString(1, nifcliente);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Mapear los resultados a un objeto Cliente
                   // int id_cliente = resultSet.getInt("id_cliente");
                    String nombre = resultSet.getString("nombre");
                    String domicilio = resultSet.getString("domicilio");
                    String nif = resultSet.getString("nif");
                    String email = resultSet.getString("email");
                    String tipoCliente = resultSet.getString("tipo_cliente");
                    cliente = new Clientes(nombre, domicilio, nif, email, TipoCliente.valueOf(tipoCliente)) {
                        @Override
                        public String tipoCliente() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }

                        @Override
                        public float calcAnual() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }

                        @Override
                        public float descuentoEnv() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }
                    };
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener el cliente de la base de datos", e);
        } finally {
            // Cerrar la conexión
            conexion.desconectar();
        }
    } catch (SQLException e) {
        try {
            throw new SQLException("Error al conectarse a la base de datos", e);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return cliente;
}


public boolean actualizar(Clientes cliente) throws DbConexionExcepciones {
    boolean actualizado = false;
    
    // Instanciar la clase Conexion y conectar a la base de datos
    Conexion conexion = new Conexion();
    try {
        Connection cx = conexion.conectar();
        
        // Crear la consulta SQL
        String sql = "UPDATE clientes SET nombre=?, domicilio=?, nif=?, email=?, tipoCliente=? WHERE Nif=?";
        
        // Ejecutar la consulta
        try (PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getDomicilio());
            statement.setString(3, cliente.getNif());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getTipoCliente());
            
            
            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                actualizado = true;
            }
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar el cliente en la base de datos", e);
        }
    } catch (SQLException e) {
            try {
                throw new SQLException("Error al conectarse a la base de datos", e);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
        // Cerrar la conexión
        conexion.desconectar();
    }
    
    return actualizado;
}


public boolean eliminar(int nifCliente) throws DbConexionExcepciones {
    // Instanciar la clase Conexion y conectar a la base de datos
    Conexion conexion = new Conexion();
    try {
        Connection cx = conexion.conectar();

        // Crear la consulta SQL
        String sql = "DELETE FROM clientes WHERE Nif = ?";

        // Ejecutar la consulta
        try (PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setInt(1, nifCliente);
            int rowCount = statement.executeUpdate();
            if (rowCount > 0) {
                // Si se eliminó al menos una fila, se considera que la operación fue exitosa
                return true;
            }
        } catch (SQLException e) {
            throw new SQLException("Error al eliminar el cliente de la base de datos", e);
        } finally {
            // Cerrar la conexión
            conexion.desconectar();
        }
    } catch (SQLException e) {
        try {
            throw new SQLException("Error al conectarse a la base de datos", e);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return false;
}

    @Override
    public Clientes obtenerPorNif(String arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(String arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Clientes obtenerPorId(int arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/

    @Override
    public List<Clientes> obtener() throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Clientes> obtenerPorNombre(String arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Clientes obtenerPorNif(String arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Clientes obtenerPorId(int arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Clientes arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(String arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}   

