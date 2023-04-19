/*package gels.DAO.mysql;

import gels.DAO.DAOException;
import gels.DAO.PedidosDAO;
import gels.modelo.Pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public class MySQLPedidosDAO implements PedidosDAO{
    
    final String INSERT = "INSERT INTO pedido(idPedido, cantidad, FechaHora, idArticuloPedido, id_eMailPedido) VALUES(?, ?, ?, ?, ?)";
    final String GETALL = "SELECT * FROM clientes";
    
    private Connection conn;
    @Override
    public void insertar(Pedidos a) throws DAOException {
PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, a.getIdPedido());
            stat.setInt(2, a.getCantidadArticulo());
            stat.setDate(3, (java.sql.Date) new Date(a.getFechaPedido().getTime()));
            stat.setInt(4, a.getArticulo());
            stat.setString(5, a.getcli());
            
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

    @Override
    public List<Pedidos> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pedidos obtener(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
*/