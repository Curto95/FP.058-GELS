package gels.DAO.mysql;

import gels.DAO.ArticuloDAO;
import gels.DAO.DAOException;
import gels.modelo.Articulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLArticuloDAO implements ArticuloDAO {
    
    private Connection conn;
    
    public MySQLArticuloDAO(Connection conn){
        this.conn = conn;
    }
    
    public void crear(Articulos a) throws DAOException {
        
        Connection conn = null;
        PreparedStatment stmt = null;
        
        try {
            conn = Connection conectar();
            String query = "INSERT INTO articulo (idArticulo, Descripcion, PvpVenta, GastosEnvio, TiempoPreparacion) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatment(query);
            stmt.setString(parameterName: "id_Articulo", articulo.getCodigo());
            stmt.setString(parameterName: "Descripcion", articulo.getDescripcion());
            stmt.setFloat(parameterName: "PvpVenta", articulo.getPvpVenta());
            stmt.setFloat(parameterName: "GastosEnvio", articulo.getGastosEnvio());
            stmt.setInt(parameterName: "TiempoPreparacion", articulo.getTiempoPreparacion());
            stmt.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            desconectar(stmt);
            desconectar(conn);
        }
    }

    public class buscarTodos() {
    
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      Articulo[] articulos = null;
      try{
        conn = Connection conectar();
        String query = "SELECT * FROM articulos";
        stmt = conn.prepareStatement(query);
        rs = stmt.executeQuery();
        rs.last();
        int count = rs.getRow();
        if (count > 0){
            articulos = new Articulo[count];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()){
                Articulo articulo = new Articulo();
                articulo.setCodigo(rs.getString("id_Articulo"));
                articulo.setDescripcion(rs.getString("Descripcion"));
                articulo.setPvpVenta(rs.getFloat("PvpVenta"));
                articulo.setGastosEnvio(rs.getFloat("GastosEnvio"));
                articulo.setTiempoPreparacion(rs.getInt("TiempoPreparacion"));
                articulos[i++] = articulo;
            }
        }
    } catch (SQLException ex){
        ex.printStackTrace(); 
    } finally {
        desconectar(rs);
        desconectar(stmt);
        desconectar(conn);
    }
    return articulos;    
}

public boolean eliminar(Articulo articulo){
    Connection conn = null;
    PreparedStatement stmt = null;
    boolean elminado = false;
    
    try{
        conn = Connection conectar();
        String query = "DELETE FROM articulos WHERE id=?";
        stmt = conn.prepareStatement(query);
        stmt.setFloat("id_Articulo", articulo.getCodigo());
        int rows = stmt.executeUpdate();
        if (rows > 0){
            eliminado = true;
        }
    } catch (SQLException ex){
        ex.printStackTrace();
    } finally {
        desconectar(stmt);
        desconectar(conn);
    }
    return elminado;   
}