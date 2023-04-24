package dao;

import conexion.Conexion;
import excepciones.DbConexionExcepciones;
import java.util.List;
import gels.modelo.Articulos;
import gels.modelo.idao.IArticulosDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticuloDao implements IArticulosDao{

    private final String SELECT_DFT = "SELECT id_articulo, descripcion, precioProducto, precio_envio, tiempo_prep_envio FROM ARTICULOS";

    public ArticuloDao() {
    }

    public boolean registrar(Articulos articulo) throws DbConexionExcepciones {
    String url = "jdbc:mysql://localhost:3306/Gels";
    String usuario = "root";
    String contrasena = "KarndePeix4";
    Connection conexion = null;
    PreparedStatement ps = null;

    try {
        conexion = DriverManager.getConnection(url, usuario, contrasena);
        String consulta = "INSERT INTO articulos (id_articulo, descripcion, precioProducto, precioEnvio, tiempoPrepEnvio) VALUES (?, ?, ?, ?, ?)";
        ps = conexion.prepareStatement(consulta);
        ps.setInt(1, articulo.getidArticulos());
        ps.setString(2, articulo.getDescripcion());
        ps.setFloat(3, articulo.getprecioProducto());
        ps.setFloat(4, articulo.getPrecioEnvio());
        ps.setInt(5, articulo.getTiempoPrepEnvio());
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

    /*public List<Articulos> obtener() throws DbConexionExcepciones {
        List<Articulos> articulos = new ArrayList<>();
        
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
                Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        
        // Crear la consulta SQL
        String sql = "SELECT * FROM articulos";
        
        // Ejecutar la consulta y obtener los resultados
        try (PreparedStatement statement = cx.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                // Mapear los resultados a objetos Articulo
                int id_articulo = resultSet.getInt("id_articulo");
                String descripcion = resultSet.getString("descripcion");
                float precioProducto = resultSet.getFloat("precioProducto");
                float precioEnvio = resultSet.getFloat("precioEnvio");
                int tiempoPrepEnvio = resultSet.getInt("tiempoPrepEnvio");
                Articulos articulo = new Articulos(id_articulo, descripcion, precioProducto, precioEnvio, tiempoPrepEnvio);
                articulos.add(articulo);
            }
        } catch (SQLException e) {
            try {
                throw new SQLException("Error al obtener los artículos de la base de datos", e);
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            // Cerrar la conexión
            conexion.desconectar();
        }
        
        return articulos;
    }
    

    public List<Articulos> obtenerPorDescripcion(String des) throws DbConexionExcepciones {
        List<Articulos> articulos = new ArrayList<>();
    // Instanciar la clase Conexion y conectar a la base de datos
    Conexion conexion = new Conexion();
    try {
        Connection cx = conexion.conectar();

        // Crear la consulta SQL
        String sql = "SELECT * FROM articulos WHERE des = ?";

        // Ejecutar la consulta y obtener los resultados
        try (PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setString(1, des);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Mapear los resultados a un objeto Articulo
                int id_articulo = resultSet.getInt("id_articulo");
                String descripcion = resultSet.getString("descripcion");
                float precioProducto = resultSet.getFloat("precioProducto");
                float precioEnvio = resultSet.getFloat("precioEnvio");
                int tiempoPrepEnvio = resultSet.getInt("tiempoPrepEnvio");
                Articulos articulo = new Articulos(id_articulo, descripcion, precioProducto, precioEnvio, tiempoPrepEnvio);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener el artículo de la base de datos", e);
        } finally {
            // Cerrar la conexión
            conexion.desconectar();
        }
    } catch (SQLException e) {
             try {
                 throw new SQLException("Error al conectarse a la base de datos", e);
             } catch (SQLException ex) {
                 Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    return articulos;
    }

    public Articulos obtenerPorId(int idArticulo) throws DbConexionExcepciones {
         Articulos articulo = null;
    // Instanciar la clase Conexion y conectar a la base de datos
    Conexion conexion = new Conexion();
    try {
        Connection cx = conexion.conectar();

        // Crear la consulta SQL
        String sql = "SELECT * FROM articulos WHERE idArticulo = ?";

        // Ejecutar la consulta y obtener los resultados
        try (PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setInt(1, idArticulo);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Mapear los resultados a un objeto Articulo
                int id_articulo = resultSet.getInt("id_articulo");
                String descripcion = resultSet.getString("descripcion");
                float precioProducto = resultSet.getFloat("precioProducto");
                float precioEnvio = resultSet.getFloat("precioEnvio");
                int tiempoPrepEnvio = resultSet.getInt("tiempoPrepEnvio");
                articulo = new Articulos(id_articulo, descripcion, precioProducto, precioEnvio, tiempoPrepEnvio);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener el artículo de la base de datos", e);
        } finally {
            // Cerrar la conexión
            conexion.desconectar();
        }
    } catch (SQLException e) {
             try {
                 throw new SQLException("Error al conectarse a la base de datos", e);
             } catch (SQLException ex) {
                 Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    return articulo;
    }

    public boolean actualizar(Articulos articulo) throws DbConexionExcepciones {
        boolean actualizado = false;
    
    // Instanciar la clase Conexion y conectar a la base de datos
    Conexion conexion = new Conexion();
    try {
        Connection cx = conexion.conectar();
        
        // Crear la consulta SQL
        String sql = "UPDATE articulos SET nombre=?, descripcion=?, precio=? WHERE idArticulo=?";
        
        // Ejecutar la consulta
        try (PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setInt(1, articulo.getidArticulos());
            statement.setString(2, articulo.getDescripcion());
            statement.setFloat(3, articulo.getprecioProducto());
            statement.setFloat(4, articulo.getPrecioEnvio());
            statement.setInt(1, articulo.getTiempoPrepEnvio());
            
            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                actualizado = true;
            }
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar el artículo en la base de datos", e);
        }
    } catch (SQLException e) {
            try {
                throw new SQLException("Error al conectarse a la base de datos", e);
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
        // Cerrar la conexión
        conexion.desconectar();
    }
    
    return actualizado;
    }

    public boolean eliminar(int id_articulo) throws DbConexionExcepciones {
         // Instanciar la clase Conexion y conectar a la base de datos
    Conexion conexion = new Conexion();
    try {
        Connection cx = conexion.conectar();

        // Crear la consulta SQL
        String sql = "DELETE FROM articulos WHERE id = ?";

        // Ejecutar la consulta
        try (PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setInt(1, id_articulo);
            int rowCount = statement.executeUpdate();
            if (rowCount > 0) {
                // Si se eliminó al menos una fila, se considera que la operación fue exitosa
                return true;
            }
        } catch (SQLException e) {
            throw new SQLException("Error al eliminar el artículo de la base de datos", e);
        } finally {
            // Cerrar la conexión
            conexion.desconectar();
        }
    } catch (SQLException e) {
        try {
            throw new SQLException("Error al conectarse a la base de datos", e);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return false;
    }*/

    @Override
    public List<Articulos> obtener() throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Articulos arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Articulos obtenerPorId(int arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Articulos> obtenerPorDescripcion(String arg0) throws DbConexionExcepciones {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

