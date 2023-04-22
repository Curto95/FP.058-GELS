package factory;
/**
 *
 * @author gels
 */
public class FactoryDao {
    public FactoryDao() {
  }
  
  public gels.modelo.idao.IArticulosDao createArticuloDao() {
    return null;
  }
  
  public gels.modelo.idao.IClienteDao createClienteDao() {
    return null;
  }
  
  public gels.modelo.idao.IPedidoDao createPedidoDao() {
    return null;
  }
}
