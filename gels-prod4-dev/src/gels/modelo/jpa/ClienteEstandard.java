package gels.modelo.jpa;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the cliente_estandard database table.
 * 
 */
@Entity
@Table(name="cliente_estandard")
@NamedQuery(name="ClienteEstandard.findAll", query="SELECT c FROM ClienteEstandard c")
public class ClienteEstandard  implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@Column(name="calculo_anual")
	private float calculoAnual;

	@Column(name="descuento_envio")
	private float descuentoEnvio;

	//bi-directional one-to-one association to Cliente
	@OneToOne
	@Id
	@JoinColumn(name="id_cliente", referencedColumnName="id_cliente")
	private Cliente cliente;

	public ClienteEstandard() {
	}

	public long getIdCliente() {
		return this.cliente.getIdCliente();
	}


	public float getCalculoAnual() {
		return this.calculoAnual;
	}

	public void setCalculoAnual(float calculoAnual) {
		this.calculoAnual = calculoAnual;
	}

	public float getDescuentoEnvio() {
		return this.descuentoEnvio;
	}

	public void setDescuentoEnvio(float descuentoEnvio) {
		this.descuentoEnvio = descuentoEnvio;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


}