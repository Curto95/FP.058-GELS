package gels.modelo;

import java.util.Date;
import java.util.List;

import gels.modelo.db.ArticuloDB;
import gels.modelo.db.ClienteDB;
import gels.modelo.db.PedidoDB;
import gels.modelo.factory.FactoryDao;
import gels.modelo.jpa.Articulo;
import gels.modelo.jpa.Cliente;
import gels.modelo.jpa.Pedido;
import gels.modelo.factory.FactoryCliente;
import gels.modelo.factory.FactoryCliente.TCliente;
import gels.zap.throwable.ArticuloException;
import gels.zap.throwable.ClienteException;
import gels.zap.throwable.DbConnectionException;

public class Datos {
	

	private ArticuloDB articuloDB;
	private ClienteDB clienteDB;
	private PedidoDB pedidoDB;
	
	
	public Datos () throws Exception{
		
		articuloDB = new FactoryDao().createArticulo();
		clienteDB = new FactoryDao().createCliente();
		pedidoDB = new FactoryDao().createPedido();
	}
	
  
	// métodos para listas de Artículos
	
	/**
	 * Añade un elemento a la lista con los datos recibidos
	 * @param id_articulo
	 * @param descripcion
	 * @param pvp
	 * @param precioEnvio
	 * @param tiempoPrepEnvio
	 * @return
	 * @throws DbConnectionException 
	 */
	
	public boolean addToListaArticulos(int id_articulo, String descripcion, float pvp, float precioEnvio, int tiempoPrepEnvio) throws DbConnectionException {
		return articuloDB.registrar(new Articulo(id_articulo, descripcion,  pvp, precioEnvio, tiempoPrepEnvio));
	}
	
	/**
	 * Muestra un articulo
	 * @param id
	 * @return Articulo
	 * @throws DbConnectionException 
	 */
	public Articulo showArticulo(int id) throws DbConnectionException {
		return  articuloDB.obtenerPorId(id);
	}

	
	public int actualizarArticulo(Articulo art) {
		return 0;
	}
	
	public boolean updateArticulo(int id_articulo, String descripcion, float pvp, float precioEnvio, int tiempoPrepEnvio) throws  DbConnectionException {
		Articulo art =  new Articulo(id_articulo, descripcion, pvp, precioEnvio, tiempoPrepEnvio);
		return articuloDB.actualizar(art);
	}


	public boolean removeArticulo(int codigo) throws DbConnectionException {
		return articuloDB.eliminar(codigo);
	}


	public List<Articulo> getArticulos() {
		return articuloDB.obtener();
	}

	
	// métodos para listas de Cliente
	
	/**
	 * Añade un cliente a la lista con los datos recibidos
	 * @param nombre
	 * @param domicilio
	 * @param nif
	 * @param email
	 * @param tipoCliente
	 * @return
	 * @throws DbConnectionException 
	 */
	public boolean addToListaCliente(String nombre, String domicilio, String nif, String email, int t) throws DbConnectionException {
	
		//Descubrimos tipoCliente
		TCliente tipoCliente;
		if (t==1) tipoCliente = TCliente.ESTANDARD;
		else tipoCliente = TCliente.PREMIUM;
		
		Cliente cli = new FactoryCliente().creaCliente(nombre, domicilio, nif, email, tipoCliente);		

		// creamos un cliente Estandard o Premium, nos da igual, nos lo da la factoria
		// y el hibernate JPA se encargará de insertarlo donde toque
		
		return clienteDB.registrar(cli);
	}
	 
	/**
	 * Muestra un cliente
	 * @param nif
	 * @return
	 * @throws DbConnectionException 
	 */
	public Cliente showCliente(String nif) throws DbConnectionException {
		return clienteDB.obtenerPorNif(nif);
	}
	
	/**
	 * Muestra lista de clientes
	 * @return List<Cliente>
	 * @throws DbConnectionException 
	 */
	public List<Cliente> getClientes() throws DbConnectionException {
		return clienteDB.obtener();
	}
	
	public boolean updateCliente(Long idCliente,  String nombre, String domicilio, String nif, String email, String tipoCliente) throws DbConnectionException {
		TCliente tc;
		
		//Si es premium le asinga premium i deasigna estandard
		if (tipoCliente.equals(TCliente.PREMIUM.name())) tc = TCliente.PREMIUM;
		else tc = TCliente.ESTANDARD;
	
		Cliente cli = new FactoryCliente().creaCliente(idCliente, nombre, domicilio, nif, email, tc);	


		return clienteDB.actualizar(cli);
	}
	

	public boolean removeCliente(String nif) throws DbConnectionException {
		return clienteDB.eliminar(nif);
	}
	
	//métodos para listas de Pedidos
	
	/**
	 * Añade un pedido a lista de pedidos
	 * @param id_pedido
	 * @param cli
	 * @param articulo
	 * @param cantidadArticulo
	 * @param fechaPedido
	 * @param pedidoEnviado
	 * @return
	 * @throws ClienteException 
	 * @throws ArticuloException 
	 * @throws DbConnectionException 
	 */
	public long addToListaPedidos(String nif, int idArticulo, int cantidadArticulo, Date fechaPedido, boolean pedidoEnviado) throws ClienteException, ArticuloException, DbConnectionException {
		Cliente cli = clienteDB.obtenerPorNif(nif);
		if (cli == null) throw new ClienteException("CLIENTE NO EXISTE!, NO SE CREA NADA");
		Articulo art =  articuloDB.obtenerPorId(idArticulo);
		if (art == null) throw new ArticuloException("ARTICULO NO EXISTE!, NO SE CREA NADA");
		Pedido pedido = new Pedido(-1, cli, art, cantidadArticulo, fechaPedido, pedidoEnviado);
		//añadimos el pedido al cliente y 
		return pedidoDB.registrar(pedido); //devoverá el id generado en el insert o -1 y error
	}
		
	/**
	 * Obtiene el total
	 * @param i
	 * @return
	 * @throws DbConnectionException 
	 */
	
	public float getTotalPedido(long i) throws DbConnectionException {
		return pedidoDB.obtenerPorId(i).getPrecio();
	}


	public List<Pedido> getPedidos() {		
		return pedidoDB.obtener();
	}


	public boolean removePedido(long p) throws DbConnectionException {
		return pedidoDB.eliminar(p);
	}


	public boolean enviaPedido(long p) throws DbConnectionException {
		return pedidoDB.enviaPedido(p);
	}



}
