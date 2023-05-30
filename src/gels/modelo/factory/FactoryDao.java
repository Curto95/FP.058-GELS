package gels.modelo.factory;

import gels.modelo.db.ArticuloDB;
import gels.modelo.db.ClienteDB;
import gels.modelo.db.PedidoDB;

public class FactoryDao {

	
	public ArticuloDB createArticulo() throws Exception {
		return new ArticuloDB();
	}
	
	public ClienteDB createCliente() throws Exception {
		return new ClienteDB();
	}
	
	public PedidoDB createPedido()  throws Exception {
		return new PedidoDB();
	}
	

}
