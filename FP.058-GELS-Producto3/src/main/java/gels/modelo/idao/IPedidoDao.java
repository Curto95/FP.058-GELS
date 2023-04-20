package gels.modelo.idao;
/**
 *
 * @author Gels
 */
public abstract interface IPedidoDao {
  public abstract int registrar(gels.modelo.Pedidos arg0) throws excepciones.DbConexionExcepciones;
  
  public abstract  java.util.List<gels.modelo.Pedidos> obtener() throws excepciones.DbConexionExcepciones;
  
  public abstract boolean actualizar(gels.modelo.Pedidos arg0) throws excepciones.DbConexionExcepciones;
  
  public abstract boolean eliminar(gels.modelo.Pedidos arg0) throws excepciones.DbConexionExcepciones;
  
  public abstract  java.util.List<gels.modelo.Pedidos> obtenerPorFecha(java.lang.String arg0) throws excepciones.DbConexionExcepciones;
  
  public abstract gels.modelo.Pedidos obtenerPorId(int arg0) throws excepciones.DbConexionExcepciones;
}
