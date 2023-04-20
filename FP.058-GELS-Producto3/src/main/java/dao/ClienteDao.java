package dao;
import gels.modelo.idao.IClienteDao;
/**
 *
 * @author gels
 */
public class ClienteDao implements IClienteDao {
 private final java.lang.String SELECT_CLIENTE_DFT;
  
  public ClienteDao(java.lang.String SELECT_CLIENTE_DFT) {
     this.SELECT_CLIENTE_DFT = SELECT_CLIENTE_DFT;
  }
  
  private boolean registrarEstandar(gels.modelo.Clientes cliente, int id) throws java.sql.SQLException, excepciones.DbConexionExcepciones {
    return false;
  }
  
  private boolean registrarPremium(gels.modelo.Clientes cliente, int id) throws java.sql.SQLException, excepciones.DbConexionExcepciones {
    return false;
  }
  
  public boolean registrar(gels.modelo.Clientes cliente) throws excepciones.DbConexionExcepciones {
    return false;
  }
  
  public  java.util.List<gels.modelo.Clientes> obtener() throws excepciones.DbConexionExcepciones {
    return null;
  }
  
  public  java.util.List<gels.modelo.Clientes> obtenerPorNombre(java.lang.String n) throws excepciones.DbConexionExcepciones {
    return null;
  }
  
  public gels.modelo.Clientes obtenerPorNif(java.lang.String nif) throws excepciones.DbConexionExcepciones {
    return null;
  }
  
  public gels.modelo.Clientes obtenerPorId(int id) throws excepciones.DbConexionExcepciones {
    return null;
  }
  
  public boolean actualizar(gels.modelo.Clientes cliente) throws excepciones.DbConexionExcepciones {
    return false;
  }
  
  public boolean eliminar(java.lang.String nif) throws excepciones.DbConexionExcepciones {
    return false;
  }
}   

