package gels.DAO.mysql;

import gels.DAO.ClientesDAO;
import gels.DAO.DAOException;
import gels.modelo.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class MySQLClientesDAO implements ClientesDAO{
    
    final String INSERT = "INSERT INTO clientes(email, nombre, domicilio, nif) VALUES(?, ?, ?, ?)";
    final String GETALL = "SELECT * FROM clientes";
    
    private Connection conn;
    
    @Override
    public void insertar(Clientes a) throws DAOException{
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, a.getEmail());
            stat.setString(2,a.getNombre());
            stat.setString(3, a.getDomicilio());
            stat.setString(4, a.getNif());
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
        }
    }

    @Override
    public List<Clientes> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    @Override
    public Clientes obtener(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }    
}


