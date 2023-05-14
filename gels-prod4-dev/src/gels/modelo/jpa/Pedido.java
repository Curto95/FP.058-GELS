package gels.modelo.jpa;

import java.io.Serializable;
import javax.persistence.*;

import gels.modelo.db.ArticuloDB;
import gels.modelo.db.ClienteDB;
import gels.modelo.factory.FactoryDao;


import java.util.Date;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p"),
	@NamedQuery(name="Pedido.findById", query="SELECT p FROM Pedido p where p.idPedido = :idPedido"),
	@NamedQuery(name="Pedido.findByDate", query="SELECT p FROM Pedido p where p.fechaPedido = :fechaPedido")
})
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private long idPedido;

	@Column(name="cantidad_articulo")
	private int cantidadArticulo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pedido")
	private Date fechaPedido;

	@Column(name="pedido_enviado", columnDefinition = "BOOLEAN")
	private boolean pedidoEnviado;

	private float precio;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Articulo
	@ManyToOne
	@JoinColumn(name="id_articulo")
	private Articulo articulo;

	public Pedido() {
	}

    public Pedido(int id_pedido, Cliente cli, Articulo articulo, int cantidadArticulo, Date fechaPedido, boolean pedidoEnviado) {
        this.idPedido = id_pedido;
        this.cliente = cli;
        this.articulo = articulo;
        this.cantidadArticulo = cantidadArticulo;
        this.fechaPedido = fechaPedido;
        this.pedidoEnviado = pedidoEnviado;
        this.precio = (articulo.getPvp() * cantidadArticulo) + articulo.getPrecioEnvio();
    }

    /**
     * Creamos el Pedido a partir de los id cliente y articulos
     * @param id_pedido
     * @param id_Cliente
     * @param id_Articulo
     * @param cantidadArticulo
     * @param fechaPedido
     * @param pedidoEnviado
     * @throws Exception 
     */
    
    public Pedido(int id_pedido, int id_Articulo, int id_Cliente, int cantidadArticulo, Date fechaPedido, boolean pedidoEnviado) throws Exception {
    	ClienteDB clienteDB = new FactoryDao().createCliente();
    	ArticuloDB articuloDB = new FactoryDao().createArticulo();
        this.idPedido = id_pedido;
        this.cliente = clienteDB.obtenerPorId(id_Cliente);
        this.articulo = articuloDB.obtenerPorId(id_Articulo);
        this.cantidadArticulo = cantidadArticulo;
        this.fechaPedido = fechaPedido;
        this.pedidoEnviado = pedidoEnviado;
        this.precio = (articulo.getPvp() * cantidadArticulo) + articulo.getPrecioEnvio();
	}
	public long getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public int getCantidadArticulo() {
		return this.cantidadArticulo;
	}

	public void setCantidadArticulo(int cantidadArticulo) {
		this.cantidadArticulo = cantidadArticulo;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public boolean getPedidoEnviado() {
		return this.pedidoEnviado;
	}

	public void setPedidoEnviado(boolean pedidoEnviado) {
		this.pedidoEnviado = pedidoEnviado;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Articulo getArticulo() {
		return this.articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	
	/*
	 * Devuelve los datos siguientes: número de pedido, fecha y hora del pedido, Nif y nombre del cliente, código y descripción del artículo, cantidad, precio artículo, 
	 * coste envío, precio total y si ya se ha enviado.
	 */
    public String toString() {
        return "Pedido "  + idPedido + " | Fecha " + fechaPedido.toString() 
        + " | NIF " + cliente.getNif()
        + " -  " + cliente.getNombre()
        + " | Artículo " + articulo.getIdArticulo()
        + " -  " + articulo.getDescripcion()
        + " | Cantidad " + cantidadArticulo
        + " | Precio " + precio
        + " | Coste envío " + articulo.getPrecioEnvio()
        + " | @Total!: " + Float.toString(this.getPrecio())
        + " | Enviado " + (pedidoEnviado ? "S�?" : "NO");
    }

}