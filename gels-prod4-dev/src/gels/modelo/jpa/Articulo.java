package gels.modelo.jpa;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;



/**
 * The persistent class for the articulo database table.
 * 
 */
@Entity
//Indicamos las queries que vamos a hacer.
@NamedQueries({
	@NamedQuery(name="Articulo.findAll", query="SELECT a FROM Articulo a"),
	@NamedQuery(name="Articulo.finByID", query="SELECT a FROM Articulo a where a.idArticulo = :idArticulo"),
	@NamedQuery(name="Articulo.finByDescription", query="SELECT a FROM Articulo a where a.descripcion like :des")
})
public class Articulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy=TABLE)
	@Column(name="id_articulo")
	private int idArticulo;

	private String descripcion;

	@Column(name="precio_envio")
	private float precioEnvio;

	private float pvp;

	@Column(name="tiempo_prep_envio")
	private int tiempoPrepEnvio;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="articulo")
	private List<Pedido> pedidos;

	public Articulo() {
		pedidos = null;
	}	
	

    public Articulo(int id_articulo, String descripcion, float pvp, float precioEnvio, int tiempoPrepEnvio) {
        this.idArticulo = id_articulo;
        this.descripcion = descripcion;
        this.pvp = pvp;
        this.precioEnvio = precioEnvio;
        this.tiempoPrepEnvio = tiempoPrepEnvio;
    }

	public int getIdArticulo() {
		return this.idArticulo;
	}

	public void setIdArticulo (int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecioEnvio() {
		return this.precioEnvio;
	}

	public void setPrecioEnvio(float precioEnvio) {
		this.precioEnvio = precioEnvio;
	}

	public float getPvp() {
		return this.pvp;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	public int getTiempoPrepEnvio() {
		return this.tiempoPrepEnvio;
	}

	public void setTiempoPrepEnvio(int tiempoPrepEnvio) {
		this.tiempoPrepEnvio = tiempoPrepEnvio;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setArticulo(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setArticulo(null);

		return pedido;
	}
	
	   
    public String toString() {
    	return    idArticulo + " : " +  descripcion + "| PVP: " + pvp + " | PrecioEnvío: " +  precioEnvio  + " | tiempo Preparacion: " + tiempoPrepEnvio + " días ";
    }


}