package dao;
import gels.modelo.idao.IPedidoDao;
import gels.modelo.Pedidos;
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
    return 0;
  }
  
  @Override
  public  java.util.List<Pedidos> obtener() throws excepciones.DbConexionExcepciones {
    return null;
  }
  
  public gels.modelo.Pedidos obtenerPorId(int id_pedido) throws excepciones.DbConexionExcepciones {
    return null;
  }
  
  public  java.util.List<Pedidos> obtenerPorFecha(java.lang.String fecha) throws excepciones.DbConexionExcepciones {
    return null;
  }
  
  public boolean actualizar(Pedidos pedido) throws excepciones.DbConexionExcepciones {
    return false;
  }
  
  public boolean eliminar(Pedidos pedido) throws excepciones.DbConexionExcepciones {
    return false;
  }
}