package gels.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gels.connection.Session;
import gels.modelo.Datos;
import gels.modelo.jpa.Articulo;
import gels.modelo.jpa.Cliente;
import gels.modelo.jpa.Pedido;
import gels.vista.data.ArticuloView;
import gels.vista.data.ClienteView;
import gels.vista.data.ClienteView.TClienteView;
import gels.vista.data.PedidoView;
import gels.zap.throwable.DbConnectionException;


public class Controlador {

	private Datos datos;
	
	public Controlador() throws Exception {
		Session.open();
		datos = new Datos ();
	}
	
	/**
	 * para comprobar si es un entero
	 * @param s
	 * @return
	 */
    public final boolean isInteger(String s) {
      	try {
    		Integer.parseInt(s);
    		return true;
    	}
      	catch (Exception e) {return false; }
    }
    
    /**
     * per comprovar si una entrada es un numero real
     * @param string
     * @return boolean
     */
    public final boolean isDouble(String s) {
      	try {
      		Double.parseDouble(s);
    		return true;
    	}
      	catch (Exception e) {return false; }
    }
    
    /**
     * per comprovar si una entrada es un float
     * @param string
     * @return boolean
     */
    public final boolean isFloat(String s) {
      	try {
      		Float.parseFloat(s);
    		return true;
    	}
      	catch (Exception e) {return false; }
    }   

    	// ---- CLIENTES -----
    	
	/**
	 * Añade un cliente
	 * @param id_articulo
	 * @param descripcion
	 * @param pvp
	 * @param precioEnvio
	 * @param tiempoPrepEnvio
	 * @param t
	 * @throws DbConnectionException 
	 */
	public void addClientes(String nombre, String domicilio, String nif, String email, int tipoCliente) throws DbConnectionException {
		datos.addToListaCliente(nombre, domicilio, nif, email, tipoCliente);
	}
	
	public String mostrarCliente(String nif) throws DbConnectionException {
		return datos.showCliente(nif).toString();
	}
	
	/**
	 * Muestra info de un cliente
	 * @param nif
	 * @return
	 * @throws DbConnectionException
	 */
	
	public ClienteView showCliente(String nif) throws DbConnectionException {
		Cliente cli = datos.showCliente(nif);
		TClienteView tcView=null;
		if (cli.isStandard()) tcView = TClienteView.ESTANDARD;
		else if (cli.isPremium()) tcView = TClienteView.PREMIUM;		
		ClienteView cv = new ClienteView(cli.getIdCliente(),  cli.getNombre(), cli.getDomicilio(), cli.getNif(), cli.getEmail(), tcView);
		return cv;			
	}
	
	/**
	 * Los datos que se van a poder actualizar
	 * @param cv
	 * @return
	 * @throws DbConnectionException
	 */
	public boolean actualizarCliente(ClienteView cv) throws  DbConnectionException {
		return datos.updateCliente(cv.getIdCliente(),  cv.getNombre(), cv.getDomicilio(), cv.getNif(), cv.getEmail(), cv.getTipoCliente().name());
	}
	
	public boolean eliminarCliente(String nif) throws DbConnectionException {
		return datos.removeCliente(nif);
	}
	
	public List<ClienteView> obtenerClientes() throws DbConnectionException {
		List<ClienteView> listaCV = new ArrayList<>();
		List<Cliente> cliente = datos.getClientes();
		
		for (Cliente cli : cliente) {
			ClienteView cv = getClienteView(cli);
			listaCV.add(cv);
			}
		return listaCV;
	}
	
	private ClienteView getClienteView(Cliente cli) {
		TClienteView tcView=null;
		if (cli.isStandard()) tcView = TClienteView.ESTANDARD;
		else if (cli.isPremium()) tcView = TClienteView.PREMIUM;
		return new ClienteView(cli.getIdCliente(), cli.getNombre(), cli.getDomicilio(), cli.getNif(), cli.getEmail(), tcView);
	}
	
	// ----- ARTICULOS
	
	/**
	 * Añade un artículo
	 * @param id_articulo
	 * @param descripcion
	 * @param pvp
	 * @param precioEnvio
	 * @param tiempoPrepEnvio
	 * @throws DbConnectionException 
	 */
	public void addArticulos(int id_articulo, String descripcion, float pvp, float precioEnvio, int tiempoPrepEnvio) throws DbConnectionException {
		datos.addToListaArticulos(id_articulo, descripcion, pvp, precioEnvio, tiempoPrepEnvio);
	}
	
	/**
	 * mostrar articulo
	 * @param id_articulo
	 * @return
	 * @throws DbConnectionException 
	 */
	public ArticuloView mostrarArticulo(int id_articulo) throws DbConnectionException {	
		Articulo art = datos.showArticulo(id_articulo);
		ArticuloView av = null;
		if (art != null) {
			av = getArticuloView(art);
		}
		return av;
	}
	
	public boolean actualizarArticulo(ArticuloView av) throws  DbConnectionException {
		return datos.updateArticulo(av.getId_articulo(), av.getDescripcion(), av.getPvp(), av.getPrecioEnvio(), av.getTiempoPrepEnvio());
	}
	
	public boolean eliminarArticulo(int codigo) throws DbConnectionException {
		return datos.removeArticulo(codigo);
	}
	
	public List<ArticuloView> obtenerArticulos() {
		List<ArticuloView> listaAV = new ArrayList<>();
		List<Articulo> articulos = datos.getArticulos();
		
		for (Articulo art : articulos) {
			ArticuloView av = getArticuloView(art);
			listaAV.add(av);
			}
		return listaAV;
	}
	
	private ArticuloView getArticuloView(Articulo art) {
		return 	 new ArticuloView(art.getIdArticulo(), art.getDescripcion(), art.getPvp(),  art.getPrecioEnvio(),  art.getTiempoPrepEnvio());
	}
	
	
	
	// -------      PEDIDOS

	/**
	 * Añade un pedido
	 * @param id_pedido
	 * @param cli
	 * @param articulo
	 * @param cantidadArticulo
	 * @param fechaPedido
	 * @return int (id pedido)
	 * @throws Exception 
	 */
	
	public long addPedidos(String nifCliente, int idArticulo, int cantidadArticulo, Date fechaPedido) throws Exception {
		return datos.addToListaPedidos(nifCliente, idArticulo, cantidadArticulo, fechaPedido, false);
	}
	
	public float totalPedido(long id) throws DbConnectionException {
		return datos.getTotalPedido(id);
	}
	
	public List<PedidoView> obtenerPedidos() {
		List<PedidoView> listaPd = new ArrayList<PedidoView>();
		List<Pedido> pedidos = datos.getPedidos();
		
		for (Pedido pd : pedidos) {		
			ClienteView cv =  getClienteView(pd.getCliente());
			ArticuloView av = getArticuloView(pd.getArticulo());
			PedidoView pdView = new PedidoView(pd.getIdPedido(), cv, av, pd.getCantidadArticulo(), pd.getFechaPedido(), pd.getPedidoEnviado(), pd.getPrecio());
			listaPd.add(pdView);
			}

		return listaPd;
	}
	
	/**
	 * Elimina un pedido
	 * @param codigo
	 * @return
	 * @throws DbConnectionException
	 */
	public boolean eliminarPedido(int codigo) throws DbConnectionException {
		long p = codigo;
		return datos.removePedido(p);	
		
	}
	
	/**
	 * envia un pedido
	 * @param codigo
	 * @return
	 * @throws DbConnectionException
	 */
	public boolean enviarPedido(int codigo) throws DbConnectionException {
		long p = codigo;
		return datos.enviaPedido(p);
	}
	
	/**
	 * Cierra todo
	 */
	public void close() {
		try {
			Session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}




}
