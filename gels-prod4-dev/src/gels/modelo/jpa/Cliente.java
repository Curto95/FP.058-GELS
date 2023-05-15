package gels.modelo.jpa;

import java.io.Serializable;
import javax.persistence.*;

import gels.modelo.factory.FactoryCliente.TCliente;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity

@NamedQueries({
	@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c"),
	@NamedQuery(name="Cliente.findById", query="SELECT c FROM Cliente c where c.idCliente = :idCliente"),
	@NamedQuery(name="Cliente.finByName", query="SELECT c FROM Cliente c where c.nombre like :nombre"),
	@NamedQuery(name="Cliente.finByNif", query="SELECT c FROM Cliente c where c.nif = :nif")
})
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="id_cliente")
	private long idCliente;

        @Column(name="Domicilio")
	private String domicilio;

        @Column(name="email")
	private String email;

        @Column(name="Nif")
	private String nif;

        @Column(name="Nombre")
	private String nombre;

    

	//bi-directional one-to-one association to ClienteEstandard
	@OneToOne(mappedBy="cliente", 
		    orphanRemoval = true, optional = true,
		    cascade = CascadeType.ALL)
	private ClienteEstandard clienteEstandard;

	//bi-directional one-to-one association to ClientePremium
	@OneToOne(mappedBy="cliente", 
		    orphanRemoval = true, optional = true,
		    cascade = CascadeType.ALL)
	private ClientePremium clientePremium;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="cliente", 
		    orphanRemoval = true,
		    cascade = CascadeType.ALL)
	private List<Pedido> pedidos;

	public Cliente() {
	}

    public Cliente(long _id, String nombre, String domicilio, String nif, String email) {
    	this.idCliente = _id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.email = email;
        clienteEstandard = null;
        clientePremium = null;
    }

    public Cliente(String nombre, String domicilio, String nif, String email) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.email = email;
    }
	
	public long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ClienteEstandard getClienteEstandard() {
		return this.clienteEstandard;
	}

	public void setClienteEstandard(ClienteEstandard clienteEstandard) {
		this.clienteEstandard = clienteEstandard;
	}

	public ClientePremium getClientePremium() {
		return this.clientePremium;
	}

	public void setClientePremium(ClientePremium clientePremium) {
		this.clientePremium = clientePremium;
	}
	
	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setCliente(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setCliente(null);

		return pedido;
	}

	public boolean isStandard() {
		return (this.clienteEstandard  != null);
	}
	
	public boolean isPremium() {
		return (this.clientePremium != null);
	}
	
    public String toString() {
    	TCliente tc;
    	
    	if (this.isPremium()) tc = TCliente.PREMIUM;
    	else tc = TCliente.ESTANDARD;
    	
        return nif + " | " + nombre + " | " + domicilio  + " | " + email  + " | " + tc.toString();
    }

}