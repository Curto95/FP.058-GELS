package gels.modelo.idao;
/**
 *
 * @author Gels
 */
public abstract interface IClienteDao {
  public abstract boolean registrar(gels.modelo.Clientes arg0) throws excepciones.DbConexionExcepciones;
}
