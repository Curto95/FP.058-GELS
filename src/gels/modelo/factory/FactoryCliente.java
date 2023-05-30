package gels.modelo.factory;

import gels.modelo.jpa.Cliente;
import gels.modelo.jpa.ClienteEstandard;
import gels.modelo.jpa.ClientePremium;


/**
 * Fabrica de clientes premium o estandard, devuelve null si no es ninguno de los dos.
 * @author antonio-cesar.flores
 *
 */
public class FactoryCliente {
	

	public enum TCliente
	{
	    PREMIUM, ESTANDARD
	}
	
	/**
	 * Crea una clase cliente asociandole la clase clienteEstandard o clientePremium según indique tipoCliente
	 * @param nombre
	 * @param domicilio
	 * @param nif
	 * @param email
	 * @param tipoCliente
	 * @return Cliente
	 */

	public Cliente creaCliente(String nombre, String domicilio, String nif, String email, TCliente tipoCliente) {
		Cliente cliente = new Cliente(nombre, domicilio, nif, email);
		ClienteEstandard cs = null;
		ClientePremium cp = null;
		
		if (tipoCliente.equals(TCliente.ESTANDARD)) {
			cs = new ClienteEstandard();
			cs.setCalculoAnual(0);
			cs.setDescuentoEnvio(0);
			cliente.setClienteEstandard(cs);
			cs.setCliente(cliente);
		}
		else if (tipoCliente.equals(TCliente.PREMIUM)) {
			cp = new ClientePremium();	
			cp.setDescuentoEnvio(0);
			cp.setCalculoAnual(0);	
			cliente.setClientePremium(cp);
			cp.setCliente(cliente);
		}
		
		return cliente;
	}
	
	
	public Cliente creaCliente(long id, String nombre, String domicilio, String nif, String email, TCliente tipoCliente) {
	//	Cliente cliente = new Cliente(id, nombre, domicilio, nif, email);
		Cliente cliente = this.creaCliente(nombre, domicilio, nif, email, tipoCliente);
		cliente.setIdCliente(id);
	/*	ClienteEstandard cs = cliente.getClienteEstandard();
		ClientePremium cp = cliente.getClientePremium();
		
		if (tipoCliente.equals(TCliente.ESTANDARD)) {
			cp = null;
			cs = new ClienteEstandard();
			cs.setCalculoAnual(0);
			cs.setDescuentoEnvio(0);
			cliente.setClienteEstandard(cs);
			cs.setCliente(cliente);
		}
		else if (tipoCliente.equals(TCliente.PREMIUM)) {
			cs = null;
			cp = new ClientePremium();
			cp.setDescuentoEnvio(0);
			cp.setCalculoAnual(9);
			cliente.setIdCliente(id);
			cliente.setClientePremium(cp);
			cp.setCliente(cliente);
			cp.setIdCliente(id);
		} 
		*/
		return cliente;
	}
	
}
