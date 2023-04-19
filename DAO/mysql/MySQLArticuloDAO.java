/*package gels.DAO.mysql;

import gels.DAO.ArticuloDAO;
import gels.DAO.DAOException;
import gels.modelo.Articulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class MySQLArticuloDAO implements ArticuloDAO {
    
    final String INSERT = "INSERT INTO articulo(idArticulo, Descripcion, PvpVenta, GastosEnvio,TiempoPreparacion) VALUES(?,?,?,?,?)";
    final String GETALL = "SELECT * FROM articulo";
    final String GETONE = "SELECT idArticulo, Descripcion, PvpVenta, GastosEnvio, TiempoPreparacion FROM articulo WHERE idArticulo = ?";
    
    private Connection conn;
    
    public MySQLArticuloDAO(Connection conn){
        this.conn = conn;
    }
    

    @Override
    public void insertar(Articulos a) throws DAOException {
PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, a.getidArticulos());
            stat.setString(2,a.getDescripcion());
            stat.setFloat(3, a.getprecioProducto());
            stat.setFloat(4, a.getPrecioEnvio());
            stat.setInt(5, a.getTiempoPrepEnvio());
            if (stat.executeUpdate() == 0){
                throw new DAOException("Puede que haya habido un error.");
            }
        }catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
        } finally{
            if (stat != null){
                try {
                    stat.close();
                }catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }    }
    
    private Articulos convertir(ResultSet rs) throws SQLException {
        int idArticulos = rs.getInt("idArticulos");
        String Descripcion = rs.getString("Descripcion");
        float precioProducto = rs.getFloat("precioProducto");
        float PrecioEnvio = rs.getFloat("PrecioEnvio");
        int TiempoPrepEnvio = rs.getInt("TiempoPrepEnvio");
        Articulos articulos = new Articulos(idArticulos, Descripcion, precioProducto, PrecioEnvio, TiempoPrepEnvio);
        articulos.setidArticulos(rs.getInt("idArticulos"));
        return articulos;
        
    }

    public class obtenerTodos {
    
      String consulta = "SELECT * FROM " + articulo;
        Statement statement = this.conexion.createStatement();
        ResultSet resultado = statement.executeQuery(consulta);
        return resultado;  
        
    
    
}
    
    

    
    public Articulos obtener(Integer id){

        
} 

}*/
