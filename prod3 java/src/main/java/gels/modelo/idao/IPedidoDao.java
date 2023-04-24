package gels.modelo.idao;
/**
 *
 * @author Gels
 */
public abstract interface IPedidoDao {
  public int registrar(gels.modelo.Pedidos arg0) throws excepciones.DbConexionExcepciones;
}
