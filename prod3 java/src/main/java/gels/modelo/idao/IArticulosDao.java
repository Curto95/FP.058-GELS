package gels.modelo.idao;
/**
 *
 * @author gels
 */
public abstract interface IArticulosDao {
  public abstract boolean registrar(gels.modelo.Articulos arg0) throws excepciones.DbConexionExcepciones;
}
