package gels.modelo.idao;
/**
 *
 * @author gels
 */
public abstract interface IArticulosDao {
  public abstract boolean registrar(gels.modelo.Articulos arg0) throws excepciones.DbConexionExcepciones;
  
  public abstract  java.util.List<gels.modelo.Articulos> obtener() throws excepciones.DbConexionExcepciones;
  
  public abstract boolean actualizar(gels.modelo.Articulos arg0) throws excepciones.DbConexionExcepciones;
  
  public abstract boolean eliminar(int arg0) throws excepciones.DbConexionExcepciones;
  
  public abstract gels.modelo.Articulos obtenerPorId(int arg0) throws excepciones.DbConexionExcepciones;
  
  public abstract  java.util.List<gels.modelo.Articulos> obtenerPorDescripcion(java.lang.String arg0) throws excepciones.DbConexionExcepciones;
}
