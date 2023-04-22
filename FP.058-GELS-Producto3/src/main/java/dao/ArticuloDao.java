package dao;

import excepciones.DbConexionExcepciones;
import java.util.List;
import gels.modelo.Articulos;
import gels.modelo.idao.IArticulosDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public List<Articulos> obtener() throws DbConexionExcepciones {
        return null;
    }

    public List<Articulos> obtenerPorDescripcion(String des) throws DbConexionExcepciones {
        return null;
    }

    public Articulos obtenerPorId(int id) throws DbConexionExcepciones {
        return null;
    }

    public boolean actualizar(Articulos articulo) throws DbConexionExcepciones {
        return false;
    }

    public boolean eliminar(int id_articulo) throws DbConexionExcepciones {
        return false;
    }
}

