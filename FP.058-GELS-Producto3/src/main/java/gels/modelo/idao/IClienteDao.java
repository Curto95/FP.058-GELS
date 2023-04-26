package gels.modelo.idao;
/**
 *
 * @author Gels
 */
public abstract interface IClienteDao {
  public abstract boolean registrar(gels.modelo.Clientes arg0) throws excepciones.DbConexionExcepciones;
  
  public abstract  java.util.List<gels.modelo.Clientes> obtener() throws excepciones.DbConexionExcepciones;
  
  public abstract  java.util.List<gels.modelo.Clientes> obtenerPorNombre(java.lang.String arg0) throws excepciones.DbConexionExcepciones;
  
  public abstract gels.modelo.Clientes obtenerPorNif(java.lang.String arg0) throws excepciones.DbConexionExcepciones;
  
  public abstract gels.modelo.Clientes obtenerPorId(int arg0) throws excepciones.DbConexionExcepciones;
  
  public abstract boolean actualizar(gels.modelo.Clientes arg0) throws excepciones.DbConexionExcepciones;
  
  public abstract boolean eliminar(java.lang.String arg0) throws excepciones.DbConexionExcepciones;
}
